/*
 * @author: ${author}
 * @date: 16-sep-2018
 * 
 */
package org.dms.orderService.entity;

import java.math.BigDecimal;
import java.util.List;

/**
 * The Class Order. This class was meant to be an Entity. In that case, there
 * should be two tables in the database: one for the Orders and another with the
 * relationship (many-to-many) between Orders and Phone's ids.
 */
public class Order {

	private Long id;
	private String name;
	private String surname;
	private String email;
	private BigDecimal totalPrice;
	private List<Long> phones;

	/**
	 * @return the id
	 */
	public Long getId() {
		return this.id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the surname
	 */
	public String getSurname() {
		return this.surname;
	}

	/**
	 * @param surname
	 *            the surname to set
	 */
	public void setSurname(String surname) {
		this.surname = surname;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return this.email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the phones
	 */
	public List<Long> getPhones() {
		return this.phones;
	}

	/**
	 * @param phones
	 *            the phones to set
	 */
	public void setPhones(List<Long> phones) {
		this.phones = phones;
	}

	/**
	 * @return the totalPrice
	 */
	public BigDecimal getTotalPrice() {
		return this.totalPrice;
	}

	/**
	 * @param totalPrice
	 *            the totalPrice to set
	 */
	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Order [id=" + this.id + ", name=" + this.name + ", surname=" + this.surname + ", email=" + this.email
				+ ", totalPrice=" + this.totalPrice + ", phones=" + this.phones + "]";
	}

}
