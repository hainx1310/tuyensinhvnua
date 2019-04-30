UPDATE tuyensinhapi.video
SET 
	url = :url
	, title = :title
	, short_content = :shortContent
	, published_date =:publishedDate
	, updated_date = now()
	, updated_user =:updatedUser
WHERE id =:id