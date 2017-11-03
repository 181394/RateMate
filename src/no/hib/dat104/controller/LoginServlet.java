package no.hib.dat104.controller;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import no.hib.dat104.model.DBKom;
import no.hib.dat104.utils.SessionUtil;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	
	@EJB
	DBKom dbk;
	
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		String personType = SessionUtil.getRolle(request);
		/**
		 * Tester om personen er logget inn og isåfall som hva.
		 */
		if(personType != null) {
			if(personType.equals("foreleser"))
				response.sendRedirect("Live");
			else 
				response.sendRedirect("Stem");
		}else 
				request.getRequestDispatcher("WEB-INF/Login.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String feilmelding;
		String ansattnr = request.getParameter("ansattnr");
		String passord = request.getParameter("passord");
		String studentnr = request.getParameter("studentnr");
		
		// Logger inn som foreleser
		if(ansattnr != null && passord != null) {
			feilmelding = "Ansattnummeret eksisterer ikke eller passordet er feil.";

			if (!dbk.finnesForeleser(ansattnr, passord)) {
				SessionUtil.setLoginFeil(request, feilmelding);
			} else {
				SessionUtil.loggInnSom(request, ansattnr);
				SessionUtil.setRolle(request, "foreleser");
			}
		}
		
		// Logger inn som student
		else if (studentnr != null) {
			feilmelding = "Studentnummeret eksisterer ikke.";
			
			if(!dbk.finnesStudent(studentnr))
				SessionUtil.setLoginFeil(request, feilmelding);
			 else {
				SessionUtil.loggInnSom(request, studentnr);
				SessionUtil.setRolle(request, "student");
			}
		}
		response.sendRedirect("Login");
	}

}

