<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@page import="vn.edu.vnua.dse.entity.User"%>

<aside class="main-sidebar">
	<!-- sidebar: style can be found in sidebar.less -->
	<section class="sidebar" style="height: auto;">
		<!-- Sidebar user panel -->
		<div class="user-panel">
			<div class="pull-left image">
				<img
					src="<%=request.getContextPath()%>/<sec:authentication property="principal.avatarUrl" />"
					class="img-circle" alt="User Image">
			</div>
			<div class="pull-left info">
				<p>
					<sec:authentication property="principal.name" />
				</p>
				<a href="#"><sec:authentication property="principal.roleName" /></a>
			</div>
		</div>
		<!-- sidebar menu: : style can be found in sidebar.less -->
		<ul class="sidebar-menu tree" data-widget="tree">
			<li><a href="${pageContext.request.contextPath}/home"> <i
					class="fa fa-home"></i> <span>Trang chủ</span>
			</a> <sec:authorize access="hasRole('ROLE_ADMIN')">
					<li><a
						href="${pageContext.request.contextPath}/admin/categories"><i
							class="fa fa-list-ul"></i> Quản lý Chuyên mục</a></li>
				</sec:authorize>
			<li class="treeview"><a href="#"> <i
					class="fa fa-file-text-o"></i> <span>Quản lý Bài viết</span> <span
					class="pull-right-container"> <i
						class="fa fa-angle-left pull-right"></i>
				</span>
			</a>
				<ul class="treeview-menu">
					<li><a href="${pageContext.request.contextPath}/post""><i
							class="fa fa-pencil"></i> Viết bài mới</a></li>
					<li><a href="${pageContext.request.contextPath}/pendingpost"><i
							class="fa  fa-hourglass-2"></i> Bài chờ duyệt</a></li>

					<li><a href="${pageContext.request.contextPath}/approvedpost"><i
							class="fa fa-calendar"></i> Bài đã duyệt</a></li>
					<li><a href="${pageContext.request.contextPath}/postpublished"><i
							class="fa fa-calendar-check-o"></i> Bài đã đăng</a></li>
				</ul></li>
			<sec:authorize access="hasRole('ROLE_ADMIN')">
				<li><a href="#" onclick="return BrowseServer( 'Images:/')"><i
						class="fa fa-image"></i> Quản lý Ảnh</a></li>
				<li><a href="${pageContext.request.contextPath}/admin/medias"><i
						class="fa fa-youtube-play"></i> Quản lý Video</a></li>
				<li><a
					href="${pageContext.request.contextPath}/admin/user/UserManagement"><i
						class="fa fa-users"></i> Quản lý tài khoản</a></li>
			</sec:authorize>
			<li><a
				href="${pageContext.request.contextPath}/admin/user/UserManagement"><i
					class="fa fa-bell-o"></i> Quản lý thông báo</a></li>
			<li><a
				href="${pageContext.request.contextPath}/admin/user/UserManagement"><i
					class="fa fa-commenting-o"></i> Quản lý bình luận</a></li>
		</ul>
	</section>
	<!-- /.sidebar -->
</aside>