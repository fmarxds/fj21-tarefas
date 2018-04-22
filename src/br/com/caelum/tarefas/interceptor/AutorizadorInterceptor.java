package br.com.caelum.tarefas.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AutorizadorInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		
		if(request.getRequestURI().endsWith("loginForm") || request.getRequestURI().endsWith("efetuaLogin") || request.getRequestURI().contains("assets")){
			return true;
		}
		
		if(request.getSession().getAttribute("usuarioLogado") != null) {
			return true;
		}
		
		if(request.getRequestURI().endsWith("/fj21-tarefas")) {
			return false;
		}
		
		response.sendRedirect("loginForm");
		return false;
		
	}
	
}
