package ar.com.granja.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.JdbcTemplate;

import com.mysql.jdbc.Statement;

import ar.com.granja.dto.UsuarioDTO;
import ar.com.granja.rowMapper.UsuarioDTORowMapper;

public class UsuarioDAO {

	private JdbcTemplate jdbcTemplate;

	public int saveUser(UsuarioDTO usuarioDTO) throws SQLException {
		String sql = "insert into users (username,password,enabled) value(?,?,?) ";
//		jdbcTemplate.update(sql, usuarioDTO.getNombreUsuario(), usuarioDTO.getPasswd(), 1);
		

		    Connection connection = jdbcTemplate.getDataSource().getConnection();
		    PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		    preparedStatement.setString(1,usuarioDTO.getNombreUsuario());
		    preparedStatement.setString(2, usuarioDTO.getPasswd());
		    preparedStatement.setInt(3, 1);

		    preparedStatement.executeUpdate();
		    ResultSet keys = preparedStatement.getGeneratedKeys();
		    Integer generatedId = -1;
		    if (keys.next()) {
		        generatedId = keys.getInt(1); //id returned after insert execution
		    }
		    
		    return generatedId;
		

	}
	
	
	public UsuarioDTO getUserByName(String username) {
		String sql ="select * from users where username=?";
		UsuarioDTO usuarioDTO = jdbcTemplate.queryForObject(sql, new Object[]{username},new UsuarioDTORowMapper());
		return usuarioDTO;
		
	}


	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}





	

}
