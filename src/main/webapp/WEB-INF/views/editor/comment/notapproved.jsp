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
				Bình luận không được duyệt<small>Tuyển sinh HVN</small>
			</h1>
			<ol class="breadcrumb">
				<li><a href="${pageContext.request.contextPath}/home"><i
						class="fa fa-home"></i> Trang chủ</a></li>
				<li class="active">Bình luận không được duyệt</li>
			</ol>
			<br>
		</section>
		<div style="margin-left: 10px; margin-right: 10px;">
			<div>
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
										<table id="table-comment-notapproved"
											class="table table-bordered table-striped" role="grid"
											aria-describedby="example2_info">
											<thead>
												<tr role="row">
													<th><input type="checkbox"
														class="custom-control-input" id="defaultUnchecked"></th>
													<th>STT</th>
													<th>Bài viết</th>
													<th>Nội dung bình luận</th>
													<th>Người bình luận</th>
													<th>Thời gian bình luận</th>
													<th style="text-align: center;">Duyệt</th>
												</tr>
											</thead>
											<tbody>
												<c:forEach var="i" begin="1" end="${listComment.size()}">
													<tr role="row" class="odd">
														<td><input type="checkbox"
															class="custom-control-input" id="defaultUnchecked"></td>
														<td class=""><c:out value="${i}" /></td>
														<td style="max-width: 400px" id="user-username"
															class="sorting_1"><c:out
																value="${listComment.get(i-1).getpost().getTitle()}" /></td>
														<td style="max-width: 200px" id="user-username"
															class="sorting_1"><c:out
																value="${listComment.get(i-1).getComment()}" /></td>
														<td id="user-email"><c:out
																value="${listComment.get(i-1).getName()}" /></td>
														<td id="user-role"><c:out
																value="${listComment.get(i-1).showCreatedDate()}" /></td>
														<td style="text-align: center;"><form
																id="form-approved-comment-${i}" action="editor/approved"
																method="POST">
																<input name="commentId" type="hidden"
																	value="${listComment.get(i-1).getId()}"><input
																	name="unapporved" type="hidden" value="unapporved"><a
																	href="#" class="fa fa-check" title="Duyệt"
																	onclick='approvedComment("${i}")'></a>
															</form></td>
													</tr>
												</c:forEach>
											</tbody>
										</table>
									</c:if>
								</div>
							</div>
							<c:if test="${totalRecord > 5}">
								<div class="row">
									<div class="col-sm-5">
										<div class="dataTables_info" id="show-data-of-page"
											role="status" aria-live="polite">
											Hiển thị <span id="recored-start">1</span> đến <span
												id="recored-end">${listComment.size()}</span> trong số
											<c:out value="${totalRecord}" />
											mục
										</div>
									</div>
									<div class="col-sm-7">
										<div class="dataTables_paginate paging_simple_numbers"
											id="example2_paginate">
											<ul class="pagination">
												<c:forEach var="i" begin="1" end="${pagesNumber}">
													<li
														class="paginate_button page-of-comment-notapproved next"
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
				</div>
			</div>
		</div>
	</div>
</div>
