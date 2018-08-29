<%@page contentType="text/html" pageEncoding="UTF-8" session="false" trimDirectiveWhitespaces="true" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="nl">
<head>
	<c:import url="/WEB-INF/JSP/head.jsp">
		<c:param name="title" value="Frituur Frita"></c:param>
	</c:import>
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