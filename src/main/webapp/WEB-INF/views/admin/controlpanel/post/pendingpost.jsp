<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
			<div id="thongke">
				<h4>Bài chờ duyệt</h4>
				<div id="filter">
					<span>Tiêu đề:&nbsp;&nbsp;</span> <input
						id="input-search-name-categories"
						onkeyup="searchCategoriesByTitle()"
						placeholder="Tìm theo tiêu đề..." type="text"
						style="width: 300px;" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span>Tên
						chuyên mục:&nbsp;&nbsp;</span> <input id="input-search-name-categories"
						onkeyup="searchCategoriesByName()"
						placeholder="Tìm theo tên chuyên mục..." type="text"
						style="width: 180px;" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span>Tên
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
												<th>STT</th>
												<th>Tiêu đề</th>
												<th>Chuyên mục</th>
												<th>Tác giả</th>
												<th>Ngày tạo</th>
												<th>Ngày xuất bản</th>
												<th></th>
											</tr>
										</thead>
										<tbody>
											<c:forEach var="i" begin="1" end="${listPendingPost.size()}">
												<tr role="row" class="odd">
													<td><c:out value="${i}"></c:out></td>
													<td class=""><c:out
															value="${listPendingPost.get(i-1).getTitle()}"></c:out></td>
													<td class="sorting_1"><c:out
															value="${listPendingPost.get(i-1).getCategories().getName()}"></c:out>
													</td>
													<td><c:out
															value="${listPendingPost.get(i-1).getAuthor()}"></c:out></td>
													<td><c:out
															value="${listPendingPost.get(i-1).getCreatedDate()}"></c:out></td>
													<td><c:out
															value="${listPendingPost.get(i-1).getPublishedDate()}"></c:out></td>
													<td><a href="#" class="fa fa-eye"></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a
														href="#" class="fa fa-pencil"></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a
														href="#" class="fa fa-check"></a></td>
												</tr>
											</c:forEach>
										</tbody>
									</table>
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