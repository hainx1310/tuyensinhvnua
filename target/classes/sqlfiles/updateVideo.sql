UPDATE tuyensinhapi.video
SET 
	video_youtube_id = :videoYoutubeId
	, title = :title
	, short_content = :shortContent
	, published_date =:publishedDate
	, updated_date = now()
	, updated_user =:updatedUser
	, avatar_video = :avatarVideo
WHERE id =:id