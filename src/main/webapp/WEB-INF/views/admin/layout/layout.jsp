<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title><tiles:getAsString name="title" /></title>
<!-- Tell the browser to be responsive to screen width -->
<meta
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"
	name="viewport">
<!-- Bootstrap 3.3.7 -->
<link rel="stylesheet"
	href="resources/bower_components/bootstrap/dist/css/bootstrap.min.css">
<!-- Font Awesome -->
<link rel="stylesheet"
	href="resources/bower_components/font-awesome/css/font-awesome.min.css">
<!-- Ionicons -->
<link rel="stylesheet"
	href="resources/bower_components/Ionicons/css/ionicons.min.css">
<!-- Theme style -->
<link rel="stylesheet" href="resources/dist/css/AdminLTE.min.css">
<!-- AdminLTE Skins. Choose a skin from the css/skins
       folder instead of downloading all of them to reduce the load. -->
<link rel="stylesheet"
	href="resources/dist/css/skins/_all-skins.min.css">
<!-- Morris chart -->
<link rel="stylesheet"
	href="resources/bower_components/morris.js/morris.css">
<!-- jvectormap -->
<link rel="stylesheet"
	href="resources/bower_components/jvectormap/jquery-jvectormap.css">
<!-- Date Picker -->
<link rel="stylesheet"
	href="resources/bower_components/bootstrap-datepicker/dist/css/bootstrap-datepicker.min.css">
<!-- Daterange picker -->
<link rel="stylesheet"
	href="resources/bower_components/bootstrap-daterangepicker/daterangepicker.css">
<!-- bootstrap wysihtml5 - text editor -->
<link rel="stylesheet"
	href="resources/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.min.css">

<link rel="stylesheet" type="text/css" href="resources/css/content.css" />

<!-- Google Font -->
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic">
</head>
<body class="hold-transition skin-blue sidebar-mini">
	<div class="wrapper">

		<!-- Header -->
		<tiles:insertAttribute name="header" />
		<!-- End header -->

		<!-- Sidebar -->
		<tiles:insertAttribute name="menu" />
		<!-- End sidebar -->

		<!-- Content -->
		<div class="content-wrapper">
			<tiles:insertAttribute name="body" />
		</div>
		<!-- End content -->

		<!-- Footer -->
		<tiles:insertAttribute name="footer" />
		<!-- End Footer -->

		<div class="control-sidebar-bg"></div>
	</div>

	<div>
		<!-- jQuery 3 -->
		<script src="resources/bower_components/jquery/dist/jquery.min.js"></script>
		<!-- jQuery UI 1.11.4 -->
		<script src="resources/bower_components/jquery-ui/jquery-ui.min.js"></script>
		<!-- Resolve conflict in jQuery UI tooltip with Bootstrap tooltip -->
		<script>
			$.widget.bridge('uibutton', $.ui.button);
		</script>
		<!-- Bootstrap 3.3.7 -->
		<script
			src="resources/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
		<!-- Morris.js charts -->
		<script src="resources/bower_components/raphael/raphael.min.js"></script>
		<script src="resources/bower_components/morris.js/morris.min.js"></script>
		<!-- Sparkline -->
		<script
			src="resources/bower_components/jquery-sparkline/dist/jquery.sparkline.min.js"></script>
		<!-- jvectormap -->
		<script
			src="resources/plugins/jvectormap/jquery-jvectormap-1.2.2.min.js"></script>
		<script
			src="resources/plugins/jvectormap/jquery-jvectormap-world-mill-en.js"></script>
		<!-- jQuery Knob Chart -->
		<script
			src="resources/bower_components/jquery-knob/dist/jquery.knob.min.js"></script>
		<!-- daterangepicker -->
		<script src="resources/bower_components/moment/min/moment.min.js"></script>
		<script
			src="resources/bower_components/bootstrap-daterangepicker/daterangepicker.js"></script>
		<!-- datepicker -->
		<script
			src="resources/bower_components/bootstrap-datepicker/dist/js/bootstrap-datepicker.min.js"></script>
		<!-- Bootstrap WYSIHTML5 -->
		<script
			src="resources/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.all.min.js"></script>
		<!-- Slimscroll -->
		<script
			src="resources/bower_components/jquery-slimscroll/jquery.slimscroll.min.js"></script>
		<!-- FastClick -->
		<script src="resources/bower_components/fastclick/lib/fastclick.js"></script>
		<!-- AdminLTE App -->
		<script src="resources/dist/js/adminlte.min.js"></script>
		<!-- AdminLTE dashboard demo (This is only for demo purposes) -->
		<script src="resources/dist/js/pages/dashboard.js"></script>
		<!-- AdminLTE for demo purposes -->
		<script src="resources/dist/js/demo.js"></script>

		<script>
			//Date picker
			$('#datepicker').datepicker({
				autoclose : true
			})
		</script>
		<script>
			function openModalUpdateUser() {
				$('#modal-user').modal({
					show : 'true'
				});
			}

			// Sự kiện khi bấm sửa thành viên
			$("#update_user").on("click", function() {
				$('#modal-user').modal({
					show : 'true'
				});

				var id = 1;
				// lấy dữ liệu user theo id
				var username = "editor01";
				var password = "123456";
				var email = "admin@vnua.edu.vn";

				$("#username").val(username);
				$("#password").val(password);
				$("#email").val(email);
				$("#select_role").val("Biên tập viên");
				$('#role_is_admin').prop('checked', true);
				$('.modal-user-title').text("Sửa thông tin người dùng");
			});

			// function bat modal tao moi user
			function openModalCreateUser() {
				$('.modal-user-title').text("Thêm người dùng mới");
				$('#modal-user').modal({
					show : 'true'
				});
			}

			// Reset data modal user sau mỗi khi bị ẩn
			$("#modal-user").on("hidden.bs.modal", function() {
				$("#username").val("");
				$("#password").val("");
				$("#email").val("");
				$("#select_role").val("---Chọn quyền--");
				$('#role_is_admin').prop('checked', false);
			});

			// Sự kiện khi bấm sửa quyền
			$("#update_role").on("click", function() {
				$('#modal-role').modal({
					show : 'true'
				});

				var id = 1;
				// lấy dữ liệu user theo id
				var name = "Quản trị viên";

				$("#role-name").val(name);
				$('#role_is_admin').prop('checked', true);
				$('.modal-role-title').text("Sửa thông tin quyền");
			});

			// su kien add quyen
			$("#btn-add-role").on("click", function() {
				$('.modal-role-title').text("Thêm quyền mới");
				$('#modal-role').modal({
					show : 'true'
				});
			});

			// function bat modal tao moi user
			function openModalCreateUser() {
				$('.modal-user-title').text("Thêm người dùng mới");
				$('#modal-user').modal({
					show : 'true'
				});
			}

			// Reset data modal user sau mỗi khi bị ẩn
			$("#modal-user").on("hidden.bs.modal", function() {
				$("#username").val("");
				$("#password").val("");
				$("#email").val("");
				$("#select_role").val("---Chọn quyền--");
				$('#role_is_admin').prop('checked', false);
			});

			// Reset data modal role sau mỗi khi bị ẩn
			$("#modal-role").on("hidden.bs.modal", function() {
				$("#role-name").val("");
				$('#role_is_admin').prop('checked', false);
			});

			//Sự kiện khi bấm sửa categories
			$("#update_categories").on("click", function() {
				$('#modal-categories').modal({
					show : 'true'
				});

				var id = 1;
				// lấy dữ liệu user theo id
				var name = "Vì sao chọn HVN";

				$("#name").val(name);
				$('#categories-is-active').prop('checked', true);
				$('.modal-categories-title').text("Sửa chuyên mục");
			});

			// Reset data modal categories sau mỗi khi bị ẩn
			$("#modal-categories").on("hidden.bs.modal", function() {
				$("#name").val("");
				$('#categories-is-active').prop('checked', false);
			});

			// su kien add categories
			$("#btn-categorites-clcik").on("click", function() {
				$('.modal-categories-title').text("Thêm chuyên mục");
				$('#modal-categories').modal({
					show : 'true'
				});
			});
		</script>
	</div>
</body>
</html>
