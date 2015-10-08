package ar.com.granja.bo;

import java.util.List;

import ar.com.granja.Chicken;
import ar.com.granja.Farm;
import ar.com.granja.dao.ChickenDAO;
import ar.com.granja.dto.SaveChickenDTO;

public class ChickenBO {

	private ChickenDAO chickenDAO;
	
	
	public List<Chicken> obtenerPollitosDeGranja(Farm farmDTO) {
	
		return chickenDAO.getChickenFromFarm(farmDTO.getIdFarm());
		  
	
}

	
	public void guardarGallinaEnGranja(SaveChickenDTO chickenDTO){
		
		
		chickenDAO.saveChickenAtFarm(chickenDTO);
		
	}
	public void eliminarGallina(Chicken chickenDTO) {


		chickenDAO.deleteChicken(chickenDTO);
		
	}


	public void modificarGallina(Chicken chickenDTO) {
		chickenDAO.updateChicken(chickenDTO);
		
	}
	
	
	public ChickenDAO getChickenDAO() {
		return chickenDAO;
	}

	public void setChickenDAO(ChickenDAO chickenDAO) {
		this.chickenDAO = chickenDAO;
	}







	
	
	
	
	
}
