package ar.com.granja.bo;

import java.util.List;

import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;

import ar.com.granja.Farm;
import ar.com.granja.dao.ChickenDAO;
import ar.com.granja.dao.FarmDAO;

public class GranjaBO {

	private FarmDAO farmDAO;
	private ChickenDAO chickenDAO;

	public void crearGranja(Farm farm) throws org.springframework.dao.DuplicateKeyException {
		 farmDAO.createFarm(farm);
		 
		
	}
	
	
	
	public void eliminarGranja(int idFarm) {

		chickenDAO.deleteChickenOfFarm(idFarm);
		farmDAO.deleteFarm(idFarm);
		
	}


	public List<Farm> hayGranjas() {

		List<Farm> farms = farmDAO.getFarms();
		 chickenDAO.getChickensOfFarms(farms);
		 return farms;

	}

	public Farm obtenerGranjaPorNombre(Farm farmDTO) {
		
		 Farm farm= farmDAO.getFarmByName(farmDTO);
		  chickenDAO.getChickenFromFarm(farm);
		  return farm;
	}

	
	public FarmDAO getFarmDAO() {
		return farmDAO;
	}

	public void setFarmDAO(FarmDAO farmDAO) {
		this.farmDAO = farmDAO;
	}

	public ChickenDAO getChickenDAO() {
		return chickenDAO;
	}

	public void setChickenDAO(ChickenDAO chickenDAO) {
		this.chickenDAO = chickenDAO;
	}



}
