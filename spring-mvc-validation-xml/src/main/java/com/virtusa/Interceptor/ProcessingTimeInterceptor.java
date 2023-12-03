package com.virtusa.Interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class ProcessingTimeInterceptor  implements HandlerInterceptor{

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		Long startTime=System.currentTimeMillis();
		request.setAttribute("startTime",startTime);
		return true;
	}

	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		Long endTime=System.currentTimeMillis();		
		Long startTime=(Long) request.getAttribute("startTime");
		System.out.println("Processing this request "+request.getRequestURI()+" took "+(endTime-startTime));
	}
	
	
}
