package vn.edu.vnua.dse.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import vn.edu.vnua.dse.dao.CategoriesDAO;
import vn.edu.vnua.dse.entity.Categories;
import vn.edu.vnua.dse.entity.Post;

@Controller
public class PostController {

	@Autowired
	private CategoriesDAO categoriesDao;

	@RequestMapping(value = { "/newpost" }, method = RequestMethod.GET)
	public String newpostPage(Model model) {
		// Get all catergories
		List<Categories> listAllCatergories = new ArrayList<Categories>();
		try {
			listAllCatergories = categoriesDao.getAllCategorires(-1);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		model.addAttribute("titleContent", "Thêm bài viết");
		model.addAttribute("listAllCatergories", listAllCatergories);
		return "newpost";
	}

	@RequestMapping(value = { "/newpost" }, method = RequestMethod.POST)
	public String addNewPostPage(Post post, String a) {
		return "home";
	}

	/**
	 * 
	 * @param postId
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/editpost{postId}", method = RequestMethod.GET)
	public String editPost(int postId, Model model) {
		// Get all catergories
		List<Categories> listAllCatergories = new ArrayList<Categories>();
		try {
			listAllCatergories = categoriesDao.getAllCategorires(-1);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		model.addAttribute("titleContent", "Thêm bài viết");
		model.addAttribute("listAllCatergories", listAllCatergories);
		model.addAttribute("titleContent", "Sửa bài viêt");
		model.addAttribute("title", "Tra cứu danh sách trúng tuyển và thủ tục nhập học");
		model.addAttribute("content",
				"<p><img alt=\"\" src=\"https://tuyensinh.vnua.edu.vn/wp-content/uploads/2019/03/t%E1%BB%9D-r%C6%A1i-m-truoc.jpg\" style=\"height:432px; width:300px\" /></p>\r\n"
						+ "\r\n" + "<p>&nbsp;</p>\r\n" + "\r\n" + "<p>nội dung b&agrave;i viết</p>\r\n" + "\r\n"
						+ "<p>&nbsp;</p>");
		model.addAttribute("author", "tác giả bài viết");
		return "newpost";
	}

	@RequestMapping(value = "/editpost{id}", method = RequestMethod.POST)
	public String editPost() {
		return "home";
	}

	@RequestMapping(value = { "/pendingpost" }, method = RequestMethod.GET)
	public String pendingPosttPage(Model model) {
		model.addAttribute("title", "Đây là title bài viết đang chờ duyệt");
		model.addAttribute("content", "Đây là nội dung bài viết đang chờ duyệt");
		model.addAttribute("author", "Đây là tác giả bài viết đang chờ duyệt");
		return "pendingpost";
	}

	@RequestMapping(value = { "/approvedpost" }, method = RequestMethod.GET)
	public String approvedPostPage(Model model) {
		model.addAttribute("title", "Đây là title bài viết đã được duyệt");
		model.addAttribute("content", "Đây là nội dung bài viết đã được duyệt");
		model.addAttribute("author", "Đây là tác giả bài viết đã được duyệt");
		return "approvedpost";
	}

	@RequestMapping(value = { "/postpublished" }, method = RequestMethod.GET)
	public String postPublishedPage(Model model) {
		model.addAttribute("title", "Đây là title bài viết đã được xuất bản");
		model.addAttribute("content", "Đây là nội dung bài viết đã được xuất bản");
		model.addAttribute("author", "Đây là tác giả bài viết đã được xuất bản");
		return "postpublished";
	}
}
