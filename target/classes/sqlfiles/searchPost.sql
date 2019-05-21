FROM
    Post
WHERE
    (shortContent LIKE :keyword
        OR title LIKE :keyword
        OR content LIKE :keyword)
        AND status = 1
        AND public = 1
        AND publishedDate <= NOW()
ORDER BY publishedDate DESC