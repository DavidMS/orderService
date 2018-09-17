/*
 * @author: ${author}
 * @date: 16-sep-2018
 * 
 */
package org.dms.orderService.web;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.dms.orderService.entity.Order;
import org.dms.orderService.service.OrderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@WebMvcTest(OrderController.class)
public class OrderControllerTest {

	@Autowired
	MockMvc mockMvc;

	@MockBean
	OrderService orderService;

	@Autowired
	ObjectMapper objectMapper;

	@Test
	public void testValidateOrderSuccessfully() throws Exception {
		Order order = new Order();
		when(this.orderService.validateOrder(ArgumentMatchers.any(Order.class))).thenReturn(true);
		this.mockMvc
				.perform(post("/order/validateOrder").contentType(MediaType.APPLICATION_JSON)
						.content(this.objectMapper.writeValueAsString(order)))
				.andExpect(status().isOk()).andExpect(content().string("true"));
	}

	@Test
	public void testValidateOrderNotOk() throws Exception {
		Order order = new Order();
		when(this.orderService.validateOrder(ArgumentMatchers.any(Order.class))).thenReturn(false);
		this.mockMvc
				.perform(post("/order/validateOrder").contentType(MediaType.APPLICATION_JSON)
						.content(this.objectMapper.writeValueAsString(order)))
				.andExpect(status().isOk()).andExpect(content().string("false"));
	}

	@Test
	public void testCalculateOrderOk() throws Exception {
		Order order = new Order();
		List<Long> phonesIds = new ArrayList<>();
		order.setEmail("example");
		order.setId(1L);
		order.setName("example");
		order.setSurname("example");
		order.setTotalPrice(BigDecimal.valueOf(0L));
		phonesIds.add(1L);
		order.setPhones(phonesIds);
		when(this.orderService.calculateOrder(ArgumentMatchers.any(Order.class))).thenReturn(order);
		this.mockMvc
				.perform(post("/order/calculateOrder").contentType(MediaType.APPLICATION_JSON)
						.content(this.objectMapper.writeValueAsString(order)))
				.andExpect(status().isOk()).andExpect(jsonPath("$.email", is("example")))
				.andExpect(jsonPath("$.id", notNullValue()));
	}

}
