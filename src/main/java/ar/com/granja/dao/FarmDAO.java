package ar.com.granja.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;

import ar.com.granja.Farm;
import ar.com.granja.rowMapper.FarmRowMapper;

public class FarmDAO {

	private JdbcTemplate jdbcTemplate;
	
	
	
	public void deleteFarm(int idFarm) {

		String sql ="delete from farm where idFarm = ? ";
		jdbcTemplate.update(sql, new Object[]{idFarm});
		
	}

	public void createFarm(Farm farm) throws org.springframework.dao.DuplicateKeyException {

		String sql = "insert into Farm (name)values (?)";
		jdbcTemplate.update(sql, new Object[] { farm.getName() });
		 
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

	public List<Farm> getFarms() {
		String sql = "select * from Farm";
		List<Farm> farms = jdbcTemplate.query(sql, new FarmRowMapper());

		return farms;
	}






}
