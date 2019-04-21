UPDATE tuyensinhapi.post
SET 
	short_content = :shortContent
	, title = :title
	, url = :title
	, avatar_post = :avatarPost
	, content = :content
	, categories_id =:categoriesId
	, published_date =:publishedDate
	, updated_date = now()
	, updated_user =:updatedUser
WHERE id =:id