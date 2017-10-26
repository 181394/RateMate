package no.hib.dat104.controller;

import java.io.IOException;
import java.util.List;
import no.hib.dat104.model.*;
import no.hib.dat104.utils.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/KaldenderServlet")
public class KaldenderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	DBKom dbKom = new DBKom();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		if (!SessionUtil.isInnlogget(request)) { // Hvis foreleser ikke er innlogget --> innloggingsside
			request.getRequestDispatcher("WebContent/foreleserlogin.jsp").forward(request, response);
		} else {
			// Henter ut liste med forelesningene fra DB
			List<Forelesning> forelesninger = dbKom.fliste();
			int str = forelesninger.size();
			request.getSession().setAttribute("str", str);
			request.getSession().setAttribute("forelesninger", forelesninger);
			// Foreleser er innlogget -->	kalenderside
			request.getRequestDispatcher("WebContent/kalender.jsp").forward(request, response); 
		}
	}
}
