package facades;

import javax.annotation.security.DeclareRoles;
import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entites.User;

@Stateless
@DeclareRoles({"admin", "user"})
public class UserFacade extends AbstractFacade<User> {
	
	@PersistenceContext(unitName="games")
	private EntityManager em;

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

	public UserFacade() {
		super(User.class);
	}

	@Override
    @RolesAllowed({"admin"})
	public void create(User entity) {
		super.create(entity);
	}

	@Override
    @RolesAllowed({"admin"})
	public void edit(User entity) {
		super.edit(entity);
	}

	@Override
    @RolesAllowed({"admin"})
	public void remove(User entity) {
		super.remove(entity);
	}
}