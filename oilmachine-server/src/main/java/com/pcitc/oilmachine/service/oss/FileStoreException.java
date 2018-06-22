package com.pcitc.oilmachine.service.oss;

public class FileStoreException extends Exception {
	private static final long serialVersionUID = 1L;

	public FileStoreException() {
	}

	public FileStoreException(String message) {
		super(message);
	}

	public FileStoreException(String message, Throwable cause) {
		super(message, cause);
	}

	public FileStoreException(Throwable cause) {
		super(cause);
	}
}