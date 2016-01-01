package com.own.gameengine.error;


public class Error {
	
	public static void throwException(final String text) throws Exception {
		throw new Exception(text);
	}
	
	public static void throwRuntimeException(final String text) {
		throw new RuntimeException(text);
	}
}
