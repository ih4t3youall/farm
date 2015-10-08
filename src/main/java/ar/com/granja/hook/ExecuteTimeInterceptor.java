package ar.com.granja.hook;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import ar.com.granja.bo.UsuarioBO;
import ar.com.granja.dto.UsuarioDTO;

public class ExecuteTimeInterceptor implements HandlerInterceptor{
	
	private UsuarioDTO usuarioDTO;
	private UsuarioBO usuarioBO;
	 @Override
	    public boolean preHandle(HttpServletRequest request,
	            HttpServletResponse response, Object handler) throws Exception {
	         request.getRequestURI();
	         
	        return true;
	    }
	     
	    @Override
	    public void postHandle(HttpServletRequest request,
	            HttpServletResponse response, Object handler,
	            ModelAndView modelAndView) throws Exception {
	    }
	     
	    @Override
	    public void afterCompletion(HttpServletRequest request,
	            HttpServletResponse response, Object handler, Exception ex)
	            throws Exception {
	    }

		public UsuarioDTO getUsuarioDTO() {
			return usuarioDTO;
		}

		public void setUsuarioDTO(UsuarioDTO usuarioDTO) {
			this.usuarioDTO = usuarioDTO;
		}

		public UsuarioBO getUsuarioBO() {
			return usuarioBO;
		}

		public void setUsuarioBO(UsuarioBO usuarioBO) {
			this.usuarioBO = usuarioBO;
		}
		
	    
	    
	    
}