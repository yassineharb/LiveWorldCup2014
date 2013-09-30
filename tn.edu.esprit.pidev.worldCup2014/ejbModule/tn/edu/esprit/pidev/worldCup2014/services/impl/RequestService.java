package tn.edu.esprit.pidev.worldCup2014.services.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.edu.esprit.pidev.worldCup2014.domain.RequestJournaliste;
import tn.edu.esprit.pidev.worldCup2014.domain.UserWorldCup;
import tn.edu.esprit.pidev.worldCup2014.services.interfaces.RequestServiceLocal;
import tn.edu.esprit.pidev.worldCup2014.services.interfaces.RequestServiceRemote;

/**
 * Session Bean implementation class RequestService
 */
@Stateless
public class RequestService implements RequestServiceRemote,
		RequestServiceLocal {

	/**
	 * Default constructor.
	 */
	@PersistenceContext
	EntityManager entityManager;


	@Override
	public void addRequest(RequestJournaliste requestJournaliste ) {
		entityManager.persist(requestJournaliste);

		
	}


	@Override
	public List<RequestJournaliste> findAllRequest() {
		String jpql = "select e from RequestJournaliste e";
		 Query query = entityManager.createQuery(jpql);
		return query.getResultList();
	}

	
	


}
