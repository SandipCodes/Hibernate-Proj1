package org.ei.test;

import org.ei.domain.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class LoadObjectTest {

public static void main(String[] args) {
		
		Configuration cfg=null;
		SessionFactory sf=null;
		Session ses=null;
		Transaction tx=null;
		
		
		Employee emp=null;
		
		//activate the HB framework or bootstrap HB
		 cfg=new Configuration();
		
		//read both mapping file and cfg file data
		cfg.configure("org/ei/cfg/hibernate.cfg.xml").addAnnotatedClass(Employee.class);
		
		//build session factory
		 sf=cfg.buildSessionFactory();
		 
		 //open session with Db s/w
		 ses=sf.openSession();
		  
		//get object from DB S/W)
		 
		 try {
			  tx=ses.beginTransaction();
			  
			  //emp=ses.load(Employee.class, 1005);
			 
			  emp=ses.get(Employee.class, 1001);
				
			  System.out.println("Object is loded::"+ emp);
			 
			  System.out.println("["+emp.getEid()+" "+ emp.getFirstName()+" "+ emp.getLastName()+" "+emp.getEmail()+" ]");
				 
				
			  emp.setEmail("sandipsh321@gmail.com");
			  
			  ses.update(emp);
			  
			  System.out.println("Object Updated");
			 
			  
               ses.delete(emp);
			  
			  System.out.println("Object delated");
			 
			  ses.getTransaction().commit();
			  
		 }//try
		 catch(Exception e) {
			 
			
			  System.out.println("Object is not loaded");
			  
			  e.printStackTrace();
				
		 }
		 
		 //close objects
		 
		 ses.close();
		 sf.close();
	}//main



}
