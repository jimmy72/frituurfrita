<%@page contentType="text/html" pageEncoding="UTF-8" session="false"
	trimDirectiveWhitespaces="true"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix='spring' uri='http://www.springframework.org/tags'%>
<!DOCTYPE html>
<html lang="nl">
<head>
<c:import url="/WEB-INF/JSP/head.jsp">
	<c:param name='title' value="Snacks" />
</c:import>
</head>
<body>
	<h1>Snacks</h1>
	<ul id='alfabet'>
		<c:forEach var='letter' items='${alfabet}'>
			<c:url value='/snacks' var='url'>
				<c:param name='beginletter' value='${letter}' />
			</c:url>
			<li><a href='${url}'>${letter}</a>&nbsp;&nbsp;</li>
		</c:forEach>
	</ul>
	<c:if test='${not empty snacks}'>
		<ul>
			<c:forEach var='snack' items='${snacks}'>
				<li>${snack.naam}</li>
			</c:forEach>
		</ul>
	</c:if>

</body>
</html>