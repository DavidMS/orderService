/*
 * @author: ${author}
 * @date: 16-sep-2018
 * 
 */
package org.dms.orderService.web;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.dms.orderService.entity.Order;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * The Class OrderControllerIT. Eureka Service, Zuul Service and PhoneCatalog
 * Service must be up in order for this test to be executed successfully.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class OrderControllerIT {

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void validateOrderIT() {
		Order order = new Order();
		List<Long> phonesIds = new ArrayList<>();
		order.setEmail("example");
		order.setId(1L);
		order.setName("example");
		order.setSurname("example");
		order.setTotalPrice(BigDecimal.valueOf(0L));
		phonesIds.add(1L);
		order.setPhones(phonesIds);
		ResponseEntity<Boolean> responseEntity = this.restTemplate.postForEntity("/order/validateOrder", order,
				Boolean.class);
		boolean response = responseEntity.getBody();
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
		assertEquals(true, responseEntity.getBody()); // We shouldn't do this assert unless is a deterministic answer
	}

	@Test
	public void calculateOrderIT() {
		Order order = new Order();
		List<Long> phonesIds = new ArrayList<>();
		order.setEmail("example");
		order.setId(1L);
		order.setName("example");
		order.setSurname("example");
		order.setTotalPrice(BigDecimal.valueOf(0L));
		phonesIds.add(1L);
		order.setPhones(phonesIds);
		ResponseEntity<Order> responseEntity = this.restTemplate.postForEntity("/order/calculateOrder", order,
				Order.class);
		Order response = responseEntity.getBody();
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
		assertEquals("example", responseEntity.getBody().getEmail()); // In this case we know the answer because the
																		// order returned is the same, but again we
																		// shouldn't do this assert
	}
}
