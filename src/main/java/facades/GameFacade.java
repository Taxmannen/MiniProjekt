package facades;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import entites.Game;

@Stateless
public class GameFacade extends AbstractFacade<Game> {
	@PersistenceContext(unitName="games")
	private EntityManager em;
	
	public GameFacade() {
		super(Game.class);
	}

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

}
