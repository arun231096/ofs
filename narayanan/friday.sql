

ALTER TABLE semester_fee
ALTER COLUMN paid_status SET DEFAULT 'Not paid';

UPDATE TABLE semester_fee
SET paid_status = 'Not Paid'

ALTER TABLE semester_fee MODIFY paid_year YEAR NULL

SELECT * FROM professor_syllabus
SELECT * FROM semester_fee
TRUNCATE semester_fee

SELECT * FROM employee AS e, (SELECT c.`name`, c.id AS c_id, c.city AS c_city, c.univ_code AS c_c, u.university_name AS un FROM college AS c
         JOIN university AS u 
           ON u.univ_code=c.univ_code
        WHERE c.city= 'Coimbatore') AS uc
  JOIN designation AS d
  JOIN college_department AS cd
  JOIN department AS ud
 WHERE e.college_id = uc.c_id AND d.id=e.desg_id AND d.`name`='HOD' AND cd.cdept_id=e.dept_id AND ud.dept_code=cd.udept_code
 

SELECT d.name FROM department as d 
WHERE d.name='Computer Science' and d.name='Information Technology'


SELECT *
FROM employee AS e 
JOIN designation as de ON de.id = e.desg_id 
WHERE de.name='HOD'
