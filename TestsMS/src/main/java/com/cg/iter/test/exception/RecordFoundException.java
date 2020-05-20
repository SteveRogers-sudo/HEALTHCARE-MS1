package com.cg.iter.test.exception;
/**
 * @author Bishal
 *
 */
public class RecordFoundException extends RuntimeException {
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public RecordFoundException(String msg){
	        super(msg);
	    }
	    public RecordFoundException(String msg,Throwable e){
	        super(msg,e);
	    }
}
