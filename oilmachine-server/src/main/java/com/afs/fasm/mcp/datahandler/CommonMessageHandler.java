package com.afs.fasm.mcp.datahandler;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import io.netty.channel.ChannelHandlerContext;

import com.afs.base.constants.TimeFormatConstant;
import com.afs.base.mq.MQException;
import com.afs.base.mq.MessageSendService;
import com.afs.base.util.MySpringContextUtil;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.pcitc.oilmachine.commons.utils.ExceptionUtil;
import com.afs.tupeasy.base.DataHandlerBase;
import com.afs.tupeasy.message.AbstractMcpEasyMessage;
import com.alibaba.fastjson.JSONObject;

/**
 * 通用消息处理器，把接收到的消息发送到mq，并且返回原消息,不做其它处理
 * @author zhang
 *
 */
public class CommonMessageHandler implements DataHandlerBase {
	private static Logger log = LogManager.getLogger(CommonMessageHandler.class.getName());
	
	protected int sendMessageToMQ(AbstractMcpEasyMessage message,String routingKey,int messageType){
		Gson gson =  new GsonBuilder().setDateFormat(TimeFormatConstant.YYYYMMDDHHMMSS).create();
		JSONObject jsonO = new JSONObject();
		jsonO.put("type", messageType);
		String json = gson.toJson(message);
		jsonO.put("message", json);
		MessageSendService mss = (MessageSendService) MySpringContextUtil.getBean("fasmSendToMQService");
		int cnt = 0 ;
		try {
			cnt = mss.sendMessage(JSONObject.toJSONBytes(jsonO),routingKey);
		} catch (MQException e) {
			e.printStackTrace();
			log.error(ExceptionUtil.getStackTrace(e));
		}catch(Throwable t){
			t.printStackTrace();
			log.error(ExceptionUtil.getStackTrace(t));
		}
		return cnt;
	}
	
	protected int sendMessageToMQ(AbstractMcpEasyMessage message){
		Gson gson =  new GsonBuilder().setDateFormat(TimeFormatConstant.YYYYMMDDHHMMSS).create();
		String json = gson.toJson(message);
		
		MessageSendService mss = (MessageSendService) MySpringContextUtil.getBean("fasmSendToMQService");
		int cnt = 0 ;
		try {
			cnt = mss.sendMessage(json.getBytes());
		} catch (MQException e) {
			e.printStackTrace();
			log.error(ExceptionUtil.getStackTrace(e));
		}catch(Throwable t){
			t.printStackTrace();
			log.error(ExceptionUtil.getStackTrace(t));
		}
		return cnt;
	}

	@Override
	public AbstractMcpEasyMessage handlerMessage(
			AbstractMcpEasyMessage message, ChannelHandlerContext ctx) {
		return message;
	}
}
