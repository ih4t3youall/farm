package ar.com.granja.rowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.omg.PortableServer.SERVANT_RETENTION_POLICY_ID;
import org.springframework.jdbc.core.RowMapper;

import ar.com.granja.Chicken;
import ar.com.granja.Farm;

public class ChickenRowMapper  implements RowMapper<Chicken> {

	@Override
	public Chicken mapRow(ResultSet rs, int arg1) throws SQLException {

		Chicken chicken = new Chicken();
		chicken.setEggs(rs.getInt("eggs"));
		chicken.setName(rs.getString("name"));
		chicken.setIdFarm(rs.getInt("Farm_idFarm"));
		chicken.setIdChicken(rs.getInt("idChicken"));
		return chicken;
		
	}

}
