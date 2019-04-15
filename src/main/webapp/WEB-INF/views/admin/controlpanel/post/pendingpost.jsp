<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

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
											<th>Tiêu đề</th>
											<th>Chuyên mục</th>
											<th>Tác giả</th>
											<th>Thời gian sửa</th>
											<th>Thời gian xuất bản</th>
											<th></th>
										</tr>
									</thead>
									<tbody>
										<tr role="row" class="odd">
											<td>1</td>
											<td class="">Chất lượng đào tạo hàng đầu Việt Nam</td>
											<td class="sorting_1">Vì sao chọn HVN</td>
											<td>Hainx</td>
											<td>05/04/2019 01:14:01 AM</td>
											<td>05/04/2019 01:14:01 AM</td>
											<td><a href="newpost"> Duyệt bài </a></td>
										</tr>
										<tr role="row" class="odd">
											<td>2</td>
											<td class="">Đội ngũ giảng viên trình độ cao</td>
											<td class="sorting_1">Vì sao chọn HVN</td>
											<td>HaiNX</td>
											<td>05/04/2019 01:14:01 AM</td>
											<td>05/04/2019 01:14:01 AM</td>
											<td><a href="newpost"> Duyệt bài </a></td>
										</tr>
										<tr role="row" class="odd">
											<td>3</td>
											<td class="">Diều kiện cơ sở vật chất khang trang, chất
												lượng cao</td>
											<td class="sorting_1">Vì sao chọn HVN</td>
											<td>HaiNX</td>
											<td>05/04/2019 01:14:01 AM</td>
											<td>05/04/2019 01:14:01 AM</td>
											<td><a href="newpost"> Duyệt bài </a></td>
										</tr>
										<tr role="row" class="odd">
											<td>4</td>
											<td class="">Điều kiện sống và sinh hoạt thuận tiện</td>
											<td class="sorting_1">Vì sao chọn HVN</td>
											<td>HaiNX</td>
											<td>05/04/2019 01:14:01 AM</td>
											<td>05/04/2019 01:14:01 AM</td>
											<td><a href="newpost"> Duyệt bài </a></td>
										</tr>
										<tr role="row" class="odd">
											<td>5</td>
											<td class="">Cơ hội việc làm rộng mở</td>
											<td class="sorting_1">Vì sao chọn HVN</td>
											<td>HaiNX</td>
											<td>05/04/2019 01:14:01 AM</td>
											<td>05/04/2019 01:14:01 AM</td>
											<td><a href="newpost"> Duyệt bài </a></td>
										</tr>
										<tr role="row" class="odd">
											<td>6</td>
											<td class="">Thông tin tuyển sinh 2019</td>
											<td class="sorting_1">Thông tin tuyển sinh</td>
											<td>HaiNX</td>
											<td>05/04/2019 01:14:01 AM</td>
											<td>05/04/2019 01:14:01 AM</td>
											<td><a href="newpost"> Duyệt bài </a></td>
										</tr>
										<tr role="row" class="odd">
											<td>7</td>
											<td class="">Ngành công nghệ thông tin</td>
											<td class="sorting_1">Ngành đào tạo</td>
											<td>HaiNX</td>
											<td>05/04/2019 01:14:01 AM</td>
											<td>05/04/2019 01:14:01 AM</td>
											<td><a href="newpost"> Duyệt bài </a></td>
										</tr>
										<tr role="row" class="odd">
											<td>8</td>
											<td class="">Ngành bảo vệ thực vật</td>
											<td class="sorting_1">Ngành đào tạo</td>
											<td>HaiNX</td>
											<td>05/04/2019 01:14:01 AM</td>
											<td>05/04/2019 01:14:01 AM</td>
											<td><a href="newpost"> Duyệt bài </a></td>
										</tr>
										<tr role="row" class="odd">
											<td>9</td>
											<td class="">Cơ hội hoạt động ngoại khóa và hoạt động xã
												hội phong phú</td>
											<td class="sorting_1">Vì sao chọn HVN</td>
											<td>HaiNX</td>
											<td>05/04/2019 01:14:01 AM</td>
											<td>05/04/2019 01:14:01 AM</td>
											<td><a href="newpost"> Duyệt bài </a></td>
										</tr>
										<tr role="row" class="odd">
											<td>10</td>
											<td class="">Chương trình đào tạo tiên tiến, chất lượng
												cao</td>
											<td class="sorting_1">Ngành đào tạo</td>
											<td>HaiNX</td>
											<td>05/04/2019 01:14:01 AM</td>
											<td>05/04/2019 01:14:01 AM</td>
											<td><a href="newpost"> Duyệt bài </a></td>
										</tr>
									</tbody>
								</table>
							</div>
						</div>
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
				<!-- /.box-body -->
			</div>
		</div>
	</div>
</div>