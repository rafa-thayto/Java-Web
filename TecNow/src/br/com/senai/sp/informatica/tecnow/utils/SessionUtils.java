package br.com.senai.sp.informatica.tecnow.utils;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.senai.sp.informatica.tecnow.model.User;

@Component
public class SessionUtils {

	private static final String USER_KEY = "user";
	
	@Autowired
	private HttpSession session;
	
	/**
	 * returns user store in session
	 * @return
	 */
	public User getLoggedUser() {
		return (User) session.getAttribute(USER_KEY);
	}
	
	/**
	 * Guard user logged
	 * @param user
	 */
	public void setLoggedUser(User user) {
		session.setAttribute(USER_KEY, user);
	}
	
	/**
	 * Checks if user is in session
	 * @return
	 */
	public boolean isLoggedUser() {
		return session.getAttribute(USER_KEY) != null;
	}
	
	/**
	 * Deletes the current client session file
	 */
	public void killSession() {
		session.invalidate();
	}
	
}
