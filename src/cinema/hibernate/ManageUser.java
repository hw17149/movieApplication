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

public class ManageUser {

	//create session factory
	private static SessionFactory factory = new Configuration()
			.configure("hibernate.cfg.xml")
			.addAnnotatedClass(User.class)
			.buildSessionFactory();
	
	public static void main(String[] args) {

		
		//testing retreiving an object
		/*
		User myUser = session.get(User.class, tempUser.getId())
		myUser is now the the selected user 
		
		*/
		
		//QUERIES
		//note in queries the object variable is java property not the column name from db
		//create session
		/*ManageUser mu = new ManageUser();
		mu.deleteUser(1);
		mu.deleteUser(2);
		mu.addUser(null, "John", "Doe", "johndoe@gmail.com", "password", null, 1, false);
		mu.addUser(null, "Hoonjae", "Won", "hw17149@uga.edu", "password", null, 1, false);*/
		//mu.updateFirstName(1, "newName");
		//User s = mu.getUser(1);
		//System.out.println(s.getFname());
		//mu.deleteUser(1);
		
		ManageUser mu = new ManageUser();
		//mu.addUser(null, "HoonJae", "Won", "hoonjaewon1@gmail.com", "password", null, 1, false, false, "1996-01-06", false);
		//mu.addUser(null, "Dick", "Deng", "rzd83091@uga.edu", "password", null, 1, false, false, "1995-10-17", false);
		//System.out.println("Hello");
		List<User> uList = mu.getEmployees();
		
		for(User tempUser : uList) {
			System.out.println(tempUser.getUserName());
			//mu.updatePassword(tempUser.getUserId(), "pw");
			
		}
		/*
		if(mu.IsValidLogin("rzd83091@uga.edu", "password")) {
			System.out.println("This is right");
		}
		if(mu.IsValidLogin("rzd83091@uga.edu", ";lkajsfdljj")) {
			System.out.println("This is wrong pw");
		}
		if(mu.IsValidLogin("rasdfjhewji@uga.edu", "password")) {
			System.out.println("This is wrong 2");
		}*/
		
		
		
	}
	
	
	
	public Integer addUser(String userName, String fname, String lname, String email, String password, String location, int userType, boolean confirmation,
			boolean subscribed, String bDate, boolean resetPassword, boolean banStatus)
	{
		Session session = factory.openSession();
		Transaction tx = null;
		Integer UserID = null;	
		
		try
		{
			tx = session.beginTransaction();
			User User = new User(userName, fname, lname, email, password, location, userType, confirmation, subscribed, bDate, resetPassword, banStatus);
			UserID = (Integer)session.save(User);
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
		
		return UserID;
	}

	public User getUser(int UserID)
	{
		Session session = factory.openSession();
		User User = null;
		
		try
		{
			User = (User)session.get(User.class, UserID);
		}
		catch(HibernateException e)
		{
			e.printStackTrace();
		}
		finally
		{
			session.close();
		}
		
		return User;
	}
	
	public static boolean isAdmin(Integer UserID) {
		int temp=0;
		Session session = factory.openSession();
		Transaction tx = null;
		
		try
		{
			tx = session.beginTransaction();
			User User = (User)session.get(User.class, UserID);
			
			temp = User.getUserType();
			tx.commit();
			session.close();			
		}
		catch(HibernateException e)
		{
			if(tx != null) tx.rollback();
			e.printStackTrace();
		}
		finally
		{
			if(temp != 2) 
				return false;
			else
				return true;
		}
	}
	
	public static boolean isEmp(Integer UserID) {
		int temp=0;
		Session session = factory.openSession();
		Transaction tx = null;
		
		try
		{
			tx = session.beginTransaction();
			User User = (User)session.get(User.class, UserID);
			
			temp = User.getUserType();
			tx.commit();
			session.close();			
		}
		catch(HibernateException e)
		{
			if(tx != null) tx.rollback();
			e.printStackTrace();
		}
		finally
		{
			if(temp != 3) 
				return false;
			else
				return true;
		}
	}
	
	public void deleteUser(int UserID)
	{
		Session session = factory.openSession();
		Transaction tx = null;
		
		try
		{
			tx = session.beginTransaction();
			User User = (User)session.get(User.class, UserID);
			session.delete(User);
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
	
	public void updateConfirmation(Integer UserID, boolean confirmation)
	{
		Session session = factory.openSession();
		Transaction tx = null;
		
		try
		{
			tx = session.beginTransaction();
			User User = (User)session.get(User.class, UserID);
			
			User.setConfirmation(confirmation);
			session.update(User);
			
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
	
	public void updateFname(Integer UserID, String fname)
	{
		Session session = factory.openSession();
		Transaction tx = null;
		
		try
		{
			tx = session.beginTransaction();
			User User = (User)session.get(User.class, UserID);
			
			User.setFname(fname);
			session.update(User);
			
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
	
	public void updateUserName(Integer UserID, String username)
	{
		Session session = factory.openSession();
		Transaction tx = null;
		
		try
		{
			tx = session.beginTransaction();
			User User = (User)session.get(User.class, UserID);
			
			User.setUserName(username);
			session.update(User);
			
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

	
	public void updateLname(Integer UserID, String lname)
	{
		Session session = factory.openSession();
		Transaction tx = null;
		
		try
		{
			tx = session.beginTransaction();
			User User = (User)session.get(User.class, UserID);
			
			User.setLname(lname);
			session.update(User);
			
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
	
	public void updateEmail(Integer UserID, String email)
	{
		Session session = factory.openSession();
		Transaction tx = null;
		
		try
		{
			tx = session.beginTransaction();
			User User = (User)session.get(User.class, UserID);
			
			User.setEmail(email);
			session.update(User);
			
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
	
	public void updateLocation(Integer UserID, String location)
	{
		Session session = factory.openSession();
		Transaction tx = null;
		
		try
		{
			tx = session.beginTransaction();
			User User = (User)session.get(User.class, UserID);
			
			User.setLocation(location);
			session.update(User);
			
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
	
	public void updatePassword(Integer UserID, String password)
	{
		Session session = factory.openSession();
		Transaction tx = null;
		
		try
		{
			tx = session.beginTransaction();
			User User = (User)session.get(User.class, UserID);
			
			User.setPassword(password);
			session.update(User);
			
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
	
	public void updateSubscribed(Integer UserID, boolean subscribed)
	{
		Session session = factory.openSession();
		Transaction tx = null;
		
		try
		{
			tx = session.beginTransaction();
			User User = (User)session.get(User.class, UserID);
			
			User.setSubscribed(subscribed);
			session.update(User);
			
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
	
	public void updatebDate(Integer UserID, String bDate)
	{
		Session session = factory.openSession();
		Transaction tx = null;
		
		try
		{
			tx = session.beginTransaction();
			User User = (User)session.get(User.class, UserID);
			
			User.setBdate(bDate);
			session.update(User);
			
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
	
	public void updateBanStatus(Integer UserID, boolean banStatus)
	{
		Session session = factory.openSession();
		Transaction tx = null;
		
		try
		{
			tx = session.beginTransaction();
			User User = (User)session.get(User.class, UserID);
			
			User.setBanStatus(banStatus);
			session.update(User);
			
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
	
	public List<User> getUsersList()
	{
		Session session = factory.openSession();
		Transaction tx = null;
		List<User> theUsers = null;
		try
		{
			tx = session.beginTransaction();
			//User User = (User)session.get(User.class, UserID);
			
			theUsers = session.createQuery("from User").list();//User is the class name not the table name!!!!
			
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
		
	}
	
	//Returns list of Employees and Managers which are userTypes 3 and 4
	public List<User> getEmployees()
	{
		Session session = factory.openSession();
		Transaction tx = null;
		List<User> theUsers = null;
		try
		{
			tx = session.beginTransaction();
			//User User = (User)session.get(User.class, UserID);
			
			theUsers = session.createQuery("from User u where u.userType >=" + 3).list();
			
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
		
	}
	
	public boolean isValidEmail(String email) {
		Session session = factory.openSession();
		Transaction tx = null;
		boolean valid = true;
		List<User> theUsers = null;
		int counter = 0;
		try
		{
			tx = session.beginTransaction();
			//User User = (User)session.get(User.class, UserID);
			
			theUsers = session.createQuery("from User").list();//User is the class name not the table name!!!!
			for(User tempUser : theUsers) {
				if(tempUser.getEmail().equals(email)) {
					counter++;
					System.out.println("COUNTER: "+counter);
					System.out.println("input email "+email);
					System.out.println("db email "+tempUser.getEmail());
					System.out.println("DUPLICATE EMAIL DETECTED!!!");
					return false;
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
		return valid;
	}
	
	public boolean isConfirmed(String email) {
		Session session = factory.openSession();
		Transaction tx = null;
		List<User> theUsers = null;
		int counter = 0;
		try
		{
			tx = session.beginTransaction();
			//User User = (User)session.get(User.class, UserID);
			
			theUsers = session.createQuery("from User").list();//User is the class name not the table name!!!!
			for(User tempUser : theUsers) {
				if(tempUser.getEmail().equals(email)) {
					if(!tempUser.getConfirmation())
						return false;
					else
						return true;
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
		return false;
	}
	
	 
	public boolean IsValidLogin(String email, String password) {
		Session session = factory.openSession();
		Transaction tx = null;
		boolean valid = false;
		List<User> theUsers = null;
		try
		{
			tx = session.beginTransaction();
			//User User = (User)session.get(User.class, UserID);
			
			theUsers = session.createQuery("from User").list();//User is the class name not the table name!!!!
			for(User tempUser : theUsers) {
				if(tempUser.getEmail().equals(email) && tempUser.getPassword().equals(password)) {
					return true;
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
		return valid;
	}
	
	public boolean getConfirmationStatus(Integer UserId) { ////Need to check this
		Session session = factory.openSession();
		User theUser = null;
		boolean check = false;
		
		try
		{
			theUser = (User)session.createQuery("from User u where u.userId=" + UserId);//User is the class name not the table name!!!!
			check = theUser.getConfirmation();
			return check;
			//User = (User)session.get(User.class, UserID);
		}
		catch(HibernateException e)
		{
			e.printStackTrace();
		}
		finally
		{
			session.close();
		}
		
		return check;
	}
	
	//password reset
	public void updateResetPass(Integer UserId) { //Call this to change the state of resetPassword
		Session session = factory.openSession();
		User theUser = null;
		boolean check = false;
		
		try
		{
			theUser = (User)session.createQuery("from User u where u.userId=" + UserId);//User is the class name not the table name!!!!
			theUser.setResetPassword(!theUser.getResetPassword());
			//User = (User)session.get(User.class, UserID);
		}
		catch(HibernateException e)
		{
			e.printStackTrace();
		}
		finally
		{
			session.close();
		}
		
	}
	
	
	
	public User getByEmail(String email) {
		Session session = factory.openSession();
		List<User> uList = getUsersList();
		User theUser = null;
		Transaction tx = null;
		try
		{
			tx = session.beginTransaction();
			
			uList = session.createQuery("from User").list();//User is the class name not the table name!!!!
			for(User tempUser : uList) {
				if(tempUser.getEmail().equals(email)) {
					//counter++;
					//System.out.println("COUNTER: "+counter);
					//System.out.println("input email "+email);
					//System.out.println("db email "+tempUser.getEmail());
					//System.out.println("DUPLICATE EMAIL DETECTED!!!");
					return tempUser;
				}
			}
			tx.commit();
			//theUser = (User)session.createQuery("from User u where u.email=" + email);//User is the class name not the table name!!!!
			//User = (User)session.get(User.class, UserID);
		}
		catch(HibernateException e)
		{
			e.printStackTrace();
		}
		finally
		{
			session.close();
		}
		
		return theUser;
		
		
	}
	
}
