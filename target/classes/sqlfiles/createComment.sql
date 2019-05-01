INSERT INTO tuyensinhapi.comment (
	post_id
	, name
	, comment
	, status
	, created_date
)
VALUES (
	:postId
	, :name
	, :comment
	, 0
	, now()
)