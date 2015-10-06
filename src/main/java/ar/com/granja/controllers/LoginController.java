package ar.com.granja.controllers;

import java.sql.SQLException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ar.com.granja.bo.UsuarioBO;
import ar.com.granja.dto.UsuarioDTO;

@Controller
public class LoginController {

	private UsuarioBO usuarioBO;
	
	
	@RequestMapping("/login.htm")
	public ModelAndView login() {
		ModelAndView mav = new ModelAndView("login/login");
		return mav;

	}

	@RequestMapping(value="/loginfailed.htm", method = RequestMethod.GET)
	public ModelAndView loginfailed(ModelMap model) {
		ModelAndView mav = new ModelAndView("login/login");
		mav.addObject("error","Usuario o contraseña incorrectos.");
		

		return mav;

	}

	@RequestMapping("/registrarse.htm")
	public ModelAndView registrarse() {

		ModelAndView mav = new ModelAndView("login/registrarse");
		UsuarioDTO usuarioDTO = new UsuarioDTO();
		mav.addObject("usuarioDTO", usuarioDTO);
		return mav;

	}

	@RequestMapping("agregarUsuario.htm")
	public ModelAndView agregarUsuario(UsuarioDTO usuarioDTO) {
		ModelAndView mav = new ModelAndView("exito/crearUsuarioExito");
		try {
			usuarioBO.guardarUsuario(usuarioDTO);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		mav.addObject("nombreUsuario", usuarioDTO.getNombreUsuario());
		return mav;

	}
	
	@RequestMapping(value="/logout.htm", method = RequestMethod.GET)
	public ModelAndView logout(ModelMap model) {
 
		ModelAndView mav = new ModelAndView("/login/logout");
		
		return mav;
 
	}

	public UsuarioBO getUsuarioBO() {
		return usuarioBO;
	}

	public void setUsuarioBO(UsuarioBO usuarioBO) {
		this.usuarioBO = usuarioBO;
	}
	
	

}
