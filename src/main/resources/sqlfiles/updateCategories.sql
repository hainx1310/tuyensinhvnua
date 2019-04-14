UPDATE tuyensinhapi.categories
SET 
	name =:name,
	updated_date = now(),
	updated_user =:updated_user,
	status =:status
WHERE id =:id