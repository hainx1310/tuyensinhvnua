SELECT 
    *
FROM
    tuyensinhapi.video
WHERE
    status = 1 AND published_date <= NOW()
ORDER BY published_date DESC