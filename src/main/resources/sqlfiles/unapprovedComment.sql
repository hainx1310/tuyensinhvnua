UPDATE tuyensinhapi.comment
SET 
	status = 0
	, is_checked = 1
	, unapproved_user = :unapprovedUser
WHERE id =:id