package com.devsuperior.dslearnbds.services.exceptions;

public class ForbiddenException extends RuntimeException{

	private static final long serialVersionUID = 8362400374349576685L;

	public ForbiddenException(String msg) {
		super(msg);
	}

}
