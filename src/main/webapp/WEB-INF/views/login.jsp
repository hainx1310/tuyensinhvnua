<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<sec:authorize access="isAuthenticated()">
	<meta http-equiv='refresh' content='0; URL=home'>
</sec:authorize>

<sec:authorize access="!isAuthenticated()">
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<title>Đăng nhập - Tuyển sinh HVN</title>
<link
	href="//netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//netdna.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<!------ Include the above in your HEAD tag ---------->

<link href="<%=request.getContextPath()%>/resources/css/login.css"
	rel="stylesheet">

<!--Pulling Awesome Font -->
<link
	href="//maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css"
	rel="stylesheet">

<div class="container">
	<div class="row">
		<div class="col-md-offset-5 col-md-3">
			<div class="form-login">
				<h4>Tuyển sinh HVN</h4>
				<form method="POST" action="login">
					<input type="text" id="userName" name="username"
						class="form-control input-sm chat-input" placeholder="username" />
					</br> <input name="password" type="password" id="userPassword"
						class="form-control input-sm chat-input" placeholder="password" />
					<input type="hidden" name="${_csrf.parameterName}"
						value="${_csrf.token}" /> <span>Nhớ mật khẩu: </span><input
						type="checkbox" name="remember-me" /><a id="quen-mk"
						href="index">Quên mật khẩu</a> </br>
					<div class="wrapper">
						<c:if test="${not empty error }">
							<span id="errormessage">${message}</span>
						</c:if>
						<button type="submit">Đăng nhập</button>
					</div>
				</form>
			</div>

		</div>
	</div>
</div>
</sec:authorize>