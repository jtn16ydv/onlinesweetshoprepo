package com.onlinesweetshopapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.onlinesweetshopapi.domain.Offer;

@Repository
public interface OfferRepository extends JpaRepository<Offer, Long> {

	/**
	 * find offer by offer id
	 * 
	 * @param offerId
	 * @return offer
	 */
	Offer findByOfferId(String offerId);
}
