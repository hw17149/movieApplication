package cinema.user.entity;

import java.io.Serializable;

//Imports gotten by right click > source > organize imports
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
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
@Table(name="review")
public class Review{
	
//	@Id
//	//@GeneratedValue(strategy=GenerationType.IDENTITY) //identifying the primary key
//	@Column(name="userId")
//	private Integer userId; 
//	
//	@Id
//	//@GeneratedValue(strategy=GenerationType.IDENTITY) //identifying the primary key
//	@Column(name="movieId")
//	private Integer movieId;
//	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) //identifying the primary key
	@Column(name="reviewNo")
	private Integer reviewNo; 
	
	/*@ManyToMany
    @JoinColumns({
        @JoinColumn(
            name = "user_Id",
            referencedColumnName = "user_Id"),
        @JoinColumn(
            name = "movie_number",
            referencedColumnName = "movie_Id")
    })
	//private User user;
	private Movie movie;*/
	
	//@EmbeddedId
	//private user_movieId id;
	
	//Column name must be the exact name with case sensitivity of the attribute inside the db table.
	//@Id
	//@GeneratedValue(strategy=GenerationType.IDENTITY) //identifying the primary key
	@Column(name="userId")
	private Integer userId; 
	
	//@Id
	//@GeneratedValue(strategy=GenerationType.IDENTITY) //identifying the primary key
	@Column(name="movieId")
	private Integer movieId;
	
	@Column(name="summary")
	private String summary;
	
	@Column(name="rating")
	private Integer rating;
	
	@Column(name="date")
	private String date;

	public Review() {}
	

	public Review(Integer userId, Integer movieId, String summary, Integer rating, String date) {
		super();
		this.userId = userId;
		this.movieId = movieId;
		this.summary = summary;
		this.rating = rating;
		this.date = date;
	}



	public Integer getReviewNo() {
		return reviewNo;
	}



	public void setReviewNo(Integer reviewNo) {
		this.reviewNo = reviewNo;
	}



	public Integer getUserId() {
		return userId;
	}



	public void setUserId(Integer userId) {
		this.userId = userId;
	}



	public Integer getMovieId() {
		return movieId;
	}



	public void setMovieId(Integer movieId) {
		this.movieId = movieId;
	}



	public String getSummary() {
		return summary;
	}



	public void setSummary(String summary) {
		this.summary = summary;
	}



	public Integer getRating() {
		return rating;
	}



	public void setRating(Integer rating) {
		this.rating = rating;
	}



	public String getDate() {
		return date;
	}



	public void setDate(String date) {
		this.date = date;
	}



	
	//This constructor made by right clicking > Source > generate constructor with fields
	
	//toString used for debugging
/*	@Override
	public String toString() {
		return "Movie [MovieId=" + movieId + ", MovieName=" + MovieName + ", fname=" + fname + ", lname="
				+ lname + ", email=" + email + ", password=" + password + ", location=" + location + ", MovieType=" + MovieType;
	}*/
	
	
	
}
