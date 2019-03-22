package com.revature.service;

import java.util.ArrayList;
import java.util.List;

import com.revature.pojos.User;

public class UserService {

	/**
	 * Dummy user service to explore servlet functionality usually. This service
	 * layer would call classes from our DAO(Data Access Object) layer.
	 * 
	 */
	public UserService() {}
		
		
		private static List<User> users = new ArrayList<User>();
		static int id = 3;

		
		static {	//simply adding static vars for testing and demo purposes
			users.add(new User("patrick", "manager", "he owns us"));
			users.add(new User("aleksandar", "trainee", "getting there"));
		}

	public List<User> getAll() {
		return users;
	}

	public User getByUsername(String name) {
		/*
		 for (User u : users) {
		 	if(name.equalsIgnoreCase(u.getUsername()))
		 		return u;
		 		}
		 */
	//For the lambda lovers:
	return users.stream()
			.filter(u -> u.getUsername().equalsIgnoreCase(name))
			.findFirst()
			.orElse(null);
	}
	
	public User addUser(User u) {
		if(getByUsername(u.getUsername()) == null) { //if the username doesn't exist
			u.setId(id++);  //incrementing the id set above every time a user is added
			users.add(u);
			return u;
		}else {		//otherwise leave it alone
			return null;
		
			
		}
	}
}
