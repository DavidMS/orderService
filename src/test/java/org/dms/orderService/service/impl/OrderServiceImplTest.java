/*
 * @author: ${author}
 * @date: 16-sep-2018
 * 
 */
package org.dms.orderService.service.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.dms.orderService.entity.Order;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@RunWith(MockitoJUnitRunner.class)
public class OrderServiceImplTest {

	@Mock
	RestTemplate restTemplate;

	@InjectMocks
	OrderServiceImpl orderService;

	private final String VALIDATE_ORDER_URL = "http://localhost:8080/phonecatalog/phone/validateOrder";
	private final String CALCULATE_ORDER_URL = "http://localhost:8080/phonecatalog/phone/getTotalPrice";

	@Test
	public void validateOrderTrueTest() {

		List<Long> phonesIdsList = new ArrayList<>();
		phonesIdsList.add(1L);
		phonesIdsList.add(2L);

		Order order = new Order();
		order.setPhones(phonesIdsList);

		when(this.restTemplate.postForEntity(this.VALIDATE_ORDER_URL, phonesIdsList, Boolean.class))
				.thenReturn(new ResponseEntity<Boolean>(true, HttpStatus.OK));

		boolean result = this.orderService.validateOrder(order);
		assertTrue(result);
	}

	@Test
	public void validateOrderFalseTest() {

		List<Long> phonesIdsList = new ArrayList<>();
		phonesIdsList.add(1L);
		phonesIdsList.add(2L);

		Order order = new Order();
		order.setPhones(phonesIdsList);

		when(this.restTemplate.postForEntity(this.VALIDATE_ORDER_URL, phonesIdsList, Boolean.class))
				.thenReturn(new ResponseEntity<Boolean>(false, HttpStatus.OK));

		boolean result = this.orderService.validateOrder(order);
		assertFalse(result);
	}

	@Test
	public void calculateOrderOkTest() {

		List<Long> phonesIdsList = new ArrayList<>();
		phonesIdsList.add(1L);
		phonesIdsList.add(2L);

		Order order = new Order();
		order.setPhones(phonesIdsList);

		when(this.restTemplate.postForEntity(this.CALCULATE_ORDER_URL, phonesIdsList, BigDecimal.class))
				.thenReturn(new ResponseEntity<BigDecimal>(BigDecimal.valueOf(2000.0), HttpStatus.OK));

		Order result = this.orderService.calculateOrder(order);
		assertNotNull(result);
		assertEquals(result.getTotalPrice(), BigDecimal.valueOf(2000.0));
	}

}
