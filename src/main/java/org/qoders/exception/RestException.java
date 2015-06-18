package org.qoders.exception;

public class RestException extends Exception {
	private static final long serialVersionUID = -8690751152293315812L;
	
	public RestException(String ex){
		super(ex);
	}
}
