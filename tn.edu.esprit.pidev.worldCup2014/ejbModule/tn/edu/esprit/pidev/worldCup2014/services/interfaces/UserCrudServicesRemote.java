package tn.edu.esprit.pidev.worldCup2014.services.interfaces;

import java.util.List;

import javax.ejb.Remote;

import tn.edu.esprit.pidev.worldCup2014.domain.UserWorldCup;

@Remote
public interface UserCrudServicesRemote {
	public void addUser(UserWorldCup user);
	

	
	public void updateUser (UserWorldCup user);
	
	public UserWorldCup FindUserByCin(int cin);
	
	public List <UserWorldCup> FindAllUser();
	
	public List <UserWorldCup> FindAllUserByType(int type);
	
	public void deleteUserWorldCupByCIN(int cin);

}
