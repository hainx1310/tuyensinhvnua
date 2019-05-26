SELECT 
    COUNT(*)
FROM
    tuyensinhapi.post
WHERE
    status = 1 AND public = 1
        AND published_date <= NOW()
        AND user_id = :userId
ORDER BY published_date DESC