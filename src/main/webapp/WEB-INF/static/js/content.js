/**
 * File js định nghĩa cho phần body của web
 */
// Date picker
$('#datepicker').datepicker({
	autoclose : true
});

/**
 * Su kien show modal cap nhat thanh vien
 * 
 * @returns
 */
function openModalUpdateUser() {
	$('#modal-user').modal({
		show : 'true'
	});
}

// Sự kiện khi bấm sửa thành viên
$("#update_user").on("click", function() {
	$('#modal-user').modal({
		show : 'true'
	});

	var id = 1;
	// lấy dữ liệu user theo id
	var username = "editor01";
	var password = "123456";
	var email = "admin@vnua.edu.vn";

	$("#username").val(username);
	$("#password").val(password);
	$("#email").val(email);
	$("#select_role").val("Biên tập viên");
	$('#role_is_admin').prop('checked', true);
	$('.modal-user-title').text("Sửa thông tin người dùng");
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
	$('#modal-update-categories .modal-body')
			.append(
					"<input name = \"updatedUser\" id = \"updatedUser\" type = \"text\" value = \"hainx\" />");
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
	$('#modal-update-categories #updatedUser').remove();
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
	$('#modal-delete-categories').modal({
		show : 'true'
	});
	$('#modal-delete-categories .modal-body').append(
			'<p>Bạn muốn xóa chuyên mục <strong>' + categoriesName
					+ '</strong> không?</p>');
	$('#modal-delete-categories .modal-body').append(
			"<input name = \"id\" id = \"categoriesId\" type = \"text\" value = "
					+ categoriesId + " />");

	$('#modal-delete-categories #categoriesId').hide();
}

/**
 * Sự kiện reset form sua chuyen muc
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
			// location.reload();
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
		td = tr[i].getElementsByTagName("td")[1];
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

$('body').on('click', '.paginate_button', function() {
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
