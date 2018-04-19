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
@Table(name="creditcard")
public class CreditCard {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) //identifying the primary key
	@Column(name="creditCardNo")
	private String creditCardNo; 
	
	//Column name must be the exact name with case sensitivity of the attribute inside the db table.
	@Column(name="expDate")
	private String expDate;
	
	@Column(name="address")
	private String address;
	
	@Column(name="userId")
	private Integer userId;

	//This constructor made by right clicking > Source > generate constructor with fields
	public CreditCard(String creditCardNo, String expDate, String address, Integer userId) {
		super();
		this.creditCardNo = creditCardNo;
		this.expDate = expDate;
		this.address = address;
		this.userId = userId;
	}

	public String getCreditCardNo() {
		return creditCardNo;
	}

	public void setCreditCardNo(String creditCardNo) {
		this.creditCardNo = creditCardNo;
	}

	public String getExpDate() {
		return expDate;
	}

	public void setExpDate(String expDate) {
		this.expDate = expDate;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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
