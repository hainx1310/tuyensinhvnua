<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div id="wrapper-content">
	<div id="container-content">
		<section class="content-header">
			<h1>
				${titleContent} <small>Tuyển sinh HVN</small>
			</h1>
			<ol class="breadcrumb">
				<li><a href="${pageContext.request.contextPath}/home"><i
						class="fa fa-home"></i> Trang chủ</a></li>
				<li class="active">Bài viết</li>
				<li class="active">${titleContent}</li>
			</ol>
			<br>
		</section>

		<div style="margin-left: 10px; margin-right: 10px;">
			<div class="box">
				<div class="box-body">
					<div id="example2_wrapper"
						class="dataTables_wrapper form-inline dt-bootstrap">
						<div class="row">
							<div class="col-sm-12">
								<form action="" method="post">
									<div class="row">
										<div class="col-sm-8" style="margin-left: 10px">
											<c:if test="${1==1 }">
												<div>
													<h5>Tiêu đề bài viết (*)</h5>
													<input style="margin-right: 0px; width: 100%" type="text"
														placeholder="Tiêu đề bài viết" name="title"
														value="${title}" />
												</div>
											</c:if>
											<div>
												<h5>Tóm tắt (*)</h5>
												<textarea
													style="margin-top: 0px; width: 100%; resize: vertical;"
													id="frmSumary"></textarea>
											</div>
											<div>
												<h5>Nội dung chính (*)</h5>
												<div>
													<textarea style="margin-top: 0px; width: 100%%;"
														name="content" id="frmContent">${content}</textarea>
													<br>
												</div>
											</div>
										</div>

										<div class="col-sm-3">
											<div id="anh-dai-dien"
												style="height: 270px; width: 250px; border-color: #1C1C1C 1px; border-style: solid; border-width: 0.2px; margin-top: 5px">
												<h5
													style="background-color: #1C1C1C; color: #fff; padding: 5px; margin-top: 0px; margin-right: 0px">Ảnh
													đại diện</h5>
												<img id="avatar-post" src="resources/images/avatar-post.png"
													alt="ảnh đại diện bài viết" height="70%" width="90%">
												<button style = "margin-left: 10px"type="button" class="btn btn-success"
													onclick="BrowseServer( 'Images:/', 'xImagePath' )">Tải ảnh lên</button>
											</div>
											
											<br>
											<div
												style="height: 200px; border-color: #1C1C1C 1px; border-style: solid; border-width: 0.2px; margin-top: 5px">
												<h5
													style="background-color: #1C1C1C; color: #fff; padding: 5px; margin-top: 0px; margin-right: 0px">Chuyên
													mục (*)</h5>
												<div
													style="width: 100%; height: 82%; overflow-y: scroll; padding-left: 10px">
													<c:forEach var="i" begin="1" end="10">
														<div class="radio">
															<label> <input type="radio" name="channelId"
																value="Chuyên mục ${ i}"> Chuyên mục <c:out
																	value="${ i}"></c:out> <br>
															</label>
														</div>
														<br>
													</c:forEach>
												</div>
											</div>

											<div>
												<br>
												<div class="form-group">
													<label>Ngày xuất bản:</label><br>
													<div class="input-group date">
														<div class="input-group-addon">
															<i class="fa fa-calendar"></i>
														</div>
														<input type="text" class="form-control pull-right"
															id="datepicker">
													</div>
													<!-- /.input group -->
												</div>
											</div>
										</div>
									</div>
									<input style="margin-top: 10px; margin-left: 10px"
										type="submit" value="Gửi bài" />
								</form>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>


		<script src="resources/bower_components/ckeditor/ckeditor.js"></script>
		<script src="resources/bower_components/ckfinder/ckfinder.js"></script>
		<script>
	var editor = CKEDITOR.replace('frmContent');
	CKFinder.setupCKEditor(editor, '<%=request.getContextPath()%>/resources/bower_components/ckfinder/');
		</script>
		<script>
			//Date picker
			$(function() {
				$('#datepicker').datetimepicker();
			});
			$('#datepicker').datepicker({
				autoclose : true
			})
		</script>

		<script>
			/*Avatar start*/
			function BrowseServer(startupPath, functionData) {
				// You can use the "CKFinder" class to render CKFinder in a page:
				var finder = new CKFinder();

				// The path for the installation of CKFinder (default = "/ckfinder/").
				finder.basePath = '../';

				//Startup path in a form: "Type:/path/to/directory/"
				finder.startupPath = startupPath;

				// Name of a function which is called when a file is selected in CKFinder.
				finder.selectActionFunction = SetFileField;

				// Additional data to be passed to the selectActionFunction in a second argument.
				// We'll use this feature to pass the Id of a field that will be updated.
				finder.selectActionData = functionData;

				// Name of a function which is called when a thumbnail is selected in CKFinder. Preview img
				// finder.selectThumbnailActionFunction = ShowThumbnails;

				// Launch CKFinder
				finder.popup();
			}

			// This is a sample function which is called when a file is selected in CKFinder.
			function SetFileField(fileUrl, data) {
				console.log(fileUrl);
				document.getElementById(data["selectActionData"]).innerHTML = this
						.getSelectedFile().name;
				document.getElementById("avatar-post").src = request
						.getContextPath()
						/ fileUrl;
			}
			/*Avatar end*/
		</script>
	</div>
</div>
