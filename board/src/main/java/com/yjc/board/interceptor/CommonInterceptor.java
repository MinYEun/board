package com.yjc.board.interceptor;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class CommonInterceptor extends HandlerInterceptorAdapter {
	protected final Logger logger = LoggerFactory.getLogger(this.getClass());
	   
	  @Override
	  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
	      throws Exception {
		  
		  try {
			  if(request.getSession().getAttribute("logininfo") == null) {
				  response.sendRedirect("/member/login.do");
				  return false;
			  }
		  } catch(Exception e) {
			  e.printStackTrace();
		  }
		  return true;
	  }
	 
	  @Override
	  public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
	      ModelAndView modelAndView) throws Exception {
	
	   
	  }
}
