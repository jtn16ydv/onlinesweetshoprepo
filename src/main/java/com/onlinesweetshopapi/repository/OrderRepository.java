package com.onlinesweetshopapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.onlinesweetshopapi.domain.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
	
	/**
	 * find order by order id
	 * 
	 * @param orderId
	 * @return order
	 */
	public Order findByOrderId(String orderId);
}
