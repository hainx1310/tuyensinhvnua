INSERT INTO tuyensinhapi.post (
	short_content
	, title
	, url
	, avatar_post
	, content
	, categories_id
	, editor
	, author
	, created_date
	, published_date
	, status
)
VALUES (:shortContent
	, :title
	, :url
	, :avatarPost
	, :content
	, :categoriesId
	, :editor
	, :author
	, now()
	, :publishedDate
	, 0
)