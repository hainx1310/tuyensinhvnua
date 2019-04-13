<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
</section>
<br>

<form action="" method="post">
	<div class="row">
		<div class="col-sm-8" style="margin-left: 10px">
			<c:if test="${1==1 }">
				<div>
					<h5>Tiêu đề bài viết (*)</h5>
					<input style="margin-right: 0px; width: 100%" type="text"
						placeholder="Tiêu đề bài viết" name="title" value="${title}" />
				</div>
			</c:if>
			<div>
				<h5>Tóm tắt (*)</h5>
				<textarea style="margin-top: 0px; width: 100%; resize: vertical;"
					id="frmSumary"></textarea>
			</div>
			<div>
				<h5>Nội dung chính (*)</h5>
				<div>
					<textarea style="margin-top: 0px; width: 100%%;" name="content"
						id="frmContent">${content}</textarea>
					<br>
				</div>
			</div>
		</div>

		<div class="col-sm-3" style="margin-left: 10px">
			<div
				style="height: 200px; border-color: #1C1C1C 1px; border-style: solid; border-width: 0.2px; margin-top: 5px">
				<h5
					style="background-color: #1C1C1C; color: #fff; padding: 5px; margin-top: 0px; margin-right: 0px">Ảnh
					đại diện</h5>
			</div>
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
									value="${ i}"></c:out>
							</label>
						</div>
					</c:forEach>
				</div>
			</div>

			<div>
				<div class="form-group">
					<label>Ngày xuất bản:</label>

					<div class="input-group date">
						<div class="input-group-addon">
							<i class="fa fa-calendar"></i>
						</div>
						<input type="text" class="form-control pull-right" id="datepicker">
					</div>
					<!-- /.input group -->
				</div>
			</div>
		</div>
	</div>
	<input style="margin-top: 10px; margin-left: 10px" type="submit"
		value="Gửi bài" />
</form>

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
