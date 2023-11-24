-- 코드를 입력하세요
SELECT CAR_ID, 
IF(IF(MAX(START_DATE <= '2022-10-16' and END_DATE >= '2022-10-16'),1,0) = 1, '대여중', '대여 가능') AS AVAILABILITY
from CAR_RENTAL_COMPANY_RENTAL_HISTORY
group by CAR_ID
order by CAR_ID desc