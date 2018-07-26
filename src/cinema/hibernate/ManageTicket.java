package cinema.hibernate;

import java.util.List;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;
import java.lang.Number;
//import javax.mail.Session;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.sql.Connection;
import java.sql.DriverManager;
import cinema.user.entity.Ticket;
import cinema.user.entity.User;
import cinema.user.entity.Booking;
import cinema.user.entity.Promotion;
import cinema.user.entity.ShowTime;


public class ManageTicket {

	//create session factory
	private static SessionFactory factory = new Configuration()
			.configure("hibernate.cfg.xml")
			.addAnnotatedClass(Ticket.class)
			.buildSessionFactory();
	private static SessionFactory factoryBooking = new Configuration()
			.configure("hibernate.cfg.xml")
			.addAnnotatedClass(Booking.class)
			.buildSessionFactory();
	
	public static void main(String[] args) {
		ManageTicket mt = new ManageTicket();
		
		
		System.out.println(mt.revenueOnShowtime(4));
		
		
	}
	
	
	
	public Integer addTicket(String movieTitle, String purchaseDate, Integer price, Integer ticketType, Integer seatNo,
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
	public List<Ticket> userOrderHistory(int userId){
		Session session = factory.openSession();
		Transaction tx = null;
		List<Ticket> ticks = null;
		try
		{
			tx = session.beginTransaction();
			
			ticks = session.createQuery("from Ticket t where t.userId =" + userId).list();//User is the class name not the table name!!!!
			
			tx.commit();
			return ticks;
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
		return ticks;	
	}
	
	public List<Ticket> ticketsBasedOnMovie(int movieId){
		Session session = factory.openSession();
		Transaction tx = null;
		List<Ticket> ticks = null;
		try
		{
			tx = session.beginTransaction();
			
			ticks = session.createQuery("from Ticket t where t.movieId =" + movieId).list();//User is the class name not the table name!!!!
			
			tx.commit();
			return ticks;
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
		return ticks;	
	}
	
	public List<Ticket> ticketsBasedOnDate(String date){
		Session session = factory.openSession();
		Transaction tx = null;
		List<Ticket> ticks = null;
		try
		{
			tx = session.beginTransaction();
			
			ticks = session.createQuery("from Ticket t where t.purchaseDate =" + date).list();//User is the class name not the table name!!!!
			
			tx.commit();
			return ticks;
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
		return ticks;	
	}
	
	public int numOfPromosOnMovie(int promoId,int movieId){
		Session session = factory.openSession();
		Session sessionBooking = factoryBooking.openSession();
		Transaction tx = null;
		Transaction rx = null;
		List<Ticket> ticks = null;
		List<Booking> books = null;
		
		int num = 0;
		try
		{
			tx = session.beginTransaction();
			
			ticks = session.createQuery("from Ticket t where t.movieId =" + movieId).list();//User is the class name not the table name!!!!
			//
			//get promoId from the promoCode
			//check the bookingNo from each ticket for the promoCode used
			tx.commit();
			
			rx = sessionBooking.beginTransaction();
			books = sessionBooking.createQuery("from Booking b where b.promoId="+ promoId).list();
			rx.commit();
			
			for(Ticket t: ticks) {
				for(Booking b:books) {
					if(t.getBookingNo() == b.getBookingNo()) {
						num++;
					}
				}
			}
			return num;
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
		return num;	
	}
	
	public int ticketTypeBymovie(int ticketType,int movieId){
		Session session = factory.openSession();
		Transaction tx = null;
		List<Ticket> ticks = null;
		
		int num = 0;
		try
		{
			tx = session.beginTransaction();
			
			ticks = session.createQuery("from Ticket t where t.movieId=" + movieId + " and t.ticketType=" + ticketType).list();//User is the class name not the table name!!!!
			tx.commit();
			num = ticks.size();
			return num;
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
		return num;	
	}
	
	public int ticketTypeByDate(int ticketType,String date){
		Session session = factory.openSession();
		Transaction tx = null;
		List<Ticket> ticks = null;
		
		int num = 0;
		try
		{
			tx = session.beginTransaction();
			
			ticks = session.createQuery("from Ticket t where t.purchaseDate= " + date + " and t.ticketType=" + ticketType).list();//User is the class name not the table name!!!!
			tx.commit();
			num = ticks.size();
			return num;
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
		return num;	
	}
	
	public double revenueOnMovie(int movieId){
		Session session = factory.openSession();
		Session sessionBooking = factoryBooking.openSession();
		Transaction tx = null;
		Transaction rx = null;
		List<Ticket> ticks = null;
		List<Booking> books = null;
		
		int num = 0;
		double total =0;
		try
		{
			tx = session.beginTransaction();
			
			ticks = session.createQuery("from Ticket t where t.movieId =" + movieId).list();//User is the class name not the table name!!!!
			//
			//get promoId from the promoCode
			//check the bookingNo from each ticket for the promoCode used
			tx.commit();
			
			rx = sessionBooking.beginTransaction();
			books = sessionBooking.createQuery("from Booking b").list();
			rx.commit();
			boolean why = true;
			int x [] = new int[books.size()];
			for(Ticket t: ticks) {
				for(Booking b:books) {
					for(int y:x) {
						if(t.getBookingNo()== y) {
							why = false;
						}
					}
					
					if(t.getBookingNo() == b.getBookingNo() && why) {
						x[num] = t.getBookingNo();
						num++;
						total+= b.getTotal();
					}
				}
				why = true;
			}
			return total;
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
		return total;	
	}
	
	public double revenueOnShowtime(int showTimeId){
		Session session = factory.openSession();
		Session sessionBooking = factoryBooking.openSession();
		Transaction tx = null;
		Transaction rx = null;
		List<Ticket> ticks = null;
		List<Booking> books = null;
		
		int num = 0;
		double total =0;
		try
		{
			tx = session.beginTransaction();
			
			ticks = session.createQuery("from Ticket t where t.showTimeId =" + showTimeId).list();//User is the class name not the table name!!!!
			//
			//get promoId from the promoCode
			//check the bookingNo from each ticket for the promoCode used
			tx.commit();
			
			rx = sessionBooking.beginTransaction();
			books = sessionBooking.createQuery("from Booking b").list();
			rx.commit();
			boolean why = true;
			int x [] = new int[books.size()];
			for(Ticket t: ticks) {
				for(Booking b:books) {
					for(int y:x) {
						if(t.getBookingNo()== y) {
							why = false;
						}
					}
					
					if(t.getBookingNo() == b.getBookingNo() && why) {
						x[num] = t.getBookingNo();
						num++;
						total+= b.getTotal();
					}
				}
				why = true;
			}
			return total;
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
		return total;	
	}
	
	public List<Ticket> getTicketList()
	{
		Session session = factory.openSession();
		Transaction tx = null;
		List<Ticket> theTickets = null;
		try
		{
			tx = session.beginTransaction();
			//User User = (User)session.get(User.class, UserID);
			
			theTickets = session.createQuery("from Ticket").list();//Show Time is the class name not the table name!!!!
			
			tx.commit();
			return theTickets;
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
		return theTickets;
		
	}
	
}
