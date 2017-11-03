package no.hib.dat104.controller;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import no.hib.dat104.model.DBKom;
import no.hib.dat104.model.Forelesning;
import no.hib.dat104.utils.SessionUtil;

public class KalenderServlet extends HttpServlet {
	@EJB
	DBKom dbk;
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		if (!SessionUtil.isInnlogget(request)) { // Hvis foreleser ikke er innlogget --> innloggingsside
			response.sendRedirect("Login");
		} else {
			// Henter ut liste med forelesningene fra DB
			List<Forelesning> forelesninger = dbk.fliste();
			SessionUtil.setForelesninger(request, forelesninger);	
			// Foreleser er innlogget -->	kalenderside
			request.getRequestDispatcher("WEB-INF/Kalender.jsp").forward(request, response); 
		}
	}
}
