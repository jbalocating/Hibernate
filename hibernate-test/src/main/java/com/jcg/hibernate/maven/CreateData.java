package com.jcg.hibernate.maven;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class CreateData {
	static User userObj;
	
	public static void main (String[] args) {
		SessionFactory sessFact = HibernateUtil.getSessionFactory();
		Session session = sessFact.getCurrentSession();
		org.hibernate.Transaction tr = session.beginTransaction();
		Employee emp = new Employee();
		emp.setEmpName("Deepak Kumar");
		emp.setEmpMobileNos("000000");
		emp.setEmpAddress("Delhi - India");
		session.save(emp);
		tr.commit();
		System.out.println("Successfully inserted");
		sessFact.close();
		
//		for (int i = 101; i <= 105; i++) {
//			userObj = new User();
//			userObj.setUserId(i);
//			userObj.setUsername("Editor " + 1);
//			userObj.setCreatedBy("Administrator");
//			userObj.setCreatedDate(new Date());
//			
//			session.save(userObj);
//			tr.commit();
//			System.out.println("Successfully inserted");
//			sessionFactory.close();
//		}
	}
}
