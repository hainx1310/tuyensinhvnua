<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!------ Include the above in your HEAD tag ---------->

<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!------ Include the above in your HEAD tag ---------->

<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>

<div id="wrapper-content">
	<div id="container-content">
		<div class="container bootstrap snippet">
			<div class="row">
				<div class="col-sm-10">
					<h1>
						<sec:authentication property="principal.username" />
					</h1>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-3">
					<!--left col-->


					<div class="text-center">
						<c:choose>
							<c:when test="${not empty user.getAvatarUrl()}">
								<img src="${user.getAvatarUrl()}"
									class="avatar img-circle img-thumbnail" alt="avatar">
							</c:when>
							<c:when test="${ empty user.getAvatarUrl()}">
								<img
									src="<%=request.getContextPath()%>/resources/images/avatar_user.png"
									class="avatar img-circle img-thumbnail" alt="avatar">
							</c:when>
						</c:choose>
						<h6>Thay ảnh đại diện...</h6>
						<input type="file" class="text-center center-block file-upload">
					</div>
					</hr>
					<br>

					<ul class="list-group">
						<li class="list-group-item text-muted">Thống kê hoạt động</li>
						<li class="list-group-item text-right"><span
							class="pull-left"><strong>Số bài viết</strong></span>
							${totalPostByAuthor}</li>
						<li class="list-group-item text-right"><span
							class="pull-left"><strong>Số video</strong></span>
							${totalVideoByAuthor}</li>
					</ul>
				</div>
				<!--/col-3-->
				<div class="col-sm-9">

					<div class="tab-pane active" id="home">
						<hr>
						<form class="form" action="##" method="post" id="registrationForm">
							<div class="form-group">

								<div class="col-xs-5">
									<label for="first_name"><h4>Họ và tên</h4></label> <input
										type="text" class="form-control" name="name" id="name"
										value="${user.getName()}"
										title="enter your first name if any.">
								</div>
							</div>

							<div class="form-group">

								<div class="col-xs-5">
									<label for="email"><h4>Email</h4></label> <input type="email"
										class="form-control" name="email" id="email"
										value="${user.getEmail()}" placeholder="you@email.com"
										title="Nhập email.">
								</div>
							</div>
							<div class="form-group">

								<div class="col-xs-5">
									<label for="password"><h4>Mật khẩu</h4></label> <input
										type="password" class="form-control" name="password"
										id="password" title="enter your password.">
								</div>
							</div>
							<div class="form-group">

								<div class="col-xs-5">
									<label for="password2"><h4>Nhập lại mật khẩu</h4></label> <input
										type="password" class="form-control" name="password2"
										id="password2" title="enter your password2.">
								</div>
							</div>
							<div class="form-group">
								<div class="col-xs-12">
									<br>
									<button class="btn btn-lg btn-success" type="submit">
										<i class="glyphicon glyphicon-ok-sign"></i> Cập nhật
									</button>
									<button class="btn btn-lg" type="reset">
										<i class="glyphicon glyphicon-repeat"></i> Reset
									</button>
								</div>
							</div>
						</form>

						<hr>

					</div>
				</div>
				<!--/col-9-->
			</div>
		</div>
	</div>
</div>
<!--/row-->
<script>
	$(document).ready(function() {

		var readURL = function(input) {
			if (input.files && input.files[0]) {
				var reader = new FileReader();

				reader.onload = function(e) {
					$('.avatar').attr('src', e.target.result);
				}

				reader.readAsDataURL(input.files[0]);
			}
		}

		$(".file-upload").on('change', function() {
			readURL(this);
		});
	});
</script>