<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<c:set var="delete"
	value="${pageContext.request.contextPath}/bai-viet/delete" />

<div id="wrapper-content">
	<div id="container-content">
		<section class="content-header">
			<h1>
				Bài chờ duyệt <small>Tuyển sinh HVN</small>
			</h1>
			<ol class="breadcrumb">
				<li><a href="${pageContext.request.contextPath}/home"><i
						class="fa fa-home"></i> Trang chủ</a></li>
				<li class="active">Bài viết</li>
				<li><a href="">Bài chờ duyệt</a></li>
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
								<c:if test="${not empty msg}">
									<input type="hidden" id="msg" value="${msg}"
										disabled="disabled">
								</c:if>
								<c:if test="${totalRecord == 0}">
									<p>Không có dữ liệu để hiển thị</p>
								</c:if>
								<c:if test="${totalRecord > 0}">
									<table id="example2" class="table table-bordered table-striped"
										role="grid" aria-describedby="example2_info">
										<thead>
											<tr role="row">
												<th><input type="checkbox" class="custom-control-input"
													id="defaultUnchecked"></th>
												<th>STT</th>
												<th>Tiêu đề</th>
												<th>Chuyên mục</th>
												<th>Tác giả</th>
												<th>Ngày tạo</th>
												<th></th>
											</tr>
										</thead>
										<tbody>
											<c:forEach var="i" begin="1" end="${listPendingPost.size()}">
												<tr role="row" class="odd">
													<td><input type="checkbox"
														class="custom-control-input" id="defaultUnchecked"></td>
													<td><c:out value="${i}"></c:out></td>
													<td style="max-width: 400px" class=""><a href="#"
														onclick="viewPost('${listPendingPost.get(i-1).getId()}', '${listPendingPost.get(i-1).getTitle()}')"
														title="Xem bài viết"><c:out
																value="${listPendingPost.get(i-1).getTitle()}"></c:out></a></td>
													<td class="sorting_1"><c:out
															value="${listPendingPost.get(i-1).getCategories().getName()}"></c:out>
													</td>
													<td><c:out
															value="${listPendingPost.get(i-1).getAuthor()}"></c:out></td>
													<td><c:out
															value="${listPendingPost.get(i-1).getCreatedDate()}"></c:out></td>
													<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a
														href="#" class="fa fa-pencil" title="Sửa bài viết"
														onclick="editPost('${listPendingPost.get(i-1).getId()}')"></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
														<a href="#" class="fa fa-trash-o" title="Xóa bài viết"
														onclick="openModalDeletePost('${listPendingPost.get(i-1).getId()}', '${listPendingPost.get(i-1).getTitle()}')"></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
														<sec:authorize
															access="hasAnyRole('ROLE_EDITOR', 'ROLE_ADMIN')">
															<a href="#" class="fa fa-check" title="Duyệt bài viết"
																onclick="openModalApprovedPost('${listPendingPost.get(i-1).getId()}')"></a>
														</sec:authorize></td>
												</tr>
											</c:forEach>
										</tbody>
									</table>
									<div class="modal fade" id="modal-view-post">
										<div class="modal-dialog">
											<div class="modal-content">
												<div class="modal-header">
													<button type="button" class="close" data-dismiss="modal"
														aria-label="Close">
														<span aria-hidden="true">&times;</span>
													</button>
													<h4></h4>
												</div>
												<div class="modal-body"></div>
											</div>
											<!-- /.modal-content -->
										</div>
										<!-- /.modal-dialog -->
									</div>
									<!-- /.modal -->
									<div class="modal fade" id="modal-confirm-delete">
										<div class="modal-dialog">
											<div class="modal-content">
												<form action="${delete}" method="post">
													<div class="modal-body"></div>
													<div class="modal-footer">
														<button type="button" class="btn btn-secondary"
															data-dismiss="modal">Hủy bỏ</button>
														<button id="btn-delete-pots" type="submit"
															class="btn btn-primary">Đồng ý</button>
													</div>
												</form>
											</div>
											<!-- /.modal-content -->
										</div>
										<!-- /.modal-dialog -->
									</div>
									<form id="form-approved-post" action="editor/approved"
										method="POST">
										<div class="modal fade" id="modal-approved-post">
											<div class="modal-dialog">
												<div class="modal-content">
													<div class="modal-header">
														<button type="button" class="close" data-dismiss="modal"
															aria-label="Close">
															<span aria-hidden="true">&times;</span>
														</button>
														<h4>Duyệt bài viết</h4>
													</div>
													<div class="modal-body">
														<table
															style="display: table; border-collapse: separate; border-spacing: 0px 10px; border-color: grey">
															<sec:authorize
																access="hasAnyRole('ROLE_EDITOR', 'ROLE_ADMIN')">
																<tr>
																	<td>Thêm thời gian đăng bài viết:</td>
																	<td>
																		<div class="input-group date">
																			<div class="input-group-addon">
																				<i class="fa fa-calendar"></i>
																			</div>
																			<input type="text" class="form-control pull-right"
																				id="datepicker-approved" name="publishedDate">
																		</div>
																	</td>
																</tr>
															</sec:authorize>
														</table>
													</div>
													<div class="modal-footer">
														<button type="button" class="btn btn-secondary"
															data-dismiss="modal">Hủy</button>
														<button id="btn-save-approved" type="button"
															class="btn btn-primary" onclick="approvedPost()">Duyệt</button>
													</div>
												</div>
												<!-- /.modal-content -->
											</div>
											<!-- /.modal-dialog -->
										</div>
									</form>
								</c:if>
							</div>
						</div>
						<c:if test="${totalrRecord > 10}">
							<div class="row">
								<div class="col-sm-5">
									<div class="dataTables_info" id="show-data-of-page"
										role="status" aria-live="polite">
										Hiển thị <span id="recored-start">1</span> đến <span
											id="recored-end">${listPendingPost.size()}</span> trong số
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
<script>
	
</script>