package com.redhat.tests.clustering;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebServlet("/change")
public class ChangeServlet extends HttpServlet {

	private static final long serialVersionUID = 686827199464353367L;
	private static final Logger logger = LoggerFactory.getLogger(ChangeServlet.class);

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");

		logger.info("Name: " + name);

		request.getSession().setAttribute("name", name);

		response.sendRedirect("index.jsf");
	}
}