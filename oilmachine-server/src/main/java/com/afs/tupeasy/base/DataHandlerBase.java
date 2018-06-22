package com.afs.tupeasy.base;


import com.afs.tupeasy.message.AbstractMcpEasyMessage;

import io.netty.channel.ChannelHandlerContext;

/**
 * 业务继承这个类接收消息并处理
 * @author zhang
 *
 */
public interface DataHandlerBase {
	public AbstractMcpEasyMessage handlerMessage(AbstractMcpEasyMessage message,ChannelHandlerContext ctx);
}
