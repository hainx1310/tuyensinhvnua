package vn.edu.vnua.dse.controller.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import vn.edu.vnua.dse.entity.Post;
import vn.edu.vnua.dse.service.PostService;

@RestController
@RequestMapping("/api")
public class PostApi {

	@Autowired
	private PostService postService;

	/**
	 * Api lay tat ca bai viet da duoc xuat ban
	 * 
	 * @return
	 */
	@RequestMapping(value = { "/post" }, method = RequestMethod.GET)
	public ResponseEntity<List<Post>> getAllPostPublished() {
		List<Post> listResult = new ArrayList<Post>();
		listResult = postService.getPostPublished();
		return new ResponseEntity<List<Post>>(listResult, HttpStatus.OK);
	}

	/**
	 * Api lay danh sach 10 bai viet
	 * 
	 * @param startIndex
	 * @return
	 */
	@RequestMapping(value = { "/post/limit" }, method = RequestMethod.GET)
	public ResponseEntity<List<Post>> getLimitPostPublish(int startIndex) {

		List<Post> listResult = new ArrayList<Post>();

		try {
			listResult = postService.getLimitPostPublished(startIndex);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		return new ResponseEntity<List<Post>>(listResult, HttpStatus.OK);
	}

	/**
	 * Api lay danh sach 10 bai viet theo chuyen muc
	 * 
	 * @param startIndex
	 * @return
	 */
	@RequestMapping(value = { "/post/categoires/limit" }, method = RequestMethod.GET)
	public ResponseEntity<List<Post>> getLimitPostPublish(int categoriesId, int startIndex) {

		List<Post> listResult = new ArrayList<Post>();

		try {
			listResult = postService.getPostPublishedByCategoriesIdLimit(categoriesId, startIndex);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		return new ResponseEntity<List<Post>>(listResult, HttpStatus.OK);
	}
}
