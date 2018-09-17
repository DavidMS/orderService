/*
 * @author: ${author}
 * @date: 16-sep-2018
 * 
 */
package org.dms.orderService.web;

import org.dms.orderService.entity.Order;
import org.dms.orderService.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * The Class OrderController.
 */
@RestController
@RequestMapping(value = "/order")
public class OrderController {

	OrderService orderService;

	/**
	 * Instantiates a new order controller.
	 *
	 * @param orderService
	 *            the order service
	 */
	@Autowired
	public OrderController(OrderService orderService) {
		this.orderService = orderService;
	}

	/**
	 * Validate order.
	 *
	 * @param order
	 *            the order to be validated
	 * @return true, if all the phone's ids exists in database, false if not
	 */
	@PostMapping(value = "/validateOrder")
	public boolean validateOrder(@RequestBody Order order) {
		return this.orderService.validateOrder(order);

	}

	/**
	 * Calculate order.
	 *
	 * @param order
	 *            the order to be calculated
	 * @return the order with the calculated total price
	 */
	@PostMapping(value = "/calculateOrder")
	public Order calculateOrder(@RequestBody Order order) {
		Order result = this.orderService.calculateOrder(order);
		return result;
	}
}
