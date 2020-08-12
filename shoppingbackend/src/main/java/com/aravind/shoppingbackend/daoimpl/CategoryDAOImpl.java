package com.aravind.shoppingbackend.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.aravind.shoppingbackend.dao.CategoryDAO;
import com.aravind.shoppingbackend.dto.Category;

@Repository("categoryDAO")
public class CategoryDAOImpl implements CategoryDAO {

	private static List<Category> categories = new ArrayList<>();

	static {
		Category category = new Category();

		// adding first Category
		category.setId(1);
		category.setName("Telivision");
		category.setDescription("Description TV");
		category.setImageURL("CAT_1.png");

		categories.add(category);

		// adding second Category
		category = new Category();
		category.setId(2);
		category.setName("Mobile");
		category.setDescription("Description Mobile");
		category.setImageURL("CAT_2.png");

		categories.add(category);

		// adding third Category
		category = new Category();
		category.setId(3);
		category.setName("Laptop");
		category.setDescription("Description laptop");
		category.setImageURL("CAT_3.png");

		categories.add(category);
	}

	@Override
	public List<Category> list() {
		return categories;
	}

	@Override
	public Category get(int id) {
		for(Category category:categories) {
			if(category.getId()==id) return category;
		}
		return null;
	}

}
