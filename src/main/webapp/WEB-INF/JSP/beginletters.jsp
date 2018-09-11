<%@page contentType="text/html" pageEncoding="UTF-8" session="false" trimDirectiveWhitespaces="true"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="nl">
<head>
<c:import url="/WEB-INF/JSP/head.jsp">
	<c:param name='title' value="Snacks (beginletters)"/>
</c:import>
</head>
<body>
	<c:import url="/WEB-INF/JSP/menu.jsp"></c:import>
	<h1>Snacks (beginletters)</h1>
	<c:url value='/snacks/beginletters' var='url' />
	<form:form action='${url}' modelAttribute='beginLettersForm'
		method='get'>
		<form:label path='beginletters'>Beginletters:<form:errors path='beginletters'></form:errors></form:label>
		<form:input path='beginletters' autofocus='autofocus' />
		<input type='submit' value='Zoeken'>
		<span><form:errors cssClass='fout'/></span>
	</form:form>
	<c:if test="${not empty snacks}">
		<ul>
			<c:forEach var="snack" items="${snacks}">
				<spring:url var="url" value="/snacks/{id}">
					<spring:param name="id" value="${snack.id}"></spring:param>
				</spring:url>
				<li><a href="${url}"><c:out value="${snack.naam}"></c:out>&nbsp;${snack.prijs}</a></li>
			</c:forEach>
		</ul>
	
	</c:if>
</body>
</html>