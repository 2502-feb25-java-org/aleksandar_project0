/**
 * 
 */
package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.revature.pojos.User;
import com.revature.service.UserService;

/**
 * @author Aleksandar Antonov Make accessible at endpoint http; There are
 *         various http methods that we can override in a servlet
 */
public class MyHttpServlet extends HttpServlet {

	private static final long serialVersionUID = -1086287541080366L;
	private static Logger log = Logger.getLogger(MyHttpServlet.class);
	static UserService service = new UserService();

	/*
	 * @Override // Remember this method signature and exception and protected
	 * protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws
	 * ServletException, IOException {
	 * 
	 * log.info("in HTTP Servlet --GET"); PrintWriter writer = resp.getWriter();
	 * writer.write("GET METHOD RESPONSE");
	 * 
	 * }
	 */
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String username = req.getParameter("username"); // Using these metods for forms with servlets
		String password = req.getParameter("password");

		User user = service.getByUsername(username);
		PrintWriter writer = resp.getWriter();
		resp.setContentType("text/html"); //for writing response to html

		String output = "";

		if (user == null) { // no user exists
			output = "<b>Incorrect user credentials. Please go back!</b>"; // generating DOM element
		} else {
			// user exists; check password
			if (password.equals(user.getPassword())) {
				// user has logged in successfully. Add user to service
				output = "<h1>Welcome, " + user.getUsername() + "!</h1><br>" + user.getBio();
			} else {
				output = "<b>Incorrect user credentials. Please go back!</b>";
				// unsuccessful log in with wrong password
			}
		}
		writer.write(output);
	}

}
