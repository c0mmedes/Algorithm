-- 코드를 입력하세요
SELECT FLAVOR
FROM FIRST_HALF 
WHERE TOTAL_ORDER > 3000 AND FLAVOR IN ('peach', 'watermelon', 'mango', 'strawberry', 'melon', 'orange', 'pineapple')
ORDER BY TOTAL_ORDER DESC