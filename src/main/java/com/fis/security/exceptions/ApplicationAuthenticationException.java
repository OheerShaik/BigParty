package com.fis.security.exceptions;

import java.io.Serializable;

/*
 * This Exception must be used only for Authentication purpose.
 */

public class ApplicationAuthenticationException extends Exception implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// for only exception message
	public ApplicationAuthenticationException(String message) {
		super(message);
	}

	// for only cause
	public ApplicationAuthenticationException(Throwable cause) {
		super(cause);
	}

	// for message and cause
	public ApplicationAuthenticationException(String message, Throwable cause) {
		super(message, cause);
	}

}
