package no.hib.dat104.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import no.hib.dat104.utils.SessionUtil;

/**
 * @author      Jørgen Schreiner <h129411@stud.hvl.no>
 * @version     1.0
 * @since       1.0
 */

public class LoggUtServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Log out a user by invalidating session
	 * 
	 * Redirects to "Login"
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SessionUtil.loggUt(request);
		response.sendRedirect("Login");
	}
}
