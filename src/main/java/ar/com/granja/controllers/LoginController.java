package ar.com.granja.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.com.granja.dto.UsuarioDTO;

@Controller
public class LoginController {

	@RequestMapping("/login.htm")
	public ModelAndView login() {
		ModelAndView mav = new ModelAndView("login/login");
		return mav;

	}

	@RequestMapping("/loginfailed.htm")
	public ModelAndView loginfailed() {
		ModelAndView mav = new ModelAndView("login/loginfailed");

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
		ModelAndView mav = new ModelAndView("login/registrarse");
		mav.addObject("usuarioDTO", usuarioDTO);
		return mav;

	}

}
