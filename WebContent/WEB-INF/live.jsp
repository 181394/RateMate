<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.2.13/semantic.css" rel="stylesheet" type="text/css">
<title>RateMate Live</title>
<!-- Send ny get forespørsel til LiveServlet. Den oppdaterer forelesningsobjektett i session -->
<meta http-equiv="refresh" content="1; url=Live" />
</head>
<body>
<div style="width: 30%; alignment: center">
<form action="Fhjem" method="post">
	<button class="ui left attached button" type="submit" name="url" value="Live">Live</button>
	<button class="right attached ui button" type="submit" name="url" value="Kalender">Kalender</button>
</form>
</div>
	<h3><c:out value="${sessionScope.forelesning.fag.emnekode}"/></h3>
	<p>Bra: <c:out value="${sessionScope.forelesning.bra}" /></p>
	<p>Middels: <c:out value="${sessionScope.forelesning.middels}" /></p>
	<p>Dårlig: <c:out value="${sessionScope.forelesning.daarlig}" /></p>

<form action="LoggUt" method="get">
<input type="submit" value="Logg Ut"/>
</form>
	
</body>
</html>