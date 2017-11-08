<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
.wrapper {
	margin-top: 3%;
	z-index: -1;
	background-color: #7FC1C2;
	height: 600px;
	width: 60%;
	border-radius: 5px;
	margin-left: 20%;
	padding:10% 0 0 5%;
	float: left;
	box-shadow: 0 4px 10px grey;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.2.13/semantic.css" rel="stylesheet" type="text/css">
<title>RateMate Live</title>
<!-- Send ny get forespørsel til LiveServlet. Den oppdaterer forelesningsobjektett i session -->
<!-- <meta http-equiv="refresh" content="1; url=Live" /> -->
</head>
<body>
<div class="wrapper">
<div align="center" style="width: 100%;">
<form action="Fhjem" method="post">
	<button class="ui left attached button" type="submit" name="url" value="Live">Live</button>
	<button class="right attached ui button" type="submit" name="url" value="Kalender">Kalender</button>
</form>
</div>
	<h3>Ingen aktive fag</h3>
	<div align="center" class="ui three column grid">
	<div class="row">
	<div class="column"><img src="http://www.hey.fr/fun/emoji/android/en/android/634-emoji_android_smiling_face_with_open_mouth_and_smiling_eyes.png" alt="Bra:" height="42" width="42"></div>
	<div class="column"><img src="http://www.emoji.co.uk/files/google-emojis/smileys-people-android/7224-neutral-face.png" alt="Middels:" height="42" width="42"></div>
	<div class="column"><img src="http://www.hey.fr/fun/emoji/android/en/android/659-emoji_android_weary_face.png" alt="Dårlig:" height="42" width="42"></div>
	</div>
	<div class="column"><p>0</p></div>
	<div class="column"><p>0</p></div>
	<div class="column"><p>0</p></div>
	</div>
	<br>
	<br>
	<br>

<form action="LoggUt" method="get">
<input type="submit" value="Logg Ut">
</form>
	
</div>
</body>
</html>