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
@Table(name="showtime")
public class ShowTime {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) //identifying the primary key
	@Column(name="showTimeId")
	private Integer showTimeId; 
	
	//Column name must be the exact name with case sensitivity of the attribute inside the db table.
	@Column(name="showingDate")
	private String showingDate;  
	
	@Column(name="hallNo")
	private Integer hallNo; 
	
	@Column(name="showMovieId")
	private Integer showMovieId;
	
	@Column(name="isFull")
	private boolean isFull;
	
	
	@Column(name="seatArray")
	private String seatArray;
	
	@Column(name="showingTime")
	private String showingTime;
	
	public ShowTime() {
		
	}

	//This constructor made by right clicking > Source > generate constructor with fields
	
	public ShowTime(String showingDate, Integer hallNo, Integer showMovieId, boolean isFull, String seatArray, String showingTime) {
		super();
		this.showingDate = showingDate;
		this.hallNo = hallNo;
		this.showMovieId  = showMovieId;
		this.isFull = isFull;
		this.seatArray = seatArray;
		this.showingTime = showingTime;
	}

	public Integer getShowTimeId() {
		return showTimeId;
	}

	public void setShowTimeId(Integer showTimeId) {
		this.showTimeId = showTimeId;
	}

	public String getShowingDate() {
		return showingDate;
	}

	public void setShowingDate(String showingDate) {
		this.showingDate = showingDate;
	}

	public Integer getHallNo() {
		return hallNo;
	}

	public void setHallNo(Integer hallNo) {
		this.hallNo = hallNo;
	}

	public Integer getShowMovieId() {
		return showMovieId;
	}

	public void setShowMovieId(Integer showMovieId) {
		this.showMovieId = showMovieId;
	}

	public boolean isFull() {
		return isFull;
	}

	public void setIsFull(boolean isFull) {
		this.isFull = isFull;
	}

	public String getSeatArray() {
		return seatArray;
	}

	public void setSeatArray(String seatArray) {
		this.seatArray = seatArray;
	}

	public String getShowingTime() {
		return showingTime;
	}

	public void setShowingTime(String showingTime) {
		this.showingTime = showingTime;
	}


	
	//toString used for debugging
/*	@Override
	public String toString() {
		return "Movie [MovieId=" + movieId + ", MovieName=" + MovieName + ", fname=" + fname + ", lname="
				+ lname + ", email=" + email + ", password=" + password + ", location=" + location + ", MovieType=" + MovieType;
	}*/
	
	
	
}
