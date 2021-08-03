package com.onlinesweetshopapi.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@NotBlank(message = "customer Name is Required")
	private String customerName;
	@NotBlank(message = "customer Id is Required")
	@Size(min = 4, max = 6, message = "Size must be between 4 to 6 character")
	@Column(unique = true, updatable = false)
	private String customerId;
	@NotBlank(message = "customer Password is Required")
	private String customerPassword;
	@NotBlank(message = "customer Email is Required")
	private String customerEmail;
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "customer")
	private List<Order> order = new ArrayList<Order>();
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "customer")
	private Event event;
	private int isloggedIn;

	/**
	 * Customer Constructor
	 */
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Customer parameterized constructor
	 * 
	 * @param customerName
	 * @param customerId
	 * @param customerPassword
	 * @param customerEmail
	 * @param isloggedIn
	 */
	public Customer(@NotBlank(message = "customer Name is Required") String customerName,
			@NotBlank(message = "customer Id is Required") @Size(min = 4, max = 6, message = "Size must be between 4 to 6 character") String customerId,
			@NotBlank(message = "customer Password is Required") String customerPassword,
			@NotBlank(message = "customer Email is Required") String customerEmail, int isloggedIn) {
		super();
		this.customerName = customerName;
		this.customerId = customerId;
		this.customerPassword = customerPassword;
		this.customerEmail = customerEmail;
		this.isloggedIn = isloggedIn;
	}

	/**
	 * Get the event
	 * 
	 * @return event Event
	 */
	public Event getEvent() {
		return event;
	}

	/**
	 * Set the event
	 * 
	 * @param event
	 */
	public void setEvent(Event event) {
		this.event = event;
	}

	/**
	 * Gets list of orders
	 * 
	 * @return order List
	 */
	public List<Order> getOrder() {
		return order;
	}

	/**
	 * Sets the list of order
	 * 
	 * @param order list
	 */
	public void setOrder(List<Order> order) {
		this.order = order;
	}

	/**
	 * Gets loginStatus
	 * 
	 * @return IsoggedIn int
	 */
	public int getIsloggedIn() {
		return isloggedIn;
	}

	/**
	 * Sets loginStatus
	 * 
	 * @param isloggedIn int
	 */
	public void setIsloggedIn(int isloggedIn) {
		this.isloggedIn = isloggedIn;
	}

	/**
	 * Gets id
	 * 
	 * @return id long
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Sets id
	 * 
	 * @param id long
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Gets CustomerName
	 * 
	 * @return customerName
	 */
	public String getCustomerName() {
		return customerName;
	}

	/**
	 * Sets CustomerName
	 * 
	 * @param customerName
	 */
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	/**
	 * Gets CustomerId
	 * 
	 * @return customerId
	 */
	public String getCustomerId() {
		return customerId;
	}

	/**
	 * Sets CustomerId
	 * 
	 * @param customerId String
	 */
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	/**
	 * Gets Customer Password
	 * 
	 * @return customerPassword
	 */
	public String getCustomerPassword() {
		return customerPassword;
	}

	/**
	 * Sets cutomerPassword
	 * 
	 * @param customerPassword
	 */
	public void setCustomerPassword(String customerPassword) {
		this.customerPassword = customerPassword;
	}

	/**
	 * Gets customerEmail
	 * 
	 * @return customerEmail
	 */
	public String getCustomerEmail() {
		return customerEmail;
	}

	/**
	 * Sets customerEmail
	 * 
	 * @param customerEmail
	 */
	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	/**
	 * Overiding to String Method
	 */
	@Override
	public String toString() {
		return "Customer [customerName=" + customerName + ", customerId=" + customerId + ", customerPassword="
				+ customerPassword + ", customerEmail=" + customerEmail + "]";
	}

}
