package cinema.user.entity;

//Imports gotten by right click > source > organize imports
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @HoonJae Won
 * Entity maps to the mysql table and the "@Column" maps the column name to the appropriate variables
 */
@Entity
@Table(name="ticket")
public class Ticket {
	 
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) //identifying the primary key
	@Column(name="ticketId")
	private Integer ticketId; 
	
	//Column name must be the exact name with case sensitivity of the attribute inside the db table.
	@Column(name="movieTitle")
	private String movieTitle; 
	
	@Column(name="purchaseDate")
	private String purchaseDate;
	
	@Column(name="price")
	private Integer price;
	
	@Column(name="ticketType")
	private Integer ticketType;
	
	@Column(name="seatNo")
	private Integer seatNo;
	
	@Column(name="movieId")
	private Integer movieId;
	
	@Column(name="showTimeId")
	private Integer showTimeId;
	
	@Column(name="userId")
	private Integer userId;
	
	@Column(name="bookingNo")
	private Integer bookingNo;
	
	
	public Ticket() {
		
	}


	public Ticket(String movieTitle, String purchaseDate, Integer price, Integer ticketType, Integer seatNo,
			Integer movieId, Integer showTimeId, Integer userId, Integer bookingNo) {
		super();
		this.movieTitle = movieTitle;
		this.purchaseDate = purchaseDate;
		this.price = price;
		this.ticketType = ticketType;
		this.seatNo = seatNo;
		this.movieId = movieId;
		this.showTimeId = showTimeId;
		this.userId = userId;
		this.bookingNo = bookingNo;
	}


	public Integer getTicketId() {
		return ticketId;
	}


	public void setTicketId(Integer ticketId) {
		this.ticketId = ticketId;
	}


	public String getMovieTitle() {
		return movieTitle;
	}


	public void setMovieTitle(String movieTitle) {
		this.movieTitle = movieTitle;
	}


	public String getPurchaseDate() {
		return purchaseDate;
	}


	public void setPurchaseDate(String purchaseDate) {
		this.purchaseDate = purchaseDate;
	}


	public Integer getPrice() {
		return price;
	}


	public void setPrice(Integer price) {
		this.price = price;
	}


	public Integer getTicketType() {
		return ticketType;
	}


	public void setTicketType(Integer ticketType) {
		this.ticketType = ticketType;
	}


	public Integer getSeatNo() {
		return seatNo;
	}


	public void setSeatNo(Integer seatNo) {
		this.seatNo = seatNo;
	}


	public Integer getMovieId() {
		return movieId;
	}


	public void setMovieId(Integer movieId) {
		this.movieId = movieId;
	}


	public Integer getShowTimeId() {
		return showTimeId;
	}


	public void setShowTimeId(Integer showTimeId) {
		this.showTimeId = showTimeId;
	}


	public Integer getUserId() {
		return userId;
	}


	public void setUserId(Integer userId) {
		this.userId = userId;
	}


	public Integer getBookingNo() {
		return bookingNo;
	}


	public void setBookingNo(Integer bookingNo) {
		this.bookingNo = bookingNo;
	}

	//This constructor made by right clicking > Source > generate constructor with fields
	

	
	
	//toString used for debugging
	/*@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", fname=" + fname + ", lname="
				+ lname + ", email=" + email + ", password=" + password + ", location=" + location + ", userType=" + userType;
	}*/
	
	
	
}
