<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<c:set var="edit" value="${pageContext.request.contextPath}/video/edit" />

<div id="wrapper-content">
	<div id="container-content">
		<section class="content-header">
			<h1>
				Video đã đăng <small>Tuyển sinh HVN</small>
			</h1>
			<ol class="breadcrumb">
				<li><a href="${pageContext.request.contextPath}/home"><i
						class="fa fa-home"></i> Trang chủ</a></li>
				<li class="active">Video</li>
				<li><a href="">Video đã đăng</a></li>
			</ol>
			<br>
		</section>

		<div style="margin-left: 10px; margin-right: 10px;">
			<!-- Thong ke -->
			<div id="thongke">
				<h4>Video đã đăng</h4>
				<div id="filter">
					<span>Tiêu đề:&nbsp;&nbsp;</span> <input
						id="input-search-name-categories"
						onkeyup="searchCategoriesByTitle()"
						placeholder="Tìm theo tiêu đề..." type="text"
						style="width: 300px;" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span>Tên
						tác giả:&nbsp;&nbsp;</span> <input id="input-search-name-categories"
						onkeyup="searchCategoriesByName()"
						placeholder="Tìm theo tên tác giả..." type="text"
						style="width: 150px;" />
				</div>
			</div>
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
									<table id="example2"
										class="table table-bordered table-hover dataTable" role="grid"
										aria-describedby="example2_info">
										<thead>
											<tr role="row">
												<th><input type="checkbox" class="custom-control-input"
													id="defaultUnchecked"></th>
												<th>STT</th>
												<th>Tiêu đề</th>
												<th>Video Youtube Id</th>
												<th>Thời gian đăng</th>
												<th>Tác giả</th>
												<th>Người duyệt</th>
												<sec:authorize
													access="hasAnyRole('ROLE_EDITOR', 'ROLE_ADMIN')">
													<th></th>
												</sec:authorize>
											</tr>
										</thead>
										<tbody>
											<c:forEach var="i" begin="1"
												end="${listPublishedVideo.size()}">
												<tr role="row" class="odd">
													<td><input type="checkbox"
														class="custom-control-input" id="defaultUnchecked"></td>
													<td><c:out value="${i }"></c:out></td>
													<td class=""><a title="Nhấn để xem video"
														target="_blank"
														href="https://www.youtube.com/watch?v=${listPublishedVideo.get(i-1).getVideoYoutubeId()}"><c:out
																value="${listPublishedVideo.get(i-1).getTitle()}"></c:out></a></td>
													<td class="sorting_1"><c:out
															value="${listPublishedVideo.get(i-1).getVideoYoutubeId()}"></c:out></td>
													<td><c:out
															value="${listPublishedVideo.get(i-1).getPublishedDate()}"></c:out></td>
													<td><c:out
															value="${listPublishedVideo.get(i-1).getAuthor()}"></c:out></td>
													<td><c:out
															value="${listPublishedVideo.get(i-1).getApprovedUser()}"></c:out></td>
													<sec:authorize
														access="hasAnyRole('ROLE_EDITOR', 'ROLE_ADMIN')">
														<td><a href="#" class="fa fa-remove" title="Gỡ video"
															onclick="unApprovedVideo('${listPublishedVideo.get(i-1).getId()}')"></a>
														</td>
													</sec:authorize>
												</tr>
											</c:forEach>
										</tbody>
									</table>
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
																<td>Thời gian đăng video:</td>
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
														<button type="button" class="btn btn-secondary"
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
									<!-- /.modal -->
								</c:if>
							</div>
						</div>

						<c:if test="${totalRecord > 10}">
							<div class="row">
								<div class="col-sm-5">
									<div class="dataTables_info" id="show-data-of-page"
										role="status" aria-live="polite">
										Hiển thị <span id="recored-start">1</span> đến <span
											id="recored-end">${listPublishedVideo.size()}</span> trong số
										<c:out value="${totalRecord}" />
										mục
									</div>
								</div>
								<div class="col-sm-7">
									<div class="dataTables_paginate paging_simple_numbers"
										id="example2_paginate">
										<ul class="pagination">
											<c:forEach var="i" begin="1" end="${numberPage}">
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
				<!-- /.box-body -->
			</div>
		</div>
	</div>
</div>