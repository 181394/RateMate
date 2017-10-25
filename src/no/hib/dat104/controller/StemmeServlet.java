package no.hib.dat104.controller;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import no.hib.dat104.model.DBKom;
import no.hib.dat104.model.Student;
import no.hib.dat104.utils.SessionUtil;

/**
 * Servlet implementation class StemmeServlet
 */
@WebServlet("/Stem")
public class StemmeServlet extends HttpServlet {
	@EJB
	DBKom dbk;
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer ny = Integer.parseInt(request.getParameter("stemme"));
		Student stud = dbk.finnStudent(SessionUtil.isInnloggetSom(request));
		Integer gammel = stud.getRating();
		stud.setRating(ny);
		dbk.UpdateLive(gammel, ny);
		dbk.UpdateStudent(stud);
		SessionUtil.setStemme(request, ny);
		
		response.sendRedirect("Stem");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if (!SessionUtil.isInnlogget(request)) {
			response.sendRedirect("Login");
		}
		request.getRequestDispatcher("WEB-INF/stem.jsp");
	}
}
