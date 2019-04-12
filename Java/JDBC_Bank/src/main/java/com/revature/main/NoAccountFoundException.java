package com.revature.main;

public class NoAccountFoundException extends Exception {

	//only method/constructor
	public NoAccountFoundException(String errorMessage) {
        super(errorMessage);
    }
	
}
