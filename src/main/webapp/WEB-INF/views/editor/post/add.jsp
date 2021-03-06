<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="avatarPost"
	value="${pageContext.request.contextPath}/resources/images/avatar-post.png" />
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<div id="wrapper-content">
	<div id="container-content">
		<section class="content-header">
			<h1>
				${titleContent} <small>Tuyển sinh HVN</small>
			</h1>
			<ol class="breadcrumb">
				<li><a href="${pageContext.request.contextPath}/home"><i
						class="fa fa-home"></i> Trang chủ</a></li>
				<li class="active">Bài viết</li>
				<li class="active">${titleContent}</li>
			</ol>
			<br>
		</section>

		<div style="margin-left: 10px; margin-right: 10px;">
			<div class="box">
				<div class="box-body">
					<div id="example2_wrapper"
						class="dataTables_wrapper form-inline dt-bootstrap">
						<div class="row">
							<c:if test="${not empty msg}">
								<input type="hidden" id="msg" value="${msg}" disabled="disabled">
							</c:if>
							<div class="col-sm-12">
								<form action="them-moi-bai-viet" method="POST">
									<div class="row">

										<div class="col-sm-8" style="margin-left: 10px">
											<div>
												<h4>Tiêu đề bài viết (*)</h4>
												<input style="margin-right: 0px; width: 100%" type="text"
													placeholder="Tiêu đề bài viết" id="title" name="title" />
											</div>
											<div>
												<h4>Địa chỉ bài viết (*)</h4>
												<input name="url" style="margin-right: 0px; width: 100%"
													type="text" placeholder="Địa chỉ bài viết" id="url"
													name="url" />
											</div>
											<div>
												<h4>Tóm tắt (*)</h4>
												<textarea
													style="margin-top: 0px; width: 100%; resize: vertical;"
													id="short_content" name="shortContent"></textarea>
											</div>
											<div>
												<h4>Nội dung chính (*)</h4>
												<div>
													<textarea style="margin-top: 0px; width: 100%%;"
														name="content" id="frmContent"></textarea>
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
												<img id="avatarPost" alt="ảnh đại diện bài viết"
													height="70%" width="90%" src="${avatarPost}"> <input
													type="hidden" id="input-avatarPost">
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
															<label> <input type="radio" id="categoriesId"
																name="categoriesId"
																value="${listAllCatergories.get(i-1).getId()}" />
																${listAllCatergories.get(i-1).getName()}<br>
															</label>
														</div>
														<br>
													</c:forEach>
												</div>
											</div>
											<sec:authorize
												access="hasAnyRole('ROLE_EDITOR', 'ROLE_ADMIN')">
												<div>
													<br>
													<div class="form-group">
														<label>Thời gian đăng bài</label> <br>
														<div class="input-group date">
															<div class="input-group-addon">
																<i class="fa fa-calendar"></i>
															</div>
															<input type="text" class="form-control pull-right"
																id="datepicker" name="publishedDate">
														</div>
														<!-- /.input group -->
													</div>
												</div>
											</sec:authorize>
										</div>
									</div>
									<input class="btn btn-primary"
										style="margin-top: 10px; margin-left: 10px" type="submit"
										value="Gửi bài" />
								</form>
							</div>

						</div>

					</div>
				</div>
			</div>
		</div>
	</div>
</div>
