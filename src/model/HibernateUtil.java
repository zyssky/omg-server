package model;

import javax.imageio.spi.ServiceRegistry;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;


import entity.User;

public final class HibernateUtil {
	private static SessionFactory sessionFactory;  
    private HibernateUtil(){  
          
    }  
      
    static{  
    	try {
            Configuration cfg=new Configuration();
            cfg.configure();  
            cfg.addAnnotatedClass(User.class);
            
            
//            sessionFactory=cfg.buildSessionFactory();  
             
            StandardServiceRegistryBuilder serviceRegistryBuilder = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties());
            StandardServiceRegistry serviceRegistry = serviceRegistryBuilder.build();
            sessionFactory = cfg.buildSessionFactory(serviceRegistry);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

        
          
    }  
  
    public static SessionFactory getSessionFactory() {  
        return sessionFactory;  
    }  
      
    public static Session getSession() {  
        return sessionFactory.openSession();  
    }  
}
