<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<div id="wrapper-content">
	<div id="container-content">
		<section class="content-header">
			<h1>
				Bài chờ đăng <small>Tuyển sinh HVN</small>
			</h1>
			<ol class="breadcrumb">
				<li><a href="${pageContext.request.contextPath}/home"><i
						class="fa fa-home"></i> Trang chủ</a></li>
				<li class="active">Bài viết</li>
				<li><a href="">Bài chờ đăng</a></li>
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
												<sec:authorize
													access="hasAnyRole('ROLE_EDITOR', 'ROLE_ADMIN')">
													<th><input type="checkbox"
														class="custom-control-input" id="defaultUnchecked"></th>
												</sec:authorize>
												<th>Tiêu đề</th>
												<th>Chuyên mục</th>
												<th>Tác giả</th>
												<th>Ngày sửa</th>
												<th>Thời gian đăng</th>
												<th>Người duyệt</th>
												<sec:authorize
													access="hasAnyRole('ROLE_EDITOR', 'ROLE_ADMIN')">
													<th style="text-align: center;">Gỡ bài viết</th>
												</sec:authorize>
											</tr>
										</thead>
										<tbody>
											<c:forEach var="i" begin="1" end="${listApprovedPost.size()}">
												<tr role="row" class="odd">
													<sec:authorize
														access="hasAnyRole('ROLE_EDITOR', 'ROLE_ADMIN')">
														<td><input type="checkbox"
															class="custom-control-input" id="defaultUnchecked"></td>
													</sec:authorize>
													<td style="max-width: 400px" class=""><a href="#"
														onclick="viewPost('${listApprovedPost.get(i-1).getId()}', '${listApprovedPost.get(i-1).getTitle()}')"
														title="Xem bài viết"><c:out
																value="${listApprovedPost.get(i-1).getTitle()}">
															</c:out></a></td>
													<td class="sorting_1"><c:out
															value="${listApprovedPost.get(i-1).getCategories().getName()}"></c:out></td>
													<td><c:out
															value="${listApprovedPost.get(i-1).getAuthor()}"></c:out></td>
													<td><c:out
															value="${listApprovedPost.get(i-1).getUpdatedDate()}"></c:out></td>
													<td><c:out
															value="${listApprovedPost.get(i-1).showPublishedDate()}"></c:out></td>
													<td><c:out
															value="${listApprovedPost.get(i-1).getApprovedUser()}"></c:out></td>
													<td style="text-align: center;"><sec:authorize
															access="hasAnyRole('ROLE_EDITOR', 'ROLE_ADMIN')">
															<a href="#" class="fa fa-remove" title="Gỡ bài viết"
																onclick="openModalUnpublicPost('${listApprovedPost.get(i-1).getId()}', '${listApprovedPost.get(i-1).getTitle()}')"></a>
														</sec:authorize></td>
												</tr>
											</c:forEach>
										</tbody>
									</table>
									<form action="editor/unapproved" method="POST"
										id="form-unpublic-post">
										<div class="modal fade" id="modal-confirm-unpublic">
											<div class="modal-dialog">
												<div class="modal-content">
													<div class="modal-body">
														<input type="hidden" name="pendingpost"
															value="pendingpost">
													</div>
													<div class="modal-footer">
														<button type="button" class="btn btn-secondary"
															data-dismiss="modal">Hủy bỏ</button>
														<button id="btn-unpublic-pots" type="button"
															onclick="unApprovedPost()" data-dismiss="modal"
															class="btn btn-primary">Đồng ý</button>
													</div>
												</div>
												<!-- /.modal-content -->
											</div>
											<!-- /.modal-dialog -->
										</div>
									</form>
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