package com.nt.exception;

public class ActorNotFoundException extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 780137793018420316L;

	public ActorNotFoundException(){
		super();
	}
	
	public ActorNotFoundException(String msg){
		super(msg);
	}

}
