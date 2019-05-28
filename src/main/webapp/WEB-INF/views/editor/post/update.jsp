<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<c:set var="avatarPost"
	value="${pageContext.request.contextPath}/resources/images/avatar-post.png" />

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
							<c:if test="${not empty msg}">
								<input type="hidden" id="msg" value="${msg}" disabled="disabled">
							</c:if>
							<div class="col-sm-12">
								<form action="cap-nhat-bai-viet" method="POST">
									<div class="row">
										<div class="col-sm-8" style="margin-left: 10px">
											<input type="hidden" value="${post.getId()}" name="id">
											<div>
												<h4>Tiêu đề bài viết (*)</h4>
												<input style="margin-right: 0px; width: 100%" type="text"
													placeholder="Tiêu đề bài viết" id="title" name="title"
													value="${post.getTitle()}" />
											</div>
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
													<img id="avatarPost" alt="ảnh đại diện bài viết"
														height="70%" width="90%" src="${avatarPost}">
												</c:if>
												<c:if test="${not empty post.getAvatarPost()}">
													<img id="avatarPost" src="${post.getAvatarPost() }"
														alt="ảnh đại diện bài viết" height="70%" width="90%">
												</c:if>
												<input type="hidden" id="input-avatarPost" name="avatarPost">
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
											<sec:authorize
												access="hasAnyRole('ROLE_EDITOR', 'ROLE_ADMIN')">
												<div>
													<br>
													<div class="form-group">
														<label>Thời gian đăng bài:</label><br>
														<div class="input-group date">
															<div class="input-group-addon">
																<i class="fa fa-calendar"></i>
															</div>
															<input type="text" class="form-control pull-right"
																id="datepicker" name="publishedDate"
																value="${post.showPublishedDate()}">
														</div>
														<!-- /.input group -->
													</div>
												</div>
											</sec:authorize>
										</div>
									</div>
									<input style="margin-top: 10px; margin-left: 10px"
										class="btn btn-primary" type="submit" value="Lưu" />
								</form>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
