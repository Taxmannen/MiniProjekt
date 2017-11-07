package bean;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import entites.Creator;
import entites.Game;
import facades.CreatorFacade;
import facades.GameFacade;

@SuppressWarnings("serial")
@Named
@ViewScoped
public class Bean implements Serializable {
	@EJB private GameFacade gameEJB;
	@EJB private CreatorFacade creatorEJB;
	
	@OneToMany(mappedBy="game")
	private List<Creator> creators;
	
	@ManyToOne
	@JoinColumn(name="creatorid", referencedColumnName="creatorid", nullable=false)
	private List<Game> games;
	
	private int id;
	private String title;
	private String genre;
	private String developer;
	
	public void saveGame(Game g) {
		gameEJB.edit(g);
	}
	
	public void deleteGame(Game g) {
		gameEJB.remove(g);
		games = gameEJB.findAll();
	}
	
	public void addGame() {
		Game g = new Game(title, genre, developer, id);
		System.out.println(id);
		gameEJB.create(g);
		games = gameEJB.findAll();
	}
	
	public void user() {
		String user = FacesContext.getCurrentInstance().getExternalContext().getUserPrincipal().toString();
		boolean creatorExists = false;
		creators = creatorEJB.findAll();
		for(Creator c : creators) {
			if(c.getName().equals(user)) {
				id = c.getId();
				creatorExists = true;
				break;
			} 
		}
		if(!creatorExists) {
			Creator c = new Creator(user);
			creatorEJB.create(c);
			id = c.getId();
		}
	}
	
	public List<Game> getGame() {
		if(games == null) {
			games = gameEJB.findAll();
			user();
		}
		return games;
	}
	public void setGame(List<Game> games) { this.games = games; }
	public String getTitle() { return title; }
	public void setTitle(String title) { this.title = title; }
	public String getGenre() { return genre; }
	public void setGenre(String genre) { this.genre = genre; }
	public String getDeveloper() { return developer; }
	public void setDeveloper(String developer) { this.developer = developer; }	
}
