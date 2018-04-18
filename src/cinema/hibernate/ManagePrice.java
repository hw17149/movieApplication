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
import cinema.user.entity.Price;

public class ManagePrice {

	//create session factory
	private static SessionFactory factory = new Configuration()
			.configure("hibernate.cfg.xml")
			.addAnnotatedClass(Price.class)
			.buildSessionFactory();
	
	public static void main(String[] args) {
		
	}
	
	
	
	public Integer addPrice(Integer ticketType, Integer price)
	{
		Session session = factory.openSession();
		Transaction tx = null;
		//Integer hallNo = null;	
		
		try
		{
			tx = session.beginTransaction();
			Price thePrice = new Price(ticketType, price);
			//ticketP = (Integer)session.save(thePrice);
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
		
		return price;
	}

	public Price getPrice(Integer ticketType)
	{
		Session session = factory.openSession();
		Price thePrice = null;
		
		try
		{
			thePrice = (Price)session.get(Price.class, ticketType);
		}
		catch(HibernateException e)
		{
			e.printStackTrace();
		}
		finally
		{
			session.close();
		}
		
		return thePrice;
	}
	

	
	public void deletePrice(int ticketType)
	{
		Session session = factory.openSession();
		Transaction tx = null;
		
		try
		{
			tx = session.beginTransaction();
			Price price = (Price)session.get(Price.class, ticketType);
			session.delete(price);
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
	
	public void updatePrice(Integer ticketType, Integer price)
	{
		Session session = factory.openSession();
		Transaction tx = null;
		
		try
		{
			tx = session.beginTransaction();
			Price thePrice = (Price)session.get(Price.class, ticketType);
			
			thePrice.setPrice(price);
			session.update(thePrice);
			
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
	
}
