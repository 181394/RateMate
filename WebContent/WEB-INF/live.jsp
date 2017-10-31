<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>RateMate Live</title>
<!-- Send ny get forespørsel til LiveServlet. Den oppdaterer forelesningsobjektett i session -->
<meta http-equiv="refresh" content="1; url=Live" />
</head>
<body>
	<p>Bra: <c:out value="${sessionScope.forelesning.bra}" /></p>
	<p>Middels: <c:out value="${sessionScope.forelesning.middels}" /></p>
	<p>Dårlig: <c:out value="${sessionScope.forelesning.daarlig}" /></p>
	<a href="LoggUt">Logg ut</a>
</body>
</html>