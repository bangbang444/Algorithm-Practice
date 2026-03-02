-- 자동차 종류가 '세단' 또는 'SUV' 인 자동차 중 2022년 11월 1일부터 2022년 11월 30일까지 대여 가능하고 30일간의 대여 금액이 50만원 이상 200만원 미만인 자동차에 대해서 자동차 ID, 자동차 종류, 대여 금액(컬럼명: FEE) 리스트를 출력하는 SQL문을 작성
-- 결과는 대여 금액을 기준으로 내림차순 정렬하고, 대여 금액이 같은 경우 자동차 종류를 기준으로 오름차순 정렬, 자동차 종류까지 같은 경우 자동차 ID를 기준으로 내림차순 정렬

SELECT CH.CAR_ID, 
        CH.CAR_TYPE,
        ROUND(CH.DAILY_FEE * (100-P.DISCOUNT_RATE) * 30 / 100.0) AS FEE
FROM CAR_RENTAL_COMPANY_DISCOUNT_PLAN AS P
JOIN 
(
    SELECT C.CAR_ID, C.CAR_TYPE, C.DAILY_FEE
    FROM CAR_RENTAL_COMPANY_CAR AS C
    WHERE CAR_TYPE IN ('세단', 'SUV')
    AND NOT EXISTS (
    SELECT 1
    FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY H
    WHERE H.CAR_ID = C.CAR_ID
      AND H.START_DATE < '2022-12-01'
      AND H.END_DATE > '2022-11-01'
    )
) AS CH
ON P.DURATION_TYPE='30일 이상' 
AND P.CAR_TYPE = CH.CAR_TYPE
WHERE CH.DAILY_FEE * (100-P.DISCOUNT_RATE) * 30 / 100 >= 500000
    AND CH.DAILY_FEE * (100-P.DISCOUNT_RATE) * 30 / 100 < 2000000
ORDER BY FEE DESC, CH.CAR_TYPE ASC, CH.CAR_ID DESC