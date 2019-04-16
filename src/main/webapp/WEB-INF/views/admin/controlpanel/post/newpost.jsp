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
													<h4>Tiêu đề bài viết (*)</h4>
													<input style="margin-right: 0px; width: 100%" type="text"
														placeholder="Tiêu đề bài viết" name="title"
														value="${title}" />
												</div>
											</c:if>
											<div>
												<h4>Tóm tắt (*)</h4>
												<textarea
													style="margin-top: 0px; width: 100%; resize: vertical;"
													id="short_content" name = "short_content"></textarea>
											</div>
											<div>
												<h4>Nội dung chính (*)</h4>
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
												<h4
													style="background-color: #1C1C1C; color: #fff; padding: 5px; margin-top: 0px; margin-right: 0px">Ảnh
													đại diện</h4>
												<img name = "avatar_post" id="avatar-post" src="resources/images/avatar-post.png"
													alt="ảnh đại diện bài viết" height="70%" width="90%">
												<button style = "margin-left: 10px"type="button" class="btn btn-success"
													onclick="BrowseServer( 'Images:/')">Tải ảnh lên</button>
											</div>
											
											<br>
											<div
												style="height: 200px; border-color: #1C1C1C 1px; border-style: solid; border-width: 0.2px; margin-top: 5px">
												<h4
													style="background-color: #1C1C1C; color: #fff; padding: 5px; margin-top: 0px; margin-right: 0px">Chuyên
													mục (*)</h4>
												<div
													style="width: 100%; height: 82%; overflow-y: scroll; padding-left: 10px">
													<c:forEach var="i" begin="1" end="${listAllCatergories.size()}">
														<div class="radio">
															<label> <input type="radio" name="categories_id"
																value="${listAllCatergories.get(i-1).getName()}"> ${listAllCatergories.get(i-1).getName()}<br>
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
														<input name = "published_date" type="text" class="form-control pull-right"
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
			// Chon avatar bai viet start
			function BrowseServer(startupPath) {
				// You can use the "CKFinder" class to render CKFinder in a page:
				var finder = new CKFinder();

				// The path for the installation of CKFinder (default = "/ckfinder/").
				finder.basePath = '../';

				//Startup path in a form: "Type:/path/to/directory/"
				finder.startupPath = startupPath;
				
				// Name of a function which is called when a file is selected in CKFinder.
				finder.selectActionFunction = SetFileField;

				// Launch CKFinder
				finder.popup();
			}

			// This is a sample function which is called when a file is selected in CKFinder.
			function SetFileField(fileUrl, data) {
				document.getElementById("avatar-post").src = fileUrl;
			}
			// Chon avatar bai viet end
			
		</script>
	</div>
</div>
