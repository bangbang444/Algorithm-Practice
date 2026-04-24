-- 사원별 성과금 정보를 조회
-- 사번, 성명, 평가 등급, 성과금을 조회
WITH EMP_AVG AS (
    SELECT EMP_NO, ROUND(AVG(SCORE), 2) AS AVG_SCORE
    FROM HR_GRADE
    GROUP BY EMP_NO
)
SELECT  HE.EMP_NO, 
        HE.EMP_NAME, 
        CASE
            WHEN A.AVG_SCORE >= 96
            THEN 'S'
            WHEN A.AVG_SCORE >= 90
            THEN 'A'
            WHEN A.AVG_SCORE >= 80
            THEN 'B'
            ELSE 'C'
        END AS GRADE, 
        CASE
            WHEN A.AVG_SCORE >= 96
            THEN HE.SAL * 0.2
            WHEN A.AVG_SCORE >= 90
            THEN HE.SAL * 0.15
            WHEN A.AVG_SCORE >= 80
            THEN HE.SAL * 0.1
            ELSE 0
        END AS BONUS
FROM HR_EMPLOYEES HE
JOIN EMP_AVG A
ON A.EMP_NO = HE.EMP_NO
ORDER BY HE.EMP_NO