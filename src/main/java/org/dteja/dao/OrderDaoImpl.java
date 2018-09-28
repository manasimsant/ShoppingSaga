package org.dteja.dao;

import org.dteja.models.Order;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class OrderDaoImpl implements OrderDao
{

	@Autowired
	SessionFactory sessionFactory;
	@Override
	public boolean insertOrderDetail(Order order) {
		try {
			
			sessionFactory.getCurrentSession().save(order);
			return true;
			
		}
		catch(Exception e) {
			return false;	
		}
		
	}

}
