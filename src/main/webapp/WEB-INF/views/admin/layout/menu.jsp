<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<aside class="main-sidebar">
	<!-- sidebar: style can be found in sidebar.less -->
	<section class="sidebar" style="height: auto;">
		<!-- Sidebar user panel -->
		<div class="user-panel">
			<div class="pull-left image">
				<img src="<%=request.getContextPath()%>/resources/dist/img/user2-160x160.jpg" class="img-circle"
					alt="User Image">
			</div>
			<div class="pull-left info">
				<p>Nguyễn Xuân Hải</p>
				<a href="#"><i class="fa fa-circle text-success"></i> Online</a>
			</div>
		</div>

		<!-- sidebar menu: : style can be found in sidebar.less -->
		<ul class="sidebar-menu tree" data-widget="tree">
			<li><a href="${pageContext.request.contextPath}/home"> <i
					class="fa fa-home"></i> <span>Trang chủ</span>
			</a>
			<li class="treeview"><a href="#"> <i class="fa fa-file-text-o"></i>
					<span>Bài viết</span> <span class="pull-right-container"> <i
						class="fa fa-angle-left pull-right"></i>
				</span>
			</a>
				<ul class="treeview-menu">
					<li><a href="${pageContext.request.contextPath}/post""><i
							class="fa fa-pencil"></i> Viết bài mới</a></li>
					<li><a href="${pageContext.request.contextPath}/admin/pendingpost"><i
							class="fa  fa-hourglass-2"></i> Bài chờ duyệt</a></li>
					<li><a href="${pageContext.request.contextPath}/admin/approvedpost"><i
							class="fa fa-calendar"></i> Bài đã duyệt</a></li>
					<li><a href="${pageContext.request.contextPath}/admin/postpublished"><i
							class="fa fa-calendar-check-o"></i> Bài đã xuất bản</a></li>
				</ul></li>
			<li class="treeview"><a href="#"> <i class="fa fa-edit"></i>
					<span>Quản lý nội dung</span> <span class="pull-right-container">
						<i class="fa fa-angle-left pull-right"></i>
				</span>
			</a>
				<ul class="treeview-menu">
					<li><a href="${pageContext.request.contextPath}/admin/categories"><i
							class="fa fa-list-ul"></i> Quản lý Chuyên mục</a></li>
					<li><a href="${pageContext.request.contextPath}/admin/categories"><i
							class="fa fa-image"></i> Quản lý Ảnh</a></li>
					<li><a href="${pageContext.request.contextPath}/admin//categories"><i
							class="fa fa-youtube-play"></i> Quản lý Video</a></li>
				</ul></li>
			<li class="treeview"><a href="#"> <i class="fa fa-cog"></i>
					<span> Tổ chức website</span> <span class="pull-right-container">
						<i class="fa fa-angle-left pull-right"></i>
				</span>
			</a>
				<ul class="treeview-menu">
					<li><a href="${pageContext.request.contextPath}/admin/UserManagement"><i
							class="fa fa-users"></i> Quản lý thành viên</a></li>
					<li><a href="${pageContext.request.contextPath}/admin/RoleManagement"><i
							class="fa fa-sitemap"></i> Quản lý quyền</a></li>
				</ul></li>
		</ul>
	</section>
	<!-- /.sidebar -->
</aside>