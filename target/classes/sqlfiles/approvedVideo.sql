UPDATE tuyensinhapi.video
SET 
	status = 1
	, approved_user = :approvedUser
WHERE id =:id