package com.afs.fasm.mqconsumer;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.afs.base.mq.MessageHandler;
import com.afs.base.util.MySpringContextUtil;
import com.alibaba.fastjson.JSONObject;
import com.pcitc.oilmachine.commons.utils.StringUtils;
import com.pcitc.oilmachine.service.mobile.CommonService;
import com.rabbitmq.client.BasicProperties;

public class MessageToDBConsumer implements MessageHandler {
	private static Logger log = LogManager.getLogger(MessageToDBConsumer.class.getName());
   
   
   @Override
	public boolean handleMessage(byte[] message, BasicProperties prop) {
		boolean result = false;
	   
	   try{
		   JSONObject messages = JSONObject.parseObject(new String(message,"utf-8"));
		   CommonService commonService = (CommonService) MySpringContextUtil.getBean("commonService");
		   commonService.saveSaleOrder(messages);
		   result = true;
	   } catch (Exception e) {
			e.printStackTrace();
			log.error(StringUtils.getErrorInfoFromException(e));
		}
		return result;
	}
}
