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
	href="<%=request.getContextPath()%>/resources/bower_components/bootstrap/dist/css/bootstrap.min.css">
<!-- Font Awesome -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/bower_components/font-awesome/css/font-awesome.min.css">
<!-- Ionicons -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/bower_components/Ionicons/css/ionicons.min.css">
<!-- Theme style -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/dist/css/AdminLTE.min.css">
<!-- AdminLTE Skins. Choose a skin from the css/skins
       folder instead of downloading all of them to reduce the load. -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/dist/css/skins/_all-skins.min.css">
<!-- Morris chart -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/bower_components/morris.js/morris.css">
<!-- jvectormap -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/bower_components/jvectormap/jquery-jvectormap.css">
<!-- Date Picker -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/bower_components/bootstrap-datetimepicker/css/bootstrap-datetimepicker.min.css">
<!-- bootstrap wysihtml5 - text editor -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.min.css">
<!-- Select2 -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/bower_components/select2/dist/css/select2.min.css">
<!-- DataTables -->
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/bower_components/datatables.net-bs/css/dataTables.bootstrap.min.css">	

<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/resources/css/content.css" />

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
	</div>

	<!-- jQuery 3 -->
	<script
		src="<%=request.getContextPath()%>/resources/bower_components/jquery/dist/jquery.min.js"></script>
	<!-- jQuery UI 1.11.4 -->
	<script
		src="<%=request.getContextPath()%>/resources/bower_components/jquery-ui/jquery-ui.min.js"></script>
	<!-- Resolve conflict in jQuery UI tooltip with Bootstrap tooltip -->
	<script>
			$.widget.bridge('uibutton', $.ui.button);
		</script>
	<!-- Bootstrap 3.3.7 -->
	<script
		src="<%=request.getContextPath()%>/resources/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
	<!-- Morris.js charts -->
	<script
		src="<%=request.getContextPath()%>/resources/bower_components/raphael/raphael.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/bower_components/morris.js/morris.min.js"></script>
	<!-- Sparkline -->
	<script
		src="<%=request.getContextPath()%>/resources/bower_components/jquery-sparkline/dist/jquery.sparkline.min.js"></script>
	<!-- jvectormap -->
	<script
		src="<%=request.getContextPath()%>/resources/plugins/jvectormap/jquery-jvectormap-1.2.2.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/plugins/jvectormap/jquery-jvectormap-world-mill-en.js"></script>
	<!-- jQuery Knob Chart -->
	<script
		src="<%=request.getContextPath()%>/resources/bower_components/jquery-knob/dist/jquery.knob.min.js"></script>
	<!-- daterangepicker -->
	<script
		src="<%=request.getContextPath()%>/resources/bower_components/moment/min/moment.min.js"></script>
	<!-- datetime picker -->
<script src="<%=request.getContextPath()%>/resources/bower_components/bootstrap-daterangepicker/daterangepicker.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/bower_components/bootstrap-datetimepicker/js/bootstrap-datetimepicker.min.js"></script>
	<!-- Bootstrap WYSIHTML5 -->
	<script
		src="<%=request.getContextPath()%>/resources/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.all.min.js"></script>
	<!-- Slimscroll -->
	<script
		src="<%=request.getContextPath()%>/resources/bower_components/jquery-slimscroll/jquery.slimscroll.min.js"></script>
	<!-- FastClick -->
	<script
		src="<%=request.getContextPath()%>/resources/bower_components/fastclick/lib/fastclick.js"></script>
	<!-- AdminLTE App -->
	<script
		src="<%=request.getContextPath()%>/resources/dist/js/adminlte.min.js"></script>
	<!-- AdminLTE dashboard demo (This is only for demo purposes) -->
	<script
		src="<%=request.getContextPath()%>/resources/dist/js/pages/dashboard.js"></script>
	<!-- AdminLTE for demo purposes -->
	<script src="<%=request.getContextPath()%>/resources/dist/js/demo.js"></script>
	<!-- DataTables -->
	<script
		src="<%=request.getContextPath()%>/resources/bower_components/datatables.net/js/jquery.dataTables.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/bower_components/datatables.net-bs/js/dataTables.bootstrap.min.js"></script>

	<!-- START js tự định nghĩa -->
	<script type="text/javascript"
		src="<%=request.getContextPath()%>/resources/js/content.js"></script>
	<!-- END js tự định nghĩa -->

	<script
		src="<%=request.getContextPath()%>/resources/bower_components/ckeditor/ckeditor.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/bower_components/ckfinder/ckfinder.js"></script>
	<script>
			var editor = CKEDITOR.replace('frmContent');
			CKFinder.setupCKEditor(editor, '<%=request.getContextPath()%>/resources/bower_components/ckfinder/');
	</script>

	<script>
		/*menu handler*/
		$(function() {
			function stripTrailingSlash(str) {
				if (str.substr(-1) == '/') {
					return str.substr(0, str.length - 1);
				}
				return str;
			}

			var url = window.location.pathname;

			var activePage = stripTrailingSlash(url);
			$('.sidebar-menu li a').each(
					function() {
						var currentPage = stripTrailingSlash($(this).attr(
								'href'));
						if (activePage == currentPage) {
							$(this).parent().addClass('active');
							$(this).parent().parent().parent().addClass(
									'menu-open').addClass('active')
						}
					});
		});
	</script>
	<script>
	$(function() {
		$('#example1').DataTable()
		$('#example2').DataTable({
	        "ordering": false,
	        "aLengthMenu": [5,10,15]
		})
	})
</script>
</body>
</html>
