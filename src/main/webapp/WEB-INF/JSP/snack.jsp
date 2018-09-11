<%@page contentType="text/html" pageEncoding="UTF-8" session="false" trimDirectiveWhitespaces="true"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="nl">
<head>
<c:import url="/WEB-INF/JSP/head.jsp">
	<c:param name='title' value="Snack (detail)"/>
</c:import>
</head>
<body>
	<c:import url="/WEB-INF/JSP/menu.jsp"></c:import>
	<c:if test="${empty snack}">
		<p>Snack niet gevonden</p>
	</c:if>
	<c:if test="${not empty snack}">
		<h1>${snack.naam}</h1>
		<dl>
			<dt>Nummer</dt>
			<dd>${snack.id}</dd>
			<dt>Naam</dt>
			<dd>${snack.naam}</dd>
			<dt>Prijs</dt>
			<dd>${snack.prijs}</dd>
		</dl>
	</c:if>
</body>
</html>