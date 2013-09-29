package tn.edu.esprit.pidev.worldCup2014.domain;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: UserWorldCup
 *
 */
@Entity

public class UserWorldCup implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int cin;
	private String name;
	private String Sname;
	private int typeUser;
	private String login;
	private String password;
	private String email;
	private String country;
	private boolean validate;


 
	@Id    
	public int getCin() {
		return this.cin;
	}

	public void setCin(int cin) {
		this.cin = cin;
	}   
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}   
	public String getSname() {
		return this.Sname;
	}

	public void setSname(String Sname) {
		this.Sname = Sname;
	}   
	public int getTypeUser() {
		return this.typeUser;
	}

	public void setTypeUser(int typeUser) {
		this.typeUser = typeUser;
	}   
	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}   
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}   
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}   
	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}   
	public boolean getValidate() {
		return this.validate;
	}

	public void setValidate(boolean validate) {
		this.validate = validate;
	}
   
}