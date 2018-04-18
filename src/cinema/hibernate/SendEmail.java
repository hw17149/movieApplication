package cinema.hibernate;

import java.util.Date;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.UUID;
public class SendEmail {
  //public static  void main(String[] args) {
	  //final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
	  // Get a Properties object
	  /*Properties props = System.getProperties();
	  props.setProperty("mail.smtp.host", "smtp.gmail.com");
	  props.setProperty("mail.smtp.socketFactory.class", SSL_FACTORY);
	  props.setProperty("mail.smtp.socketFactory.fallback", "false");
	  props.setProperty("mail.smtp.port", "465");
	  props.setProperty("mail.smtp.socketFactory.port", "465");
	  props.put("mail.smtp.auth", "true");
	  props.put("mail.debug", "true");
	  props.put("mail.store.protocol", "pop3");
	  props.put("mail.transport.protocol", "smtp");*/
	  /* email and password (make sure to have access for less secure app) */
	  /*String username = "cinema4050@gmail.com";
	  String password = "movie4050";/*
	  
	  /* customer email */
	  //String customerEmail = "cinema4050@gmail.com";
	  
	  //registerConfirmation(props, username, password, customerEmail);
     
  //}
	
  public Properties makeProps() {
	  final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
	  // Get a Properties object
	  Properties props = System.getProperties();
	  props.setProperty("mail.smtp.host", "smtp.gmail.com");
	  props.setProperty("mail.smtp.socketFactory.class", SSL_FACTORY);
	  props.setProperty("mail.smtp.socketFactory.fallback", "false");
	  props.setProperty("mail.smtp.port", "465");
	  props.setProperty("mail.smtp.socketFactory.port", "465");
	  props.put("mail.smtp.auth", "true");
	  props.put("mail.debug", "true");
	  props.put("mail.store.protocol", "pop3");
	  props.put("mail.transport.protocol", "smtp");
	  /* email and password (make sure to have access for less secure app) */
	  return props;
  }
  
  public void registerConfirmation(Properties props, final String username, final String password, String customerEmail){
	  
	  
	  try{
		  Session session = Session.getDefaultInstance(props, 
				  new Authenticator(){
			  		protected PasswordAuthentication getPasswordAuthentication() {
			  			return new PasswordAuthentication(username, password);}});
	  // -- Create a new message --
	  Message msg = new MimeMessage(session);

	  /* from */
	  msg.setFrom(new InternetAddress(username));
     
	  /* to */
	  msg.setRecipients(Message.RecipientType.TO, 
                      InternetAddress.parse(customerEmail,false));
	  /* title */
	  msg.setSubject("Register Confirmation Email");
     
	  /* text field */ 
	  msg.setText("Welcome! You are registered!\n To confirm account go to http://localhost:8080/movieApplication/login2.jsp");
	  msg.setSentDate(new Date());
	  Transport.send(msg);
     
	  System.out.println("Message sent.");
	  }catch (MessagingException e){ 
		  System.out.println("Error: " + e);
	  }
  }
  
  public static String sendForgotPassword(String customerEmail){
	  final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
	  // Get a Properties object
	  Properties props = System.getProperties();
	  props.setProperty("mail.smtp.host", "smtp.gmail.com");
	  props.setProperty("mail.smtp.socketFactory.class", SSL_FACTORY);
	  props.setProperty("mail.smtp.socketFactory.fallback", "false");
	  props.setProperty("mail.smtp.port", "465");
	  props.setProperty("mail.smtp.socketFactory.port", "465");
	  props.put("mail.smtp.auth", "true");
	  props.put("mail.debug", "true");
	  props.put("mail.store.protocol", "pop3");
	  props.put("mail.transport.protocol", "smtp");
	  /* email and password (make sure to have access for less secure app) */
	  String username = "cinema4050@gmail.com";
	  String password = "movie4050";
	  
	  /* customer email */
	  //String customerEmail = "guangqian.zhang@gmail.com";
	  
	  String pw = forgotPassword(props, username, password, customerEmail);
	  
	  return pw;
  }
  
  public static String forgotPassword(Properties props, final String username, final String password, String customerEmail){
	  String pw = generateString();
	  
	  try{
		  Session session = Session.getDefaultInstance(props, 
				  new Authenticator(){
			  		protected PasswordAuthentication getPasswordAuthentication() {
			  			return new PasswordAuthentication(username, password);}});
	  // -- Create a new message --
	  Message msg = new MimeMessage(session);

	  /* from */
	  msg.setFrom(new InternetAddress(username));
     
	  /* to */
	  msg.setRecipients(Message.RecipientType.TO, 
                      InternetAddress.parse(customerEmail,false));
	  /* title */
	  msg.setSubject("Forgot Password");
     
	  
	  
	  /* text field */ 
	  msg.setText("Your password has been reset" + "\n\n" + "Your new password is: " + pw);
	  msg.setSentDate(new Date());
	  Transport.send(msg);
	  
	  System.out.println("Message sent.");
	  }catch (MessagingException e){ 
		  System.out.println("Error: " + e);
	  }
	  return pw;
  }
  
  public static String generateString() {
      String uuid = UUID.randomUUID().toString();
      uuid = uuid.substring(0,8);
      return uuid;
  }
  
}
  

