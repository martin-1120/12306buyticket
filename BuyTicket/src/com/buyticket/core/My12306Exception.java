package com.buyticket.core;

public class My12306Exception extends Exception{
	private static final long serialVersionUID = 1L;
	public My12306Exception(String msg) {
		super(msg);
	}
	
	public My12306Exception(String msg,Throwable throwable) {
		super(msg,throwable);
	}

	
}
