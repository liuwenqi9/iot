package com.afs.tupeasy.message;

/**
 * 在解码器中调用，生成一个新消息实例
 * @author zhang
 *
 */
public interface MessageFactory {
	public Message newMessage(String packageHead,byte messageType);
}
