package com.afs.fasm.mcp.mq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.afs.base.mq.MessageHandler;
import com.rabbitmq.client.BasicProperties;

public class DownMessageConsumer implements MessageHandler {
	
	private static Logger log = LoggerFactory.getLogger(DownMessageConsumer.class);

	@Override
	public boolean handleMessage(byte[] message, BasicProperties prop) {
		try {
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

}
