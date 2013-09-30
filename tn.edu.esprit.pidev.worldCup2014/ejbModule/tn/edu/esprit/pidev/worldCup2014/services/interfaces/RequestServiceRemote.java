package tn.edu.esprit.pidev.worldCup2014.services.interfaces;

import javax.ejb.Remote;

import tn.edu.esprit.pidev.worldCup2014.domain.RequestJournaliste;

@Remote
public interface RequestServiceRemote {
	
	public void addRequest( RequestJournaliste requestJournaliste );

}
