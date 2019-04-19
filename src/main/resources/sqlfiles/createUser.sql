INSERT INTO tuyensinhapi.user (
	email
	, username
	, password
	, password_salt
	, password_hash
	, role
	, last_login
	, created_date
	, created_user
	, updated_date
	, updated_user
	, status
	, reset_password_code
	, name
	, avatar_url
)
VALUES (:email
	, :username
	, :password
	, :passwordSalt
	, null
	, :role
	, null
	, now()
	, :createdUser
	, null
	, null
	, :status
	, null
	, null
	, null
)