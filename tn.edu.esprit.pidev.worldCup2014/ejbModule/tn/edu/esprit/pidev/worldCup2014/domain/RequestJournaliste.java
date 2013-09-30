package tn.edu.esprit.pidev.worldCup2014.domain;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: RequestJournaliste
 *
 */
@Entity

public class RequestJournaliste implements Serializable {

	
	private int idRequest;
	private String motivation;
	private UserWorldCup userWorldCup;
	private static final long serialVersionUID = 1L;

	public RequestJournaliste() {
		super();
	}   
	@Id  
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	public int getIdRequest() {
		return this.idRequest;
	}

	public void setIdRequest(int idRequest) {
		this.idRequest = idRequest;
	}   
	public String getMotivation() {
		return this.motivation;
	}

	public void setMotivation(String motivation) {
		this.motivation = motivation;
	}
	
	@OneToOne
	@JoinColumn(insertable =true , name ="cin",referencedColumnName="cin" )
	public UserWorldCup getUserWorldCup() {
		return userWorldCup;
	}
	public void setUserWorldCup(UserWorldCup userWorldCup) {
		this.userWorldCup = userWorldCup;
	}
   
}
