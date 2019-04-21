UPDATE tuyensinhapi.user
SET
	updated_date = now(),
	updated_user =:updated_user,
	status =:status
WHERE id =:id