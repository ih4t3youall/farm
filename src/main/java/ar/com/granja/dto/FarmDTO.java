package ar.com.granja.dto;

public class FarmDTO {

	private int chickenCount;
	private int eggCount;
	private String name;

	
	
	
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
