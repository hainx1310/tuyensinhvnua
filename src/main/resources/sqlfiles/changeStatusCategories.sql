UPDATE tuyensinhapi.categories
SET
	updated_date = now(),
	updated_user =:updated_user,
	status =:status
WHERE id =:id