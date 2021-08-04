package com.onlinesweetshopapi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.onlinesweetshopapi.domain.Admin;
@Repository
public interface AdminRepository extends CrudRepository<Admin, Long>{

	/**
	 * find user by user id
	 * 
	 * @param userId
	 * @return admin
	 */
	Admin findByuserId(String userId);

}
