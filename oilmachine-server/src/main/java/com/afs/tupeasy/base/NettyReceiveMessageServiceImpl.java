package com.afs.tupeasy.base;

import com.afs.base.util.MySpringContextUtil;
import com.afs.tupeasy.message.AbstractMcpEasyMessage;
import com.afs.tupeasy.message.Message;
import com.afs.tupeasy.sync.SyncCallBack;
import com.afs.tupeasy.sync.SyncManager;
import com.pcitc.oilmachine.commons.utils.ByteUtil;

import io.netty.channel.ChannelHandlerContext;

public class NettyReceiveMessageServiceImpl implements NettyReceiveMessageService {

	@Override
	public void onReceiveMessage(AbstractMcpEasyMessage message, ChannelHandlerContext ctx) {
		//查看是否有进程等待这个消息
		SyncCallBack sync = null;
		
		if(message.getCorrespondId()!=null){
			sync = SyncManager.getSyncCallBackObject(message.getCorrespondId());
		}
		
		if(sync!=null){
			sync.setMessage(message);
			sync.syncFinish();  //同步等待结束
		}else{
			DataHandlerFactory busiMessageHandlerFactory = (DataHandlerFactory) MySpringContextUtil.getBean("busiMessageHandlerFactory");
			DataHandlerBase myBusiMessageHandlerBase = busiMessageHandlerFactory.getDataHandler(ByteUtil.getHexString(message.getPackageHead()),message.getMessageType());
			Message respMessage = myBusiMessageHandlerBase.handlerMessage(message,ctx);
			if(respMessage!=null){
				ctx.writeAndFlush(respMessage);
			}
		}
	}

}
