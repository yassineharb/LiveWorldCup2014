package tn.edu.esprit.pidev.worldCup2014.services.impl;

import java.util.List;


import javax.ejb.Stateless;
import javax.persistence.Query;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.edu.esprit.pidev.worldCup2014.domain.UserWorldCup;
import tn.edu.esprit.pidev.worldCup2014.services.interfaces.UserCrudServicesLocal;
import tn.edu.esprit.pidev.worldCup2014.services.interfaces.UserCrudServicesRemote;

/**
 * Session Bean implementation class UserCrudServices
 */
@Stateless

public class UserCrudServices implements UserCrudServicesRemote,
		UserCrudServicesLocal {

	/**
	 * Default constructor.
	 */
	@PersistenceContext
	EntityManager entityManager;

	public UserCrudServices() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void addUser(UserWorldCup user) {
		entityManager.persist(user);

		// TODO Auto-generated method stub

	}


	public void updateUser(UserWorldCup user) {
		entityManager.merge(user);

	}

	@Override
	public UserWorldCup FindUserByCin(int cin) {

		return entityManager.find(UserWorldCup.class, cin);
	}

	@Override
	public List<UserWorldCup> FindAllUser() {
		String jpql = "select e from UserWorldCup e";
		 Query query = entityManager.createQuery(jpql);
		return query.getResultList();
	}

	@Override
	public List<UserWorldCup> FindAllUserByType(int type) {
		
		String jpql = "select e from UserWorldCup e where e.typeUser = :p";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("p", type);
		
		return query.getResultList();
		
		
		
	}

	@Override
	public void deleteUserWorldCupByCIN(int cin) {
		UserWorldCup userw=new UserWorldCup();
		userw=FindUserByCin(cin);
		entityManager.remove(userw);
		
		
	}

}
