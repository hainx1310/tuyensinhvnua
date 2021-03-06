<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div id="wrapper-content">
	<div id="container-content">
		<section class="content-header">
			<h1>
				Quản lý chuyên mục <small>Tuyển sinh HVN</small>
			</h1>
			<ol class="breadcrumb">
				<li><a href="${pageContext.request.contextPath}/home"><i
						class="fa fa-home"></i> Trang chủ</a></li>
				<li class="active">Quản lý nội dung</li>
				<li class="active">Quản lý chuyên mục</li>
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
									<div id="example2_filter" class="dataTables_filter">
										<label>Lọc:<input id="input-search-name-categories"
											type="search" onkeyup="searchCategoriesByName()"
											class="form-control input-sm" placeholder=""
											aria-controls="example2"></label>
										<button type="button" class="btn btn-success"
											data-toggle="modal" data-target="#modal-success"
											id="btn-categorites-clcik">Thêm</button>
									</div>
									<table id="table-categories"
										class="table table-bordered table-striped" role="grid"
										aria-describedby="example2_info">
										<thead>
											<tr role="row">
												<th><input type="checkbox" class="custom-control-input"
													id="defaultUnchecked"></th>
												<th>STT</th>
												<th>Tên chuyên mục</th>
												<th>Trạng thái</th>
												<th>Ngày tạo</th>
												<th>Người tạo</th>
												<th>Ngày sửa</th>
												<th>Người sửa</th>
												<th style="text-align: center;">Hành động</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach var="i" begin="1" end="${listCategories.size()}">
												<tr role="row" class="odd">
													<td><input type="checkbox"
														class="custom-control-input" id="defaultUnchecked"></td>
													<td class=""><c:out value="${i}" /></td>
													<td style="max-width: 400px" id="categories-name"
														class="sorting_1"><c:out
															value="${listCategories.get(i-1).getName()}" /></td>
													<td id="categories-status"><c:out
															value="${listCategories.get(i-1).isStatus()==true ? \"Kích hoạt\" : \"Khóa\"}" /></td>
													<td id="categories-created-date"><c:out
															value="${listCategories.get(i-1).getCreatedDate()}" /></td>
													<td id="categories-created-user"><c:out
															value="${listCategories.get(i-1).getCreatedUser()}" /></td>
													<td id="categories-updated-date"><c:out
															value="${listCategories.get(i-1).getUpdatedDate()}" /></td>
													<td id="categories-updated-user"><c:out
															value="${listCategories.get(i-1).getUpdatedUser()}" /></td>
													<td style="text-align: center;"><c:if
															test="${listCategories.get(i-1).isStatus() == true}">
															<a title="Khóa chuyên mục" id="changeStatusCategories"
																onclick='openModalChangeStatusCategories(${listCategories.get(i-1).getId()}, ${listCategories.get(i-1).isStatus()})'
																href="#" class="fa fa-toggle-on"></a>
														</c:if> <c:if
															test="${listCategories.get(i-1).isStatus() == false}">
															<a title="Kích hoạt chuyên mục"
																id="changeStatusCategories"
																onclick='openModalChangeStatusCategories(${listCategories.get(i-1).getId()}, ${listCategories.get(i-1).isStatus()})'
																href="#" class="fa fa-toggle-off"></a>
														</c:if>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a
														title="Sửa"
														onclick='openModalUpdateCategories(${listCategories.get(i-1).getId()}, "${listCategories.get(i-1).getName()}", ${listCategories.get(i-1).isStatus()})'
														href="#" class="fa fa-pencil"></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a
														title="Xóa"
														onclick='openModalDeleteCategories(${listCategories.get(i-1).getId()}, "${listCategories.get(i-1).getName()}")'
														href="#" class="fa fa-trash-o"></a></td>
												</tr>
											</c:forEach>
										</tbody>
									</table>
								</div>
							</div>

							<c:if test="${totalrRecord > 5}">
								<div class="row">
									<div class="col-sm-5">
										<div class="dataTables_info" id="show-data-of-page"
											role="status" aria-live="polite">
											Hiển thị <span id="recored-start">1</span> đến <span
												id="recored-end">${listCategories.size()}</span> trong số
											<c:out value="${totalrRecord}" />
											kết quả
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
					<div class="modal fade" id="modal-create-categories">
						<div class="modal-dialog">
							<div class="modal-content">
								<div class="modal-header">
									<button type="button" class="close" data-dismiss="modal"
										aria-label="Close">
										<span aria-hidden="true">&times;</span>
									</button>
									<h4>Thêm chuyên mục mới</h4>
								</div>
								<form action="AddCategories" method="post">
									<div class="modal-body">
										<table
											style="display: table; border-collapse: separate; border-spacing: 10px; border-color: grey">
											<tr>
												<td>Tên chuyên mục:</td>
												<td><input type="text" id="name" name="name" size="50%"
													maxlength="50" autofocus="autofocus"></td>
											</tr>
											<tr>
												<td>Kích hoạt:</td>
												<td><input type="checkbox" id="categories-is-active"
													name="status"></td>
											</tr>
										</table>
									</div>
									<div class="modal-footer">
										<button type="button" class="btn btn-secondary"
											data-dismiss="modal">Hủy</button>
										<button id="btn-save" type="submit" class="btn btn-primary">Lưu</button>
									</div>
								</form>
							</div>
							<!-- /.modal-content -->
						</div>
						<!-- /.modal-dialog -->
					</div>
					<!-- /.modal -->
					<!-- /.box-body -->

					<div class="modal fade" id="modal-update-categories">
						<div class="modal-dialog">
							<div class="modal-content">
								<div class="modal-header">
									<button type="button" class="close" data-dismiss="modal"
										aria-label="Close">
										<span aria-hidden="true">&times;</span>
									</button>
									<h4>Cập nhật chuyên mục</h4>
								</div>
								<form action="EditCategories" method="post">
									<div class="modal-body">
										<table
											style="display: table; border-collapse: separate; border-spacing: 10px; border-color: grey">
											<tr>
												<td>Tên chuyên mục:</td>
												<td><input type="text" id="name" name="name" size="50%"
													maxlength="50" autofocus="autofocus"></td>
											</tr>
											<tr>
												<td>Kích hoạt:</td>
												<td><input type="checkbox" id="categories-is-active"
													name="status"></td>
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

					<div class="modal fade" id="modal-confirm-delete">
						<div class="modal-dialog">
							<div class="modal-content">
								<form action="DeleteCategories" method="post">
									<div class="modal-body"></div>
									<div class="modal-footer">
										<button type="button" class="btn btn-secondary"
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