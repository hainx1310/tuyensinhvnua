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

	}
}