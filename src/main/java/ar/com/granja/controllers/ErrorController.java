package ar.com.granja.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ErrorController {

	
	@RequestMapping("eliminarGranjaError.htm")
	public ModelAndView eliminarGranjaError(){
		
		ModelAndView mav = new ModelAndView("errores/eliminarGranjaError");
		return mav;
		
	}
	
}
