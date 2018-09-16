/*
 * @author: ${author}
 * @date: 16-sep-2018
 * 
 */
package org.dms.orderService.exceptions;

/**
 * The Class OrderServiceException. Base class for application Exceptions.
 */
public class OrderServiceException extends RuntimeException {

	/**
	 * Instantiates a new order service exception.
	 *
	 * @param message
	 *            the message
	 */
	OrderServiceException(String message) {
		super(message);
	}
}
