<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="edit" value="${pageContext.request.contextPath}/video/edit" />
<c:set var="add" value="${pageContext.request.contextPath}/video/add" />
<c:set var="delete" value="${pageContext.request.contextPath}/video/delete" />

<div id="wrapper-content">
	<div id="container-content">
		<section class="content-header">
			<h1>
				Quản lý video <small>Tuyển sinh HVN</small>
			</h1>
			<ol class="breadcrumb">
				<li><a href="${pageContext.request.contextPath}/home"><i
						class="fa fa-home"></i> Trang chủ</a></li>
				<li class="active">Quản lý video</li>
			</ol>
			<br>
		</section>

		<div style="margin-left: 10px; margin-right: 10px;">
			<!-- Thong ke -->
			<div id="thongke">
				<h4>Video</h4>
				<div id="filter">
					<span>Tiêu đề video:&nbsp;&nbsp;</span> <input
						id="input-search-title-video" onkeyup="searchVideoByName()"
						placeholder="Tìm tiêu đề video..." type="text"
						style="width: 300px;" />
				</div>
			</div>
			<div>
				<div class="box">
					<div class="box-body">
						<div id="example2_wrapper"
							class="dataTables_wrapper form-inline dt-bootstrap">
							<div class="row">
								<div class="col-sm-12">
									<c:if test="${totalRecord == 0}">
										<p>Không có dữ liệu để hiển thị</p>
									</c:if>
									<c:if test="${totalRecord > 0}">
										<table id="table-video"
											class="table table-bordered table-hover dataTable"
											role="grid" aria-describedby="example2_info">
											<thead>
												<tr role="row">
													<th></th>
													<th>STT</th>
													<th>Tiêu đề</th>
													<th>Id video</th>
													<th>Trạng thái</th>
													<th>Ngày tạo</th>
													<th>Người tạo</th>
													<th>Ngày sửa</th>
													<th>Người sửa</th>
													<th></th>
												</tr>
											</thead>
											<tbody>
												<c:forEach var="i" begin="1" end="${listVideo.size()}">
													<tr role="row" class="odd">
														<td><input type="checkbox"
															class="custom-control-input" id="defaultUnchecked"></td>
														<td class=""><c:out value="${i}" /></td>
														<td id="video-title" class="sorting_1"><a
															title="Nhấn để xem video" target="_blank"
															href="https://www.youtube.com/watch?v=${listVideo.get(i-1).getVideoYoutubeId()}"><c:out
																	value="${listVideo.get(i-1).getTitle()}" /></a></td>
														<td id="video-url" class="sorting_1"><c:out
																value="${listVideo.get(i-1).getVideoYoutubeId()}" /></a></td>
														<td id="video-status"><c:out
																value="${listVideo.get(i-1).isStatus()==true ? \"Kích hoạt\" : \"Khóa\"}" /></td>
														<td id="video-created-date"><c:out
																value="${listVideo.get(i-1).getCreatedDate()}" /></td>
														<td id="video-created-user"><c:out
																value="${listVideo.get(i-1).getAuthor()}" /></td>
														<td id="video-updated-date"><c:out
																value="${listVideo.get(i-1).getUpdatedDate()}" /></td>
														<td id="video-updated-user"><c:out
																value="${listVideo.get(i-1).getUpdatedUser()}" /></td>
														<td><a title="Sửa video"
															onclick='openModalUpdateVideo(${listVideo.get(i-1).getId()}, "${listVideo.get(i-1).getVideoYoutubeId()}", "${listVideo.get(i-1).getTitle()}", "${listVideo.get(i-1).getPublishedDate()}")'
															href="#" class="fa fa-pencil"></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a
															title="Xóa video"
															onclick='openModalDeleteVideo(${listVideo.get(i-1).getId()}, "${listVideo.get(i-1).getTitle()}")'
															href="#" class="fa fa-trash-o"></a></td>
													</tr>
												</c:forEach>
											</tbody>
										</table>
									</c:if>
								</div>
							</div>

							<button type="button" class="btn btn-success" data-toggle="modal"
								data-target="#modal-success" id="btn-video-clcik">Thêm
								mới</button>

							<c:if test="${totalRecord > 10}">
								<div class="row">
									<div class="col-sm-5">
										<div class="dataTables_info" id="show-data-of-page"
											role="status" aria-live="polite">
											Hiển thị <span id="recored-start">1</span> đến <span
												id="recored-end">${listVideo.size()}</span> trong số
											<c:out value="${totalRecord}" />
											mục
										</div>
									</div>
									<div class="col-sm-7">
										<div class="dataTables_paginate paging_simple_numbers"
											id="example2_paginate">
											<ul class="pagination">
												<c:forEach var="i" begin="1" end="${pagesNumber}">
													<li class="paginate_button page-of-categories next"
														id="example2_next"><a href="#"
														aria-controls="example2" data-dt-idx="'${i}'" tabindex="0">${i}</a></li>
												</c:forEach>
											</ul>
										</div>
									</div>
								</div>
							</c:if>
						</div>
					</div>
					<div class="modal fade" id="modal-create-video">
						<div class="modal-dialog">
							<div class="modal-content">
								<div class="modal-header">
									<button type="button" class="close" data-dismiss="modal"
										aria-label="Close">
										<span aria-hidden="true">&times;</span>
									</button>
									<h4>Thêm video mới</h4>
								</div>
								<form action="${add}" method="post">
									<div class="modal-body">
										<table
											style="display: table; border-collapse: separate; border-spacing: 0px 10px; border-color: grey">
											<tr>
												<td>Tiêu đề:</td>
												<td><input type="text" id="title" name="title"
													size="50%" autofocus="autofocus"></td>
											</tr>
											<tr>
												<td>ID video youtube:</td>
												<td><input type="text" id="videoYoutubeId"
													name="videoYoutubeId" size="50%"></td>
											</tr>
											<tr>
												<td>Ngày đăng video:</td>
												<td>
													<div class="input-group date">
														<div class="input-group-addon">
															<i class="fa fa-calendar"></i>
														</div>
														<input type="text" class="form-control pull-right"
															id="datepicker" name="publishedDate">
													</div>
												</td>
											</tr>
										</table>
									</div>
									<div class="modal-footer">
										<button type="button" class="btn btn-default pull-left"
											data-dismiss="modal">Hủy</button>
										<button id="btn-save-video" type="submit"
											class="btn btn-primary">Lưu</button>
									</div>
								</form>
							</div>
							<!-- /.modal-content -->
						</div>
						<!-- /.modal-dialog -->
					</div>
					<!-- /.modal -->
					<!-- /.box-body -->

					<div class="modal fade" id="modal-update-video">
						<div class="modal-dialog">
							<div class="modal-content">
								<div class="modal-header">
									<button type="button" class="close" data-dismiss="modal"
										aria-label="Close">
										<span aria-hidden="true">&times;</span>
									</button>
									<h4>Cập nhật video</h4>
								</div>
								<form action="${edit}" method="post">
									<div class="modal-body">
										<table
											style="display: table; border-collapse: separate; border-spacing: 0px 10px; border-color: grey">
											<tr>
												<td>Tiêu đề:</td>
												<td><input type="text" id="title" name="title"
													size="50%" autofocus="autofocus"></td>
											</tr>
											<tr>
												<td>ID video youtube:</td>
												<td><input type="text" id="videoYoutubeId"
													name="videoYoutubeId" size="50%"></td>
											</tr>
											<tr>
												<td>Ngày đăng video:</td>
												<td>
													<div class="input-group date">
														<div class="input-group-addon">
															<i class="fa fa-calendar"></i>
														</div>
														<input type="text" class="form-control pull-right"
															id="datepicker-update" name="publishedDate">
													</div>
												</td>
											</tr>
										</table>
									</div>
									<div class="modal-footer">
										<button type="button" class="btn btn-default pull-left"
											data-dismiss="modal">Hủy</button>
										<button id="btn-save-update" type="submit"
											class="btn btn-primary">Lưu</button>
									</div>
								</form>
							</div>
							<!-- /.modal-content -->
						</div>
						<!-- /.modal-dialog -->
					</div>

					<div class="modal fade" id="modal-confirm-delete">
						<div class="modal-dialog">
							<div class="modal-content">
								<form action="${delete}" method="post">
									<div class="modal-body"></div>
									<div class="modal-footer">
										<button type="button" class="btn btn-default pull-left"
											data-dismiss="modal">Hủy bỏ</button>
										<button id="btn-delete-categories" type="submit"
											class="btn btn-primary">Đồng ý</button>
									</div>
								</form>
							</div>
							<!-- /.modal-content -->
						</div>
						<!-- /.modal-dialog -->
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
