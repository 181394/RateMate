package no.hib.dat104.controller;

import java.io.IOException;
import java.util.Date;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import no.hib.dat104.model.DBKom;
import no.hib.dat104.model.Forelesning;
import no.hib.dat104.utils.SessionUtil;

/**
 * @author      Jørgen Schreiner <h129411@stud.hvl.no>
 * @version     1.0
 * @since       1.0
 */

public class LiveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	DBKom dbk;
	
	/**
	 * Handles the view of live lecture voting results
	 * <p>
	 * Checks if a user is logged in and is a professor,
	 * if not redirects to login page.
	 * <p>
	 * If logged in, fetches lecture object from DB.
	 * Saves lecture object in session and redirects
	 * to view "stem.jsp".
	 */
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if (SessionUtil.isInnloggetForeleser(request)) {
			request.getRequestDispatcher("WEB-INF/Login.jsp").forward(request, response);
		} else {
			
			Forelesning f = dbk.getForelesning();
			
			request.getSession().setAttribute("forelesning", f);
			request.getRequestDispatcher("WEB-INF/live.jsp").forward(request, response);
		}
	}
	

}
