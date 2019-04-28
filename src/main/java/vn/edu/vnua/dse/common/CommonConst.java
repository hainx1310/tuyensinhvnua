package vn.edu.vnua.dse.common;

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
		 * cau sql lay ra danh sach tat ca bai viet da xuat ban theo chuyen muc theo chuyen muc
		 */
		public static final String GET_ALL_PUBLISHED_POST_BY_CATEGORIES_ID = "sqlfiles/getAllPublishedPostByCategoriesId.sql";
		
		/**
		 * cau sql lay ra danh sach 10 bai viet da xuat ban theo chuyen muc theo chuyen muc
		 */
		public static final String GET_LIMIT_PUBLISHED_POST_BY_CATEGORIES_ID = "sqlfiles/getLimitPublishedPostByCategoriesId.sql";

	}
}
