package com.hospital.clinica.auxiliares;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class CORS implements Filter{
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException{
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletResponse res = (HttpServletResponse) response;
		HttpServletRequest req = (HttpServletRequest) request;
		
		res.setHeader("Access-Control-Allow-Origin", "*");
		res.setHeader("Access-Control-Allow-Methods","DELETE, GET, OPTIONS, PATCH, POST, PUT");
		res.setHeader("Access-Control-Max-Age", "3600");
		res.setHeader("Access-Control-Allow-Headers", "x-requested, authorization, Content-Type, Authorization, credential, X-XSRF-TOKEN");
		
		if("OPTIONS".equalsIgnoreCase(req.getMethod())) {
			
			res.setStatus(HttpServletResponse.SC_OK);
			
		}else{
			
			chain.doFilter(req, res);
			
		}
		
	}
	
}
