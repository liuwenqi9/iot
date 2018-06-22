package com.afs.fasm.mcp.datahandler;


//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import io.netty.channel.ChannelHandlerContext;

import com.afs.tupeasy.message.AbstractMcpEasyMessage;

public class OildeviceMessageHandler extends CommonMessageHandler {
	//private static Logger log = LoggerFactory.getLogger(OildeviceMessageHandler.class);
	@Override
	public AbstractMcpEasyMessage handlerMessage(AbstractMcpEasyMessage message,
			ChannelHandlerContext ctx) {
		return message;
	}
}
