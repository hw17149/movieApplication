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
import org.hibernate.query.Query;

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
		ManageReview rw = new ManageReview();
		
		System.out.println(rw.averageReview(1));
	}
	
	
	
	public Integer Review(Integer userId, Integer movieId, String summary, Integer rating, String date)
	{
		Session session = factory.openSession();
		Transaction tx = null;
		Integer promoId = null;	
		
		try
		{
			tx = session.beginTransaction();
			Review review = new Review(userId, movieId, summary, rating, date);
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

	public Review getReview(Integer reviewNo)
	{
		Session session = factory.openSession();
		Review review = null;
		
		
		try
		{
			review = (Review)session.get(Review.class, reviewNo);
			//review = (Review) session.createQuery("from Review r where r.userId=" + userId + "and r.movieId="+movieId);
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
	

	
	public void deleteReview(Integer reviewNo)
	{
		Session session = factory.openSession();
		Transaction tx = null;
		Review review = null;
		
		try
		{
			tx = session.beginTransaction();
			//review = (Review) session.createQuery("from Review r where r.userId=" + userId + "and r.movieId="+movieId);
			review = (Review)session.get(Review.class, reviewNo);
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
	
	public void updateRating(Integer reviewNo, Integer rating)
	{
		Session session = factory.openSession();
		Transaction tx = null;
		Review review = null;
		
		try
		{
			tx = session.beginTransaction();
			//review = (Review) session.createQuery("from Review r where r.userId=" + userId + "and r.movieId="+movieId);
			review = (Review)session.get(Review.class, reviewNo);
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
	
	public void updateSummary(Integer reviewNo, String summary)
	{
		Session session = factory.openSession();
		Transaction tx = null;
		Review review = null;
		
		try
		{
			tx = session.beginTransaction();
			//review = (Review) session.createQuery("from Review r where r.userId=" + userId + "and r.movieId="+movieId);
			review = (Review)session.get(Review.class, reviewNo);
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
	
	public void updateDate(Integer reviewNo, String date)
	{
		Session session = factory.openSession();
		Transaction tx = null;
		Review review = null;
		
		try
		{
			tx = session.beginTransaction();
			//review = (Review) session.createQuery("from Review r where r.userId=" + userId + "and r.movieId="+movieId);
			review = (Review)session.get(Review.class, date);
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
	
	public List<Review> getReviewList(){
		Session session = factory.openSession();
		Transaction tx = null;
		List<Review> theReviews = null;
		try
		{
			tx = session.beginTransaction();
			//User User = (User)session.get(User.class, UserID);
			
			theReviews = session.createQuery("from Review").list();//User is the class name not the table name!!!!
			
			tx.commit();
			return theReviews;
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
		return theReviews;
	}
	
	public double averageReview(Integer movieId){
		Session session = factory.openSession();
		Transaction tx = null;
		List<Review> theReviews = null;
		List list;
		double average = 0;
		double count = 0;
		try
		{
			tx = session.beginTransaction();
			//User User = (User)session.get(User.class, UserID);
			
			theReviews = session.createQuery("from Review").list();//User is the class name not the table name!!!!
			
			for(Review r : theReviews) {
				if(r.getMovieId()==movieId) {
					average+=r.getRating();
					count++;
				}
			}
			average = average/count;
			tx.commit();
			return average;
			
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
		return average;
	}
}
