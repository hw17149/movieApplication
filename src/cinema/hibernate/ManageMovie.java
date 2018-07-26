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

public class ManageMovie {

	//create session factory
	private static SessionFactory factory = new Configuration()
			.configure("hibernate.cfg.xml")
			.addAnnotatedClass(Movie.class)
			.buildSessionFactory();
	
	public static void main(String[] args) {
		ManageMovie mm = new ManageMovie();
		//mm.addMovie();
		
		List<Movie> movies = mm.getMoviesList();
		for(Movie m: movies) {
			System.out.println(m.getTitle());
		}
		
	}
	
	
	
	public Integer addMovie(String title, String icon, String summary, double averageUserRating, String genre, int length, String filmRating)
	{
		Session session = factory.openSession();
		Transaction tx = null;
		Integer MovieID = null;	
		
		try
		{
			tx = session.beginTransaction();
			Movie Movie = new Movie(title, icon, summary, averageUserRating, genre, length, filmRating);
			MovieID = (Integer)session.save(Movie);
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
		
		return MovieID;
	}

	public Movie getMovie(int MovieID)
	{
		Session session = factory.openSession();
		Movie Movie = null;
		
		try
		{
			Movie = (Movie)session.get(Movie.class, MovieID);
		}
		catch(HibernateException e)
		{
			e.printStackTrace();
		}
		finally
		{
			session.close();
		}
		
		return Movie;
	}
	

	
	public void deleteMovie(int MovieID)
	{
		Session session = factory.openSession();
		Transaction tx = null;
		
		try
		{
			tx = session.beginTransaction();
			Movie Movie = (Movie)session.get(Movie.class, MovieID);
			session.delete(Movie);
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
	
	public void updateTitle(Integer MovieID, String title)
	{
		Session session = factory.openSession();
		Transaction tx = null;
		
		try
		{
			tx = session.beginTransaction();
			Movie Movie = (Movie)session.get(Movie.class, MovieID);
			
			Movie.setTitle(title);
			session.update(Movie);
			
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
	
	public void updateIcon(Integer MovieID, String icon)
	{
		Session session = factory.openSession();
		Transaction tx = null;
		
		try
		{
			tx = session.beginTransaction();
			Movie Movie = (Movie)session.get(Movie.class, MovieID);
			
			Movie.setIcon(icon);
			session.update(Movie);
			
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
	
	public void updateSummary(Integer MovieID, String summary)
	{
		Session session = factory.openSession();
		Transaction tx = null;
		
		try
		{
			tx = session.beginTransaction();
			Movie Movie = (Movie)session.get(Movie.class, MovieID);
			
			Movie.setSummary(summary);
			session.update(Movie);
			
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
	
	public void updateAverageUserRating(Integer MovieID, double averageUserRating)
	{
		Session session = factory.openSession();
		Transaction tx = null;
		
		try
		{
			tx = session.beginTransaction();
			Movie Movie = (Movie)session.get(Movie.class, MovieID);
			
			Movie.setAverageUserRating(averageUserRating);
			session.update(Movie);
			
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
	
	public void updateGenre(Integer MovieID, String genre)
	{
		Session session = factory.openSession();
		Transaction tx = null;
		
		try
		{
			tx = session.beginTransaction();
			Movie Movie = (Movie)session.get(Movie.class, MovieID);
			
			Movie.setGenre(genre);
			session.update(Movie);
			
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
	
	public void updateLength(Integer MovieID, int length)
	{
		Session session = factory.openSession();
		Transaction tx = null;
		
		try
		{
			tx = session.beginTransaction();
			Movie Movie = (Movie)session.get(Movie.class, MovieID);
			
			Movie.setLength(length);
			session.update(Movie);
			
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
	
	public void updateFilmRating(Integer MovieID, String filmRating)
	{
		Session session = factory.openSession();
		Transaction tx = null;
		
		try
		{
			tx = session.beginTransaction();
			Movie Movie = (Movie)session.get(Movie.class, MovieID);
			
			Movie.setFilmRating(filmRating);
			session.update(Movie);
			
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
	
	
	
	public List<Movie> getMoviesList()
	{
		Session session = factory.openSession();
		Transaction tx = null;
		List<Movie> theMovies = null;
		try
		{
			tx = session.beginTransaction();
			//Movie Movie = (Movie)session.get(Movie.class, MovieID);
			
			theMovies = session.createQuery("from Movie").list();//Movie is the class name not the table name!!!!
			
			tx.commit();
			return theMovies;
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
		return theMovies;
		
	}
	
	public List<Movie> getAlphabetical()
	{
		Session session = factory.openSession();
		Transaction tx = null;
		List<Movie> ordered = null;
		try
		{
			tx = session.beginTransaction();
			//Movie Movie = (Movie)session.get(Movie.class, MovieID);
			
			ordered = session.createQuery("from Movie m ORDER BY m.title").list();//I HOPE THIS WORKS
			
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
	
}
