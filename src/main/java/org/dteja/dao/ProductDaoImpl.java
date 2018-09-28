package org.dteja.dao;

import java.util.List;

import org.dteja.models.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("productDao")
@Transactional
public class ProductDaoImpl implements ProductDao {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public boolean addProduct(Product product) {
		try {
			sessionFactory.getCurrentSession().save(product);
			return true;

		} catch (Exception e) {
			return false;
		}

	}

	@Override
	public boolean saveProduct(Product product) {
		try {
			sessionFactory.getCurrentSession().save(product);
			return true;

		} catch (Exception e) {
			return false;
		}

	}

	@Override
	public boolean deleteProduct(Product product) {
		try {
			sessionFactory.getCurrentSession().delete(product);
			return true;

		} catch (Exception e) {
			return false;
		}

	}

	@Override
	public boolean updateProduct(Product product) {
		try {
			sessionFactory.getCurrentSession().update(product);
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	@Override
	public List<Product> listProducts() {
		Session session = sessionFactory.openSession();
		Query<Product> query = session.createQuery("from Product");
		List<Product> listProducts = query.list();
		session.close();
		return listProducts;
	}

	@Override
	public Product getProduct(int productId) {
		Session session = sessionFactory.openSession();
		Product product = (Product) session.get(Product.class, productId);
		session.close();
		return product;
	}

}
