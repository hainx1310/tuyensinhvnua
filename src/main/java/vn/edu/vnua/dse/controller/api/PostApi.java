package vn.edu.vnua.dse.controller.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import vn.edu.vnua.des.co.PostCO;
import vn.edu.vnua.dse.entity.Comment;
import vn.edu.vnua.dse.entity.Post;
import vn.edu.vnua.dse.service.CommentService;
import vn.edu.vnua.dse.service.PostService;

@RestController
@RequestMapping("/api")
public class PostApi {

	@Autowired
	private PostService postService;

	@Autowired
	private CommentService commentService;

	/**
	 * Api lay tat ca bai viet da duoc xuat ban
	 * 
	 * @return
	 */
	@RequestMapping(value = { "/post" }, method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<Object> getAllPostPublished() {
		List<Post> listResult = new ArrayList<Post>();
		List<PostCO> list = new ArrayList<PostCO>();
		PostCO postCO = new PostCO();
		List<Comment> listComment = new ArrayList<Comment>();

		try {
			listResult = postService.getPostPublished();
			if (listResult != null && listResult.size() > 0) {
				for (Post post : listResult) {
					postCO.setId(post.getId());
					postCO.setShortContent(post.getShortContent());
					postCO.setTitle(post.getTitle());
					postCO.setUrl(post.getUrl());
					postCO.setAvatarPost(post.getAvatarPost());
					postCO.setContent(post.getContent());
					postCO.setCategories(post.getCategories());
					postCO.setEditor(post.getEditor());
					postCO.setAuthor(post.getAuthor());
					postCO.setCreatedDate(post.getCreatedDate());
					postCO.setUpdatedDate(post.getUpdatedDate());
					postCO.setPublishedDate(post.getPublishedDate());
					postCO.setStatus(post.isStatus());
					postCO.setApprovedUser(post.getApprovedUser());
					postCO.setUnapprovedUser(post.getUnapprovedUser());
					listComment = commentService.getComments(post.getId());
					postCO.setComments(listComment);
					list.add(postCO);
					postCO = new PostCO();
				}
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		return new ResponseEntity<Object>(list, HttpStatus.OK);
	}

	/**
	 * Api lay danh sach 10 bai viet
	 * 
	 * @param startIndex
	 * @return
	 */
	@RequestMapping(value = { "/post/limit" }, method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<Object> getLimitPostPublish(int startIndex) {

		List<Post> listResult = new ArrayList<Post>();
		List<PostCO> list = new ArrayList<PostCO>();
		PostCO postCO = new PostCO();
		List<Comment> listComment = new ArrayList<Comment>();

		try {
			listResult = postService.getLimitPostPublished(startIndex, 10);
			if (listResult != null && listResult.size() > 0) {
				for (Post post : listResult) {
					postCO.setId(post.getId());
					postCO.setShortContent(post.getShortContent());
					postCO.setTitle(post.getTitle());
					postCO.setUrl(post.getUrl());
					postCO.setAvatarPost(post.getAvatarPost());
					postCO.setContent(post.getContent());
					postCO.setCategories(post.getCategories());
					postCO.setEditor(post.getEditor());
					postCO.setAuthor(post.getAuthor());
					postCO.setCreatedDate(post.getCreatedDate());
					postCO.setUpdatedDate(post.getUpdatedDate());
					postCO.setPublishedDate(post.getPublishedDate());
					postCO.setStatus(post.isStatus());
					postCO.setApprovedUser(post.getApprovedUser());
					postCO.setUnapprovedUser(post.getUnapprovedUser());
					listComment = commentService.getComments(post.getId());
					postCO.setComments(listComment);
					list.add(postCO);
					postCO = new PostCO();
				}
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		return new ResponseEntity<Object>(list, HttpStatus.OK);
	}

	/**
	 * Api lay danh sach 10 bai viet theo chuyen muc
	 * 
	 * @param startIndex
	 * @return
	 */
	@RequestMapping(value = {
			"/post/categoires/limit" }, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<Object> getLimitPostPublish(int categoriesId, int startIndex) {

		List<Post> listResult = new ArrayList<Post>();
		List<PostCO> list = new ArrayList<PostCO>();
		PostCO postCO = new PostCO();
		List<Comment> listComment = new ArrayList<Comment>();

		try {
			listResult = postService.getPostPublishedByCategoriesIdLimit(categoriesId, startIndex);
			if (listResult != null && listResult.size() > 0) {
				for (Post post : listResult) {
					postCO.setId(post.getId());
					postCO.setShortContent(post.getShortContent());
					postCO.setTitle(post.getTitle());
					postCO.setUrl(post.getUrl());
					postCO.setAvatarPost(post.getAvatarPost());
					postCO.setContent(post.getContent());
					postCO.setCategories(post.getCategories());
					postCO.setEditor(post.getEditor());
					postCO.setAuthor(post.getAuthor());
					postCO.setCreatedDate(post.getCreatedDate());
					postCO.setUpdatedDate(post.getUpdatedDate());
					postCO.setPublishedDate(post.getPublishedDate());
					postCO.setStatus(post.isStatus());
					postCO.setApprovedUser(post.getApprovedUser());
					postCO.setUnapprovedUser(post.getUnapprovedUser());
					listComment = commentService.getComments(post.getId());
					postCO.setComments(listComment);
					list.add(postCO);
					postCO = new PostCO();
				}
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		return new ResponseEntity<Object>(list, HttpStatus.OK);
	}

	/**
	 * Api lay tat ca bai viet theo id
	 * 
	 * @return
	 */
	@RequestMapping(value = { "/post/{arrPostId}" }, method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<Object> getAllPostPublished(@PathVariable String arrPostId) {
		List<Post> listResult = new ArrayList<Post>();
		List<PostCO> list = new ArrayList<PostCO>();
		PostCO postCO = new PostCO();
		List<Comment> listComment = new ArrayList<Comment>();

		try {
			listResult = postService.getListPostById(arrPostId);
			if (listResult != null && listResult.size() > 0) {
				for (Post post : listResult) {
					postCO.setId(post.getId());
					postCO.setShortContent(post.getShortContent());
					postCO.setTitle(post.getTitle());
					postCO.setUrl(post.getUrl());
					postCO.setAvatarPost(post.getAvatarPost());
					postCO.setContent(post.getContent());
					postCO.setCategories(post.getCategories());
					postCO.setEditor(post.getEditor());
					postCO.setAuthor(post.getAuthor());
					postCO.setCreatedDate(post.getCreatedDate());
					postCO.setUpdatedDate(post.getUpdatedDate());
					postCO.setPublishedDate(post.getPublishedDate());
					postCO.setStatus(post.isStatus());
					postCO.setApprovedUser(post.getApprovedUser());
					postCO.setUnapprovedUser(post.getUnapprovedUser());
					listComment = commentService.getComments(post.getId());
					postCO.setComments(listComment);
					list.add(postCO);
					postCO = new PostCO();
				}
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		return new ResponseEntity<Object>(list, HttpStatus.OK);
	}

	/**
	 * Api tra ve danh sach bai viet theo keyword, moi lan duoc goi se lay 10 bai ke
	 * tu index truyen vao
	 * 
	 * @param startIndex
	 * @return
	 */
	@RequestMapping(value = { "/post/search/{keyword}/{startIndex}" }, method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<Object> searchPostByKeyword(@PathVariable String keyword,
			@PathVariable int startIndex) {

		List<Post> listResult = new ArrayList<Post>();
		List<PostCO> list = new ArrayList<PostCO>();
		PostCO postCO = new PostCO();
		List<Comment> listComment = new ArrayList<Comment>();

		if (keyword != null) {
			keyword = keyword.toLowerCase().trim();
		}

		try {
			listResult = postService.getPostByKeyword(keyword, startIndex);
			if (listResult != null && listResult.size() > 0) {
				for (Post post : listResult) {
					postCO.setId(post.getId());
					postCO.setShortContent(post.getShortContent());
					postCO.setTitle(post.getTitle());
					postCO.setUrl(post.getUrl());
					postCO.setAvatarPost(post.getAvatarPost());
					postCO.setContent(post.getContent());
					postCO.setCategories(post.getCategories());
					postCO.setEditor(post.getEditor());
					postCO.setAuthor(post.getAuthor());
					postCO.setCreatedDate(post.getCreatedDate());
					postCO.setUpdatedDate(post.getUpdatedDate());
					postCO.setPublishedDate(post.getPublishedDate());
					postCO.setStatus(post.isStatus());
					postCO.setApprovedUser(post.getApprovedUser());
					postCO.setUnapprovedUser(post.getUnapprovedUser());
					listComment = commentService.getComments(post.getId());
					postCO.setComments(listComment);
					list.add(postCO);
					postCO = new PostCO();
				}
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		return new ResponseEntity<Object>(list, HttpStatus.OK);
	}
}
