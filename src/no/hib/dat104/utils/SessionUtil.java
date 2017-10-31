package no.hib.dat104.utils;

import java.util.List;

import javax.ejb.EJB;
import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import no.hib.dat104.model.DBKom;
import no.hib.dat104.model.Forelesning;

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
    public static boolean isInnloggetStudent(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        return (session != null)
                && (session.getAttribute("innloggetSomStudent") != null);
    }
    public static boolean isInnloggetForeleser(HttpServletRequest request) {
    	HttpSession session = request.getSession(false);
    	return (session != null)
    			&& (session.getAttribute("innloggetSomForeleser") != null);
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
    
    public static void setStemme(HttpServletRequest request, Integer ny) {
    	HttpSession session = request.getSession(false);
    	session.setAttribute("stemme", ny);
    }
    public static void setForelesninger(HttpServletRequest request, List<Forelesning> forelesninger) {
    	HttpSession session = request.getSession(false);
    	session.setAttribute("forelesninger", forelesninger);
    }

}
