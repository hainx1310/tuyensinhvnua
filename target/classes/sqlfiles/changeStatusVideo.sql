UPDATE tuyensinhapi.video
SET
	updated_date = now(),
	updated_user =:updatedUser,
	status =:status
WHERE id =:id