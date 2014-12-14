package pe.almc.sbs.view.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import pe.almc.sbs.view.bean.LoginBean;

public class LoginFilter implements Filter{
	
	private static Logger logger = LoggerFactory.getLogger(LoginFilter.class);

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,	FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse resp = (HttpServletResponse)response;
		
		LoginBean session = (LoginBean)req.getSession().getAttribute("login");
		
		String url = req.getRequestURI();
		/**
		 A: if request is for forum or logout and there is no session, redirect the request to login.xhtml
		 B: if request is for register or login and there's a session, redirect the request to forum.xhtml
		 C: if request is for logout and there's session, remove session and redirect to login.xhtml		  
		 */
		
		logger.info("Filter: URL =" + url);
		
		if(session == null || !session.isLogged()){
			
			if (url.indexOf("uimain.jsf")>=0 || url.indexOf("forum.jsf")>=0 || url.indexOf("logout.jsf")>=0){
				resp.sendRedirect(req.getServletContext().getContextPath()+"/login.jsf");
			}else{
				chain.doFilter(request, response);
			}
		}else{
			if (url.indexOf("register.jsf")>=0 || url.indexOf("login.jsf")>=0){
				resp.sendRedirect(req.getServletContext().getContextPath()+"/uimain.jsf");
			}else if( url.indexOf("logout.jsf")>=0 ){
				req.getSession().removeAttribute("login");
				resp.sendRedirect(req.getServletContext().getContextPath()+"/login.jsf");								
			}else{
				chain.doFilter(request, response);
			}
		}
		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
