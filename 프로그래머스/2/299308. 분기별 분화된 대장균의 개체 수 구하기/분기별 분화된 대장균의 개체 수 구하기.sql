SELECT CONCAT(CEIL(MONTH(DIFFERENTIATION_DATE)/3),'Q') AS QUARTER, COUNT(*) ECOLI_COUNT
FROM ECOLI_DATA 
GROUP BY QUARTER
ORDER BY QUARTER


