/**
 * File js định nghĩa cho phần body của web
 */
// Date picker
$('#datepicker').datepicker({
	autoclose : true
});

/**
 * function bat modal tao moi user
 * 
 * @returns
 */
function openModalCreateUser() {
	$('.modal-user-title').text("Thêm người dùng mới");
	$('#modal-user').modal({
		show : 'true'
	});
}

/**
 * Reset data modal user sau mỗi khi bị ẩn
 * 
 * @returns
 */
$("#modal-user").on("hidden.bs.modal", function() {
	$("#username").val("");
	$("#password").val("");
	$("#email").val("");
	$("#select_role").val("---Chọn quyền--");
	$('#role_is_admin').prop('checked', false);
});

/**
 * Sự kiện khi bấm sửa quyền
 * 
 * @returns
 */
$("#update_role").on("click", function() {
	$('#modal-role').modal({
		show : 'true'
	});

	var id = 1;
	// lấy dữ liệu user theo id
	var name = "Quản trị viên";

	$("#role-name").val(name);
	$('#role_is_admin').prop('checked', true);
	$('.modal-role-title').text("Sửa thông tin quyền");
});

/**
 * su kien add quyen
 * 
 * @returns
 */
$("#btn-add-role").on("click", function() {
	$('.modal-role-title').text("Thêm quyền mới");
	$('#modal-role').modal({
		show : 'true'
	});
});

/**
 * function show modal tao moi user
 * 
 * @returns
 */
function openModalCreateUser() {
	$('.modal-user-title').text("Thêm người dùng mới");
	$('#modal-user').modal({
		show : 'true'
	});
}

/**
 * Reset data modal user sau mỗi khi bị ẩn
 * 
 * @returns
 */
$("#modal-user").on("hidden.bs.modal", function() {
	$("#username").val("");
	$("#password").val("");
	$("#email").val("");
	$("#select_role").val("---Chọn quyền--");
	$('#role_is_admin').prop('checked', false);
});

/**
 * Reset data modal role sau mỗi khi bị ẩn
 * 
 * @returns
 */
$("#modal-role").on("hidden.bs.modal", function() {
	$("#role-name").val("");
	$('#role_is_admin').prop('checked', false);
});

/**
 * su kien add categories
 * 
 * @returns
 */
$("#btn-categorites-clcik").on("click", function() {
	$('#modal-create-categories').modal({
		show : 'true'
	});
});

$("#btn-save").on("click", function() {
	$('#modal-create-categories').modal('hide');
});

$("#btn-submit-user").on("click", function() {
	$('#modal-user"').modal('hide');
});

$("#btn-save-update").on("click", function() {
	$('#modal-update-categories').modal('hide');
});

/**
 * ham sua chuyen muc
 * 
 * @param categoriesId
 * @param name
 * @param status
 * @returns
 */
function openModalUpdateCategories(categoriesId, name, status) {
	// show modal
	$('#modal-update-categories').modal({
		show : 'true'
	});

	$('#modal-update-categories .modal-body').append(
			"<input name = \"id\" id = \"categoriesId\" type = \"text\" value = "
					+ categoriesId + " />");
	$('#categoriesId').hide();
	$('#updatedUser').hide();

	$('#modal-update-categories #name').val(name);
	$('#modal-update-categories #categories-is-active').prop('checked', status);

}

/**
 * Sự kiện reset form sua chuyen muc
 * 
 * @returns
 */
$("#modal-update-categories").on("hidden.bs.modal", function() {
	$("#modal-update-categories #name").val("");
	$('#modal-update-categories #categories-is-active').prop('checked', false);
	// clear input id
	$('#modal-update-categories #categoriesId').remove();
});

/**
 * Hàm mở modal xác nhận xóa chuyên mục
 * 
 * @param categoriesId
 * @param categoriesName
 * @returns
 */
function openModalDeleteCategories(categoriesId, categoriesName) {
	// show modal
	$('#modal-confirm-delete').modal({
		show : 'true'
	});
	$('#modal-confirm-delete .modal-body')
			.append(
					'<p><strong>Xác nhận</strong></p><p>Bạn chắc chắn muốn xóa chuyên mục <strong>'
							+ categoriesName
							+ '</strong>?</p><p><strong>Tất cả bài viết của chuyên mục này sẽ được chuyển sang chuyên mục đã xóa</strong></p>');
	$('#modal-confirm-delete .modal-body').append(
			"<input name = \"id\" id = \"categoriesId\" type = \"text\" value = "
					+ categoriesId + " />");

	$('#modal-confirm-delete #categoriesId').hide();
}

/**
 * Sự kiện reset form xoa chuyen muc
 * 
 * @returns
 */
$("#modal-delete-categories").on("hidden.bs.modal", function() {
	$('#modal-delete-categories #categoriesId').remove();
	$('#modal-delete-categories p').remove();
});

/**
 * Hàm xử lý sự kiện người dùng nhấn đổi trạng thái chuyên mục
 * 
 * @param categoriesId
 * @param status
 * @returns
 */
function openModalChangeStatusCategories(categoriesId, status) {
	$.ajax({
		type : "post",
		url : "changeStatusCategories",
		data : {
			status : status,
			id : categoriesId,
		},
		success : function(response) {
			location.reload();
		},
		error : function(e) {
			location.reload();
		}
	});
}

/**
 * Sự kiện reset form sua chuyen muc
 * 
 * @returns
 */
$("#modal-cahngeStatus-categories").on("hidden.bs.modal", function() {
	$('#modal-cahngeStatus-categories #categoriesId').remove();
	$('#modal-cahngeStatus-categories p').remove();
});

/**
 * Hàm sự kiện nhập keyword tìm kiếm theo tên categoriesF
 * 
 * @returns
 */
function searchCategoriesByName() {
	// Declare variables
	var input, filter, table, tr, td, i, txtValue;
	input = document.getElementById("input-search-name-categories");
	filter = input.value.toUpperCase();
	table = document.getElementById("table-categories");
	tr = table.getElementsByTagName("tr");

	// Loop through all table rows, and hide those who don't match the search
	// query
	for (i = 0; i < tr.length; i++) {
		td = tr[i].getElementsByTagName("td")[2];
		if (td) {
			txtValue = td.textContent || td.innerText;
			if (txtValue.toUpperCase().indexOf(filter) > -1) {
				tr[i].style.display = "";
			} else {
				tr[i].style.display = "none";
			}
		}
	}
}

/**
 * Sự kiện phân trang chuyên mục
 * 
 * @returns
 */
$('body').on('click', '.page-of-categories', function() {
	var currentPage = $(this).text();
	var startIndex = (currentPage - 1) * 10;
	$('#recored-start').text(startIndex + 1);
	$.ajax({
		url : "getCategoriresLimit",
		type : "get",
		data : {
			startIndex : startIndex,
		},
		success : function(value) {
			var element = $('#table-categories').find("tbody");
			var idx = value.lastIndexOf(">") + 1;
			var last = value.substring(idx, value.length);
			var result = value.substring(0, idx);
			element.empty();
			element.append(result);
			$('#recored-end').text(last);
		}
	});
});

/**
 * Hàm xử lý sự kiện người dùng nhấn đổi trạng thái user
 * 
 * @param userId
 * @param status
 * @returns
 */
function changeStatusUserById(userId, status) {
	$.ajax({
		type : "post",
		url : "changeStatusUser",
		data : {
			status : status,
			id : userId,
		},
		success : function(response) {
			location.reload();
		},
		error : function(e) {
			location.reload();
		}
	});
}

/**
 * ham sua user
 * 
 * @param categoriesId
 * @param name
 * @param status
 * @returns
 */
function openModalUpdateUser(userId, username, role, status) {

	console.log(userId, username, role, status);

	// show modal
	$('#modal-update-user').modal({
		show : 'true'
	});

	$('#modal-update-user .modal-body').append(
			"<input name = \"id\" id = \"userId\" type = \"text\" value = "
					+ userId + " />");
	$('#userId').hide();

	$('#modal-update-user #username').text(username);
	if (role === 'Quản trị viên') {
		$("#modal-update-user #select_role").val("ROLE_ADMIN");
	} else if (role === 'Biên tập viên') {
		$("#modal-update-user #select_role").val("ROLE_EDITOR");
	} else {
		$("#modal-update-user #select_role").val("ROLE_COLLABORARATORS");
	}
	$('#modal-update-user #user_is_active').prop('checked', status);

}

/**
 * Sự kiện reset form sua user
 * 
 * @returns
 */
$("#modal-update-user").on("hidden.bs.modal", function() {
	$("#modal-update-user #username").val("");
	$('#modal-update-user #user_is_active').prop('checked', false);
	// clear input id
	$('#modal-update-user #userId').remove();
});

/**
 * Hàm mở modal xác nhận xóa user
 * 
 * @param userId
 * @param username
 * @returns
 */
function openModalDeleteUser(userId, username) {
	// show modal
	$('#modal-confirm-delete').modal({
		show : 'true'
	});
	$('#modal-confirm-delete .modal-body').append(
			'<p><strong>Xác nhận</strong></p><p>Bạn có chắc muốn xóa thành viên <strong>'
					+ username + '</strong>?</p>');
	$('#modal-confirm-delete .modal-body').append(
			"<input name = \"id\" id = \"userId\" type = \"text\" value = "
					+ userId + " />");

	$('#modal-confirm-delete #userId').hide();
}

/**
 * Sự kiện reset form xoa user
 * 
 * @returns
 */
$("#modal-delete-categories").on("hidden.bs.modal", function() {
	$('#modal-delete-categories #userId').remove();
	$('#modal-delete-categories p').remove();
});

/**
 * Hàm sự kiện nhập keyword lọc theo username
 * 
 * @returns
 */
function searchUserByUsername() {
	// Declare variables
	var input, filter, table, tr, td, i, txtValue;
	input = document.getElementById("input-search-name-user");
	filter = input.value.toUpperCase();
	table = document.getElementById("table-user");
	tr = table.getElementsByTagName("tr");

	// Loop through all table rows, and hide those who don't match the search
	// query
	for (i = 0; i < tr.length; i++) {
		td = tr[i].getElementsByTagName("td")[2];
		if (td) {
			txtValue = td.textContent || td.innerText;
			if (txtValue.toUpperCase().indexOf(filter) > -1) {
				tr[i].style.display = "";
			} else {
				tr[i].style.display = "none";
			}
		}
	}
}

/**
 * Sự kiện phân trang user
 * 
 * @returns
 */
$('body').on('click', '.page-of-user', function() {
	var currentPage = $(this).text();
	var startIndex = (currentPage - 1) * 10;
	$('#recored-start').text(startIndex + 1);
	$.ajax({
		url : "getUserLimit",
		type : "get",
		data : {
			startIndex : startIndex,
		},
		success : function(value) {
			var element = $('#table-user').find("tbody");
			var idx = value.lastIndexOf(">") + 1;
			var last = value.substring(idx, value.length);
			var result = value.substring(0, idx);
			element.empty();
			element.append(result);
			$('#recored-end').text(last);
		}
	});
});

// Chon avatar bai viet start
function BrowseServer(startupPath) {
	// You can use the "CKFinder" class to render CKFinder in a page:
	var finder = new CKFinder();

	// The path for the installation of CKFinder (default = "/ckfinder/").
	finder.basePath = '../';

	// Startup path in a form: "Type:/path/to/directory/"
	finder.startupPath = startupPath;

	// Name of a function which is called when a file is selected in CKFinder.
	finder.selectActionFunction = SetFileField;

	// Launch CKFinder
	finder.popup();
}

// This is a sample function which is called when a file is selected in
// CKFinder.
function SetFileField(fileUrl, data) {
	document.getElementById("avatarPost").src = fileUrl;
}

/**
 * Hàm sự kiện nhập keyword lọc theo tiêu đề video
 * 
 * @returns
 */
function searchVideoByName() {
	// Declare variables
	var input, filter, table, tr, td, i, txtValue;
	input = document.getElementById("input-search-title-video");
	filter = input.value.toUpperCase();
	table = document.getElementById("table-video");
	tr = table.getElementsByTagName("tr");

	// Loop through all table rows, and hide those who don't match the search
	// query
	for (i = 0; i < tr.length; i++) {
		td = tr[i].getElementsByTagName("td")[2];
		if (td) {
			txtValue = td.textContent || td.innerText;
			if (txtValue.toUpperCase().indexOf(filter) > -1) {
				tr[i].style.display = "";
			} else {
				tr[i].style.display = "none";
			}
		}
	}
}

/**
 * su kien add video
 * 
 * @returns
 */
$("#btn-video-clcik").on("click", function() {
	$('#modal-create-video').modal({
		show : 'true'
	});
});

$("#btn-save-video").on("click", function() {
	$('#modal-create-video').modal('hide');
});

/**
 * Phuong thuc xu ly su kien nguoi dung click duyet bai viet
 * 
 * @returns
 */
function approvedPost() {
	var postId = document.getElementById("postId").value;
	var publishedDate = document.getElementById("datepicker-approved").value;
	console.log(postId)
	console.log(publishedDate)
	$.ajax({
		type : "post",
		url : "editor/approved",
		data : {
			postId : postId,
			publishedDate: publishedDate,
		},
		success : function(response) {
			location.reload();
		},
		error : function(e) {
			location.reload();
		}
	});
}

/**
 * Phuong thuc go bai viet
 * 
 * @param postId
 * @returns
 */
function unApprovedPost(postId) {
	$.ajax({
		type : "post",
		url : "editor/unapproved",
		data : {
			postId : postId,
		},
		success : function(response) {
			location.reload();
		},
		error : function(e) {
			location.reload();
		}
	});
}

/**
 * Phuong thuc go bai viet tai trang chu
 * 
 * @param postId
 * @returns
 */
function unApprovedPostAtHome(postId) {
	$.ajax({
		type : "post",
		url : "post/editor/unapproved",
		data : {
			postId : postId,
		},
		success : function(response) {
			location.reload();
		},
		error : function(e) {
			location.reload();
		}
	});
}

function editPost(postId) {

	$.ajax({
		type : "get",
		url : "edit",
		data : {
			postId : postId,
		},
		success : function(response) {
			location.href = "update?postId=" + postId;
		},
		error : function(e) {
		}
	});
}

function editPostHome(postId) {

	$.ajax({
		type : "get",
		url : "post/edit",
		data : {
			postId : postId,
		},
		success : function(response) {
			location.href = "post/update?postId=" + postId;
		},
		error : function(e) {
		}
	});
}


/**
 * su kien khi bam xem bai viet
 * 
 * @returns
 */
function viewPost(postId, title) {

	$.ajax({
		type : "get",
		url : "view",
		data : {
			postId : postId,
		},
		success : function(response) {
			$("#modal-view-post h4").text(title);
			$('#modal-view-post .modal-body').append(
					'<div id = "post-content"> ' + response + ' </div>');
		},
		error : function(e) {
		}
	});
	$('#modal-view-post').modal({
		show : 'true'
	});
};


/**
 * su kien khi bam xem bai viet
 * 
 * @returns
 */
function viewPostHome(postId, title) {

	$.ajax({
		type : "get",
		url : "post/view",
		data : {
			postId : postId,
		},
		success : function(response) {
			$("#modal-view-post h4").text(title);
			$('#modal-view-post .modal-body').append(
					'<div id = "post-content"> ' + response + ' </div>');
		},
		error : function(e) {
		}
	});
	$('#modal-view-post').modal({
		show : 'true'
	});
};

/**
 * Reset data modal xem bai viet sau khi bi an
 * 
 * @returns
 */
$("#modal-view-post").on("hidden.bs.modal", function() {
	$("#modal-view-post h4").text("");
	$('#modal-view-post .modal-body #post-content').remove();
});

/**
 * Hàm mở modal xác nhận xóa bài viết
 * 
 * @param categoriesId
 * @param categoriesName
 * @returns
 */
function openModalDeletePost(postId, title) {
	// show modal
	$('#modal-confirm-delete').modal({
		show : 'true'
	});
	$('#modal-confirm-delete .modal-body').append(
			'<strong> <p>Xác nhận </strong>'
					+ '<p>Bạn chắc chắn muốn xóa bài viết <strong>' + title
					+ '</strong>?</p>');
	$('#modal-confirm-delete .modal-body').append(
			"<input name = \"id\" id = \"postId\" type = \"text\" value = "
					+ postId + " />");

	$('#modal-confirm-delete #postId').hide();
}

/**
 * Sự kiện reset form xóa bài viết
 * 
 * @returns
 */
$("#modal-confirm-delete").on("hidden.bs.modal", function() {
	$('#modal-confirm-delete #postId').remove();
	$('#modal-confirm-delete p').remove();
});

// Date picker
/*
 * $(function() { $('#datepicker').datetimepicker({ locale : 'vi' }); });
 * $('#datepicker').datetimepicker({ autoclose : true })
 */
$(function() {
	var bindDatePicker = function() {
		$("#datepicker").datetimepicker({
			locale : 'vi',
			format : 'DD-MM-YYYY HH:mm:ss.S',
			icons : {
				time : "fa fa-clock-o",
				date : "fa fa-calendar",
				up : "fa fa-arrow-up",
				down : "fa fa-arrow-down"
			}
		}).find('input:first').on("blur", function() {
			// check if the date is correct. We can accept dd-mm-yyyy and
			// yyyy-mm-dd.
			// update the format if it's yyyy-mm-dd
			var date = parseDate($(this).val());

			if (!isValidDate(date)) {
				// create date based on momentjs (we have that)
				date = moment().format('DD-MM-YYYY HH:mm:ss.S');
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

$(function() {
	var bindDatePicker = function() {
		$("#datepicker-update").datetimepicker({
			locale : 'vi',
			format : 'DD-MM-YYYY HH:mm:ss.S',
			icons : {
				time : "fa fa-clock-o",
				date : "fa fa-calendar",
				up : "fa fa-arrow-up",
				down : "fa fa-arrow-down"
			}
		}).find('input:first').on("blur", function() {
			// check if the date is correct. We can accept dd-mm-yyyy and
			// yyyy-mm-dd.
			// update the format if it's yyyy-mm-dd
			var date = parseDate($(this).val());

			if (!isValidDate(date)) {
				// create date based on momentjs (we have that)
				date = moment().format('DD-MM-YYYY HH:mm:ss.S');
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

$(function() {
	var bindDatePicker = function() {
		$("#datepicker-approved").datetimepicker({
			locale : 'vi',
			format : 'DD-MM-YYYY HH:mm:ss.S',
			icons : {
				time : "fa fa-clock-o",
				date : "fa fa-calendar",
				up : "fa fa-arrow-up",
				down : "fa fa-arrow-down"
			}
		}).find('input:first').on("blur", function() {
			// check if the date is correct. We can accept dd-mm-yyyy and
			// yyyy-mm-dd.
			// update the format if it's yyyy-mm-dd
			var date = parseDate($(this).val());

			if (!isValidDate(date)) {
				// create date based on momentjs (we have that)
				date = moment().format('DD-MM-YYYY HH:mm:ss.S');
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

/**
 * ham sua video
 * 
 * @param categoriesId
 * @param name
 * @param status
 * @returns
 */
function openModalUpdateVideo(id, videoYoutubeId, title, publishedDate) {
	// show modal
	$('#modal-update-video').modal({
		show : 'true'
	});

	$('#modal-update-video .modal-body').append(
			"<input name = \"id\" id = \"id\" type = \"text\" value = " + id
					+ " />");
	$('#id').hide();

	$('#modal-update-video #title').val(title);
	$('#modal-update-video #videoYoutubeId').val(videoYoutubeId);
	$('#modal-update-video #datepicker-update').val(publishedDate);
}

/**
 * Sự kiện reset form sua video
 * 
 * @returns
 */
$("#modal-update-video").on("hidden.bs.modal", function() {
	$("#modal-update-video #title").val("");
	$("#modal-update-video #videoYoutubeId").val("");
	$('#modal-update-video #datepicker-update').val("");
	// clear input id
	$('#modal-update-video #id').remove();
});

/**
 * ham click duyet video
 * 
 * @param videoId
 * @param name
 * @param status
 * @returns
 */
function openModalApprovedVideo(id, videoYoutubeId, title) {
	// show modal
	$('#modal-approved-video').modal({
		show : 'true'
	});

	$('#modal-approved-video .modal-body').append(
			"<input name = \"videoId\" id = \"videoId\" type = \"text\" value = " + id
					+ " />");
	$('#modal-approved-video #title').val(title);
	$('#modal-approved-video #videoYoutubeId').val(videoYoutubeId);
	
	$('#modal-approved-video #videoId').hide();
	$('#modal-approved-video #title').hide();
	$('#modal-approved-video #videoYoutubeId').hide();
}

/**
 * Sự kiện reset form duyet video
 * 
 * @returns
 */
$("#modal-approved-video").on("hidden.bs.modal", function() {
	$("#modal-approved-video #title").remove();
	$("#modal-approved-video #videoYoutubeId").remove();
	$('#modal-approved-video #videoId').remove();
});

/**
 * ham click duyet bai viet
 * 
 * @param postId
 * @returns
 */
function openModalApprovedPost(id) {
	// show modal
	$('#modal-approved-post').modal({
		show : 'true'
	});

	$('#modal-approved-post .modal-body').append(
			"<input name = \"postId\" id = \"postId\" type = \"text\" value = " + id
					+ " />");
	
	$('#modal-approved-post #postId').hide();
}

/**
 * Sự kiện reset form duyet bai viet
 * 
 * @returns
 */
$("#modal-approved-post").on("hidden.bs.modal", function() {
	$('#modal-approved-post #postId').remove();
});

/**
 * Phuong thuc go video
 * 
 * @param postId
 * @returns
 */
function unApprovedVideo(videoId) {
	$.ajax({
		type : "post",
		url : "editor/unapproved",
		data : {
			videoId : videoId,
		},
		success : function(response) {
			location.reload();
		},
		error : function(e) {
			location.reload();
		}
	});
}

/**
 * Phuong thuc bỏ go video
 * 
 * @param postId
 * @returns
 */
function publicVideo(videoId) {
	$.ajax({
		type : "post",
		url : "editor/public",
		data : {
			videoId : videoId,
		},
		success : function(response) {
			location.reload();
		},
		error : function(e) {
			location.reload();
		}
	});
}

/**
 * Phuong thuc bỏ go bai viet
 * 
 * @param postId
 * @returns
 */
function publicPost(postId) {
	$.ajax({
		type : "post",
		url : "editor/public",
		data : {
			postId : postId,
		},
		success : function(response) {
			location.reload();
		},
		error : function(e) {
			location.reload();
		}
	});
}

/**
 * Hàm mở modal xác nhận xóa user
 * 
 * @param userId
 * @param username
 * @returns
 */
function openModalDeleteVideo(videoId, title) {
	// show modal
	$('#modal-confirm-delete').modal({
		show : 'true'
	});
	$('#modal-confirm-delete .modal-body').append(
			'<p><strong>Xác nhận</strong></p><p>Bạn có chắc muốn xóa video <strong>'
					+ title + '</strong>?</p>');
	$('#modal-confirm-delete .modal-body').append(
			"<input name = \"id\" id = \"videoId\" type = \"text\" value = "
					+ videoId + " />");

	$('#modal-confirm-delete #videoId').hide();
}

/**
 * Sự kiện reset form xoa user
 * 
 * @returns
 */
$("#modal-delete-categories").on("hidden.bs.modal", function() {
	$('#modal-delete-categories #userId').remove();
	$('#modal-delete-categories p').remove();
});

/**
 * Phuong thuc xu ly su kien nguoi dung click duyet binh luan
 * 
 * @returns
 */
function approvedComment(commentId) {
	$.ajax({
		type : "post",
		url : "editor/comment/approved",
		data : {
			commentId : commentId,
		},
		success : function(response) {
			location.reload();
		},
		error : function(e) {
			location.reload();
		}
	});
}

/**
 * Phuong thuc go video
 * 
 * @param postId
 * @returns
 */
function unApprovedComment(commentId) {
	$.ajax({
		type : "post",
		url : "editor/comment/approved/unapproved",
		data : {
			commentId : commentId,
		},
		success : function(response) {
			location.reload();
		},
		error : function(e) {
			location.reload();
		}
	});
}
