SELECT 
    *
FROM
    tuyensinhapi.post
WHERE
    status = 1 AND public = 1 
    AND published_date <= NOW()
    AND categories_id = :categoriesId
ORDER BY published_date DESC