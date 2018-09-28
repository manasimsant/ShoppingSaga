package org.dteja.test;
import static org.junit.Assert.assertTrue;

import org.dteja.dao.CategoryDao;
import org.dteja.models.Category;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CategoryDaoTest {

	static CategoryDao categoryDao;
	
	@BeforeClass
	public static void initialize() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("org.dteja");
		context.refresh();
		categoryDao = (CategoryDao) context.getBean("categoryDao");
		((AnnotationConfigApplicationContext)context).close();
	}
	
	@Test
	public void addCategoryTest() {
		Category category = new Category();
		category.setCategoryName("SHIRTS");
		category.setCategoryDesc("All types of shirts are available");
		assertTrue("Problam in adding category",categoryDao.addCategory(category));
	}
	@Test
	public void updateCategoryTest() {
		Category category=categoryDao.getCategory(2);
		category.setCategoryName("Jeans");
		category.setCategoryDesc("Comfortable ones");
		assertTrue("Problem in updating the category",categoryDao.updateCategory(category));
	}

}
