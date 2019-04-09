<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Demo</title>
</head>
<body>
	<%
		double num = Math.random();
		if (num > 0.95) {
	%>
	<h2>You'll have a luck day!</h2>
	<p>
		(<%=num%>)
	</p>
	<%
		} else {
	%>
	<h2>Well, life goes on ...</h2>
	<p>
		(<%=num%>)
	</p>
	<%
		}
	%>
	<a href="<%=request.getRequestURI()%>"><h3>Try Again</h3></a>
</body>
</html>