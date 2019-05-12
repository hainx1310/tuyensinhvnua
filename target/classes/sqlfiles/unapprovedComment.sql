UPDATE tuyensinhapi.comment
SET 
	status = 0
	, unapproved_user = :unapprovedUser
WHERE id =:id