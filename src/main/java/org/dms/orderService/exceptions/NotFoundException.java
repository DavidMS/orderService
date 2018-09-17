/*
 * @author: ${author}
 * @date: 16-sep-2018
 * 
 */
package org.dms.orderService.exceptions;

/**
 * The Class NotFoundException. Rised when a Not Found erro is thrown by a
 * RestTemplate call.
 */
public class NotFoundException extends OrderServiceException {

	/**
	 * Instantiates a new not found exception.
	 */
	public NotFoundException() {
		super("I can't find the resource you are looking for. Update your URLs.");
	}
}
