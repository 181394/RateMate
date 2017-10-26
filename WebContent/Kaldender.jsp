<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Kaldender</title>
</head>
<body>
	<h2>Kaldender</h2>
	<form action="KaldenderServlet" method="get">
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
				<td align="center">${f.Dato}</td>
				<td align="center">${f.KlSstart}</td>
				<td align="center">${f.KlSlutt}</td>
				<td align="center">${f.Fag}</td>
				<td align="center">${f.Bra}</td>
				<td align="center">${f.Middels}</td>
				<td align="center">${f.Daarlig}</td>
			</c:forEach>
		</table>
	</form>
</body>
</html>