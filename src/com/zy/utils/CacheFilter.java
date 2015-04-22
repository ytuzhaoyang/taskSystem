package com.zy.utils;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CacheFilter implements Filter {

	private FilterConfig filterConfig;

	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {

		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		
		String path = request.getRequestURI();
		String uri = path.substring(path.lastIndexOf(".")+1);
		  
		String time = filterConfig.getInitParameter(uri);
		if(time!=null){
			response.setDateHeader("expires", System.currentTimeMillis()+Integer.parseInt(time)*3600*1000);
		}
		
		chain.doFilter(req, resp);
	}

	public void init(FilterConfig arg0) throws ServletException {
           this.filterConfig = filterConfig;
	}
	
	public void destroy() {

	}

}
