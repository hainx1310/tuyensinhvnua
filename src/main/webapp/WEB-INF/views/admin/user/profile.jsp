<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div id="wrapper-content">
	<div id="container-content">

		<h1 style="text-align: center;">Thông tin cá nhân</h1>
		<div class="container bootstrap snippet">
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
						<div class="form-group">

							<div class="col-xs-5">
								<label for="first_name"><h4>Họ và tên</h4></label> <input
									type="text" class="form-control" name="name" id="name"
									value="${user.getName()}" title="Nhập họ và tên"> <label
									for="email"><h4>Email</h4></label> <input type="email"
									class="form-control" name="email" id="email"
									value="${user.getEmail()}" placeholder="you@email.com"
									title="Nhập email">
								<div class="form-group">
									<div class="col-xs-12" style="padding-left: 0px">
										<br>
										<button class="btn btn-lg btn-success" type="submit">
											<i class="glyphicon glyphicon-ok-sign"></i> Cập nhật
										</button>
									</div>
								</div>
							</div>
						</div>
						</form>

						<form class="form" action="changepw" method="post"
							id="updatePassword">
							<div class="form-group">
								<div class="col-xs-5">
									<label for="password2"><h4>Mật khẩu hiện tại</h4></label> <input
										type="password" class="form-control" name="password"
										id="password2" title="Nhập mật khẩu hiện tại"> <label
										for="password"><h4>Mật khẩu mới</h4></label> <input
										type="password" class="form-control" name="password"
										id="password" title="Nhập mật khẩu mới"> <label
										for="password2"><h4>Nhập lại mật khẩu mới</h4></label> <input
										type="password" class="form-control" name="password2"
										id="password2" title="Nhập lại mật khẩu mới">
									<div class="form-group">
										<div class="col-xs-12" style="padding-left: 0px">
											<br>
											<button class="btn btn-lg btn-success" type="submit">
												<i class="glyphicon glyphicon-ok-sign"></i> Cập nhật
											</button>
										</div>
									</div>
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