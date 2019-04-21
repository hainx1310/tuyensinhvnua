UPDATE tuyensinhapi.user
SET 
	updated_date = now(),
	updated_user =:updated_user,
	status =:status,
	role =:role
WHERE id =:id