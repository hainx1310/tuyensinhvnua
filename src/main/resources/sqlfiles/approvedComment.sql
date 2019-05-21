UPDATE tuyensinhapi.comment
SET 
	status = 1
	, is_checked = 1
	, approved_user = :approvedUser
WHERE id =:id