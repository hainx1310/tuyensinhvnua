<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div id="wrapper-content">
	<div id="container-content">
		<section class="content-header">
			<h1>
				Quản lý tài khoản <small>Tuyển sinh HVN</small>
			</h1>
			<ol class="breadcrumb">
				<li><a href="${pageContext.request.contextPath}/home"><i
						class="fa fa-home"></i> Trang chủ</a></li>
				<li class="active">Quản lý tài khoản</li>
			</ol>
			<br>
		</section>
		<div style="margin-left: 10px; margin-right: 10px;">
			<!-- Thong ke -->
			<!-- Thong ke -->
			<div id="thongke">
				<h4>Tài khoản</h4>
				<div id="filter">
					<span>Tên tài khoản:&nbsp;&nbsp;</span> <input
						id="input-search-name-user" onkeyup="searchUserByUsername()"
						placeholder="Lọc tài khoản..." type="text" style="width: 300px;" />
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
										<table id="table-user"
											class="table table-bordered table-hover dataTable"
											role="grid" aria-describedby="example2_info">
											<thead>
												<tr role="row">
													<th></th>
													<th>STT</th>
													<th>Tên đăng nhập</th>
													<th>Email</th>
													<th>Trạng thái</th>
													<th>Quyền</th>
													<th>Ngày tạo</th>
													<th>Người tạo</th>
													<th>Ngày sửa</th>
													<th>Người sửa</th>
													<th></th>
												</tr>
											</thead>
											<tbody>
												<c:forEach var="i" begin="1" end="${listUser.size()}">
													<tr role="row" class="odd">
														<td><input type="checkbox"
															class="custom-control-input" id="defaultUnchecked"></td>
														<td class=""><c:out value="${i}" /></td>
														<td id="user-username" class="sorting_1"><c:out
																value="${listUser.get(i-1).getUsername()}" /></td>
														<td id="user-email"><c:out
																value="${listUser.get(i-1).getEmail()}" /></td>
														<td id="user-status"><c:out
																value="${listUser.get(i-1).isStatus()==true ? \"Kích hoạt\" : \"Khóa\"}" /></td>
														<td id="user-role"><c:out
																value="${listUser.get(i-1).getRoleName()}" /></td>
														<td id="user-created-date"><c:out
																value="${listUser.get(i-1).getCreatedDate()}" /></td>
														<td id="user-created-user"><c:out
																value="${listUser.get(i-1).getCreatedUser()}" /></td>
														<td id="user-udapted-date"><c:out
																value="${listUser.get(i-1).getUpdatedDate()}" /></td>
														<td id="user-udapted-user"><c:out
																value="${listUser.get(i-1).getUpdatedUser()}" /></td>
														<td><c:if
																test="${listUser.get(i-1).isStatus()==true}">
																<a id="changeStatusUser"
																	onclick='changeStatusUserById(${listUser.get(i-1).getId()}, ${listUser.get(i-1).isStatus()})'
																	href="#" class="fa fa-toggle-on"></a>
															</c:if> <c:if test="${listUser.get(i-1).isStatus()==false }">
																<a id="changeStatusUser"
																	onclick='changeStatusUserById(${listUser.get(i-1).getId()}, ${listUser.get(i-1).isStatus()})'
																	href="#" class="fa fa-toggle-off"></a>
															</c:if>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a
															onclick='openModalUpdateUser(${listUser.get(i-1).getId()}, "${listUser.get(i-1).getUsername()}", "${listUser.get(i-1).getRoleName()}", ${listUser.get(i-1).isStatus()})'
															href="#" class="fa fa-pencil"></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a
															onclick='openModalDeleteUser(${listUser.get(i-1).getId()}, "${listUser.get(i-1).getUsername()}")'
															href="#" class="fa fa-trash-o"></a></td>
													</tr>
												</c:forEach>
											</tbody>
										</table>
									</c:if>
								</div>
							</div>

							<button type="button" class="btn btn-success" data-toggle="modal"
								data-target="#modal-success" onclick="openModalCreateUser()">Thêm
								mới</button>
							<div class="box-header"></div>

							<c:if test="${totalRecord > 10}">
								<div class="row">
									<div class="col-sm-5">
										<div class="dataTables_info" id="show-data-of-page"
											role="status" aria-live="polite">
											Hiển thị <span id="recored-start">1</span> đến <span
												id="recored-end">${listUser.size()}</span> trong số
											<c:out value="${totalRecord}" />
											mục
										</div>
									</div>
									<div class="col-sm-7">
										<div class="dataTables_paginate paging_simple_numbers"
											id="example2_paginate">
											<ul class="pagination">
												<c:forEach var="i" begin="1" end="${pagesNumber}">
													<li class="paginate_button page-of-user next"
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
					<div class="modal fade" id="modal-user">
						<div class="modal-dialog">
							<div class="modal-content">
								<div class="modal-header">
									<button type="button" class="close" data-dismiss="modal"
										aria-label="Close">
										<span aria-hidden="true">&times;</span>
									</button>
									<h4 class="modal-user-title"></h4>
								</div>
								<form action="add" method="post">
									<div class="modal-body">
										<table
											style="display: table; border-collapse: separate; border-spacing: 10px; border-color: grey">
											<tr>
												<td>Tên đăng nhập:</td>
												<td><input type="text" id="username" name="username"
													size="50%" maxlength="50" autofocus="autofocus"></td>
												<p>${message}</p>
											</tr>
											<tr style="padding-top: 10px">
												<td>Mật khẩu:</td>
												<td><input type="password" id="password"
													name="password" size="50%" maxlength="500"></td>
											</tr>
											<br>
											<tr style>
												<td>Nhập lại mật khẩu:</td>
												<td><input type="password" id="password_again"
													name="passwrod_again" size="50%" maxlength="500"></td>
											</tr>
											<tr>
												<td>Email:</td>
												<td><input type="text" id="email" name="email"
													size="50%" maxlength="50"></td>
											</tr>
											<tr>
												<td>Quyền:</td>
												<td><div class="form-group">
														<select id="select_role"
															class="form-control select2 select2-hidden-accessible"
															style="width: 100%;" tabindex="-1" aria-hidden="true"
															name="role">
															<option selected="selected">---Chọn quyền--</option>
															<option value="ROLE_ADMIN">Quản trị viên</option>
															<option value="ROLE_EDITOR">Biên tập viên</option>
															<option value="ROLE_COLLABORARATORS">Cộng tác viên</option>
														</select>
													</div></td>
											</tr>
											<tr>
												<td>Kích hoạt:</td>
												<td><input type="checkbox" id="user_is_active"
													name="status"></td>
											</tr>
										</table>
									</div>
									<div class="modal-footer">
										<button type="button" class="btn btn-default pull-left"
											data-dismiss="modal">Hủy</button>
										<button id="btn-submit-user" type="submit"
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

					<!-- Modal update user -->
					<div class="modal fade" id="modal-update-user">
						<div class="modal-dialog">
							<div class="modal-content">
								<div class="modal-header">
									<button type="button" class="close" data-dismiss="modal"
										aria-label="Close">
										<span aria-hidden="true">&times;</span>
									</button>
									<h4 class="modal-user-title">Cập nhật thành viên</h4>
								</div>
								<form action="EditUser" method="post">
									<div class="modal-body">
										<table
											style="display: table; border-collapse: separate; border-spacing: 10px; border-color: grey">
											<tr>
												<td>Tên đăng nhập:</td>
												<td id="username"></td>
											</tr>
											<tr>
												<td>Quyền:</td>
												<td><div class="form-group">
														<select id="select_role"
															class="form-control select2 select2-hidden-accessible"
															style="width: 100%;" tabindex="-1" aria-hidden="true"
															name="role">
															<option selected="selected">---Chọn quyền--</option>
															<option value="ROLE_ADMIN">Quản trị viên</option>
															<option value="ROLE_EDITOR">Biên tập viên</option>
															<option value="ROLE_COLLABORARATORS">Cộng tác viên</option>
														</select>
													</div></td>
											</tr>
											<tr>
												<td>Kích hoạt:</td>
												<td><input type="checkbox" id="user_is_active"
													name="status"></td>
											</tr>
										</table>
									</div>
									<div class="modal-footer">
										<button type="button" class="btn btn-default pull-left"
											data-dismiss="modal">Hủy</button>
										<button id="btn-submit-user" type="submit"
											class="btn btn-primary">Lưu</button>
									</div>
								</form>
							</div>
							<!-- /.modal-content -->
						</div>
						<!-- /.modal-dialog -->
					</div>
					<!-- End modal update user -->

					<!-- Start modal delete user -->
					<div class="modal fade" id="modal-confirm-delete">
						<div class="modal-dialog">
							<div class="modal-content">
								<form action="DeleteUser" method="post">
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
					<!-- End modal delete user -->
				</div>
			</div>
		</div>
	</div>
</div>