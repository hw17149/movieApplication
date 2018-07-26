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

import cinema.user.entity.Movie;
import cinema.user.entity.Promotion;
import cinema.user.entity.Ticket;
import cinema.user.entity.User;

public class ManagePromotion {

	//create session factory
	private static SessionFactory factory = new Configuration()
			.configure("hibernate.cfg.xml")
			.addAnnotatedClass(Promotion.class)
			.buildSessionFactory();
	
	public static void main(String[] args) {
		ManagePromotion mp = new ManagePromotion();
		
		System.out.println(mp.getPromotion(1).getPromoCode());	
	}
	
	
	
	public Integer addPromotion(boolean expire, double discount, String promoCode)
	{
		Session session = factory.openSession();
		Transaction tx = null;
		Integer promoId = null;	
		
		try
		{
			tx = session.beginTransaction();
			Promotion promotion = new Promotion(expire, discount, promoCode);
			promoId = (Integer)session.save(promotion);
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
	
	public void updateExpireDate(Integer promoId)
	{
		Session session = factory.openSession();
		Transaction tx = null;
		
		try
		{
			tx = session.beginTransaction();
			Promotion promotion = (Promotion)session.get(Promotion.class, promoId);
			
			promotion.setExpire(!promotion.getExpire());
			session.update(promotion);
			
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
	
	public void updateDiscount(Integer promoId, double discount)
	{
		Session session = factory.openSession();
		Transaction tx = null;
		
		try
		{
			tx = session.beginTransaction();
			Promotion promotion = (Promotion)session.get(Promotion.class, promoId);
			
			promotion.setDiscount(discount);
			session.update(promotion);
			
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
	
	public void updatePromoCode(Integer promoId, String promoCode)
	{
		Session session = factory.openSession();
		Transaction tx = null;
		
		try
		{
			tx = session.beginTransaction();
			Promotion promotion = (Promotion)session.get(Promotion.class, promoId);
			
			promotion.setPromoCode(promoCode);
			session.update(promotion);
			
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
	
	public List<Promotion> getPromotionList()
	{
		Session session = factory.openSession();
		Transaction tx = null;
		List<Promotion> thePromotions = null;
		try
		{
			tx = session.beginTransaction();
			//Movie Movie = (Movie)session.get(Movie.class, MovieID);
			
			thePromotions = session.createQuery("from Promotion").list();//Movie is the class name not the table name!!!!
			
			tx.commit();
			return thePromotions;
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
		return thePromotions;
		
	}
	
	public int isValidPromo(String code) {
		Session session = factory.openSession();
		Transaction tx = null;
		List<Promotion> thePromotions = null;
		int counter = 0;
		try
		{
			tx = session.beginTransaction();
			//User User = (User)session.get(User.class, UserID);
			
			thePromotions = session.createQuery("from Promotion").list();//User is the class name not the table name!!!!
			for(Promotion tempPromo : thePromotions) {
				if(tempPromo.getPromoCode().equals(code)) {
					counter++;
					System.out.println("COUNTER: "+counter);
					System.out.println("input code "+code);
					System.out.println("db promotion "+tempPromo.getPromoCode());
					System.out.println("VALID PROMO!");
					return tempPromo.getPromoId();
				}
			}
			
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
		return -1;
	}
}
