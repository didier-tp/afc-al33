package fr.afcepf.al33.tp.service;
//public class MyServiceException extends Exception {
public class MyServiceException extends RuntimeException {
	//private String details; 

	public MyServiceException() {
	}

	public MyServiceException(String message) {
		super(message);
	}

	public MyServiceException(Throwable cause) {
		super(cause);
	}

	public MyServiceException(String message, Throwable cause) {
		super(message, cause);
	}

	public MyServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
