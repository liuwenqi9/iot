package com.afs.tupeasy.encoder;

import com.afs.tupeasy.message.Message;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * 在此类中，把消息对象编码为二进制发送出去
 * @author zhang
 *
 */
public class McpServerEncoder extends MessageToByteEncoder<Message> {

	@Override
	protected void encode(ChannelHandlerContext ctx, Message message, ByteBuf out)
			throws Exception {
		
		if(message==null){
			throw new Exception("message is null");
		}
		message.encode(out);
	}
}
