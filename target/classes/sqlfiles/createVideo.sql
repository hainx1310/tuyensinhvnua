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
)
VALUES (
	:videoYoutubeId
	, :title
	, :shortContent
	, :editor
	, :author
	, now()
	, :publishedDate
	, 0
	, :avatarVideo
)