-- DEVELOPER 테이블에서 GRADE별 개발자 정보 조회
SELECT GRADE, ID, EMAIL
FROM (
    SELECT
            CASE
                WHEN MAX(S.CATEGORY = 'Front End') = 1 AND MAX(S.NAME = 'Python') = 1
                THEN 'A'
                WHEN MAX(S.NAME = 'C#') = 1
                THEN 'B'
                WHEN MAX(S.CATEGORY = 'Front End') = 1
                THEN 'C'
            END AS GRADE,
            D.ID, 
            D.EMAIL
    FROM DEVELOPERS AS D
        JOIN SKILLCODES AS S
        ON S.CODE & D.SKILL_CODE = S.CODE
    GROUP BY D.ID, D.EMAIL
) AS RESULT
WHERE GRADE IS NOT NULL
ORDER BY GRADE, ID