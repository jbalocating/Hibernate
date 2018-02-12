package com.jcg.hibernate.maven;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class Main {
	
	private static SessionFactory sessionFactory; 
    private static ServiceRegistry serviceRegistry; 
     
    static { 
        try { 
            // Create the SessionFactory from standard (hibernate.cfg.xml)  
            // config file. 
            sessionFactory = createSessionFactory(); 
        } catch (Throwable ex) { 
            // Log the exception.  
            System.err.println("Initial SessionFactory creation failed." + ex); 
            throw new ExceptionInInitializerError(ex); 
        } 
    } 
     
    private static SessionFactory createSessionFactory() { 
        Configuration configuration = new Configuration(); 
        configuration.configure(); 
        serviceRegistry = new StandardServiceRegistryBuilder().applySettings( 
            configuration.getProperties()).build(); 
        sessionFactory = configuration.buildSessionFactory(serviceRegistry); 
        return sessionFactory; 
    } 
     
    public static SessionFactory getSessionFactory() { 
        return sessionFactory; 
    } 
	
	
}
