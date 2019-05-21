UPDATE tuyensinhapi.post
SET 
	public = 0
	, unapproved_user = :unapprovedUser
WHERE id =:id