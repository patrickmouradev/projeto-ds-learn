package com.devsuperior.dslearnbds.services.exceptions;

public class UnauthorizedException extends RuntimeException{

	private static final long serialVersionUID = 4130174912767924138L;

	public UnauthorizedException(String msg) {
		super(msg);
	}

}
