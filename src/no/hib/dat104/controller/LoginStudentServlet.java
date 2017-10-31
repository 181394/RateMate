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
 * Servlet implementation class LoginStudentServlet
 */
@WebServlet("/LoginStudentServlet")
public class LoginStudentServlet extends HttpServlet {
	
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
		response.sendRedirect("Stem");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String studentnr = request.getParameter("studentnr");
		String feilmelding = "Studentnummeret eksisterer ikke.";
		
		if(!dbk.finnesStudent(studentnr)) {
			request.setAttribute("feilmelding", feilmelding);
			
			response.sendRedirect("LoginServlet");
		}
		else {
			SessionUtil.loggInnSom(request, studentnr);
			doGet(request, response);
		}
	}
}