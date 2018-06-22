package com.afs.tupeasy.base;

import com.afs.tupeasy.message.AbstractMcpEasyMessage;

import io.netty.channel.ChannelHandlerContext;

//接收到消息后，netty自动调用这个接口的实现类,在实现类中区分是否有进程等待这个响应消息，
//如果有将消息给进程，如果没有调用业务的消息处理类,如果处理消息后需要返回一个消息，则返回message，否则返回null
public interface NettyReceiveMessageService {
	public void onReceiveMessage(AbstractMcpEasyMessage message, ChannelHandlerContext ctx);
}
