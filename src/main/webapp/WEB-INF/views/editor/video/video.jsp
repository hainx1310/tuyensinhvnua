<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="add" value="${pageContext.request.contextPath}/video/add" />
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<div id="wrapper-content">
	<div id="container-content">
		<section class="content-header">
			<h1>
				Quản lý video <small>Tuyển sinh HVN</small>
			</h1>
			<ol class="breadcrumb">
				<li><a href="${pageContext.request.contextPath}/home"><i
						class="fa fa-home"></i> Trang chủ</a></li>
				<li class="active">Quản lý video</li>
			</ol>
			<br>
		</section>
		<div class="box box-primary">
			<div class="box-header with-border" style="text-align: center">
				<h3>Thêm mới video</h3>
			</div>
			<!-- /.box-header -->
			<!-- form start -->
			<form role="form" action="${add}" method="post">
				<div class="box-body">
					<div class="form-group">
						<label for="exampleInputEmail1">Tiêu đề</label> <input type="text"
							class="form-control" id="exampleInputEmail1" name="title">
					</div>
					<div class="form-group">
						<label for="exampleInputPassword1">Id video youtube</label> <input
							type="text" class="form-control" id="exampleInputPassword1"
							name="videoYoutubeId">
					</div>
					<sec:authorize access="hasAnyRole('ROLE_EDITOR', 'ROLE_ADMIN')">
						<div class="form-group">
							<label for="exampleInputPassword1">Thời gian đăng</label>
							<div class="input-group date">
								<div class="input-group-addon">
									<i class="fa fa-calendar"></i>
								</div>
								<input type="text" class="form-control pull-right"
									id="datepicker" name="publishedDate">
							</div>
						</div>
					</sec:authorize>
				</div>
				<!-- /.box-body -->

				<div class="box-footer">
					<button type="submit" class="btn btn-primary">Lưu</button>
				</div>
			</form>
		</div>
	</div>
</div>