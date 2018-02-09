package com.jcg.hibernate.maven;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class AppMain {
	
	static User userObj;
	static Session session;
	static SessionFactory sessionFactory;
	
	private static SessionFactory buildSessionFactory() {
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		sessionFactory = configuration.buildSessionFactory(
				new StandardServiceRegistryBuilder().build() );
		
		return sessionFactory;
	}
	
	public static void main (String[] args) {
		System.out.println(".......Hibernate Maven Example.......\n");
		try {
			session = buildSessionFactory().openSession();
			session.beginTransaction();
			
			for (int i = 101; i <= 105; i++) {
				userObj = new User();
				userObj.setUserId(i);
				userObj.setUsername("Editor " + 1);
				userObj.setCreatedBy("Administrator");
				userObj.setCreatedDate(new Date());
				
				session.save(userObj);
			}
		} catch (Exception e) {
			if (null != session.getTransaction()) {
				System.out.println("\n.......Transaction Is Being Rolled Back.......");
				session.getTransaction().rollback();
			}
			
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}
	
	
}
