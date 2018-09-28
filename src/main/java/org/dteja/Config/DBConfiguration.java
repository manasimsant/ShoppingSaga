package org.dteja.Config;

import java.util.Properties;

import javax.sql.DataSource;

import org.dteja.models.Category;
import org.dteja.models.Product;
import org.dteja.models.User;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration

@EnableTransactionManagement
public class DBConfiguration

{
	@Bean(name="dataSource")
	public DataSource getH2DataSource() {
		
		DriverManagerDataSource dataSource=new DriverManagerDataSource();
		
		dataSource.setDriverClassName("org.h2.Driver");
		
		dataSource.setUrl("jdbc:h2:~/test");
		
		dataSource.setUsername("sa");
		
		dataSource.setPassword("sa");
		
		return dataSource;
		
	}
	
	@Bean(name="sessionFactory")
	public SessionFactory getSessionFactory() {
		
		Properties hibernateProperties=new Properties();
		hibernateProperties.put("hibernate.dialect","org.hibernate.dialect.H2Dialect");
		hibernateProperties.setProperty("hibernate.hbm2ddl.auto", "update");
		hibernateProperties.setProperty("hibernate.show_sql", "true");
		
		
		LocalSessionFactoryBuilder localsessionFactory=new LocalSessionFactoryBuilder(getH2DataSource());
		localsessionFactory.addProperties(hibernateProperties);

		localsessionFactory.addAnnotatedClass(Category.class);	
		localsessionFactory.addAnnotatedClass(Product.class);
		localsessionFactory.addAnnotatedClass(User.class);
		SessionFactory sessionFactory=localsessionFactory.buildSessionFactory();
		
		return sessionFactory;
		
	}
	
	@Bean
	public HibernateTransactionManager hibTransManagement() {
		return new HibernateTransactionManager(getSessionFactory());
		
	}
	
	
}
