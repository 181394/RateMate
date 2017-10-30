<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- <meta http-equiv="refresh" content="1">-->
<title>Stem</title>
</head>
<body>
	<h1>Stem på forelesning</h1>

<!-- Må legge til funksjon for sessionAtt "stemme" skal være checked -->
	<form action="Stem" method="post">
		<input type="radio" name="stemme" value="0" checked="checked"/>Bra
		<input type="radio" name="stemme" value="1"/>Middels
		<input type="radio" name="stemme" value="2"/>Dårlig<br>
		<input type="submit" value="Stem"/>
	</form>
</body>
</html>