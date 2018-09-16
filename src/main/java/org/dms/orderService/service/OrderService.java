/*
 * @author: ${author}
 * @date: 16-sep-2018
 * 
 */
package org.dms.orderService.service;

import org.dms.orderService.entity.Order;

/**
 * The Interface OrderService.
 */
public interface OrderService {

	/**
	 * Validate order.
	 *
	 * @param order
	 *            the order. The order object to be validated. An order object is
	 *            valid when all the phones ids in it exists in the database.
	 * @return true, if all the order's phone's ids exists in the database, false if
	 *         not.
	 */
	boolean validateOrder(Order order);

	/**
	 * Calculate order.
	 *
	 * @param order
	 *            the order object to be calculated.
	 * @return the order with the calculated total price (sum of all phones values)
	 */
	Order calculateOrder(Order order);

}
