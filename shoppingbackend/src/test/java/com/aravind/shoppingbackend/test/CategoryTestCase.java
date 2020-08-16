package com.aravind.shoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.aravind.shoppingbackend.dao.CategoryDAO;
import com.aravind.shoppingbackend.dto.Category;

public class CategoryTestCase {

	private static AnnotationConfigApplicationContext context;

	private static CategoryDAO categoryDAO;

	private Category category;

	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.aravind.shoppingbackend");
		context.refresh();
		categoryDAO = (CategoryDAO) context.getBean("categoryDAO");
	}

	/*
	 * @Test public void testAddCategory() { category = new Category();
	 * category.setName("Mobile"); category.setDescription("Description Mobile");
	 * category.setImageURL("CAT_2.png");
	 * 
	 * assertEquals("Suucessfully added a category inside the table", true,
	 * categoryDAO.add(category));
	 * 
	 * }
	 */

	/*
	 * @Test public void testGetCategory() { category = categoryDAO.get(33);
	 * assertEquals("Suucessfully fetched a single category from the table",
	 * "Mobile", category.getName()); }
	 */

	/*
	 * @Test public void testUpdateCategory() { category = categoryDAO.get(33);
	 * category.setName("Mob");
	 * assertEquals("Suucessfully Updated a single category from the table", true,
	 * categoryDAO.update(category)); }
	 */

	/*
	 * @Test public void testDeleteCategory() { category = categoryDAO.get(33);
	 * //category.setName("Mob");
	 * assertEquals("Suucessfully Deleted a single category from the table", true,
	 * categoryDAO.delete(category)); }
	 */

	/*
	 * @Test public void testListCategory() {
	 * assertEquals("Suucessfully fetched a list of categories from the table",3,
	 * categoryDAO.list().size()); }
	 */

	/*
	 * @Test public void testCRUDCategory() { category = new Category();
	 * category.setName("MMM"); category.setDescription("Description MMM");
	 * category.setImageURL("CAT_88.png");
	 * 
	 * assertEquals("Suucessfully added a category inside the table", true,
	 * categoryDAO.add(category)); }
	 */
}
