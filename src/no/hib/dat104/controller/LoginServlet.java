package no.hib.dat104.controller;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
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
       
    /**
     * @see HttpServlet#HttpServlet()
     */

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String personType = (String) request.getAttribute("LoggetInnSom");
		
		// PRG fra doPost her
		if(personType != null) {
			if(personType.equals("foreleser")) {
				response.sendRedirect("Kalender");
			}
			else {
				request.getRequestDispatcher("WEB-INF/stem.jsp").forward(request, response);
			}
		}
		
		// Tester om personen allerede er logget inn, sender videre deretter
		else {
			if(SessionUtil.isInnloggetStudent(request)) {
				request.getRequestDispatcher("WEB-INF/stem.jsp").forward(request, response);
			}
			else if(SessionUtil.isInnloggetForeleser(request)){
				request.getRequestDispatcher("WEB-INF/Kalender.jsp").forward(request, response);
			}
			else {
				request.getRequestDispatcher("WEB-INF/Login.jsp").forward(request, response);
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ansattnr = request.getParameter("ansattnr");
		String passord = request.getParameter("passord");
		String studentnr = request.getParameter("studentnr");
		
		// Logger inn som foreleser
		if(!ansattnr.equals(null) && !passord.equals(null)) {
			String feilmelding = "Ansattnummeret eksisterer ikke eller passordet er feil.";

			if (!dbk.finnesForeleser(ansattnr, passord)) {
				request.setAttribute("feilmelding", feilmelding);
				response.sendRedirect("Login");
			} else {
				SessionUtil.loggInnSom(request, ansattnr);
				request.setAttribute("LoggetInnSom", "foreleser");
				doGet(request, response);
			}
		}
		
		// Logger inn som student
		else if(!studentnr.equals(null)) {
			String feilmelding = "Studentnummeret eksisterer ikke.";
			
			if(!dbk.finnesStudent(studentnr)) {
				request.setAttribute("feilmelding", feilmelding);
				
				response.sendRedirect("LoginServlet");
			}
			else {
				SessionUtil.loggInnSom(request, studentnr);
				request.setAttribute("LoggetInnSom", "student");
				doGet(request, response);
			}
		}
		
		// Logget ikke inn som noen ting
		else {
			request.setAttribute("feilmelding", "Ingenting ble skrevet inn.");
			request.getRequestDispatcher("WEB-INF/Login.jsp").forward(request, response);
		}
	}

}

