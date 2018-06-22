package com.afs.tupeasy.base;

import com.afs.tupeasy.exception.CommunicationException;
import com.afs.tupeasy.message.AbstractMcpEasyMessage;


//这个类的实例是在客户端登录到服务器，校验成功后建立的，并保存在SessionManager中，对于每个
//客户端，都有这样一个实例。
public interface NettySendMessageService {
    /**
     * 向一个客户端发送消息,并同步等待响应消息
     * @param clientId 该客户端id
     * @param message 要发送的消息
     * @param timeout 等待超时时间，以毫秒为单位
     * @return waitResponse为true的情况下返回响应消息，否则为null
     * @throws McpException
     */
	public AbstractMcpEasyMessage sendMessage(String clientId,AbstractMcpEasyMessage message,int timeout_milliscond) throws CommunicationException;
	/**
	 * 发送消息，不等待响应消息
	 * @param clientId
	 * @param message
	 * @throws McpException
	 */
	public void sendMessageNoWaitResponse(String clientId,AbstractMcpEasyMessage message) throws CommunicationException;
	
	/**
	 * 断开一个客户端的连接
	 * @param channelId 客户单channelId
	 */
	public void disConnect(String clientId)throws CommunicationException;
}
