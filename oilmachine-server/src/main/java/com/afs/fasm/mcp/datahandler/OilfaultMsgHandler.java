package com.afs.fasm.mcp.datahandler;

import io.netty.channel.ChannelHandlerContext;

import com.afs.base.util.MySpringContextUtil;
import com.afs.fasm.mcp.message.OilfaultMessage;
import com.afs.tupeasy.message.AbstractMcpEasyMessage;
import com.afs.tupeasy.session.Session;
import com.afs.tupeasy.session.SessionManager;
import com.pcitc.oilmachine.service.mobile.CommonService;

public class OilfaultMsgHandler extends CommonMessageHandler {
	@Override
	public AbstractMcpEasyMessage handlerMessage(AbstractMcpEasyMessage message,
			ChannelHandlerContext ctx) {
		CommonService commonService = (CommonService) MySpringContextUtil.getBean("commonService");
		OilfaultMessage OilfaultMessage = (OilfaultMessage) message;
		try {
			//1:处理摄像头连接
			Session session = SessionManager.getSession(String.valueOf(OilfaultMessage.getOildeviceid()));
			if(session != null && session.getReceivedata() != 0){
				return message;
			}
			super.sendMessageToMQ(message,commonService.getQueueName(),2);
			
		} catch (Exception e) {
		}
		return message;
	}
}
