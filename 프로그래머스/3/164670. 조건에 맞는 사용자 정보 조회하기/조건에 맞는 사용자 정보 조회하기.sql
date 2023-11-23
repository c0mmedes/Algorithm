-- 코드를 입력하세요
# SELECT B.USER_ID, B.NICKNAME, CONCAT(B.STREET_ADDRESS1, B.STREET_ADDRESS2) AS 전체주소, 
# CONCAT (substring(B.TLNO,1,3),"-",substring(B.TLNO,4,4),"-",substring(B.TLNO,8,4)) AS 전화번호
SELECT B.user_id,B.nickname
,concat(B.city,' ',B.street_address1,' ',B.street_address2) AS 전체주소
,concat(LEFT(tlno,3), '-', MID(tlno,4,4),'-', RIGHT(tlno,4)) AS 전화번호
FROM USED_GOODS_BOARD A
JOIN USED_GOODS_USER B
ON A.WRITER_ID = B.USER_ID
GROUP BY WRITER_ID
HAVING COUNT(WRITER_ID) >= 3 
ORDER BY B.USER_ID DESC
