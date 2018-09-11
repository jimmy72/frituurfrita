<%@page contentType="text/html" pageEncoding="UTF-8" session="false" trimDirectiveWhitespaces="true" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="nl">
<head>
<c:import url="/WEB-INF/JSP/head.jsp">
	<c:param name='title' value="Sauzen"/>
</c:import>
</head>
<body>
	<c:import url="/WEB-INF/JSP/menu.jsp"></c:import>
	<h1>Sauzen</h1>
	<c:forEach var="saus" items="${sauzen}" varStatus="status">
		<h2>${saus.naam}</h2>
		<img alt="${saus.naam}" src="<c:url value='/images/${saus.naam}.png'></c:url>">
		<c:forEach var="ingredient" items="${saus.ingredienten}" varStatus="status">
			${ingredient}<c:if test="${not status.last}">, </c:if> 
		</c:forEach>
	</c:forEach>
	
</body>
</html>