SELECT GRADE, ID, EMAIL
FROM
(
    SELECT  CASE
                WHEN MAX(S.CATEGORY = 'Front End') = 1 AND MAX(S.NAME = 'Python') = 1
                THEN 'A'
                WHEN MAX(S.NAME = 'C#') = 1
                THEN 'B'
                WHEN MAX(S.CATEGORY = 'Front End') = 1
                THEN 'C'
            END AS GRADE,
            D.ID,
            D.EMAIL
    FROM DEVELOPERS D
    JOIN SKILLCODES S
        ON D.SKILL_CODE & S.CODE = S.CODE
    GROUP BY D.ID, D.EMAIL
) AS RESULT
WHERE GRADE IS NOT NULL
ORDER BY GRADE ASC, ID ASC