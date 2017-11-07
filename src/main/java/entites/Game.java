package entites;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Game {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="title", nullable = false, length = 32) 	
	private String title;
	@Column(name="genre", nullable = false, length = 32) 	
	private String genre;
	@Column(name="developer", nullable = false, length = 32) 	
	private String developer;
	@Column(name="creatorid", nullable = false) 	
	private int creatorId;
	
	
	public Game(){ }
	public Game(String title, String genre, String developer, int creatorId) {
		this.title = title;
		this.genre = genre;
		this.developer = developer;
		this.creatorId = creatorId;
	}
	
	public int getId() { return id; }
	public void setId(int id) { this.id = id; }

	public String getTitle() { return title; }
	public void setTitle(String title) { this.title = title; }

	public String getGenre() { return genre; }
	public void setGenre(String genre) { this.genre = genre; }

	public String getDeveloper() { return developer; }
	public void setDeveloper(String developer) { this.developer = developer; }
	
	public int getCreatorId() { return creatorId; }
	public void setCreatorId(int creatorId) { this.creatorId = creatorId; }
}
