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

/**
 * The Class OrderServiceImpl.
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

	private static final String GET_TOTAL_PRICE_URL = "/phonecatalog/phone/getTotalPrice";
	private static final String VALIDATE_ORDER_URL = "/phonecatalog/phone/validateOrder";

	/** The rest template. */
	private RestTemplate restTemplate;

	/**
	 * Instantiates a new order service impl.
	 *
	 * @param restTemplate
	 *            the rest template
	 */
	@Autowired
	public OrderServiceImpl(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.dms.orderService.service.OrderService#validateOrder(org.dms.orderService.
	 * entity.Order)
	 */
	@Override
	public boolean validateOrder(Order order) {
		return this.restTemplate.postForEntity(VALIDATE_ORDER_URL, order.getPhones(), Boolean.class).getBody();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.dms.orderService.service.OrderService#calculateOrder(org.dms.orderService
	 * .entity.Order)
	 */
	@Override
	public Order calculateOrder(Order order) {
		BigDecimal result = this.restTemplate.postForEntity(GET_TOTAL_PRICE_URL, order.getPhones(), BigDecimal.class)
				.getBody();
		order.setTotalPrice(result);
		log.info(order.toString());
		return order;
	}

}
