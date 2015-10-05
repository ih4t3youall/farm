package ar.com.granja.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SuccessController {

	
	@RequestMapping("eliminarGranjaExito.htm")
	public ModelAndView eliminarGranjaExito(){
		
		ModelAndView mav = new ModelAndView("exito/eliminarGranjaExito");
		
		return mav;
		
		
	}
}
