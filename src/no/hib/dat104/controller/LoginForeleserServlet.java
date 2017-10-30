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
 * Servlet implementation class LoginForeleser
 */
public class LoginForeleserServlet extends HttpServlet {
	
	@EJB
	DBKom dbk;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginForeleserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		request.getRequestDispatcher("WEB-INF/FHjem.jsp").forward(request, response);
		response.sendRedirect("Kalender");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ansattnr = request.getParameter("ansattnr");
		String passord = request.getParameter("passord");
		String feilmelding = "Ansattnummeret eksisterer ikke eller passordet er feil.";
		
		if(!dbk.finnesForeleser(ansattnr, passord)) {
			request.setAttribute("feilmelding", feilmelding);
			
			response.sendRedirect("Login");
		}
		else {
			SessionUtil.loggInnSom(request, ansattnr);
			doGet(request, response);
		}
	}
	}
