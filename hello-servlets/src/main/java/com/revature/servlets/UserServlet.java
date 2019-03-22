package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.pojos.User;
import com.revature.service.UserService;

@WebServlet(loadOnStartup = 2, urlPatterns = { "/users" }) // same as including in web.xml
public class UserServlet extends HttpServlet {

	private static final long serialVersionUID = 3646950905094715833L;

	/*
	 * Creating a RESTFUL servlet ... more of this later
	 */
	static UserService service = new UserService();
	private static Logger log = Logger.getLogger(UserServlet.class);

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<User> users = service.getAll(); //All users in a list

		// Turn Java Objects into JSON strings -> enabled by jackson, in pom.xml
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(users);

		PrintWriter writer = resp.getWriter();
		resp.setContentType("application/json"); // when using json
		writer.write(json);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		User user = mapper.readValue(req.getInputStream(), User.class); // '.class' martials for format
		log.trace("ADDING USER: " + user.toString());
		user = service.addUser(user);
		if (user == null) { //user already exists as in addUser method
			resp.setStatus(409); //client did something wrong
		} else {		//user was added
			resp.setStatus(201); //success
		}
	}
}
