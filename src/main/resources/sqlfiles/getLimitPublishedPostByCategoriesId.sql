FROM Post
where categories.id = :categoriesId
	and status = 1 
	and published_date <= now()
order by published_date desc