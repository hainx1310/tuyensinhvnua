package vn.edu.vnua.dse.common;

/**
 * Class chứa các hằng số dùng trong toàn bộ hệ thống
 * 
 * @author HaiNX
 *
 */
public class CommonConst {

	/**
	 * Lớp chứa danh sách tên file sql
	 * 
	 * @author HaiNX
	 *
	 */
	public class SqlFileName {

		/**
		 * cau sql lay ra danh sach tat ca user
		 */
		public static final String GET_lIST_USER = "sqlfiles/getListUser.sql";

		/**
		 * cau sql lay ra danh sach tat ca categories
		 */
		public static final String GET_lIST_CATEGORIES = "sqlfiles/getListCategories.sql";

		/**
		 * cau sql lay ra danh sach tat ca categories duoc kich hoat
		 */
		public static final String GET_lIST_CATEGORIES_IS_ACTIVE = "sqlfiles/getListCategoriesIsActive.sql";

		/**
		 * cau sql lay ra categories theo id
		 */
		public static final String GET_CATEGORIES_BY_ID = "sqlfiles/getListCategoriesById.sql";

		/**
		 * cau sql insert categories vao bang categories
		 */
		public static final String INSERT_CATEGORIES = "sqlfiles/insertCategories.sql";

		/**
		 * cau sql update categories vao bang categories
		 */
		public static final String UPDATE_CATEGORIES = "sqlfiles/updateCategories.sql";

		/**
		 * cau sql xóa 1 categories trong bang categories
		 */
		public static final String DELETE_CATEGORIES = "sqlfiles/deleteCategories.sql";

		/**
		 * cau sql thay doi trang thai cua 1 categories trong bang categories
		 */
		public static final String CHANGE_STATUS_CATEGORIES = "sqlfiles/changeStatusCategories.sql";

		/**
		 * cau sql them moi user vao bang user
		 */
		public static final String CREATE_USER = "sqlfiles/createUser.sql";

		/**
		 * cau sql tra ve user thong qua username
		 */
		public static final String GET_USER_BY_USERNAME = "sqlfiles/getUserByUsername.sql";

		/**
		 * cau sql xóa 1 user trong bang user
		 */
		public static final String DELETE_USER = "sqlfiles/deleteUser.sql";

		/**
		 * cau sql thay doi trang thai cua 1 user trong bang user
		 */
		public static final String CHANGE_STATUS_USER = "sqlfiles/changeStatusUser.sql";

		/**
		 * cau sql update user vao bang user
		 */
		public static final String UPDATE_USER = "sqlfiles/updateUser.sql";

		/**
		 * cau sql lay ra danh sach tat ca bai viet
		 */
		public static final String GET_ALL_POST = "sqlfiles/getListPost.sql";

		/**
		 * cau sql lay ra bai viet theo id
		 */
		public static final String GET_POST_BY_ID = "sqlfiles/getPostById.sql";

		/**
		 * cau sql lay ra 10 bai viet theo keyword va index
		 */
		public static final String SEARCH_POST = "sqlfiles/searchPost.sql";

		/**
		 * cau sql xóa 1 bai viet trong bang post theo id bai viet
		 */
		public static final String DELETE_POST_BY_ID = "sqlfiles/deletePost.sql";

		/**
		 * cau sql them moi bai viet
		 */
		public static final String CREATE_POST = "sqlfiles/createPost.sql";

		/**
		 * cau sql update bai viet
		 */
		public static final String UPDATE_POST = "sqlfiles/updatePost.sql";

		/**
		 * cau sql duyet bai viet
		 */
		public static final String APPROVED_POST = "sqlfiles/approvedPost.sql";

		/**
		 * cau sql go bai viet
		 */
		public static final String UNAPPROVED_POST = "sqlfiles/unapprovedPost.sql";

		/**
		 * cau sql lay ra danh sach tat ca bai viet da xuat ban
		 */
		public static final String GET_ALL_PUBLISHED_POST = "sqlfiles/getAllPublishedPost.sql";

		/**
		 * cau sql lay ra danh sach tat ca bai viet dang cho duyet
		 */
		public static final String GET_ALL_PENDING_POST = "sqlfiles/getAllPendingPost.sql";

		/**
		 * cau sql lay ra danh sach tat ca bai viet da duoc duyet
		 */
		public static final String GET_ALL_APPROVED_POST = "sqlfiles/getAllApprovedPost.sql";

		/**
		 * cau sql lay ra danh sach tat ca bai viet da xuat ban theo chuyen muc theo
		 * chuyen muc
		 */
		public static final String GET_ALL_PUBLISHED_POST_BY_CATEGORIES_ID = "sqlfiles/getAllPublishedPostByCategoriesId.sql";

		/**
		 * cau sql lay ra danh sach 10 bai viet da xuat ban theo chuyen muc theo chuyen
		 * muc
		 */
		public static final String GET_LIMIT_PUBLISHED_POST_BY_CATEGORIES_ID = "sqlfiles/getLimitPublishedPostByCategoriesId.sql";

		/**
		 * cau sql lay so luong bai viet theo tac gia
		 */
		public static final String GET_TOTAL_POST_BY_AUTHOR = "sqlfiles/getTotalPostByUser.sql";

		/**
		 * cau sql lay so luong video theo tac gia
		 */
		public static final String GET_TOTAL_VIDEO_BY_AUTHOR = "sqlfiles/getTotalVideoByUser.sql";

		/**
		 * cau sql lay ra danh sach tat ca video
		 */
		public static final String GET_ALL_VIDEO = "sqlfiles/getAllVideo.sql";

		/**
		 * cau sql lay ra danh sach tat ca video dang cho duyet
		 */
		public static final String GET_ALL_VIDEO_PENDING = "sqlfiles/getAllPendingVideo.sql";

		/**
		 * cau sql lay ra danh sach tat ca video da duoc duyet
		 */
		public static final String GET_ALL_VIDEO_APPROVED = "sqlfiles/getAllAprrovedVideo.sql";

		/**
		 * cau sql lay ra danh sach tat ca video da duoc dang
		 */
		public static final String GET_ALL_VIDEO_PUBLISHED = "sqlfiles/getAllPublishedVideo.sql";

		/**
		 * cau sql lay ra video theo id
		 */
		public static final String GET_VIDEO_BY_ID = "sqlfiles/getVideoById.sql";

		/**
		 * cau sql them moi mot video
		 */
		public static final String CREATE_VIDEO = "sqlfiles/createVideo.sql";

		/**
		 * cau sql update categories vao bang categories
		 */
		public static final String UPDATE_VIDEO = "sqlfiles/updateVideo.sql";

		/**
		 * cau sql xóa 1 categories trong bang categories
		 */
		public static final String DELETE_VIDEO = "sqlfiles/deleteVideo.sql";

		/**
		 * cau sql thay doi trang thai cua 1 categories trong bang categories
		 */
		public static final String CHANGE_STATUS_VIDEO = "sqlfiles/changeStatusVideo.sql";

		/**
		 * cau sql lay ra danh sach tat ca video
		 */
		public static final String GET_ALL_VIDEO_IS_ACTIVE = "sqlfiles/getAllVideoIsActive.sql";

		/**
		 * cau sql lay ra danh sach binh luan theo id bai viet
		 */
		public static final String GET_COMMENT_BY_POST_ID = "sqlfiles/getCommentByPostId.sql";

		/**
		 * cau sql them moi binh luan
		 */
		public static final String CREATE_COMMENT = "sqlfiles/createComment.sql";

		/**
		 * cau sql duyet video
		 */
		public static final String APPROVED_VIDEO = "sqlfiles/approvedVideo.sql";

		/**
		 * cau sql go video
		 */
		public static final String UNAPPROVED_VIDEO = "sqlfiles/unapprovedVideo.sql";

	}

	/**
	 * Class chứa tên quyền
	 * 
	 * @author HaiNX
	 *
	 */
	public class ROLE_NAME {

		/**
		 * Quyen quan tri vien
		 */
		public static final String ROLE_ADMIN = "ROLE_ADMIN";

		/**
		 * Quyen bien tap vien
		 */
		public static final String ROLE_EDITOR = "ROLE_EDITOR";

		/**
		 * Quyen cong tac vien
		 */
		public static final String ROLE_COLLABORARATORS = "ROLE_COLLABORARATORS";
	}
}
