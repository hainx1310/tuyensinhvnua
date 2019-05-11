package vn.edu.vnua.dse.controller.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import vn.edu.vnua.dse.entity.Video;
import vn.edu.vnua.dse.service.VideoService;

@RestController
@RequestMapping("api")
public class VideoAPI {
	@Autowired
	private VideoService videoService;

	/**
	 * Api lấy ra danh sách 10 video
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = { "/video/{startIndex}" }, method = RequestMethod.GET)
	public ResponseEntity<List<Video>> listAllUsers(@PathVariable int startIndex) {
		List<Video> listUser = new ArrayList<Video>();
		try {
			listUser = videoService.getLimitPublishedVideo(startIndex);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return new ResponseEntity<List<Video>>(listUser, HttpStatus.OK);
	}
}
