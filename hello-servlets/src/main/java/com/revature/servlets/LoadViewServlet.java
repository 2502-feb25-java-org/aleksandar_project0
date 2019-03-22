package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

//every ending in .view will be handled by this servlet
@WebServlet("*.view") // declares servlet /loadView mapping to the below
public class LoadViewServlet extends HttpServlet {

	private static Logger log = Logger.getLogger(LoadViewServlet.class);

	/*
	 * forward Http pages as a response
	 * 
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		log.trace("In Servlet");
		//req.getRequestDispatcher("partials/landing.html").forward(req, resp);
		 // webapp is our source folder
			// partial forwarded to landing.html
		log.info("SENT TO URI: " + req.getRequestURI());// URI gives us the relevant bit
		// log.info("SENT TO URL: " + req.getRequestURL());
		//req.getRequestDispatcher(getResource(req.getRequestURI())).forward(req, resp);
		String uri = req.getRequestURI();
		String name = req.getRequestURI().substring(16,uri.length()-5);
		log.info("TESTING URI "+ name);
		//String resource = getResource(req.getRequestURI());
		//req.getRequestDispatcher(resource).forward(req, resp);
		
		
		/**
		 * Instead of the method below, we can simply parse our URI to get vital info.
		 * Streamline process of returning partial views, where we send requests to X.view,
		 * where X is the name of our .html
		 */
		req.getRequestDispatcher("partials/"+name+".html").forward(req, resp);
	}

/*
 * Helper method for displaying resource
 * 
 * private String getResource(String uri) { String resource = "partials/";
 * switch (uri) { case "/hello-servlets/landing.view": resource +=
 * "landing.html"; break;
 * 
 * case "/hello-servlets/home.view": resource += "homepage.html"; break;
 * 
 * } return resource; } }
 */

}