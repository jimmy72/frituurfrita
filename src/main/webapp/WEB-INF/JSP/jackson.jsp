<%@page language="java" contentType="text/html" pageEncoding="UTF-8" session="false" trimDirectiveWhitespaces="true"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="nl">
<head>
<c:import url="/WEB-INF/JSP/head.jsp">
	<c:param name='title' value="Jackson"/>
</c:import>
</head>
<body>
<c:import url="/WEB-INF/JSP/menu.jsp"></c:import>
<h1>Jackson test</h1>
<c:url value="/jackson" var="url">
	<c:param name="endpoint" value="http://data.fixer.io/api/latest?access_key=3d0a4fecd7d5a53aa66487323c7dc519"></c:param>
</c:url>

<a href="${url}">Get dollarkoers</a>

	<c:choose>
		<c:when test="${empty usd}">
			<p>niet gevonden</p>
		</c:when>
		<c:otherwise>
			<c:choose>
				<c:when test="${! (usd == 'firstvisit')}">
					<p>${usd}</p>
				</c:when>
			</c:choose>
		</c:otherwise>
	</c:choose>
</body>
</html>