package facades;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entites.Creator;

@Stateless
public class CreatorFacade extends AbstractFacade<Creator> {
	@PersistenceContext(unitName="games")
	private EntityManager em;
	
	public CreatorFacade() {
		super(Creator.class);
	}

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

}