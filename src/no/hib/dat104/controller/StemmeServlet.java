package no.hib.dat104.controller;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import no.hib.dat104.model.DBKom;
import no.hib.dat104.model.Fag;
import no.hib.dat104.model.Forelesning;
import no.hib.dat104.model.Student;
import no.hib.dat104.utils.SessionUtil;

/**
 * Servlet implementation class StemmeServlet
 */
public class StemmeServlet extends HttpServlet {
	@EJB
	DBKom dbk;
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Integer ny = Integer.parseInt(request.getParameter("stemme"));
		Student stud = dbk.finnStudent(SessionUtil.isInnloggetSom(request));
		Integer gammel = stud.getRating();
		dbk.UpdateLive(gammel, ny);
		dbk.UpdateStudent(stud, ny);
		SessionUtil.setStemme(request, ny);

		response.sendRedirect("Stem");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if (!SessionUtil.isInnlogget(request)) {
			response.sendRedirect("Login");
		}
		Forelesning f1 = dbk.getForelesning();
		if (f1 != null)
			session.setAttribute("Forelesning", f1.getFag().getEmnekode() + ": " + f1.getFag().getNavn());
		else
			session.setAttribute("Forelesning", "Ingen aktive forelesninger");
		request.getRequestDispatcher("WEB-INF/stem.jsp").forward(request, response);;
	}
}
