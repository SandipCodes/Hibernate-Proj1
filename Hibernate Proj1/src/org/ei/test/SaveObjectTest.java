package org.ei.test;

import org.ei.domain.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class SaveObjectTest {

	public static void main(String[] args) {
		
		Configuration cfg=null;
		SessionFactory sf=null;
		Session ses=null;
		Transaction tx=null;
		
		
		Employee emp=null;
		
		//activate the HB framework or bootstrap HB
		 cfg=new Configuration();
		
		//read both mapping file and cfg file data
		cfg.configure("org/ei/cfg/hibernate.cfg.xml");
		
		//build session factory
		 sf=cfg.buildSessionFactory();
		 
		 //open session with Db s/w
		 ses=sf.openSession();
		  
		//create object from domain class
		 emp=new Employee();
		 
		 emp.setEid(1002);
		 emp.setFirstName("SACHIN");
		 emp.setLastName("HUMBE");
		 emp.setEmail("HUMBE175@GMAIL.com");
		 
		 try {
			  tx=ses.beginTransaction();
			  ses.save(emp);
			  
			  tx.commit();
			  System.out.println("Object is saved/ inserted");
			  
		 }//try
		 catch(Exception e) {
			 
			 tx.rollback();
			  System.out.println("Object is not saved/ inserted");
			  
			  e.printStackTrace();
				
		 }
		 
		 //close objects
		 
		 ses.close();
		 sf.close();
	}//main

}//class
