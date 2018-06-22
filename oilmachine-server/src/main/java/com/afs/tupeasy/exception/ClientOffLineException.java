package com.afs.tupeasy.exception;

public class ClientOffLineException extends CommunicationException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ClientOffLineException(){
		super();
	}
	
	public ClientOffLineException(String cause){
		super(cause);
	}
}
