SELECT 
    *
FROM
    tuyensinhapi.video
WHERE
    status = 1 AND public = 1
        AND published_date > NOW()