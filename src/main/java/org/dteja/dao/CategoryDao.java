package org.dteja.dao;

import org.dteja.models.Category;

 
public interface CategoryDao 
{	
	public boolean addCategory(Category category);
	
	public boolean updateCategory(Category category);
	
	public boolean deleteCategory(Category category);

	public Category getCategory(int categoryId);

	
}
