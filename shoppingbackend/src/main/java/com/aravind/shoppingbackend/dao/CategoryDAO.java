package com.aravind.shoppingbackend.dao;

import java.util.List;

import com.aravind.shoppingbackend.dto.Category;

public interface CategoryDAO {
	
	List<Category> list();
	Category get(int id);
	

}
