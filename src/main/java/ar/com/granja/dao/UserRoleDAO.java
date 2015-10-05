package ar.com.granja.dao;

import org.springframework.jdbc.core.JdbcTemplate;

import ar.com.granja.dto.UsuarioDTO;

public class UserRoleDAO {

	private JdbcTemplate jdbcTemplate;

	public void saveUserRole(UsuarioDTO usuarioDTO) {

		String sql = "INSERT INTO granja.user_roles (USER_ID,AUTHORITY) VALUES (?, 'ROLE_USER');";
		jdbcTemplate.update(sql, new Object[] { usuarioDTO.getIdUser() });

	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

}
