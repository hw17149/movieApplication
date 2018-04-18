package cinema.hibernate;

import java.util.List;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;
//import javax.mail.Session;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import java.sql.Connection;
import java.sql.DriverManager;
import cinema.user.entity.CreditCard;
import cinema.user.entity.User;

public class ManageCreditCard {

	//create session factory
	private static SessionFactory factory = new Configuration()
			.configure("hibernate.cfg.xml")
			.addAnnotatedClass(CreditCard.class)
			.buildSessionFactory();
	
	public static void main(String[] args) {
		
	}
	
	
	
	public Integer addCreditCard(Integer creditCardNo, String expDate, String address, Integer userId)
	{
		Session session = factory.openSession();
		Transaction tx = null;
		//Integer creditCardNo = null;	
		
		try
		{
			tx = session.beginTransaction();
			CreditCard theCreditCard = new CreditCard(creditCardNo, expDate, address, userId);
			//creditCardNo = (Integer)session.save(showTime);
			tx.commit();
		}
		catch(HibernateException e)
		{
			if(tx != null) tx.rollback();
			e.printStackTrace();
		}
		finally
		{
			session.close();
		}
		
		return creditCardNo;
	}

	public CreditCard getCreditCard(int creditCardNo)
	{
		Session session = factory.openSession();
		CreditCard theCreditCard = null;
		
		try
		{
			theCreditCard = (CreditCard)session.get(CreditCard.class, creditCardNo);
		}
		catch(HibernateException e)
		{
			e.printStackTrace();
		}
		finally
		{
			session.close();
		}
		
		return theCreditCard;
	}
	

	
	public void deleteCreditCard(int creditCardNo)
	{
		Session session = factory.openSession();
		Transaction tx = null;
		
		try
		{
			tx = session.beginTransaction();
			CreditCard theCreditCard = (CreditCard)session.get(CreditCard.class, creditCardNo);
			session.delete(theCreditCard);
			tx.commit();
		}
		catch(HibernateException e)
		{
			if(tx != null) tx.rollback();
			e.printStackTrace();
		}
		finally
		{
			session.close();
		}
	}
	
	
	public List<User> listOfUsers(Integer userId){
		Session session = factory.openSession();
		Transaction tx = null;
		List<User> theUsers = null;
		try
		{
			tx = session.beginTransaction();
			//User User = (User)session.get(User.class, UserID);
			
			theUsers = session.createQuery("from CreditCard c where c.userId=" + userId).list();//User is the class name not the table name!!!!
			
			tx.commit();
			return theUsers;
		}
		catch(HibernateException e)
		{
			if(tx != null) tx.rollback();
			e.printStackTrace();
		}
		finally
		{
			session.close();
		}
		return theUsers;
		
		
	}
}