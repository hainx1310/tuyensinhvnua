package vn.edu.vnua.dse.controller.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import vn.edu.vnua.dse.entity.Comment;
import vn.edu.vnua.dse.entity.Post;
import vn.edu.vnua.dse.service.CommentService;
import vn.edu.vnua.dse.service.PostService;

@RestController
@RequestMapping("/api")
public class CommentApi {

	@Autowired
	private CommentService commentService;

	@Autowired
	private PostService postService;

	/**
	 * Api lay tat ca bai viet da duoc xuat ban
	 * 
	 * @return
	 */
	@RequestMapping(value = { "/comment/get/{postId}" }, method = RequestMethod.GET)
	public ResponseEntity<List<Comment>> getAllPostPublished(@PathVariable int postId) {
		List<Comment> listResult = new ArrayList<Comment>();

		try {
			listResult = commentService.getComments(postId);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		return new ResponseEntity<List<Comment>>(listResult, HttpStatus.OK);
	}

	/**
	 * API chop phep them moi binh luan tren ung dung di dong
	 * 
	 * @param comment
	 * @return
	 */
	@RequestMapping(value = { "/comment" }, method = RequestMethod.POST)
	public ResponseEntity<String> createComment(@RequestBody Comment comment) {
		Post post = new Post();
		try {
			post = postService.getPostById(comment.getId());
			comment.setpost(post);
			commentService.createComment(comment);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		return new ResponseEntity<String>(HttpStatus.CREATED);
	}
}
