FROM
    Post
WHERE
    (shortContent LIKE :keyword
        OR title LIKE :keyword
        OR content LIKE :keyword)
        AND publishedDate <= NOW()
ORDER BY publishedDate DESC