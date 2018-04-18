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
@Table(name="booking")
public class Booking {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) //identifying the primary key
	@Column(name="bookingNo")
	private Integer bookingNo; 
	
	//Column name must be the exact name with case sensitivity of the attribute inside the db table.
	@Column(name="numberOfAdults")
	private Integer numberOfAdults; 
	
	@Column(name="numberOfChildren")
	private Integer numberOfChildren; 
	
	
	@Column(name="numberOfSeniors")
	private Integer numberOfSeniors;
	
	@Column(name="promoId")
	private Integer promoId;
	
	@Column(name="total")
	private double total;
	
	@Column(name="userId")
	private Integer userId;
	
	public Booking() {
		
	}

	public Booking(Integer numberOfAdults, Integer numberOfChildren, Integer numberOfSeniors,
			Integer promoId, double total, Integer userId) {
		super();
		this.numberOfAdults = numberOfAdults;
		this.numberOfChildren = numberOfChildren;
		this.numberOfSeniors = numberOfSeniors;
		this.promoId = promoId;
		this.total = total;
		this.userId = userId;
	}
	
	//This constructor made by right clicking > Source > generate constructor with fields

	public Integer getBookingNo() {
		return bookingNo;
	}

	public void setBookingNo(Integer bookingNo) {
		this.bookingNo = bookingNo;
	}

	public Integer getNumberOfAdults() {
		return numberOfAdults;
	}

	public void setNumberOfAdults(Integer numberOfAdults) {
		this.numberOfAdults = numberOfAdults;
	}

	public Integer getNumberOfChildren() {
		return numberOfChildren;
	}

	public void setNumberOfChildren(Integer numberOfChildren) {
		this.numberOfChildren = numberOfChildren;
	}

	public Integer getNumberOfSeniors() {
		return numberOfSeniors;
	}

	public void setNumberOfSeniors(Integer numberOfSeniors) {
		this.numberOfSeniors = numberOfSeniors;
	}

	public Integer getPromoId() {
		return promoId;
	}

	public void setPromoId(Integer promoId) {
		this.promoId = promoId;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	

	
	
	//toString used for debugging
/*	@Override
	public String toString() {
		return "Movie [MovieId=" + movieId + ", MovieName=" + MovieName + ", fname=" + fname + ", lname="
				+ lname + ", email=" + email + ", password=" + password + ", location=" + location + ", MovieType=" + MovieType;
	}*/
	
	
	
}
