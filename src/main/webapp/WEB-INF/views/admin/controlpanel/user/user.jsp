<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<div id="wrapper-content">
	<div id="container-content">
		<section class="content-header">
			<h1>
				Quản lý thành viên <small>Tuyển sinh HVN</small>
			</h1>
			<ol class="breadcrumb">
				<li><a href="${pageContext.request.contextPath}/home"><i
						class="fa fa-home"></i> Trang chủ</a></li>
				<li class="active">Quản lý thành viên</li>
				<li class="active">Quản lý thành viên</li>
			</ol>
			<br>
		</section>
		<div style="margin-left: 10px; margin-right: 10px;">
			<!-- Thong ke -->
			<div id="thongke">
				<h4>Thành viên</h4>
				<tbody>
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
												<th>Tên đăng nhập</th>
												<th>Email</th>
												<th>Trạng thái</th>
												<th>Ngày tạo</th>
												<th>Người tạo</th>
												<th>Ngày sửa</th>
												<th>Người sửa</th>
												<th></th>
											</tr>
										</thead>
										<tbody>
											<tr role="row" class="odd">
												<td>1</td>
												<td class="">editor01</td>
												<td class="sorting_1">admin@vnua.edu.vn</td>
												<td>Kích hoạt</td>
												<td>10/04/2019</td>
												<td>administrator</td>
												<td></td>
												<td></td>
												<td><a
													href="${pageContext.request.contextPath}/editpost?postId=1">Đổi
														trạng thái</a> | <a id="update_user" href="#">Sửa</a> | <a
													href="#">Xóa</a></td>
											</tr>
										</tbody>
									</table>
								</div>
							</div>

							<button type="button" class="btn btn-success" data-toggle="modal"
								data-target="#modal-success" onclick="openModalCreateUser()">Thêm
								mới</button>
							<div class="box-header"></div>

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
															<option value="0">Biên tập viên</option>
															<option value="1">Quản trị viên</option>
														</select>
													</div></td>
											</tr>
											<tr>
												<td>Kích hoạt:</td>
												<td><input type="checkbox" id="role_is_admin"
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
				</div>
			</div>
		</div>
	</div>
</div>