<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head id="Head1">
<title>.: Login - Tuyển sinh Administration :.</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<link rel="stylesheet" type="text/css" href="resources/css/login.css" />
<script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
</head>
<body id="loginpage" style="">
	<div class="wrapper">
		<form method="post" action="${pageContext.request.contextPath}/login"
			class="form-signin">
			<h2 class="form-signin-heading">Đăng nhập</h2>
			<input type="text" class="form-control" name="username"
				placeholder="Email Address" required="" autofocus=""></input> <input
				type="password" class="form-control" name="password"
				placeholder="Password" required="" /> <label class="checkbox">
				<input type="checkbox" value="remember-me" id="rememberMe"
				name="rememberMe"> Nhớ mật khẩu </input>
			</label>
			<button class="btn btn-lg btn-primary btn-block" type="submit">Đăng
				nhập</button>
		</form>
	</div>
</body>
</html>