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
@Table(name="movie")
public class Movie {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) //identifying the primary key
	@Column(name="movieId")
	private Integer movieId; 
	
	//Column name must be the exact name with case sensitivity of the attribute inside the db table.
	@Column(name="title")
	private String title; 
	
	@Column(name="icon")
	private String icon;
	
	@Column(name="summary")
	private String summary;
	
	@Column(name="averageUserRating")
	private double averageUserRating;
	
	@Column(name="genre")
	private String genre;
	
	@Column(name="length")
	private int length;
	
	@Column(name="filmRating")
	private String filmRating;
	
	
	public Movie() {
		
	}


	public Movie(String title, String icon, String summary, double averageUserRating, String genre, int length,
			String filmRating) {
		super();
		this.title = title;
		this.icon = icon;
		this.summary = summary;
		this.averageUserRating = averageUserRating;
		this.genre = genre;
		this.length = length;
		this.filmRating = filmRating;
	}


	public Integer getMovieId() {
		return movieId;
	}


	public void setMovieId(Integer movieId) {
		this.movieId = movieId;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getIcon() {
		return icon;
	}


	public void setIcon(String icon) {
		this.icon = icon;
	}


	public String getSummary() {
		return summary;
	}


	public void setSummary(String summary) {
		this.summary = summary;
	}


	public double getAverageUserRating() {
		return averageUserRating;
	}


	public void setAverageUserRating(double averageUserRating) {
		this.averageUserRating = averageUserRating;
	}


	public String getGenre() {
		return genre;
	}


	public void setGenre(String genre) {
		this.genre = genre;
	}


	public int getLength() {
		return length;
	}


	public void setLength(int length) {
		this.length = length;
	}


	public String getFilmRating() {
		return filmRating;
	}


	public void setFilmRating(String filmRating) {
		this.filmRating = filmRating;
	}

	//This constructor made by right clicking > Source > generate constructor with fields
	

	
	
	//toString used for debugging
/*	@Override
	public String toString() {
		return "Movie [MovieId=" + movieId + ", MovieName=" + MovieName + ", fname=" + fname + ", lname="
				+ lname + ", email=" + email + ", password=" + password + ", location=" + location + ", MovieType=" + MovieType;
	}*/
	
	
	
}
