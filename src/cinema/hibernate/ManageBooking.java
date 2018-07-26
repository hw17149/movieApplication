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
import cinema.user.entity.Booking;
import cinema.user.entity.Review;

public class ManageBooking {

	//create session factory
	private static SessionFactory factory = new Configuration()
			.configure("hibernate.cfg.xml")
			.addAnnotatedClass(Booking.class)
			.buildSessionFactory();
	
	public static void main(String[] args) {
		
	}
	
	
	
	public Integer addBooking(Integer numberOfAdults, Integer numberOfChildren, Integer numberOfSeniors,
			Integer promoId, double total, Integer userId)
	{
		Session session = factory.openSession();
		Transaction tx = null;
		Integer bookingNo = null;	
		
		try
		{
			tx = session.beginTransaction();
			Booking booking = new Booking(numberOfAdults, numberOfChildren, numberOfSeniors, promoId, total, userId);
			bookingNo = (Integer)session.save(booking);
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
		
		return bookingNo;
	}

	public Booking getBooking(int bookingNo)
	{
		Session session = factory.openSession();
		Booking booking = null;
		
		try
		{
			booking = (Booking)session.get(Booking.class, bookingNo);
		}
		catch(HibernateException e)
		{
			e.printStackTrace();
		}
		finally
		{
			session.close();
		}
		
		return booking;
	}
	

	
	public void deleteBooking(int bookingNo)
	{
		Session session = factory.openSession();
		Transaction tx = null;
		
		try
		{
			tx = session.beginTransaction();
			Booking booking = (Booking)session.get(Booking.class, bookingNo);
			session.delete(booking);
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
	
	public void updateNumberOfAdults(Integer bookingNo, Integer numberOfAdults)
	{
		Session session = factory.openSession();
		Transaction tx = null;
		
		try
		{
			tx = session.beginTransaction();
			Booking booking = (Booking)session.get(Booking.class, bookingNo);
			
			booking.setNumberOfAdults(numberOfAdults);
			session.update(booking);
			
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
	
	public void updateNumberOfChildren(Integer bookingNo, Integer numberOfChildren)
	{
		Session session = factory.openSession();
		Transaction tx = null;
		
		try
		{
			tx = session.beginTransaction();
			Booking booking = (Booking)session.get(Booking.class, bookingNo);
			
			booking.setNumberOfChildren(numberOfChildren);
			session.update(booking);
			
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
	
	public void updateNumberOfSeniors(Integer bookingNo, Integer numberOfSeniors)
	{
		Session session = factory.openSession();
		Transaction tx = null;
		
		try
		{
			tx = session.beginTransaction();
			Booking booking = (Booking)session.get(Booking.class, bookingNo);
			
			booking.setNumberOfSeniors(numberOfSeniors);
			session.update(booking);
			
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
	
	public void updatePromoId(Integer bookingNo, Integer promoId)
	{
		Session session = factory.openSession();
		Transaction tx = null;
		
		try
		{
			tx = session.beginTransaction();
			Booking booking = (Booking)session.get(Booking.class, bookingNo);
			
			booking.setPromoId(promoId);
			session.update(booking);
			
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
	
	public void updateTotal(Integer bookingNo, Integer total)
	{
		Session session = factory.openSession();
		Transaction tx = null;
		
		try
		{
			tx = session.beginTransaction();
			Booking booking = (Booking)session.get(Booking.class, bookingNo);
			
			booking.setTotal(total);
			session.update(booking);
			
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
	
	public void updateUserId(Integer bookingNo, Integer userId)
	{
		Session session = factory.openSession();
		Transaction tx = null;
		
		try
		{
			tx = session.beginTransaction();
			Booking booking = (Booking)session.get(Booking.class, bookingNo);
			
			booking.setUserId(userId);
			session.update(booking);
			
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
	public List<Booking> getBookingList(){
		Session session = factory.openSession();
		Transaction tx = null;
		List<Booking> theBookings = null;
		try
		{
			tx = session.beginTransaction();
			//User User = (User)session.get(User.class, UserID);
			
			theBookings = session.createQuery("from Booking").list();//User is the class name not the table name!!!!
			
			tx.commit();
			return theBookings;
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
		return theBookings;
	}
	
}
