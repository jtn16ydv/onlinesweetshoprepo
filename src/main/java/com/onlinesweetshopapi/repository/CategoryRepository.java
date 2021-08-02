package com.onlinesweetshopapi.repository;




import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.onlinesweetshopapi.domain.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer>{
	
	Category findByCategoryIdentifier(String categoryIdentifier);
}
