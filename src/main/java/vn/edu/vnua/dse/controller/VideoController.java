package vn.edu.vnua.dse.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import vn.edu.vnua.dse.common.CommonConst;
import vn.edu.vnua.dse.common.DateUtils;
import vn.edu.vnua.dse.entity.User;
import vn.edu.vnua.dse.entity.Video;
import vn.edu.vnua.dse.service.UserService;
import vn.edu.vnua.dse.service.VideoService;

@Controller
@RequestMapping(value = "/video")
public class VideoController {

	@Autowired
	private VideoService videoService;

	@Autowired
	private UserService userService;

	/**
	 * Controller thực hiện điều hướng tới màn hình thêm mới video
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/them-moi-video", method = RequestMethod.GET)
	public String getAllVideo(Model model) {

		List<Video> listAllVideo = new ArrayList<Video>();
		List<Video> listLimitVideo = new ArrayList<Video>();
		int pagesNumber = 0;
		int totalRecord = 0;
		String msg = (String) model.asMap().get("msg");

		try {
			listAllVideo = videoService.getAllVideo();
			listLimitVideo = videoService.getLimitedVideo(0);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		pagesNumber = (int) Math.ceil(listAllVideo.size() / 10.0);
		totalRecord = listAllVideo.size();
		model.addAttribute("listVideo", listLimitVideo);
		model.addAttribute("pagesNumber", pagesNumber);
		model.addAttribute("totalRecord", totalRecord);
		model.addAttribute("activeAddNewVideo", "active");
		model.addAttribute("msg", msg);

		return "video/them-moi-video";
	}

	/**
	 * Controller thêm mới một video
	 * 
	 * @param Video
	 * @return
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ModelAndView createVideo(HttpServletRequest request, @ModelAttribute("Video") Video video,
			BindingResult result, final RedirectAttributes redirectAttributes) {
		String username = "";
		String msg = "";
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof UserDetails) {
			username = ((UserDetails) principal).getUsername();
			video.setAuthor(username);
			video.setEditor(username);
		}

		// get avatar video by video id youtube
		String avatar = "https://i.ytimg.com/vi/".concat(video.getVideoYoutubeId()).concat("/hqdefault.jpg");
		video.setAvatarVideo(avatar);

		User user = new User();
		try {
			user = userService.getUserByUsername(username).get(0);
			video.setUser(user);
			if (user.getRole().equals(CommonConst.ROLE_NAME.ROLE_EDITOR)
					|| user.getRole().equals(CommonConst.ROLE_NAME.ROLE_ADMIN)) {
				video.setStatus(true);
				video.setPublishedDate(DateUtils.stringToDateTime(request.getParameter("publishedDate")));
				msg = "Thêm mới video thành công";
			} else {
				video.setStatus(false);
				msg = "Thêm mới thành công! Video của bạn đã được chuyển đến mục chờ duyệt.";
			}
			videoService.addVideo(video);
			redirectAttributes.addFlashAttribute("msg", msg);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return new ModelAndView("redirect:/video/them-moi-video");
	}

	/**
	 * Controller cập nhật một video
	 * 
	 * @return
	 */
	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public ModelAndView updateVideo(HttpServletRequest request, @ModelAttribute("Video") Video video,
			BindingResult result, final RedirectAttributes redirectAttributes) {

		// Get username
		String username;
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof UserDetails) {
			username = ((UserDetails) principal).getUsername();
			video.setUpdatedUser(username);
		}

		// get avatar video by video id youtube
		String avatar = "https://i.ytimg.com/vi/".concat(video.getVideoYoutubeId()).concat("/hqdefault.jpg");
		video.setAvatarVideo(avatar);

		// get publishedDate
		video.setPublishedDate(DateUtils.stringToDateTime(request.getParameter("publishedDate")));

		try {
			videoService.updateVideo(video);
			redirectAttributes.addFlashAttribute("msg", "Cập nhật video thành công!");
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return new ModelAndView("redirect:/video/video-dang-cho-duyet");
	}

	/**
	 * Phương thức xóa bỏ 1 video
	 * 
	 * @param Video
	 * @return
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public ModelAndView deleteVideo(HttpServletRequest request, final RedirectAttributes redirectAttributes) {
		int videoId;
		videoId = request.getParameter("id") != null ? Integer.parseInt(request.getParameter("id").toString()) : 0;
		try {
			videoService.deleteVideo(videoId);
			redirectAttributes.addFlashAttribute("msg", "Xóa video thành công!");
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return new ModelAndView("redirect:/video/video-dang-cho-duyet");
	}

	/**
	 * Phuong thuc thay doi trang thai cua video
	 * 
	 * @param request
	 */
	@RequestMapping(value = "/change-status", method = RequestMethod.POST)
	public String changeStatusVideo(HttpServletRequest request, final RedirectAttributes redirectAttributes) {
		int videoId;
		String username = null;

		// get VideoId
		videoId = request.getParameter("id") != null ? Integer.parseInt(request.getParameter("id").toString()) : 0;
		boolean status = request.getParameter("status") != null
				? "true".equals(request.getParameter("status")) ? false : true
				: false;

		// Get username
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof UserDetails) {
			username = ((UserDetails) principal).getUsername();
		}

		try {
			videoService.changeStatusVideo(videoId, status, username);
			redirectAttributes.addFlashAttribute("msg", "Đổi trạng thái video thành công!");
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return "redirect:/video";
	}

	/**
	 * Controller lấy ra 10 video tiep theo
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/getVideoLimit", method = RequestMethod.GET, produces = "text/plain; charset=utf-8")
	@ResponseBody
	public String getVideoLimit(@RequestParam int startIndex) {

		List<Video> listVideo = new ArrayList<Video>();
		String html = "";
		int i = startIndex + 1;
		try {
			listVideo = videoService.getLimitedVideo(startIndex);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		for (Video item : listVideo) {
			// html += "<tr role='row' class='odd'>";
			// html += "<td><input type=\"checkbox\" class=\"custom-control-input\"
			// id=\"defaultUnchecked\"></td>";
			// html += "<td class=''>" + (i++) + "</td>";
			// html += "<td id='Video-name' class='sorting_1'>" + item.getName() + "</td>";
			// html += "<td id='Video-status'>" + (item.isStatus() == true ? "Kích hoạt" :
			// "Khóa") + "</td>";
			// html += "<td id='Video-created-date'>" + item.getCreatedDate() + "</td>";
			// html += "<td id='Video-created-user'>" + (item.getCreatedUser() == null ? ""
			// : item.getCreatedUser())
			// + "</td>";
			// html += "<td id='Video-updated-date'>" + (item.getUpdatedDate() == null ? ""
			// : item.getUpdatedDate())
			// + "</td>";
			// html += "<td id='Video-updated-user'>" + (item.getUpdatedUser() == null ? ""
			// : item.getUpdatedUser())
			// + "</td>";
			// html += "<td><a id='changeStatusVideo' onclick='openModalChangeStatusVideo("
			// + item.getId() + ", "
			// + item.isStatus() + ")' href='#' class = "
			// + (item.isStatus() == true ? "\"fa fa-toggle-on\"" : "\"fa fa-toggle-off\"")
			// + "></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a
			// onclick='openModalUpdateVideo("
			// + item.getId() + ", \"" + item.getName() + "\", " + item.isStatus()
			// + ")' href=\"#\" class = \"fa
			// fa-pencil\"></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a "
			// + "onclick='openModalDeleteVideo(" + item.getId() + ", \"" + item.getName() +
			// "\")' "
			// + "href=\"#\" class = \"fa fa-trash-o\"></a></td>";
			// html += "</tr>";
		}
		return html + (i - 1);
	}

	/**
	 * Controller xua ly su kien click vao menu video cho duyet
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = { "/video-dang-cho-duyet" }, method = RequestMethod.GET)
	public String pendingPosttPage(Model model) {
		List<Video> listAllPendingVideo = new ArrayList<Video>();
		List<Video> listLimitPendingVideo = new ArrayList<Video>();
		String msg = (String) model.asMap().get("msg");

		try {
			// lay tat ca danh sach video dang cho duyet
			listAllPendingVideo = videoService.getPendingVideo();

			// lay 10 video dang cho duyet
			listLimitPendingVideo = videoService.getLimitPendingVideo(0);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		int numberPage = (int) Math.ceil(listAllPendingVideo.size() / 10.0);

		model.addAttribute("listPendingVideo", listLimitPendingVideo);
		model.addAttribute("totalRecord", listAllPendingVideo.size());
		model.addAttribute("numberPage", numberPage);
		model.addAttribute("activeVideoPending", "active");
		model.addAttribute("msg", msg);

		return "video/video-dang-cho-duyet";
	}

	@RequestMapping(value = { "/video-cho-dang" }, method = RequestMethod.GET)
	public String approvedVideoPage(Model model) {
		List<Video> listAllApprovedVideo = new ArrayList<Video>();
		List<Video> listLimitApprovedVideo = new ArrayList<Video>();
		String msg = (String) model.asMap().get("msg");

		try {
			// lay danh sach tat ca video da duyet tu db
			listAllApprovedVideo = videoService.getApprovedVideo();

			// lay 10 video da duyet
			listLimitApprovedVideo = videoService.getLimitApprovedVideo(0);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		int numberPage = (int) Math.ceil(listAllApprovedVideo.size() / 10.0);

		model.addAttribute("listApprovedVideo", listLimitApprovedVideo);
		model.addAttribute("totalRecord", listAllApprovedVideo.size());
		model.addAttribute("numberPage", numberPage);
		model.addAttribute("activeVideoApproved", "active");
		model.addAttribute("msg", msg);

		return "video/video-cho-dang";
	}

	@RequestMapping(value = { "/video-da-dang" }, method = RequestMethod.GET)
	public String videoPublishedPage(Model model) {

		List<Video> listAllPublishedVideo = new ArrayList<Video>();
		List<Video> listLimitPublishedVideo = new ArrayList<Video>();

		try {
			// lay danh sach tat ca video da xuat ban moi nhat tu db
			listAllPublishedVideo = videoService.getPublishedVideo();

			// lay 10 bai video xuat ban
			listLimitPublishedVideo = videoService.getLimitPublishedVideo(0);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		int numberPage = (int) Math.ceil(listAllPublishedVideo.size() / 10.0);

		model.addAttribute("listPublishedVideo", listLimitPublishedVideo);
		model.addAttribute("totalRecord", listAllPublishedVideo.size());
		model.addAttribute("numberPage", numberPage);
		model.addAttribute("activeVideoPublised", "active");

		return "video/video-da-dang";
	}

	/**
	 * Controller duyet video, chi chap nhan quyen editor va admin
	 * 
	 * @return
	 */
	@RequestMapping(value = { "/editor/approved" }, method = RequestMethod.POST)
	public String approved(HttpServletRequest request, final RedirectAttributes redirectAttributes) {

		// Get user
		String approvedUser = "";
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof UserDetails) {
			approvedUser = ((UserDetails) principal).getUsername();
		}

		// check role user
		User user = new User();
		try {
			user = userService.getUserByUsername(approvedUser).get(0);
			if (user.getRole().equals(CommonConst.ROLE_NAME.ROLE_EDITOR)
					|| user.getRole().equals(CommonConst.ROLE_NAME.ROLE_ADMIN)) {

				// get videoId
				int videoId = request.getParameter("videoId") != null
						? Integer.parseInt(request.getParameter("videoId").toString())
						: 0;

				// set thoi gian dang video
				Date publishedDate = request.getParameter("publishedDate") != null
						? !"".equals(request.getParameter("publishedDate"))
								? DateUtils.stringToDateTime(request.getParameter("publishedDate"))
								: new Date()
						: new Date();

				// duyet video
				videoService.approved(videoId, approvedUser, publishedDate);
				redirectAttributes.addFlashAttribute("msg", "Duyệt video thành công!");
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		return "redirect:/video/video-dang-cho-duyet";
	}

	/**
	 * Controller go video, chi chap nhan quyen editor va admin
	 * 
	 * @return
	 */
	@RequestMapping(value = { "/editor/unapproved" }, method = RequestMethod.POST)
	public String unapproved(HttpServletRequest request, final RedirectAttributes redirectAttributes) {

		// Get user
		String unapprovedUser = "";
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof UserDetails) {
			unapprovedUser = ((UserDetails) principal).getUsername();
		}

		// check role user
		User user = new User();
		try {
			user = userService.getUserByUsername(unapprovedUser).get(0);
			if (user.getRole().equals(CommonConst.ROLE_NAME.ROLE_EDITOR)
					|| user.getRole().equals(CommonConst.ROLE_NAME.ROLE_ADMIN)) {

				// get videoId
				int videoId = request.getParameter("videoId") != null
						? Integer.parseInt(request.getParameter("videoId").toString())
						: 0;

				// go video
				videoService.unapproved(videoId, unapprovedUser);
				redirectAttributes.addFlashAttribute("msg", "Gỡ video thành công!");
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		return request.getParameter("approved") != null ? "redirect:/video/video-cho-dang"
				: "redirect:/video/video-da-dang";
	}

	/**
	 * Controller bo go video, chi chap nhan quyen editor va admin
	 * 
	 * @return
	 */
	@RequestMapping(value = { "/editor/public" }, method = RequestMethod.POST)
	public String unpublic(HttpServletRequest request, final RedirectAttributes redirectAttributes) {

		// Get user
		String unapprovedUser = "";
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof UserDetails) {
			unapprovedUser = ((UserDetails) principal).getUsername();
		}

		// check role user
		User user = new User();
		try {
			user = userService.getUserByUsername(unapprovedUser).get(0);
			if (user.getRole().equals(CommonConst.ROLE_NAME.ROLE_EDITOR)
					|| user.getRole().equals(CommonConst.ROLE_NAME.ROLE_ADMIN)) {

				// get videoId
				int videoId = request.getParameter("videoId") != null
						? Integer.parseInt(request.getParameter("videoId").toString())
						: 0;

				// bo go video
				videoService.publicVideo(videoId);
				redirectAttributes.addFlashAttribute("msg", "Bỏ gỡ video thành công!");
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		return "redirect:/video/video-da-go";
	}

	@RequestMapping(value = { "/video-da-go" }, method = RequestMethod.GET)
	public String unPublicVideo(Model model) {

		List<Video> listAllVideo = new ArrayList<Video>();
		List<Video> listLimitVideo = new ArrayList<Video>();
		String msg = (String) model.asMap().get("msg");

		try {
			// lay danh sach tat ca video da bi go moi nhat tu db
			listAllVideo = videoService.getVideounPublic();

			// lay 5 video da bi go
			listLimitVideo = videoService.getLimitVideoUnPublic(0);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		int numberPage = (int) Math.ceil(listAllVideo.size() / 5.0);

		model.addAttribute("listVideoUnPublic", listLimitVideo);
		model.addAttribute("totalRecord", listAllVideo.size());
		model.addAttribute("numberPage", numberPage);
		model.addAttribute("activeVideoUnPublic", "active");
		model.addAttribute("video", msg);

		return "video/video-da-go";
	}

}
