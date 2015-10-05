package ar.com.granja.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import ar.com.granja.Farm;
import ar.com.granja.rowMapper.FarmRowMapper;

public class FarmDAO {

	private JdbcTemplate jdbcTemplate;
	
	
	
	public void deleteFarm(int idFarm) {

		String sql ="delete from farm where idFarm = ? ";
		jdbcTemplate.update(sql, new Object[]{idFarm});
		
	}

	public void createFarm(Farm farm) throws org.springframework.dao.DuplicateKeyException {

		String sql = "insert into Farm (name,users_USER_ID)values (?,?)";
		jdbcTemplate.update(sql, new Object[] { farm.getName(),farm.getUserID() });
		 
	}
	
	public Farm getFarmByName(Farm farmDTO) {

		String sql = "select * from Farm where name = ?";
		Farm farm = jdbcTemplate.queryForObject(sql, new Object[]{farmDTO.getName()},new FarmRowMapper());
		
		return farm;
		
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public List<Farm> getFarmsByUserId(int userId) {
		//fix granjas por usuario
		
		String sql = "select * from Farm inner join users on Farm.users_USER_ID = users.USER_ID where users.user_id = ?";
		List<Farm> farms = null;
		try{
		farms = jdbcTemplate.query(sql,new Object[]{userId}, new FarmRowMapper());
		return farms;
		}catch(Exception e){
			e.printStackTrace();
			return new ArrayList<Farm>();
		}
		
		
		
	}






}
