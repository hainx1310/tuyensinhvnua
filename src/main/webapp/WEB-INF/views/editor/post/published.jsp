<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<div id="wrapper-content">
	<div id="container-content">
		<section class="content-header">
			<h1>
				Bài đã đăng <small>Tuyển sinh HVN</small>
			</h1>
			<ol class="breadcrumb">
				<li><a href="${pageContext.request.contextPath}/home"><i
						class="fa fa-home"></i> Trang chủ</a></li>
				<li class="active">Bài viết</li>
				<li><a href="">Bài đã đăng</a></li>
			</ol>
			<br>
		</section>

		<div style="margin-left: 10px; margin-right: 10px;">
			<div class="box">
				<div class="box-body">
					<div id="example1_wrapper"
						class="dataTables_wrapper form-inline dt-bootstrap">
						<div class="row">
							<div class="col-sm-12">
								<c:if test="${totalRecord == 0}">
									<p>Không có dữ liệu để hiển thị</p>
								</c:if>
								<c:if test="${totalRecord > 0}">
									<table id="example2" class="table table-bordered table-striped">
										<thead>
											<tr role="row">
												<th><input type="checkbox" class="custom-control-input"
													id="defaultUnchecked"></th>
												<th>STT</th>
												<th>Tiêu đề</th>
												<th>Chuyên mục</th>
												<th>Thời gian đăng bài</th>
												<th>Tác giả</th>
												<th>Người duyệt</th>
												<th></th>
											</tr>
										</thead>
										<tbody>
											<c:forEach var="i" begin="1"
												end="${listPublishedPost.size()}">
												<tr role="row" class="odd">
													<td><input type="checkbox"
														class="custom-control-input" id="defaultUnchecked"></td>
													<td><c:out value="${i }"></c:out></td>
													<td class=""><c:out
															value="${listPublishedPost.get(i-1).getTitle()}"></c:out></td>
													<td class="sorting_1"><c:out
															value="${listPublishedPost.get(i-1).getCategories().getName()}"></c:out></td>
													<td><c:out
															value="${listPublishedPost.get(i-1).showPublishedDate()}"></c:out></td>
													<td><c:out
															value="${listPublishedPost.get(i-1).getAuthor()}"></c:out></td>
													<td><c:out
															value="${listPublishedPost.get(i-1).getApprovedUser()}"></c:out></td>
													<td><a href="#" class="fa fa-eye"
														onclick="viewPost('${listPublishedPost.get(i-1).getId()}', '${listPublishedPost.get(i-1).getTitle()}')"
														title="Xem bài viết"></a>
													<sec:authorize
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
					</div>
				</div>
				<!-- /.box-body -->
			</div>
		</div>
	</div>
</div>
