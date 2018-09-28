package org.dteja.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Category 
{
	@Id
	@GeneratedValue
	@Column
	private int categoryId;
	@Column
	private String categoryName;
	@Column
	private String CategoryDesc;
	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getCategoryDesc() {
		return CategoryDesc;
	}

	public void setCategoryDesc(String CategoryDesc) {
		this.CategoryDesc = CategoryDesc;
	}
}
 