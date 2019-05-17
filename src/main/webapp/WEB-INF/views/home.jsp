<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<div id="wrapper-content">
	<div id="container-content">
		<section class="content-header">
			<h1>
				Trang chủ <small>Tuyển sinh HVN</small>
			</h1>
			<br>
		</section>


		<div style="margin-left: 10px; margin-right: 10px;">
			<div class="box">
				<div class="box-header">
					<!-- Thong ke -->
					<div id="thongke">
						<h4>Thống kê</h4>
						<a href="${pageContext.request.contextPath}/post/pending">(${pendingPosts})
							Bài chờ duyệt</a>, <a
							href="${pageContext.request.contextPath}/post/approved">(${approvedPosts})
							Bài đã duyệt</a>
					</div>
				</div>
				<h5 class="box-title">Bài mới đăng</h5>
				<div class="box-body">
					<div id="example2_wrapper"
						class="dataTables_wrapper form-inline dt-bootstrap">
						<div class="row">
							<div class="col-sm-12">
								<table id="example2"
									class="table table-bordered table-hover dataTable" role="grid"
									aria-describedby="example2_info">
									<thead>
										<tr role="row">
											<th>STT</th>
											<th>Tiêu đề</th>
											<th>Chuyên mục</th>
											<th>Thời gian đăng</th>
											<th>Tác giả</th>
											<th>Người đăng cuối</th>
											<th></th>
										</tr>
									</thead>
									<tbody>
										<c:forEach var="i" begin="1" end="${listPublishedPost.size()}">
											<tr role="row" class="odd">
												<td><c:out value="${i }"></c:out></td>
												<td class=""><c:out
														value="${listPublishedPost.get(i-1).getTitle()}"></c:out></td>
												<td class="sorting_1"><c:out
														value="${listPublishedPost.get(i-1).getCategories().getName()}"></c:out></td>
												<td><c:out
														value="${listPublishedPost.get(i-1).getPublishedDate()}"></c:out></td>
												<td><c:out
														value="${listPublishedPost.get(i-1).getAuthor()}"></c:out></td>
												<td><c:out
														value="${listPublishedPost.get(i-1).getAuthor()}"></c:out></td>
												<td><a href="#"
													onclick="viewPostHome('${listPublishedPost.get(i-1).getId()}', '${listPublishedPost.get(i-1).getTitle()}')"
													class="fa fa-eye" title="Xem bài viết"></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a
													href="#" class="fa fa-pencil" title="Sửa bài viết"
													onclick="editPostHome('${listPublishedPost.get(i-1).getId()}')"></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<sec:authorize
														access="hasAnyRole('ROLE_EDITOR', 'ROLE_ADMIN')">
														<a href="#" class="fa fa-remove" title="Gỡ bài viết"
															onclick="unApprovedPost('${listPublishedPost.get(i-1).getId()}')"></a>
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
											<div class="modal-body">
											</div>
										</div>
										<!-- /.modal-content -->
									</div>
									<!-- /.modal-dialog -->
								</div>
								<!-- /.modal -->
							</div>
						</div>
					</div>
				</div>
				<!-- /.box-body -->
			</div>
		</div>
	</div>
</div>