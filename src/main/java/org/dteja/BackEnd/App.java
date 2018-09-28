package org.dteja.BackEnd;

import org.dteja.Config.DBConfiguration;
import org.dteja.dao.CategoryDaoImpl;
import org.dteja.dao.ProductDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("org.dteja.models")


public class App 
{
	@Autowired
    public static void main( String[] args )
    {
    	ApplicationContext context = new AnnotationConfigApplicationContext(DBConfiguration.class,CategoryDaoImpl.class,ProductDaoImpl.class);    		
    	
    	((AnnotationConfigApplicationContext)context).close();
   
		
     
    }
}
