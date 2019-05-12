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
			</a> <!-- Menu admin --> <sec:authorize access="hasRole('ROLE_ADMIN')">
					<li><a
						href="${pageContext.request.contextPath}/admin/categories"><i
							class="fa fa-list-ul"></i><span>Quản lý Chuyên mục</span></a>
					<li><a
						href="${pageContext.request.contextPath}/admin/user/UserManagement"><i
							class="fa fa-users"></i><span>Quản lý tài khoản</span></a></li>
				</sec:authorize> <!-- Menu editor --> <sec:authorize
					access="hasAnyRole('ROLE_EDITOR', 'ROLE_COLLABORARATORS')">
					<li class="treeview"><a href="#"> <i
							class="fa fa-file-text-o"></i> <span>Quản lý Bài viết</span> <span
							class="pull-right-container"> <i
								class="fa fa-angle-left pull-right"></i>
						</span>
					</a>
						<ul class="treeview-menu">
							<li><a href="${pageContext.request.contextPath}/post/add"><i
									class="fa fa-pencil"></i><span>Viết bài mới</span></a></li>
							<li><a
								href="${pageContext.request.contextPath}/post/pending"><i
									class="fa  fa-hourglass-2"></i><span>Bài chờ duyệt</span></a></li>

							<li><a
								href="${pageContext.request.contextPath}/post/approved"><i
									class="fa fa-calendar"></i><span>Bài chờ đăng</span></a></li>
							<li><a
								href="${pageContext.request.contextPath}/post/published"><i
									class="fa fa-calendar-check-o"></i><span>Bài đã đăng</span></a></li>
						</ul></li>

					<li class="treeview"><a href="#"> <i
							class="fa fa-youtube-play"></i> <span>Quản lý Video</span> <span
							class="pull-right-container"> <i
								class="fa fa-angle-left pull-right"></i>
						</span>
					</a>
						<ul class="treeview-menu">
							<li><a href="${pageContext.request.contextPath}/video/"><i
									class="fa fa-pencil"></i><span>Thêm mới</span></a></li>
							<li><a
								href="${pageContext.request.contextPath}/video/pending"><i
									class="fa  fa-hourglass-2"></i><span>Video chờ duyệt</span></a></li>

							<li><a
								href="${pageContext.request.contextPath}/video/approved"><i
									class="fa fa-calendar"></i><span>Video chờ đăng</span></a></li>
							<li><a
								href="${pageContext.request.contextPath}/video/published"><i
									class="fa fa-calendar-check-o"></i><span>Video đã đăng</span></a></li>
						</ul></li>

					<li><a href="#" onclick="return BrowseServer( 'Images:/')"><i
							class="fa fa-image"></i><span>Hình ảnh</span></a></li>

					<li><a
						href="${pageContext.request.contextPath}/comment"><i
							class="fa fa-commenting-o"></i><span>Quản lý bình luận</span></a></li>

					<li><a
						href="${pageContext.request.contextPath}/notification"><i
							class="fa fa-bell-o"></i><span>Quản lý thông báo</span></a></li>
				</sec:authorize>
		</ul>
	</section>
	<!-- /.sidebar -->
</aside>