package com.afs.tupeasy.exception;

public class CommunicationException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CommunicationException(){
		super();
	}
	
	public CommunicationException(String cause){
		super(cause);
	}
	
}
