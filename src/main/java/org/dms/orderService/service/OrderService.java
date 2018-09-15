/*
 * @author: ${author}
 * @date: 15-sep-2018
 * 
 */
package org.dms.orderService.service;

import org.dms.orderService.entity.Order;

public interface OrderService {

	boolean validateOrder(Order order);

	Order calculateOrder(Order order);

	int test();
}
