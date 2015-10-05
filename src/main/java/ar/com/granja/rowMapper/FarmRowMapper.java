package ar.com.granja.rowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import ar.com.granja.Farm;

public class FarmRowMapper implements RowMapper<Farm> {

	@Override
	public Farm mapRow(ResultSet rs, int arg1) throws SQLException {

		
		Farm farm = new Farm();
		farm.setName(rs.getString("name"));
		farm.setIdFarm(rs.getInt("idFarm"));
		farm.setUserID(rs.getInt("users_USER_ID"));
		return farm;
		
	}

}
