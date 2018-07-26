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
import cinema.user.entity.ShowTime;
import cinema.user.entity.User;

public class ManageShowTime {

	//create session factory
	private static SessionFactory factory = new Configuration()
			.configure("hibernate.cfg.xml")
			.addAnnotatedClass(ShowTime.class)
			.buildSessionFactory();
	
	public static void main(String[] args) {
		
		ManageShowTime ms = new ManageShowTime();
		ms.reserveSeat(5, 0);
		
		
	}
	
	
	
	public Integer addShowTime(String showingDate, Integer hallNo, Integer showMovieId, boolean isFull, String seatArray, String showingTime)
	{
		Session session = factory.openSession();
		Transaction tx = null;
		Integer showTimeId = null;	
		
		try
		{
			tx = session.beginTransaction();
			ShowTime showTime = new ShowTime(showingDate, hallNo, showMovieId, isFull, seatArray, showingTime);
			showTimeId = (Integer)session.save(showTime);
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
		
		return showTimeId;
	}

	public ShowTime getShowTime(int showTimeId)
	{
		Session session = factory.openSession();
		ShowTime showTime = null;
		
		try
		{
			showTime = (ShowTime)session.get(ShowTime.class, showTimeId);
		}
		catch(HibernateException e)
		{
			e.printStackTrace();
		}
		finally
		{
			session.close();
		}
		
		return showTime;
	}
	
	public List<ShowTime> getShowTimeList()
	{
		Session session = factory.openSession();
		Transaction tx = null;
		List<ShowTime> theShowTime = null;
		try
		{
			tx = session.beginTransaction();
			//User User = (User)session.get(User.class, UserID);
			
			theShowTime = session.createQuery("from ShowTime").list();//Show Time is the class name not the table name!!!!
			
			tx.commit();
			return theShowTime;
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
		return theShowTime;
		
	}
	
	public void deleteShowTime(int showTimeId)
	{
		Session session = factory.openSession();
		Transaction tx = null;
		
		try
		{
			tx = session.beginTransaction();
			ShowTime showTime = (ShowTime)session.get(ShowTime.class, showTimeId);
			session.delete(showTime);
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
	
	public void updateShowingDate(Integer showTimeId, String showingDate)
	{
		Session session = factory.openSession();
		Transaction tx = null;
		
		try
		{
			tx = session.beginTransaction();
			ShowTime showTime = (ShowTime)session.get(ShowTime.class, showTimeId);
			
			showTime.setShowingDate(showingDate);
			session.update(showTime);
			
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
	
	public void updateHallNo(Integer showTimeId, Integer hallNo)
	{
		Session session = factory.openSession();
		Transaction tx = null;
		
		try
		{
			tx = session.beginTransaction();
			ShowTime showTime = (ShowTime)session.get(ShowTime.class, showTimeId);
			
			showTime.setHallNo(hallNo);
			session.update(showTime);
			
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
	
	public void updateShowMovieId(Integer showTimeId, Integer showMovieId)
	{
		Session session = factory.openSession();
		Transaction tx = null;
		
		try
		{
			tx = session.beginTransaction();
			ShowTime showTime = (ShowTime)session.get(ShowTime.class, showTimeId);
			
			showTime.setShowMovieId(showMovieId);
			session.update(showTime);
			
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
	
	public void updateisFull(Integer showTimeId, boolean isFull)
	{
		Session session = factory.openSession();
		Transaction tx = null;
		
		try
		{
			tx = session.beginTransaction();
			ShowTime showTime = (ShowTime)session.get(ShowTime.class, showTimeId);
			
			showTime.setIsFull(isFull);
			session.update(showTime);
			
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
	
	public void updateSeatArray(Integer showTimeId, int seatNumber)
	{
		Session session = factory.openSession();
		Transaction tx = null;
		String seatArray = null;
		char[] updatedArray = null;
		
		try
		{
			tx = session.beginTransaction();
			ShowTime showTime = (ShowTime)session.get(ShowTime.class, showTimeId);
			seatArray = showTime.getSeatArray();
			
			updatedArray = seatArray.toCharArray();
			if(updatedArray[seatNumber] == '1') {
				updatedArray[seatNumber] = '0';
			}else {
				updatedArray[seatNumber] = '1';
			}
			seatArray = updatedArray.toString();
			
			showTime.setSeatArray(seatArray);
			session.update(showTime);
			
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
	
	public void updateShowingTime(Integer showTimeId, String showingTime)
	{
		Session session = factory.openSession();
		Transaction tx = null;
		
		try
		{
			tx = session.beginTransaction();
			ShowTime showTime = (ShowTime)session.get(ShowTime.class, showTimeId);
			
			showTime.setShowingTime(showingTime);
			session.update(showTime);
			
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
	
	public boolean isOccupied(Integer showTimeId, Integer seatNumber) {//starts at 0
		Session session = factory.openSession();
		Transaction tx = null;
		boolean isOccupied = false;
		String seatArray = null;
		try
		{
			tx = session.beginTransaction();
			//User User = (User)session.get(User.class, UserID);
			
			ShowTime showTime = (ShowTime)session.get(ShowTime.class, showTimeId);
			seatArray = showTime.getSeatArray();
			if(seatArray.charAt(seatNumber) == '1') {
				isOccupied = true;
				return isOccupied;
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
		return isOccupied;
	}
	public void reserveSeat(Integer showTimeId, Integer seatNumber) {
		Session session = factory.openSession();
		Transaction tx = null;
		String seatArray = null;
		StringBuilder sb;
		try
		{
			tx = session.beginTransaction();
			ShowTime showTime = (ShowTime)session.get(ShowTime.class, showTimeId);
			seatArray = showTime.getSeatArray();
			sb = new StringBuilder(seatArray);
			sb.setCharAt(seatNumber,'1');
			showTime.setSeatArray(sb.toString());
			
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
	
	public List<ShowTime> getOrderedByDate()
	{
		Session session = factory.openSession();
		Transaction tx = null;
		List<ShowTime> ordered = null;
		try
		{
			tx = session.beginTransaction();
			//Movie Movie = (Movie)session.get(Movie.class, MovieID);
			
			ordered = session.createQuery("from ShowTime st ORDER BY st.showingDate, st.showingTime").list();//I HOPE THIS WORKS
			
			tx.commit();
			return ordered;
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
		return ordered;
		
	}
	public void unreserveSeat(Integer showTimeId, Integer seatNumber) {
		Session session = factory.openSession();
		Transaction tx = null;
		String seatArray = null;
		StringBuilder sb;
		try
		{
			tx = session.beginTransaction();
			ShowTime showTime = (ShowTime)session.get(ShowTime.class, showTimeId);
			seatArray = showTime.getSeatArray();
			sb = new StringBuilder(seatArray);
			sb.setCharAt(seatNumber,'0');
			showTime.setSeatArray(sb.toString());
			
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
