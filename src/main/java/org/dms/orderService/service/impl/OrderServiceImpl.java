/*
 * @author: ${author}
 * @date: 16-sep-2018
 * 
 */
package org.dms.orderService.service.impl;

import java.math.BigDecimal;

import org.dms.orderService.entity.Order;
import org.dms.orderService.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

	RestTemplate restTemplate;

	@Autowired
	public OrderServiceImpl(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	@Override
	public boolean validateOrder(Order order) {
		return this.restTemplate.postForEntity("http://localhost:8080/phonecatalog/phone/validateOrder",
				order.getPhones(), Boolean.class).getBody();

	}

	@Override
	public Order calculateOrder(Order order) {
		BigDecimal result = this.restTemplate.postForEntity("http://localhost:8080/phonecatalog/phone/getTotalPrice",
				order.getPhones(), BigDecimal.class).getBody();
		order.setTotalPrice(result);
		log.info(order.toString());
		return order;
	}

	@Override
	public int test() {
		return this.restTemplate.getForObject("http://localhost:8080/phonecatalog/phone/test", Integer.class);
	}

}
