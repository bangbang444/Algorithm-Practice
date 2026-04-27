SELECT  ID,
        CASE
            WHEN ED.PCT >= 0 AND PCT <= 0.25
            THEN 'CRITICAL'
            WHEN ED.PCT <= 0.5
            THEN 'HIGH'
            WHEN ED.PCT <= 0.75
            THEN 'MEDIUM'
            ELSE 'LOW'
        END AS COLONY_NAME
FROM 
(
    SELECT  ID, 
            SIZE_OF_COLONY,
            PERCENT_RANK() OVER (ORDER BY SIZE_OF_COLONY DESC) AS PCT
    FROM ECOLI_DATA
) AS ED
ORDER BY ID ASC