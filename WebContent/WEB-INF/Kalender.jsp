<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Kalender</title>
</head>
<body>
	<h2>Kalender</h2>
	<form action="KalenderServlet" method="get">
		<table border="1">
			<tr>
				<th>Dato</th>
				<th>Fra kl.</th>
				<th>Til kl.</th>
				<th>Fag</th>
				<th>Foreleser</th>
				<th>Bra</th>
				<th>Middels</th>
				<th>Dårlig</th>
			</tr>
			<c:forEach var="f" items="${forelesninger}">
				<tr>
					<td align="center">${f.dato}</td>
					<td align="center">${f.kl_start}</td>
					<td align="center">${f.kl_slutt}</td>
					<td align="center">${f.fag.emnekode}</td>
					<td align="center">${f.bra}</td>
					<td align="center">${f.middels}</td>
					<td align="center">${f.daarlig}</td>
					<td align="center"></td>
				</tr>
			</c:forEach>
		</table>
	</form>
</body>
</html>