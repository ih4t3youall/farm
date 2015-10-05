package ar.com.granja.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;

import ar.com.granja.Chicken;
import ar.com.granja.Farm;
import ar.com.granja.dto.SaveChickenDTO;
import ar.com.granja.rowMapper.ChickenRowMapper;

public class ChickenDAO {

	private JdbcTemplate jdbcTemplate;
	
	
	public void deleteChickenOfFarm(int idFarm) {

			String sql = "DELETE FROM chicken WHERE  Farm_idFarm = ?";
			jdbcTemplate.update(sql,new Object[]{idFarm});
		
	}
	

	public void getChickensOfFarms(List<Farm> farms) {

		for (Farm farm : farms) {

			String sql = "select * from chicken where Farm_idFarm = ?";
			List<Chicken> query = jdbcTemplate.query(sql, new Object[] {farm.getIdFarm()}, new ChickenRowMapper());
			farm.setChickens(query);

		}

	}
	
	public void getChickenFromFarm(Farm farm){
		String sql = "select * from chicken where Farm_idFarm = ?";
		List<Chicken> chickens = jdbcTemplate.query(sql, new Object[]{farm.getIdFarm()},new ChickenRowMapper());
		farm.setChickens(chickens);
		
		
		
	}
	
	public void saveChickenAtFarm(SaveChickenDTO chickenDTO) {

		String sql = "insert into chicken (eggs,Farm_idFarm,name) values (?,?,?)";
		jdbcTemplate.update(sql,new Object[]{chickenDTO.getEggs(),chickenDTO.getIdFarm(),chickenDTO.getName()});
		
		
	}
	
	public void updateChicken(Chicken chickenDTO) {
		String sql = "update chicken set name = ? , eggs=? where idChicken = ?";
		jdbcTemplate.update(sql,new Object[]{chickenDTO.getName(),chickenDTO.getEggs(),chickenDTO.getIdChicken()});
		
	}



	public void saveCkicken(Farm farm) {
		List<Chicken> chickens = farm.getChickens();
		String sql = "insert into chicken (eggs,Farm_idFarm,name) values(?,?,?) ";
		jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement ps, int index) throws SQLException {
				Chicken chicken = chickens.get(index);
				ps.setInt(1, farm.getIdFarm());
				ps.setInt(2, chicken.getEggs());
				ps.setString(3, chicken.getName());
			}

			@Override
			public int getBatchSize() {
				return chickens.size();
			}
		});

	}
	
	
	public void deleteChicken(Chicken chickenDTO) {

		String sql = "DELETE FROM chicken WHERE idChicken=? ";
		jdbcTemplate.update(sql,new Object[]{chickenDTO.getIdChicken()});
		
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	





}
