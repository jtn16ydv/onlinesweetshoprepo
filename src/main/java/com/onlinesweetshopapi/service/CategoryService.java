package com.onlinesweetshopapi.service;

import com.onlinesweetshopapi.domain.Category;

public interface CategoryService {

	public Category save(Category category);
	public Iterable<Category> getCategories();
	public Category findCategoryByCategoryIdentifier(String categoryIdentifier);
	public void deleteCategoryByCategoryIdentifier(String categoryIdentifier);
}
