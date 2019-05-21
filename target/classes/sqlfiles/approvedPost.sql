UPDATE tuyensinhapi.post
SET 
	status = 1
	, approved_user = :approvedUser
	, published_date = :publishedDate
WHERE id =:id