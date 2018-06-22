package com.afs.tupeasy.message;

import java.io.Serializable;

import com.afs.tupeasy.exception.CommunicationException;

import io.netty.buffer.ByteBuf;


public interface Message extends Serializable{
	public abstract void decode(ByteBuf in) throws CommunicationException ;
	public abstract void encode(ByteBuf out) throws CommunicationException;
	public abstract void printlnMsg();
	public boolean isCheckbitOk()throws CommunicationException ;
	public void validateMessage()throws CommunicationException ;
}
