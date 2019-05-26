<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<sec:authorize access="isAuthenticated()">
	<header class="main-header">
		<!-- Logo -->
		<a href="" class="logo"> <!-- mini logo for sidebar mini 50x50 pixels -->
			<span class="logo-mini"><b>HVN</b></span> <!-- logo for regular state and mobile devices -->
			<span class="logo-lg"><b>Tuyển sinh </b>[HVN]</span>
		</a>
		<!-- Header Navbar: style can be found in header.less -->
		<nav class="navbar navbar-static-top">
			<!-- Sidebar toggle button-->
			<a href="#" class="sidebar-toggle" data-toggle="push-menu"
				role="button"> <span class="sr-only"></span>
			</a>
			<div class="navbar-custom-menu">
				<ul class="nav navbar-nav">
					<!-- User Account: style can be found in dropdown.less -->
					<li class="dropdown user user-menu"><a href="#"
						class="dropdown-toggle" data-toggle="dropdown"> <img
							src="<%=request.getContextPath()%>/<sec:authentication property="principal.avatarUrl" />"
							class="user-image" alt="User Image"> <span
							class="hidden-xs"><sec:authentication
									property="principal.name" /></span>
					</a>
						<ul class="dropdown-menu">
							<!-- User image -->
							<li class="user-header"><img
								src="<%=request.getContextPath()%>/<sec:authentication property="principal.avatarUrl" />"
								class="img-circle" alt="Avartar người dùng">

								<p>
									<sec:authentication property="principal.username" />
									<small><sec:authentication
											property="principal.roleName" /></small>
								</p></li>
							<!-- Menu Body -->
							<!-- Menu Footer-->
							<li class="user-footer">
								<div class="pull-left">
									<a href="${pageContext.request.contextPath}/thong-tin-ca-nhan"
										class="btn btn-default btn-flat">Thông tin cá nhân</a>
								</div>
								<div class="pull-right">
									<a href="${pageContext.request.contextPath}/logout"
										class="btn btn-default btn-flat">Đăng xuất</a>
								</div>
							</li>
						</ul></li>
				</ul>
			</div>
		</nav>
	</header>
</sec:authorize>