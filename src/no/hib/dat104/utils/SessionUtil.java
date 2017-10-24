package no.hib.dat104.utils;

import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import no.hib.dat104.model.DBKom;

public class SessionUtil {
	@EJB
	static
	DBKom dbk;
	
    public static boolean isGyldigStudnr(String studnr) {
        return studnr != null && dbk.finnesStudent(studnr);
    }
    public static boolean isGyldigForeleser(String ansattnr, String passord) {
    	return ansattnr != null && passord != null && dbk.finnesForeleser(ansattnr, passord);
    }

    public static boolean isInnlogget(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        return (session != null)
                && (session.getAttribute("innloggetBruker") != null);
    }

    public static String isInnloggetSom(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        return isInnlogget(request) ? (String) session.getAttribute("innloggetBruker") : null;
    }

    public static void loggInnSom(HttpServletRequest request, String studnr) {
        loggUt(request);
        HttpSession session = request.getSession(true);
        session.setAttribute("innloggetBruker", studnr);
    }

    public static void loggUt(HttpServletRequest request) {

        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
    }

}
