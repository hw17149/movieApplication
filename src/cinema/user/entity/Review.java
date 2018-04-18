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
@Table(name="promotion")
public class Review {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) //identifying the primary key
	@Column(name="userId")
	private Integer userId; 
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) //identifying the primary key
	@Column(name="movieId")
	private Integer movieId;
	
	//Column name must be the exact name with case sensitivity of the attribute inside the db table.
	@Column(name="price")
	private Integer price;
	
	@Column(name="expire")
	private String expire;
	
	@Column(name="discount")
	private double discount;
	
	@Column(name="promoCode")
	private String promoCode;

	
	//This constructor made by right clicking > Source > generate constructor with fields
	public Review(Integer price, String expire, double discount, String promoCode) {
		super();
		this.price = price;
		this.expire = expire;
		this.discount = discount;
		this.promoCode = promoCode;
	}

	public Integer getPromoId() {
		return promoId;
	}

	public void setPromoId(Integer promoId) {
		this.promoId = promoId;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public String getExpire() {
		return expire;
	}

	public void setExpire(String expire) {
		this.expire = expire;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public String getPromoCode() {
		return promoCode;
	}

	public void setPromoCode(String promoCode) {
		this.promoCode = promoCode;
	}
	
	//toString used for debugging
/*	@Override
	public String toString() {
		return "Movie [MovieId=" + movieId + ", MovieName=" + MovieName + ", fname=" + fname + ", lname="
				+ lname + ", email=" + email + ", password=" + password + ", location=" + location + ", MovieType=" + MovieType;
	}*/
	
	
	
}
