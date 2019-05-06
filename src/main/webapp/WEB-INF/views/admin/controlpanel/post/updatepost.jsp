<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div id="wrapper-content">
	<div id="container-content">
		<section class="content-header">
			<h1>
				Sửa bài viết <small>Tuyển sinh HVN</small>
			</h1>
			<ol class="breadcrumb">
				<li><a href="${pageContext.request.contextPath}/home"><i
						class="fa fa-home"></i> Trang chủ</a></li>
				<li class="active">Bài viết</li>
				<li class="active">Sửa bài viêt</li>
			</ol>
			<br>
		</section>

		<div style="margin-left: 10px; margin-right: 10px;">
			<div class="box">
				<div class="box-body">
					<div id="example2_wrapper"
						class="dataTables_wrapper form-inline dt-bootstrap">
						<div class="row">
							<div class="col-sm-12">
								<div class="row">
									<div class="col-sm-8" style="margin-left: 10px">
										<c:if test="${1==1 }">
											<div>
												<h4>Tiêu đề bài viết (*)</h4>
												<input style="margin-right: 0px; width: 100%" type="text"
													placeholder="Tiêu đề bài viết" id="title"
													value="${post.getTitle()}" />
											</div>
										</c:if>
										<div>
											<h4>Địa chỉ bài viết (*)</h4>
											<input name="url" style="margin-right: 0px; width: 100%"
												type="text" placeholder="Địa chỉ bài viết" id="url"
												value="${post.getUrl()}" />
										</div>
										<div>
											<h4>Tóm tắt (*)</h4>
											<textarea
												style="margin-top: 0px; width: 100%; resize: vertical;"
												id="short_content" name="shortContent">${post.getShortContent()}</textarea>
										</div>
										<div>
											<h4>Nội dung chính (*)</h4>
											<div>
												<textarea style="margin-top: 0px; width: 100%%;"
													name="content" id="frmContent">${post.getContent()}</textarea>
												<br>
											</div>
										</div>
									</div>

									<div class="col-sm-3">
										<div id="anh-dai-dien"
											style="height: 270px; width: 250px; border-color: #1C1C1C 1px; border-style: solid; border-width: 0.2px; margin-top: 5px">
											<h4
												style="background-color: #1C1C1C; color: #fff; padding: 5px; margin-top: 0px; margin-right: 0px">Ảnh
												đại diện</h4>
											<c:if test="${empty post.getAvatarPost()}">
												<img id="avatarPost" src="resources/images/avatar-post.png"
													alt="ảnh đại diện bài viết" height="70%" width="90%">
											</c:if>
											<c:if test="${not empty post.getAvatarPost()}">
												<img id="avatarPost" src="${post.getAvatarPost() }"
													alt="ảnh đại diện bài viết" height="70%" width="90%">
											</c:if>
											<button style="margin-left: 10px" type="button"
												class="btn btn-success" onclick="BrowseServer( 'Images:/')">Tải
												ảnh lên</button>
										</div>

										<br>
										<div
											style="height: 200px; border-color: #1C1C1C 1px; border-style: solid; border-width: 0.2px; margin-top: 5px">
											<h4
												style="background-color: #1C1C1C; color: #fff; padding: 5px; margin-top: 0px; margin-right: 0px">Chuyên
												mục (*)</h4>
											<div
												style="width: 100%; height: 82%; overflow-y: scroll; padding-left: 10px">
												<c:forEach var="i" begin="1"
													end="${listAllCatergories.size()}">
													<div class="radio">
														<label> <c:if
																test="${post.getCategories().getId() == listAllCatergories.get(i-1).getId()}">
																<input type="radio" id="categoriesId"
																	name="categoriesId"
																	value="${listAllCatergories.get(i-1).getId()}"
																	checked="true" />
															</c:if> <c:if
																test="${post.getCategories().getId() != listAllCatergories.get(i-1).getId()}">
																<input type="radio" id="categoriesId"
																	name="categoriesId"
																	value="${listAllCatergories.get(i-1).getId()}" />
															</c:if> ${listAllCatergories.get(i-1).getName()}<br>
														</label>
													</div>
													<br>
												</c:forEach>
											</div>
										</div>

										<div>
											<br>
											<div class="form-group">
												<label>Thời gian đăng bài:</label><br>
												<div class='input-group date' id='datetimepicker1'>
													<input id = "publishedDate" type='text' class="form-control"  value = "${post.getPublishedDate() }"/> <span
														class="input-group-addon"><span
														class="glyphicon glyphicon-calendar"></span> </span>
												</div>
												<!-- /.input group -->
											</div>
										</div>
									</div>
								</div>
								<input style="margin-top: 10px; margin-left: 10px" type="button"
									value="Gửi bài" onclick="updatedPost('${post.getId()}')" />
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<script src="resources/bower_components/ckeditor/ckeditor.js"></script>
<script src="resources/bower_components/ckfinder/ckfinder.js"></script>
<script>
	var editor = CKEDITOR.replace('frmContent');
	CKFinder.setupCKEditor(editor, '<%=request.getContextPath()%>/resources/bower_components/ckfinder/');
</script>

<script type="text/javascript">
	/**
	 * Ham thuc hien submit bai viet moi
	 * 
	 * @returns
	 */
	function updatedPost(id) {
		var title = document.getElementById("title").value;
		var shortContent = document.getElementById("short_content").value;
		var content = CKEDITOR.instances['frmContent'].getData();
		var avatarPost = $('#avatarPost').attr('src');
		var categoriesId = $('input[name=categoriesId]:checked').val();
		var publishedDate = document.getElementById("publishedDate").value;
		var url = document.getElementById("url").value;
		$.ajax({
			type : "post",
			url : "updatedPost",
			data : {
				id : id,
				title : title,
				url : url,
				shortContent : shortContent,
				content : content,
				avatarPost : avatarPost,
				categoriesId : categoriesId,
				publishedDate : publishedDate
			},
			success : function(response) {
				location.href = 'pendingpost'
			},
			error : function(e) {
			}
		});
	}
</script>

<script
	src="http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<script
	src="http://cdnjs.cloudflare.com/ajax/libs/moment.js/2.9.0/moment-with-locales.min.js"></script>
<script
	src="http://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/3.1.3/js/bootstrap-datetimepicker.min.js"></script>
<script type = "text/javascrip">
	$(function() {
		var bindDatePicker = function() {
			$(".date").datetimepicker({
				format : 'DD-MM-YYYY HH:mm:ss.S',
				icons : {
					time : "fa fa-clock-o",
					date : "fa fa-calendar",
					up : "fa fa-arrow-up",
					down : "fa fa-arrow-down"
				}
			}).find('input:first').on("blur", function() {
				// check if the date is correct. We can accept dd-mm-yyyy and yyyy-mm-dd.
				// update the format if it's yyyy-mm-dd
				var date = parseDate($(this).val());

				if (!isValidDate(date)) {
					//create date based on momentjs (we have that)
					date = moment().format('YYYY-MM-DD');
				}

				$(this).val(date);
			});
		}

		var isValidDate = function(value, format) {
			format = format || false;
			// lets parse the date to the best of our knowledge
			if (format) {
				value = parseDate(value);
			}

			var timestamp = Date.parse(value);

			return isNaN(timestamp) == false;
		}

		var parseDate = function(value) {
			var m = value.match(/^(\d{1,2})(\/|-)?(\d{1,2})(\/|-)?(\d{4})$/);
			if (m)
				value = m[5] + '-' + ("00" + m[3]).slice(-2) + '-'
						+ ("00" + m[1]).slice(-2);

			return value;
		}

		bindDatePicker();
	});
</script>
