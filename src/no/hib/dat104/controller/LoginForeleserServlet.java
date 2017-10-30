package no.hib.dat104.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginForeleser
 */
@WebServlet("/LoginForeleser")
public class LoginForeleserServlet extends HttpServlet {
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
		request.getRequestDispatcher("WEB-INF/homeForeleser.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ansattnr = request.getParameter("ansattnr");
		String passord = request.getParameter("passord");
		String feilmelding = "Ansattnummeret eksisterer ikke eller passordet er feil.";
		
		if(!DBKom.finnesForeleserMedPassord(ansattnr, passord)) {
			request.setAttribute("feilmelding", feilmelding);
			
			response.sendRedirect("LoginServlet");
		}
		else {
			SessionUtil.loggInnSom(request, ansattnr));
			doGet(request, response);
		}
	}
	}

}
