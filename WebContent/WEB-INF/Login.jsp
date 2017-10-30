<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>RateMate Login</title>
</head>
<body>
<h1>Velkommen til RateMate!</h1>
<p>Vennligst logg inn som foreleser eller student</p>

<form action="LoginStudentServlet" method="post">
  <fieldset>
  	<h3>Student</h3>
	<p>Studentnummer:</p>
    <p><input type="text" name="studentnr"/></p>
    <p><input type="submit" value="Logg inn"/></p>
  </fieldset>
</form>

<form action="LoginForeleser" method="post">
  <fieldset>
  	<h3>Foreleser</h3>
  	<p>Ansattnummer:</p>
    <p><input type="text" name="ansattnr"/></p>
    <p>Passord:</p>
     <p><input type="password" name="passord"/></p>
     <p><input type="submit" value="Logg inn"/></p>
  </fieldset>
</form>

</body>
</html>