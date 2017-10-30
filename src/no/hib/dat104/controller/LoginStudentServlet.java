package no.hib.dat104.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginStudentServlet
 */
@WebServlet("/LoginStudentServlet")
public class LoginStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginStudentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/stem.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String studentnr = request.getParameter("studentnr");
		String feilmelding = "Studentnummeret eksisterer ikke.";
		
		if(!DBKom.finnesStudent(studentnr)) {
			request.setAttribute("feilmelding", feilmelding);
			
			response.sendRedirect("LoginServlet");
		}
		else {
			SessionUtil.loggInnSom(request, studentnr);
			doGet(request, response);
		}
	}
