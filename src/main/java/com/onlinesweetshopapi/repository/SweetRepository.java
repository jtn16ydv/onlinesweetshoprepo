package com.onlinesweetshopapi.repository;




import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.onlinesweetshopapi.domain.Sweet;

@Repository
public interface SweetRepository extends JpaRepository<Sweet, Long> {
		
 	Sweet findBySweetIdentifier(String sweetIdentifier);
}
