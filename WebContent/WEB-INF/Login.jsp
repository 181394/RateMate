<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.2.13/semantic.css"
	rel="stylesheet" type="text/css">
<style type="text/css">
.forms {
	width: 30%;
	float: left;
	margin-top: 3%;
}

.wrapper {
	margin-top: 3%;
	z-index: -1;
	background-color: #7FC1C2;
	height: 600px;
	width: 60%;
	border-radius: 5px;
	margin-left: 20%;
	float: left;
	box-shadow: 0 4px 10px grey;
}
}
</style>
<title>RateMate Login</title>
</head>
<body>
	<div class="wrapper">
		<h1 align="center" style="margin-top: 15%">Velkommen til
			RateMate!</h1>
		<p align="center">Vennligst logg inn som student eller foreleser</p>
		<p align="center">
			<c:out value="${feilLogin}" />
		</p>
		<div class="forms" style="margin-left: 15%">
			<form class="ui form" action="Login" method="post">
				<div style="margin-left: 40%" align="center" class="ui people shape">
					<h3>Student</h3>
					<p>Studentnummer:</p>
					<p>
						<input type="text" name="studentnr" />
					</p>
					<button class="ui button" type="submit">Logg inn</button>
					<!--     <p><input type="submit" value="Logg inn"/></p> -->
				</div>
			</form>
		</div>
		<div class="forms" style="margin-left: 10%">
			<form class="ui form" action="Login" method="post">
				<div style="margin-left: 40%, 5%, 0, 0" align="left"
					class="ui people shape">
					<h3>Foreleser</h3>
					<p>Ansattnummer:</p>
					<p>
						<input type="text" name="ansattnr" />
					</p>
					<p>Passord:</p>
					<p>
						<input type="password" name="passord" />
					</p>
					<button class="ui button" type="submit">Logg Inn</button>
					<!--      <p><input type="submit" value="Logg inn"/></p> -->
				</div>
			</form>
		</div>
	</div>
</body>
</html>