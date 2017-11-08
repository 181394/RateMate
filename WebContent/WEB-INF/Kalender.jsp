<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
.wrapper {
	margin-top: 3%;
	z-index: -1;
	background-color: #7FC1C2;
	width: 80%;
	border-radius: 5px;
	margin-left: 10%;
	padding: 5% 5% 0 5%;
	float: left;
	box-shadow: 0 4px 10px grey;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.2.13/semantic.css"
	rel="stylesheet" type="text/css">
<title>Kalender</title>
</head>
<body>
	<div class="wrapper">
		<div align="center" style="width: 100%;">
			<form action="Fhjem" method="post">
				<button class="ui left attached button" type="submit" name="url"
					value="Live">Live</button>
				<button class="right attached ui button" type="submit" name="url"
					value="Kalender">Kalender</button>
			</form>
		</div>
		<h2>Kalender</h2>


		<form class="ui form" action="KalenderServlet" method="get">
			<table class="ui selectable celled table" border="1">
				<tr>
					<th>Dato</th>
					<th>Fra kl.</th>
					<th>Til kl.</th>
					<th>Fag</th>
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
					</tr>
				</c:forEach>
			</table>
		</form>
		<br> <br> <br>
		<form action="LoggUt" method="get">
			<input type="submit" value="Logg Ut" />
		</form>
	</div>
</body>
</html>