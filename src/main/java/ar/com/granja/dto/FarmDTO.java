package ar.com.granja.dto;

public class FarmDTO {

	private int farmId;
	private int chickenCount;
	private int eggCount;
	private String name;
	private int userID;

	
	
	

	public int getFarmId() {
		return farmId;
	}

	public void setFarmId(int farmId) {
		this.farmId = farmId;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getChickenCount() {
		return chickenCount;
	}

	public void setChickenCount(int chickenCount) {
		this.chickenCount = chickenCount;
	}

	public int getEggCount() {
		return eggCount;
	}

	public void setEggCount(int eggCount) {
		this.eggCount = eggCount;
	}

}
