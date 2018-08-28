SELECT sr.stud_id, sr.grade,  
(sr.credit * (CASE 
   WHEN sr.grade = 'A' THEN  5
   WHEN sr.grade = 'B' THEN 7
   ELSE 4
END)/ sr.credit) AS GPA
FROM semester_result as sr

/*
WHERE sr.stud_id = 101
--SELECT *FROM semester_fee
--SELECT *FROM syllabus
INSERT into ()


SELECT 
SELECT (SELECT SUM(amount) FROM semester_fee)-(SELECT SUM(amount) FROM semester_fee WHERE paid_year = 2018) AS S
--SELECT * FROM syllabus

*/