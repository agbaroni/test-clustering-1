package com.redhat.tests.clustering;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebFilter({ "/", "/index.jsf" })
public class IndexFilter implements Filter {

	private static final Logger logger = LoggerFactory.getLogger(IndexFilter.class);

	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
			throws IOException, ServletException {
		Object objName = ((HttpServletRequest) request).getSession().getAttribute("name");

		if (objName != null) {
			logger.info("Name: " + objName.toString());
		} else {
			logger.warn("Name is not set");
		}

		filterChain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}
}