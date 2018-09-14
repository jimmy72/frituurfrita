<%@page contentType="text/html" pageEncoding="UTF-8" session="false"
	trimDirectiveWhitespaces="true"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix='spring' uri='http://www.springframework.org/tags'%>
<!DOCTYPE html>
<html lang="nl">
<head>
<c:import url="/WEB-INF/JSP/head.jsp">
	<c:param name='title' value="Snacks (alfabet)" />
</c:import>
</head>
<body>
<c:import url="/WEB-INF/JSP/menu.jsp"></c:import>
	<h1>Snacks</h1>
	<ul id='alfabet'>
		<c:forEach var='letter' items='${alfabet}'>
			<c:url value='/snacks/alfabet' var='url'>
				<c:param name='beginletter' value='${letter}' />
			</c:url>
			<li><a href='${url}'>${letter}</a>&nbsp;&nbsp;</li>
		</c:forEach>
	</ul>
	<c:if test='${not empty snacks}'>
		<ul>
			<c:forEach var='snack' items='${snacks}'>
				<spring:url var="url" value="/snacks/{id}/wijzigen">
					<spring:param name="id" value="${snack.id}"></spring:param>
				</spring:url>
				<li><a href="${url}"> <c:out value="${snack.naam}"></c:out>&nbsp;${snack.prijs}</a></li>
			</c:forEach>
		</ul>
	</c:if>
</body>
</html>