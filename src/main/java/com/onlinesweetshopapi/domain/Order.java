package com.onlinesweetshopapi.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Orders")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotBlank(message = "customerIdentfier is required")
	@Size(min = 4, max = 6, message = "Size must be between 4 to 6 characters")
	private String customerIdentifier;

	@Column(columnDefinition = "text")
	@NotBlank(message = "paymentMethod is required")
	private String paymentMethod;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
	@JoinColumn(name = "customer_id", updatable = false, nullable = false)
	@JsonIgnore
	private Customer customer;

	@Column(columnDefinition = "text")
	@NotBlank(message = "orderId is required")
	@Size(min = 4, max = 6, message = "Size must be between 4 to 6 characters")
	private String orderId;

	@NotBlank(message = "deliveryAddress is required")
	private String deliveryAddress;

	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date orderDate;

	@NotBlank(message = "sweetIdentifier is required")
	private String sweetIdentifier;

	@Column(columnDefinition = "text")
	@NotBlank(message = "orderDetails is required")
	private String orderDetails;

	@Column(columnDefinition = "text")
	private String orderStatus;

	private double orderPrice;

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "fb_id", nullable = false)
	private Feedback feedback;

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "orders_sweets", joinColumns = {
			@JoinColumn(name = "order_id", referencedColumnName = "id", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "sweet_id", referencedColumnName = "sweetId", nullable = false, updatable = false) })
	@JsonIgnore
	private List<Sweet> sweets = new ArrayList<>();

	/**
	 * Constructor for Order
	 */
	public Order() {
		super();
	}

	/**
	 * Parameterized Order Constructor
	 * 
	 * @param customerIdentifier
	 * @param paymentMethod
	 * @param orderId
	 * @param deliveryAddress
	 * @param sweetIdentifier
	 * @param orderDetails
	 * @param orderStatus
	 */
	public Order(String customerIdentifier, String paymentMethod, String orderId, String deliveryAddress,
			String sweetIdentifier, String orderDetails, String orderStatus) {
		super();
		this.customerIdentifier = customerIdentifier;
		this.paymentMethod = paymentMethod;
		this.orderId = orderId;
		this.deliveryAddress = deliveryAddress;
		this.sweetIdentifier = sweetIdentifier;
		this.orderDetails = orderDetails;
		this.orderStatus = orderStatus;
	}

	/**
	 * Gets SweetIdentifier
	 * 
	 * @return sweetIdentifier
	 */
	public String getSweetIdentifier() {
		return sweetIdentifier;
	}

	/**
	 * Sets SweetIdentifier
	 * 
	 * @param sweetIdentifier
	 */
	public void setSweetIdentifier(String sweetIdentifier) {
		this.sweetIdentifier = sweetIdentifier;
	}

	/**
	 * Gets Customer
	 * 
	 * @return Customer
	 */
	public Customer getCustomer() {
		return customer;
	}

	/**
	 * Sets Customer
	 * 
	 * @param Customer
	 */
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	/**
	 * Gets CustomerIdentifier
	 * 
	 * @return CustomerIdentifier
	 */
	public String getCustomerIdentifier() {
		return customerIdentifier;
	}

	/**
	 * Sets CustomerIdentifier
	 * 
	 * @param CustomerIdentifier
	 */
	public void setCustomerIdentifier(String customerIdentifier) {
		this.customerIdentifier = customerIdentifier;
	}

	/**
	 * Gets OrderDate
	 * 
	 * @return Orderdate
	 */
	public Date getOrderDate() {
		return orderDate;
	}

	/**
	 * Sets OrderDate
	 * 
	 * @param OrderDate
	 */
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	/**
	 * Gets OrderId
	 * 
	 * @return OrderId
	 */
	public String getOrderId() {
		return orderId;
	}

	/**
	 * Sets OrderId
	 * 
	 * @param OrderId
	 */
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	/**
	 * Gets Feedback
	 * 
	 * @return feeedback
	 */
	public Feedback getFeedback() {
		return feedback;
	}

	/**
	 * Sets Feedback
	 * 
	 * @param feeedback
	 */
	public void setFeedback(Feedback feedback) {
		this.feedback = feedback;
	}

	/**
	 * Gets Id
	 * 
	 * @return Id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Sets Id
	 * 
	 * @param Id
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Gets paymentMethod
	 * 
	 * @return paymentMethod
	 */
	public String getPaymentMethod() {
		return paymentMethod;
	}

	/**
	 * Sets paymentMethod
	 * 
	 * @param paymentMethod
	 */
	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	/**
	 * Gets deliveryAddress
	 * 
	 * @return deliveryAddress
	 */
	public String getDeliveryAddress() {
		return deliveryAddress;
	}

	/**
	 * Sets deliveryAddress
	 * 
	 * @param deliveryAddress
	 */
	public void setDeliveryAddress(String deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}

	/**
	 * Gets orderDetails
	 * 
	 * @return orderDetails
	 */
	public String getOrderDetails() {
		return orderDetails;
	}

	/**
	 * Sets orderDetails
	 * 
	 * @param orderDetails
	 */
	public void setOrderDetails(String orderDetails) {
		this.orderDetails = orderDetails;
	}

	/**
	 * Gets orderStatus
	 * 
	 * @return orderStatus
	 */
	public String getOrderStatus() {
		return orderStatus;
	}

	/**
	 * Sets orderStatus
	 * 
	 * @param orderStatus
	 */
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	/**
	 * Gets orderPrice
	 * 
	 * @return orderPrice
	 */
	public double getOrderPrice() {
		return orderPrice;
	}

	/**
	 * Sets orderPrice
	 * 
	 * @param orderPrice
	 */
	public void setOrderPrice(double orderPrice) {
		this.orderPrice = orderPrice;
	}

	/**
	 * Gets Sweets List
	 * 
	 * @return Sweets
	 */
	public List<Sweet> getSweets() {
		return sweets;
	}

	/**
	 * Sets Sweets List
	 * 
	 * @param Sweets List
	 */
	public void setSweets(List<Sweet> sweets) {
		this.sweets = sweets;
	}

	/**
	 * Set orderDate to currentDate
	 */
	@PrePersist
	public void onOrder() {
		this.orderDate = new Date();
	}

}
