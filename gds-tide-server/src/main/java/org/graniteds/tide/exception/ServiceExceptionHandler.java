package org.graniteds.tide.exception;

import org.granite.messaging.service.ExtendedServiceExceptionHandler;

public class ServiceExceptionHandler extends ExtendedServiceExceptionHandler {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ServiceExceptionHandler() {
		this(true);
		System.out.println("omg an error append omg !!!");
	}
	
	public ServiceExceptionHandler(boolean logException) {
		super(logException);
		System.out.println("omg an error append omg !!!!!!!!!!!!");
	}
}
