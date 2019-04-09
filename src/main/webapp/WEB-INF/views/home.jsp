<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<div id="titleContent">
	<h2>Trang chủ</h2>
	<hr>
</div>

<div>
	<!-- Thong ke -->
	<div id="thongke">
		<h5>Thống kê</h5>
		<a href="pendingpost">(57) Bài chờ duyệt</a>, <a href="pendingpost">(1)
			Bài đã duyệt</a>
	</div>
	<br>

	<div>
		<div class="box">
			<div class="box-header">
				<h5 class="box-title">Bài mới cập nhật</h5>
			</div>
			<!-- /.box-header -->
			<div class="box-body">
				<div id="example2_wrapper"
					class="dataTables_wrapper form-inline dt-bootstrap">
					<div class="row">
						<div class="col-sm-6"></div>
						<div class="col-sm-6"></div>
					</div>
					<div class="row">
						<div class="col-sm-12">
							<table id="example2"
								class="table table-bordered table-hover dataTable" role="grid"
								aria-describedby="example2_info">
								<thead>
									<tr role="row">
										<th>Tiêu đề</th>
										<th>Chuyên mục</th>
										<th>Ngày sửa cuối</th>
										<th>Ngày xuất bản</th>
										<th>Tác giả</th>
										<th>Người đăng cuối</th>
										<th></th>
									</tr>
								</thead>
								<tbody>
									<tr role="row" class="odd">
										<td class="">Chất lượng đào tạo hàng đầu Việt Nam</td>
										<td class="sorting_1">Vì sao chọn HVN</td>
										<td>05/04/2019 01:14:01 AM</td>
										<td></td>
										<td>Hainx</td>
										<td>Administrator</td>
										<td><a
											href="${pageContext.request.contextPath}/editpost?postId=1">Sửa
												bài|</a><a href="#">Xem trên mobile</a></td>
									</tr>
									<tr role="row" class="odd">
										<td class="">Đội ngũ giảng viên trình độ cao</td>
										<td class="sorting_1">Vì sao chọn HVN</td>
										<td>05/04/2019 01:14:01 AM</td>
										<td></td>
										<td>Hainx</td>
										<td>Administrator</td>
										<td><a
											href="${pageContext.request.contextPath}/editpost?postId=2">Sửa
												bài</a></td>
									</tr>
									<tr role="row" class="odd">
										<td class="">Diều kiện cơ sở vật chất khang trang, chất
											lượng cao</td>
										<td class="sorting_1">Vì sao chọn HVN</td>
										<td>05/04/2019 01:14:01 AM</td>
										<td></td>
										<td>Hainx</td>
										<td>Administrator</td>
										<td><a href="newpost">Sửa bài</a></td>
									</tr>
									<tr role="row" class="odd">
										<td class="">Điều kiện sống và sinh hoạt thuận tiện</td>
										<td class="sorting_1">Vì sao chọn HVN</td>
										<td>05/04/2019 01:14:01 AM</td>
										<td></td>
										<td>Administrator</td>
										<td>Administrator</td>
										<td><a
											href="${pageContext.request.contextPath}/editpost?postId=3">Sửa
												bài</a></td>
									</tr>
									<tr role="row" class="odd">
										<td class="">Cơ hội việc làm rộng mở</td>
										<td class="sorting_1">Vì sao chọn HVN</td>
										<td>05/04/2019 01:14:01 AM</td>
										<td></td>
										<td>Administrator</td>
										<td>Administrator</td>
										<td><a
											href="${pageContext.request.contextPath}/editpost?postId=9">Sửa
												bài</a></td>
									</tr>
									<tr role="row" class="odd">
										<td class="">Thông tin tuyển sinh 2019</td>
										<td class="sorting_1">Thông tin tuyển sinh</td>
										<td>05/04/2019 01:14:01 AM</td>
										<td></td>
										<td>Administrator</td>
										<td>Administrator</td>
										<td><a
											href="${pageContext.request.contextPath}/editpost?postId=4">Sửa
												bài</a></td>
									</tr>
									<tr role="row" class="odd">
										<td class="">Ngành công nghệ thông tin</td>
										<td class="sorting_1">Ngành đào tạo</td>
										<td>05/04/2019 01:14:01 AM</td>
										<td></td>
										<td>Administrator</td>
										<td>Administrator</td>
										<td><a
											href="${pageContext.request.contextPath}/editpost?postId=8">Sửa
												bài</a></td>
									</tr>
									<tr role="row" class="odd">
										<td class="">Ngành bảo vệ thực vật</td>
										<td class="sorting_1">Ngành đào tạo</td>
										<td>05/04/2019 01:14:01 AM</td>
										<td></td>
										<td>Administrator</td>
										<td>Administrator</td>
										<td><a
											href="${pageContext.request.contextPath}/editpost?postId=5">Sửa
												bài</a></td>
									</tr>
									<tr role="row" class="odd">
										<td class="">Cơ hội hoạt động ngoại khóa và hoạt động xã
											hội phong phú</td>
										<td class="sorting_1">Vì sao chọn HVN</td>
										<td>05/04/2019 01:14:01 AM</td>
										<td></td>
										<td>Administrator</td>
										<td>Administrator</td>
										<td><a
											href="${pageContext.request.contextPath}/editpost?postId=6">Sửa
												bài</a></td>
									</tr>
									<tr role="row" class="odd">
										<td class="">Chương trình đào tạo tiên tiến, chất lượng
											cao</td>
										<td class="sorting_1">Ngành đào tạo</td>
										<td>05/04/2019 01:14:01 AM</td>
										<td></td>
										<td>Administrator</td>
										<td>Administrator</td>
										<td><a
											href="${pageContext.request.contextPath}/editpost?postId=7">Sửa
												bài</a></td>
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
										href="#" aria-controls="example2" data-dt-idx="7" tabindex="0">Next</a></li>
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
