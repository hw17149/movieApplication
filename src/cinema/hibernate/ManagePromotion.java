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
import cinema.user.entity.Promotion;

public class ManagePromotion {

	//create session factory
	private static SessionFactory factory = new Configuration()
			.configure("hibernate.cfg.xml")
			.addAnnotatedClass(CreditCard.class)
			.buildSessionFactory();
	
	public static void main(String[] args) {
		
	}
	
	
	
	public Integer addPromotion(Integer price, String expire, double discount, String promoCode)
	{
		Session session = factory.openSession();
		Transaction tx = null;
		Integer promoId = null;	
		
		try
		{
			tx = session.beginTransaction();
			Promotion promotion = new Promotion(price, expire, discount, promoCode);
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
		
		return promoId;
	}

	public Promotion getPromotion(Integer promoId)
	{
		Session session = factory.openSession();
		Promotion promotion = null;
		
		try
		{
			promotion = (Promotion)session.get(Promotion.class, promoId);
		}
		catch(HibernateException e)
		{
			e.printStackTrace();
		}
		finally
		{
			session.close();
		}
		
		return promotion;
	}
	

	
	public void deletePromotion(Integer promoId)
	{
		Session session = factory.openSession();
		Transaction tx = null;
		
		try
		{
			tx = session.beginTransaction();
			Promotion promotion = (Promotion)session.get(Promotion.class, promoId);
			session.delete(promotion);
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
	
	
	
	
	/*public List<User> listOfUsers(Integer userId){
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
		
		
	}*/
}
