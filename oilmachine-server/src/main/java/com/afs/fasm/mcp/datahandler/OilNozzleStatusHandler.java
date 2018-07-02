package com.afs.fasm.mcp.datahandler;

import io.netty.channel.ChannelHandlerContext;

import com.afs.base.util.MySpringContextUtil;
import com.afs.fasm.mcp.message.OilNozzleStatusMessage;
import com.afs.tupeasy.message.AbstractMcpEasyMessage;
import com.afs.tupeasy.session.Session;
import com.afs.tupeasy.session.SessionManager;
import com.pcitc.oilmachine.service.mobile.CommonService;

public class OilNozzleStatusHandler extends CommonMessageHandler {
	@Override
	public AbstractMcpEasyMessage handlerMessage(AbstractMcpEasyMessage message,
			ChannelHandlerContext ctx) {
		CommonService commonService = (CommonService) MySpringContextUtil.getBean("commonService");
		OilNozzleStatusMessage oilnozzlestatusMsg = (OilNozzleStatusMessage) message;
		try {
			//1:处理摄像头连接
			Session session = SessionManager.getSession(String.valueOf(oilnozzlestatusMsg.getOildeviceid()));
			if(session != null && session.getReceivedata() != 0){
				return message;
			}
			oilnozzlestatusMsg.getMessageContent();
			super.sendMessageToMQ(message,commonService.getQueueName(),1);
			
		} catch (Exception e) {
		}
		return message;
	}
}
