INSERT INTO tuyensinhapi.video (
	video_youtube_id
	, title
	, short_content
	, editor
	, author
	, created_date
	, published_date
	, status
	, avatar_video
	, public
	, user_id
)
VALUES (
	:videoYoutubeId
	, :title
	, :shortContent
	, :editor
	, :author
	, now()
	, :publishedDate
	, :status
	, :avatarVideo
	, 1
	, :userId
)