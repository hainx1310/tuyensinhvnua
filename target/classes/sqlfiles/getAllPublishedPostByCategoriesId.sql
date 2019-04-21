SELECT * FROM tuyensinhapi.post
WHERE status = 1 and published_date >= now() and categories_id =:categoriesId
ORDER BY published_date desc