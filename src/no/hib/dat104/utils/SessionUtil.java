package no.hib.dat104.utils;

import java.util.List;

import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.http.parser.HttpParser;

import no.hib.dat104.model.DBKom;
import no.hib.dat104.model.Forelesning;

public class SessionUtil {

    public static boolean isInnlogget(HttpServletRequest request) {
    	HttpSession session = request.getSession(false);
    	return (session != null)
    			&& (session.getAttribute("innloggetBruker") != null);
    }
    public static boolean isInnloggetStudent(HttpServletRequest request) {
        return (isInnlogget(request)) && (getRolle(request).equals("student"));
    }
    public static boolean isInnloggetForeleser(HttpServletRequest request) {
    	return isInnlogget(request)	&& (getRolle(request).equals("foreleser"));
    }

    public static String isInnloggetSom(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        return isInnlogget(request) ? (String) session.getAttribute("innloggetBruker") : null;
    }

    public static void loggInnSom(HttpServletRequest request, String ID) {
        loggUt(request);
        request.getSession(true).setAttribute("innloggetBruker", ID);
    }

    public static void loggUt(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null)
            session.invalidate();
    }
    
    public static String getRolle(HttpServletRequest request) {
    	return request.getSession(false) != null ? (String) request.getSession(false).getAttribute("rolle") : null;
    }
    
    public static void setRolle(HttpServletRequest request, String rolle) {
    	request.getSession(false).setAttribute("rolle", rolle);
    }
    
    public static void setStemme(HttpServletRequest request, Integer ny) {
    	HttpSession session = request.getSession(false);
    	session.setAttribute("stemme", ny);
    }
    public static void setForelesninger(HttpServletRequest request, List<Forelesning> forelesninger) {
    	HttpSession session = request.getSession(false);
    	session.setAttribute("forelesninger", forelesninger);
    }
    
    public static void setLoginFeil(HttpServletRequest request, String feilmelding) {
    	request.getSession(false).setAttribute("feilLogin", feilmelding);
    }

}
