SELECT * FROM tuyensinhapi.post
WHERE status = 1 and published_date >= now()
ORDER BY published_date desc