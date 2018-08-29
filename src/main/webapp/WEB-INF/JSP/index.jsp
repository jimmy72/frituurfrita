<%@page contentType="text/html" pageEncoding="UTF-8" session="false" trimDirectiveWhitespaces="true" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="nl">
<head>
	<meta charset="UTF-8">
	<title>Frituur Frita</title>
	<link rel='icon' href='images/frita.ico'>
	<meta name='viewport' content='width=device-width,initial-scale=1'>
	<link rel='stylesheet' href='css/frituurfrita.css'>
</head>
<body>
	<h1>Frituur Frita</h1>
	<p>Vandaag zijn we ${message}</p>
	<img alt="Frituur Frita" src="images/${message}.png">
	<dl>
		<dt>Adres</dt>
		<dd>${frituur.straat}&nbsp;${frituur.huisNr}<br>
		${frituur.gemeente.postcode}&nbsp;${frituur.gemeente.naam}</dd>
	</dl>
</body>
</html>