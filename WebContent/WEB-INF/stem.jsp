<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- <meta http-equiv="refresh" content="1">-->
<title>Stem</title>
</head>
<body>
	<h1>Stem på forelesning</h1>
	<h2><c:out value="${Forelesning}"/></h2>
<!-- Må legge til funksjon for sessionAtt "stemme" skal være checked -->

	<form action="Stem" method="post">
		<c:if test="${stemme == null || stemme == 0}">
			<c:set var="status0" scope="session" value="checked=\"checked\""/>
			<c:set var="status1" scope="session" value=""/>
			<c:set var="status2" scope="session" value=""/>
		</c:if>
		<c:if test="${stemme == 1}">
			<c:set var="status0" scope="session" value=""/>
			<c:set var="status1" scope="session" value="checked=\"checked\""/>
			<c:set var="status2" scope="session" value=""/>
		</c:if>
		<c:if test="${stemme == 2}">
			<c:set var="status0" scope="session" value=""/>
			<c:set var="status1" scope="session" value=""/>
			<c:set var="status2" scope="session" value="checked=\"checked\""/>
		</c:if>
		<input type="radio" name="stemme" value="0" ${status0}/>Bra
		<input type="radio" name="stemme" value="1" ${status1}/>Middels
		<input type="radio" name="stemme" value="2" ${status2}/>Dårlig<br>
		<input type="submit" value="Stem"/>
	</form>
</body>
</html>