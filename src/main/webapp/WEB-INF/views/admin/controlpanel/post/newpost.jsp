<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div id="titleContent">
	<H2>${titleContent}</H2>
</div>

<form action="" method="post">
	<div class="row">
		<div class="col-sm-8" style="margin-left: 10px">
			<c:if test="${1==1 }">
				<div
					style="height: 80px; border-color: #1C1C1C 1px; border-style: solid; border-width: 0.2px; margin-top: 5px">
					<h5
						style="background-color: #1C1C1C; color: #fff; padding: 5px; margin-top: 0px; margin-right: 0px">Tiêu
						đề bài viết (*)</h5>
					<input style="margin-right: 0px; margin-left: 5px; width: 95%"
						type="text" placeholder="Tiêu đề bài viết" name="title"
						value="${title}" />
				</div>
			</c:if>
			<div
				style="height: 130px; border-color: #1C1C1C 1px; border-style: solid; border-width: 0.5px; margin-top: 5px">
				<h5
					style="background-color: #1C1C1C; color: #fff; padding: 5px; margin-top: 0px; margin-right: 0px">Tóm
					tắt (*)</h5>
				<textarea style="margin-top: 0px; margin-left: 5px; width: 95%"
					name="summary" rows="3"></textarea>
			</div>
			<div
				style="height: 444px; border-color: #1C1C1C 1px; border-style: solid; border-width: 0.5px; margin-top: 5px">
				<h5
					style="background-color: #1C1C1C; color: #fff; padding: 5px; margin-top: 0px; margin-right: 0px">Nội
					dung chính (*)</h5>
				<div>
					<textarea style="margin-top: 0px" name="content" cols="20"
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
