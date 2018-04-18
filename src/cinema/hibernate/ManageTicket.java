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
import cinema.user.entity.Ticket;

public class ManageTicket {

	//create session factory
	private static SessionFactory factory = new Configuration()
			.configure("hibernate.cfg.xml")
			.addAnnotatedClass(Ticket.class)
			.buildSessionFactory();
	
	public static void main(String[] args) {
		
	}
	
	
	
	public Integer addShowTime(String movieTitle, String purchaseDate, Integer price, Integer ticketType, Integer seatNo,
			Integer movieId, Integer showTimeId, Integer userId, Integer bookingNo)
	{
		Session session = factory.openSession();
		Transaction tx = null;
		Integer ticketId = null;	
		
		try
		{
			tx = session.beginTransaction();
			Ticket ticket = new Ticket(movieTitle, purchaseDate, price, ticketType, seatNo, movieId, showTimeId, userId, bookingNo);
			ticketId = (Integer)session.save(ticket);
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
		
		return ticketId;
	}

	public Ticket getTicket(int ticketId)
	{
		Session session = factory.openSession();
		Ticket ticket = null;
		
		try
		{
			ticket = (Ticket)session.get(Ticket.class, ticketId);
		}
		catch(HibernateException e)
		{
			e.printStackTrace();
		}
		finally
		{
			session.close();
		}
		
		return ticket;
	}
	

	
	public void deleteTicket(int ticketId)
	{
		Session session = factory.openSession();
		Transaction tx = null;
		
		try
		{
			tx = session.beginTransaction();
			Ticket ticket = (Ticket)session.get(Ticket.class, ticketId);
			session.delete(ticket);
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
	
	public void updateMovieTitle(Integer ticketId, String movieTitle)
	{
		Session session = factory.openSession();
		Transaction tx = null;
		
		try
		{
			tx = session.beginTransaction();
			Ticket ticket = (Ticket)session.get(Ticket.class, ticketId);
			
			ticket.setMovieTitle(movieTitle);
			session.update(movieTitle);
			
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
	
	public void updatePurchaseDate(Integer ticketId, String purchaseDate)
	{
		Session session = factory.openSession();
		Transaction tx = null;
		
		try
		{
			tx = session.beginTransaction();
			Ticket ticket = (Ticket)session.get(Ticket.class, ticketId);
			
			ticket.setMovieTitle(purchaseDate);
			session.update(purchaseDate);
			
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
	
	public void updatePrice(Integer ticketId, Integer price)
	{
		Session session = factory.openSession();
		Transaction tx = null;
		
		try
		{
			tx = session.beginTransaction();
			Ticket ticket = (Ticket)session.get(Ticket.class, ticketId);
			
			ticket.setPrice(price);
			session.update(ticket);
			
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
	
	public void updateTicketType(Integer ticketId, Integer ticketType)
	{
		Session session = factory.openSession();
		Transaction tx = null;
		
		try
		{
			tx = session.beginTransaction();
			Ticket ticket = (Ticket)session.get(Ticket.class, ticketId);
			
			ticket.setTicketType(ticketType);
			session.update(ticket);
			
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
	
	public void updateSeatNo(Integer ticketId, Integer seatNo)
	{
		Session session = factory.openSession();
		Transaction tx = null;
		
		try
		{
			tx = session.beginTransaction();
			Ticket ticket = (Ticket)session.get(Ticket.class, ticketId);
			
			ticket.setSeatNo(seatNo);
			session.update(ticket);
			
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
	
	public void updateMovieId(Integer ticketId, Integer movieId)
	{
		Session session = factory.openSession();
		Transaction tx = null;
		
		try
		{
			tx = session.beginTransaction();
			Ticket ticket = (Ticket)session.get(Ticket.class, ticketId);
			
			ticket.setMovieId(movieId);
			session.update(ticket);
			
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
	
	public void updateShowTimeId(Integer ticketId, Integer showTimeId)
	{
		Session session = factory.openSession();
		Transaction tx = null;
		
		try
		{
			tx = session.beginTransaction();
			Ticket ticket = (Ticket)session.get(Ticket.class, ticketId);
			
			ticket.setShowTimeId(showTimeId);
			session.update(ticket);
			
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
	
	public void updateUserId(Integer ticketId, Integer userId)
	{
		Session session = factory.openSession();
		Transaction tx = null;
		
		try
		{
			tx = session.beginTransaction();
			Ticket ticket = (Ticket)session.get(Ticket.class, ticketId);
			
			ticket.setUserId(userId);
			session.update(ticket);
			
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
	
	public void updateBookingNo(Integer ticketId, Integer bookingNo)
	{
		Session session = factory.openSession();
		Transaction tx = null;
		
		try
		{
			tx = session.beginTransaction();
			Ticket ticket = (Ticket)session.get(Ticket.class, ticketId);
			
			ticket.setBookingNo(bookingNo);
			session.update(ticket);
			
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
