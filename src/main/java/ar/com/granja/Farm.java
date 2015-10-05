package ar.com.granja;

import java.util.List;

public class Farm {

	private int userID;
	private int idFarm;
	private String name;
	private List<Chicken> chickens;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public List<Chicken> getChickens() {
		return chickens;
	}
	public void setChickens(List<Chicken> chickens) {
		this.chickens = chickens;
	}
	public int getIdFarm() {
		return idFarm;
	}
	public void setIdFarm(int idFarm) {
		this.idFarm = idFarm;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	
	
	
}
