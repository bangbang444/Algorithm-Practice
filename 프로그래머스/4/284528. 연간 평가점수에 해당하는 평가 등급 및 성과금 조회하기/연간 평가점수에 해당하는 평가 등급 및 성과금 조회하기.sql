-- 사원별 성과금 정보를 조회
-- 사번, 성명, 평가 등급, 성과금을 조회
SELECT  HE.EMP_NO, 
        HE.EMP_NAME, 
        CASE
            WHEN AVG(HG.SCORE) >= 96
            THEN 'S'
            WHEN AVG(HG.SCORE) >= 90
            THEN 'A'
            WHEN AVG(HG.SCORE) >= 80
            THEN 'B'
            ELSE 'C'
        END AS GRADE, 
        CASE
            WHEN AVG(HG.SCORE) >= 96
            THEN HE.SAL * 0.2
            WHEN AVG(HG.SCORE) >= 90
            THEN HE.SAL * 0.15
            WHEN AVG(HG.SCORE) >= 80
            THEN HE.SAL * 0.1
            ELSE 0
        END AS BONUS
FROM HR_DEPARTMENT HD
JOIN HR_EMPLOYEES HE
    ON HE.DEPT_ID = HD.DEPT_ID
JOIN HR_GRADE HG
    ON HG.EMP_NO = HE.EMP_NO
GROUP BY HE.EMP_NO