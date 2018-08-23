package com.afs.fasm.mcp.datahandler;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.afs.tupeasy.session.SessionManager;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.timeout.ReadTimeoutException;
import io.netty.handler.timeout.ReadTimeoutHandler;

public class MyReadTimeoutHander extends ReadTimeoutHandler {
	private static Logger log = LogManager.getLogger(MyReadTimeoutHander.class.getName());
	public MyReadTimeoutHander(int timeoutSeconds) {
		super(timeoutSeconds);
	}

	@Override
	protected void readTimedOut(ChannelHandlerContext ctx) throws Exception {
		log.info("readtimeout,clientId is:" + SessionManager.getClientIdByChannelId(ctx.channel().id().toString()) );
		super.readTimedOut(ctx);
	}
	
	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause)
			throws Exception {
		if(cause instanceof ReadTimeoutException){
			log.info("捕获到ReadTimeoutException");
		}
		super.exceptionCaught(ctx, cause);
	}
	
	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg)
			throws Exception {
		super.channelRead(ctx, msg);
		log.info("MyReadTimeoutHander--channelRead");
	}
	
}
