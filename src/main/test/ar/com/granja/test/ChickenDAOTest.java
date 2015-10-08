package ar.com.granja.test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import ar.com.granja.Chicken;
import ar.com.granja.Farm;
import ar.com.granja.dao.ChickenDAO;
import ar.com.granja.dto.UsuarioDTO;

public class ChickenDAOTest {

	private static final String driverClassName = "com.mysql.jdbc.Driver";
	private static final String url = "jdbc:mysql://localhost/granjaTest";
	private static final String dbUsername = "root";
	private static final String dbPassword = "root";

	@Test
	public void getChickensOfFarms() {

		JdbcTemplate jdbcTemplate = getJdbcTemplateTest();
		Farm farm = getFarm();

		ChickenDAO chickenDAO = getChickenDAO();
		chickenDAO.getChickenFromFarm(farm);

		assertEquals(farm.getChickens().size(), 1);

	}

	@Test
	public void deleteChickenOfFarm() {

		Farm farm = getFarm();
		ChickenDAO chickenDAO = getChickenDAO();
		Chicken chicken = farm.getChickens().get(0);
		
		chickenDAO.deleteChicken(chicken);
		
		
		
		
		
		
		
		
		
		
	}

	public Chicken getChicken(){
		
		Chicken chicken = new Chicken();
		chicken.setIdChicken(1);
		chicken.setEggs(10);
		chicken.setIdFarm(1);
		chicken.setName("un pollito");
		return chicken;
		
	}
	
	public Farm getFarm() {
		Farm farm = new Farm();
		farm.setIdFarm(1);
		farm.setName("una granja");
		farm.setUserID(3);
		
		 List<Chicken> chickens = new ArrayList<Chicken>();
		chickens.add(getChicken());
		
		
		return farm;

	}
	
	public UsuarioDTO getUsuario(){
		UsuarioDTO usuarioDTO = new UsuarioDTO();
		usuarioDTO.setIdUser(3);
		usuarioDTO.setNombreUsuario("test");
		usuarioDTO.setPasswd("test");
		return usuarioDTO;
		
		
	}
	
	public ChickenDAO getChickenDAO(){
		
		ChickenDAO chickenDAO = new ChickenDAO();
		chickenDAO.setJdbcTemplate(getJdbcTemplateTest());
		return chickenDAO;
		
	}

	public JdbcTemplate getJdbcTemplateTest() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();

		dataSource.setDriverClassName(driverClassName);
		dataSource.setUrl(url);
		dataSource.setUsername(dbUsername);
		dataSource.setPassword(dbPassword);

		return new JdbcTemplate(dataSource);
	}

}
