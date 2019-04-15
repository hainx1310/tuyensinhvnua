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
			<!-- Thong ke -->
			<div id="thongke">
				<h4>Chuyên mục</h4>
				<tbody id="filter">
					<tr class="odd">
						<td style="width: 220px; padding-left: 10px;" valign="middle">
							<span>Trạng thái:&nbsp;&nbsp;</span> <select
							name="ctl00$plhContent$ddlStatus" id="plhContent_ddlStatus"
							style="width: 100px;">
								<option value="">[Tất cả]</option>
								<option selected="selected" value="true">Kích hoạt</option>
								<option value="false">Khóa</option>

						</select>
						</td>
						<td style="width: 220px;" valign="middle"><span>Quyền:&nbsp;&nbsp;</span>
							<select name="ctl00$plhContent$ddlRoles" id="plhContent_ddlRoles"
							style="width: 120px;">
								<option value="">[Tất cả]</option>
								<option value="Administrators">Administrators</option>
								<option value="AdvertisementManagemer">AdvertisementManagemer</option>
								<option value="AllUsers">AllUsers</option>
								<option value="Biên tập viên">Biên tập viên</option>
								<option value="Guests">Guests</option>
								<option selected="selected" value="Moderators">Moderators</option>
								<option value="phóng viên">phóng viên</option>
								<option value="quản trị">quản trị</option>
								<option value="quyencaonhat">quyencaonhat</option>
								<option value="siteadmin">siteadmin</option>
								<option value="Users">Users</option>

						</select></td>
						<td style="width: 220px;" valign="middle"><span>Tìm
								theo:&nbsp;&nbsp;</span> <select name="ctl00$plhContent$ddlSearchBy"
							id="plhContent_ddlSearchBy" style="width: 130px;">
								<option selected="selected" value="UserName">Tên đăng
									nhập</option>
								<option value="Email">Email</option>

						</select></td>
						<td style="width: 295px; text-align: right;"><span>Từ
								khóa:&nbsp;&nbsp;</span> <input name="ctl00$plhContent$txtKeyword"
							type="text" id="plhContent_txtKeyword" style="width: 190px;">
						</td>
						<td style="text-align: right; padding-right: 45px;"
							valign="middle"><input type="button"
							name="ctl00$plhContent$btnSearch" value="Tìm kiếm"
							onclick="javascript:__doPostBack('ctl00$plhContent$btnSearch','')"
							id="plhContent_btnSearch" style="height: 26px; width: 80px;">
							<div id="plhContent_spin" style="display: none;"></div></td>
					</tr>
				</tbody>
			</div>
			<div>
				<div class="box">
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
												<th>Tên chuyên mục</th>
												<th>Trạng thái</th>
												<th>Ngày tạo</th>
												<th>Người tạo</th>
												<th>Ngày sửa</th>
												<th>Người sửa</th>
												<th></th>
											</tr>
										</thead>
										<tbody>
											<c:forEach var="i" begin="1" end="${listCategories.size()}">
												<div class="radio">
													<tr role="row" class="odd">
														<td class=""><c:out value="${i}" /></td>
														<td id="categories-name" class="sorting_1"><c:out
																value="${listCategories.get(i-1).getName()}" /></td>
														<td id="categories-status"><c:out
																value="${listCategories.get(i-1).isStatus()==true ? \"Kích hoạt\" : \"Đang ẩn\"}" /></td>
														<td id="categories-created-date"><c:out
																value="${listCategories.get(i-1).getCreatedDate()}" /></td>
														<td id="categories-created-user">administrator</td>
														<td id="categories-updated-date"><c:out
																value="${listCategories.get(i-1).getUpdatedDate()}" /></td>
														<td id="categories-updated-user"><c:out
																value="${listCategories.get(i-1).getUpdatedUser()}" /></td>
														<td><a id="changeStatusCategories"
															onclick='openModalChangeStatusCategories(${listCategories.get(i-1).getId()}, ${listCategories.get(i-1).isStatus()})'
															href="#">Đổi trạng thái</a> | <a
															onclick='openModalUpdateCategories(${listCategories.get(i-1).getId()}, "${listCategories.get(i-1).getName()}", ${listCategories.get(i-1).isStatus()})'
															href="#">Sửa</a> | <a
															onclick='openModalDeleteCategories(${listCategories.get(i-1).getId()}, "${listCategories.get(i-1).getName()}")'
															href="#">Xóa</a></td>
													</tr>
												</div>
											</c:forEach>

										</tbody>
									</table>
								</div>
							</div>

							<button type="button" class="btn btn-success" data-toggle="modal"
								data-target="#modal-success" id="btn-categorites-clcik">Thêm
								mới</button>

							<div class="row">
								<div class="col-sm-5">
									<div class="dataTables_info" id="example2_info" role="status"
										aria-live="polite">Hiển thị 1 đến 10 trong số 57 mục</div>
								</div>
								<div class="col-sm-7">
									<div class="dataTables_paginate paging_simple_numbers"
										id="example2_paginate">
										<ul class="pagination">
											<li class="paginate_button previous disabled"
												id="example2_previous"><a href="#"
												aria-controls="example2" data-dt-idx="0" tabindex="0">Đầu</a></li>
											<li class="paginate_button active"><a href="#"
												aria-controls="example2" data-dt-idx="1" tabindex="0">1</a></li>
											<li class="paginate_button "><a href="#"
												aria-controls="example2" data-dt-idx="2" tabindex="0">2</a></li>
											<li class="paginate_button "><a href="#"
												aria-controls="example2" data-dt-idx="3" tabindex="0">3</a></li>
											<li class="paginate_button "><a href="#"
												aria-controls="example2" data-dt-idx="4" tabindex="0">4</a></li>
											<li class="paginate_button "><a href="#"
												aria-controls="example2" data-dt-idx="5" tabindex="0">5</a></li>
											<li class="paginate_button "><a href="#"
												aria-controls="example2" data-dt-idx="6" tabindex="0">6</a></li>
											<li class="paginate_button next" id="example2_next"><a
												href="#" aria-controls="example2" data-dt-idx="7"
												tabindex="0">Next</a></li>
										</ul>
									</div>
								</div>
							</div>
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
										<button type="button" class="btn btn-default pull-left"
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
									<h4>Sửa chuyên mục</h4>
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

					<div class="modal fade" id="modal-delete-categories">
						<div class="modal-dialog">
							<div class="modal-content">
								<form action="DeleteCategories" method="post">
									<div class="modal-body"></div>
									<div class="modal-footer">
										<button type="button" class="btn btn-default pull-left"
											data-dismiss="modal">Không</button>
										<button id="btn-delete-categories" type="submit"
											class="btn btn-primary">Có</button>
									</div>
								</form>
							</div>
							<!-- /.modal-content -->
						</div>
						<!-- /.modal-dialog -->
					</div>

					<div class="modal fade" id="modal-cahngeStatus-categories">
						<div class="modal-dialog">
							<div class="modal-content">
								<form action="ChangeStatusCategories" method="post">
									<div class="modal-body"></div>
									<div class="modal-footer">
										<button type="button" class="btn btn-default pull-left"
											data-dismiss="modal">Không</button>
										<button id="btn-cahngeStatus-categories" type="submit"
											class="btn btn-primary">Có</button>
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