/*
 * @author: ${author}
 * @date: 16-sep-2018
 * 
 */
package org.dms.orderService.exceptions;

/**
 * The Class ClientErrorException. Thrown when a Client error exception rises by
 * the RestTemplate calls.
 */
public class ClientErrorException extends OrderServiceException {

	/**
	 * Instantiates a new client error exception.
	 */
	public ClientErrorException() {
		super("Error in the Client. Do something about it... or not... who cares...");
	}
}
