package com.pcitc.oilmachine.commons.certificate;

public class BusinessException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final String code;
	private final String msg;

	public BusinessException(String code, String msg) {
		this(code, msg, null);
	}

	public BusinessException(String code, String msg, Throwable cause) {
		super(msg, cause);
		this.msg = msg;
		this.code = code;
	}
	public BusinessException(String msg){
		this(null,msg, null);
	} 
	public BusinessException(String msg, Throwable cause){
		this(null,msg, cause);
	} 

	public String getCode() {
		return this.code;
	}

	public String getMsg() {
		return this.msg;
	}
}
