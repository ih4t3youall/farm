package ar.com.granja.bo;

import java.sql.SQLException;

import ar.com.granja.dao.UserRoleDAO;
import ar.com.granja.dao.UsuarioDAO;
import ar.com.granja.dto.UsuarioDTO;

public class UsuarioBO {
	
	private UsuarioDAO usuarioDAO;
	private UserRoleDAO userRoleDAO;
	
	public void guardarUsuario(UsuarioDTO usuarioDTO) throws SQLException{
		
		int userId = usuarioDAO.saveUser(usuarioDTO);
		usuarioDTO.setIdUser(userId);
		userRoleDAO.saveUserRole(usuarioDTO);
		
		
		
		
		
	}
	
	public UsuarioDTO obtenerUsuario(String username){
		
		return usuarioDAO.getUserByName(username);
		
	}
	
	
	public UsuarioDAO getUsuarioDAO() {
		return usuarioDAO;
	}

	public void setUsuarioDAO(UsuarioDAO usuarioDAO) {
		this.usuarioDAO = usuarioDAO;
	}



	public UserRoleDAO getUserRoleDAO() {
		return userRoleDAO;
	}



	public void setUserRoleDAO(UserRoleDAO userRoleDAO) {
		this.userRoleDAO = userRoleDAO;
	}




	
	
	
	
	
}
