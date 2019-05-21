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
	, public
	, user_id
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
	, :status
	, 1
	, :userId
)