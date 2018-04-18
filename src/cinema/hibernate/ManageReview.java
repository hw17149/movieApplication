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
import cinema.user.entity.User;
import cinema.user.entity.Movie;
import cinema.user.entity.Review;

public class ManageReview {

	//create session factory
	private static SessionFactory factory = new Configuration()
			.configure("hibernate.cfg.xml")
			.addAnnotatedClass(Review.class)
			.buildSessionFactory();
	
	public static void main(String[] args) {
		
	}
	
	
	
	public Integer Review(Integer userId, Integer movieId, Integer rating, String summary, String date)
	{
		Session session = factory.openSession();
		Transaction tx = null;
		Integer promoId = null;	
		
		try
		{
			tx = session.beginTransaction();
			Review review = new Review(userId, movieId, rating, summary, date);
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

	public Review getReview(Integer userId, Integer movieId)
	{
		Session session = factory.openSession();
		Review review = null;
		
		
		try
		{
			//review = (Review)session.get(Review.class, userId);
			review = (Review) session.createQuery("from Review r where r.userId=" + userId + "and r.movieId="+movieId);
		}
		catch(HibernateException e)
		{
			e.printStackTrace();
		}
		finally
		{
			session.close();
		}
		
		return review;
	}
	

	
	public void deleteReview(Integer userId, Integer movieId)
	{
		Session session = factory.openSession();
		Transaction tx = null;
		Review review = null;
		
		try
		{
			tx = session.beginTransaction();
			review = (Review) session.createQuery("from Review r where r.userId=" + userId + "and r.movieId="+movieId);
			session.delete(review);
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
	
	public void updateRating(Integer userId, Integer movieId, Integer rating)
	{
		Session session = factory.openSession();
		Transaction tx = null;
		Review review = null;
		
		try
		{
			tx = session.beginTransaction();
			review = (Review) session.createQuery("from Review r where r.userId=" + userId + "and r.movieId="+movieId);
			
			review.setRating(rating);
			session.update(rating);
			
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
	
	public void updateSummary(Integer userId, Integer movieId, String summary)
	{
		Session session = factory.openSession();
		Transaction tx = null;
		Review review = null;
		
		try
		{
			tx = session.beginTransaction();
			review = (Review) session.createQuery("from Review r where r.userId=" + userId + "and r.movieId="+movieId);
			
			review.setSummary(summary);
			session.update(summary);
			
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
	
	public void updateDate(Integer userId, Integer movieId, String date)
	{
		Session session = factory.openSession();
		Transaction tx = null;
		Review review = null;
		
		try
		{
			tx = session.beginTransaction();
			review = (Review) session.createQuery("from Review r where r.userId=" + userId + "and r.movieId="+movieId);
			
			review.setDate(date);
			session.update(date);
			
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
