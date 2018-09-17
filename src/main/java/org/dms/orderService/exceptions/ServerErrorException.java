/*
 * @author: ${author}
 * @date: 16-sep-2018
 * 
 */
package org.dms.orderService.exceptions;

/**
 * The Class ServerErrorException. Raised when a Server error is thrown by a
 * RestTemplate call.
 */
public class ServerErrorException extends OrderServiceException {

	/**
	 * Instantiates a new server error exception.
	 */
	public ServerErrorException() {
		super("Error in the Server. Do something about it... or not... who cares...");
	}
}
