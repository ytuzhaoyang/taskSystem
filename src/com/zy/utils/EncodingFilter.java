package com.zy.utils;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class EncodingFilter implements Filter {

	private FilterConfig filterConfig;
	private static final String defaultCharset = "UTF-8";
	
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
            
		String charset = filterConfig.getInitParameter("charset");
		if(charset == null){
			charset = defaultCharset;
		}
		
		req.setCharacterEncoding(charset);
		resp.setCharacterEncoding(charset);
		resp.setContentType("text/html;charset="+charset);
		chain.doFilter(req, resp);
	}

	public void init(FilterConfig filterConfig) throws ServletException {
		this.filterConfig = filterConfig;
	}
	
	public void destroy() {
		
	}

}
