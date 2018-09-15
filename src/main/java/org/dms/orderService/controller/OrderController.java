/*
 * @author: ${author}
 * @date: 15-sep-2018
 * 
 */
package org.dms.orderService.controller;

import org.dms.orderService.entity.Order;
import org.dms.orderService.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/order")
public class OrderController {

	OrderService orderService;

	@Autowired
	public OrderController(OrderService orderService) {
		this.orderService = orderService;
	}

	@PostMapping(value = "/validateOrder")
	public boolean validateOrder(@RequestBody Order order) {
		return this.orderService.validateOrder(order);

	}

	@PostMapping(value = "/calculateOrder")
	public Order calculateOrder(@RequestBody Order order) {
		return this.orderService.calculateOrder(order);
	}

	@GetMapping(value = "/test")
	public int getOrderId() {
		return this.orderService.test();
	}
}
