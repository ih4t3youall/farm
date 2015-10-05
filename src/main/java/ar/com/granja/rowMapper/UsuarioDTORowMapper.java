package ar.com.granja.rowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import ar.com.granja.dto.UsuarioDTO;

public class UsuarioDTORowMapper implements RowMapper<UsuarioDTO> {

	@Override
	public UsuarioDTO mapRow(ResultSet rs, int arg1) throws SQLException {

		
		UsuarioDTO usuarioDTO = new UsuarioDTO();
		usuarioDTO.setIdUser(rs.getInt(1));
		usuarioDTO.setNombreUsuario(rs.getString(2));
		
		
		
		return usuarioDTO;
		
	}

}
