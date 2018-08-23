package com.afs.fasm.mcp.datahandler;

import java.util.Date;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;

import com.afs.base.util.MySpringContextUtil;
import com.afs.fasm.mcp.message.CarMessage;
import com.afs.tupeasy.message.AbstractMcpEasyMessage;
import com.afs.tupeasy.session.Session;
import com.afs.tupeasy.session.SessionManager;
import com.alibaba.fastjson.JSONObject;
import com.pcitc.oilmachine.commons.constant.Constant;
import com.pcitc.oilmachine.commons.utils.StringUtils;
import com.pcitc.oilmachine.service.mobile.CommonService;

public class CarMessageHandler extends CommonMessageHandler {
	@Override
	public AbstractMcpEasyMessage handlerMessage(AbstractMcpEasyMessage message,
			ChannelHandlerContext ctx) {
		CommonService commonService = (CommonService) MySpringContextUtil.getBean("commonService");
		Channel ch = ctx.channel();
		CarMessage carMessage = (CarMessage) message;
		try {
			//1:处理摄像头连接
			Session session = SessionManager.getSession(String.valueOf(carMessage.getCameraid()));
			
			if(session == null){
				session = new Session();
				session.setLoginTime(new Date());
				session.setClientId(String.valueOf(carMessage.getCameraid()));
				session.setChannel(ch);
				session.setDeviceTypeCode(Constant.CAMERA_CODE);
				SessionManager.addSession(String.valueOf(carMessage.getCameraid()), session, ch);
			}else{
				if(session.getChannel() == null || !ch.id().asLongText().equals(session.getChannel().id().asLongText())){
					session.setChannel(ch);
					SessionManager.addSession(String.valueOf(carMessage.getCameraid()), session, ch);
				}
			}
			
			if(session.getReceivedata() != 0){
				return message;
			}
			super.sendMessageToMQ(message,commonService.getQueueName(),3);			
		} catch (Exception e) {
			commonService.saveDeviceConnectError(String.valueOf(carMessage.getCameraid()), JSONObject.toJSONString(carMessage),StringUtils.getErrorInfoFromException(e) );
		}
		return message;
	}
}
