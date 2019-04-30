INSERT INTO tuyensinhapi.video (
	url
	, title
	, short_content
	, editor
	, author
	, created_date
	, published_date
	, status
)
VALUES (
	:url
	, :title
	, :shortContent
	, :editor
	, :author
	, now()
	, :publishedDate
	, 0
)