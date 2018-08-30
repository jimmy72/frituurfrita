<%@ page language="java" contentType="text/html" pageEncoding="UTF-8" session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="nl">
<head>
<c:import url="/WEB-INF/JSP/head.jsp">
	<c:param name='title' value="Voorkeurtaal"/>
</c:import>
</head>
<body>
	<h1>Voorkeurtaal</h1>
	<p>Uw voorkeurtaal is ${voorkeurTaal ? "Nederlands" : "geen Nederlands"}</p>
</body>
</html>