SELECT `name`
FROM colleges
WHERE 

SELECT * FROM designation
SELECT * FROM college

SELECT u.`university_name`, c.`name`
FROM department AS d 
LEFT JOIN university AS u on d.univ_code = u.univ_code
RIGHT JOIN college AS c
ON c.univ_code = d.univ_code

WHERE dept_name = 'Computer Science' OR dept_name = 'Information Technology'


--AND (ed.desg_id=(SELECT   id  from designation where `name`= 'HOD'))
--JOIN employee as ed ON ed.college_id = c.id

SELECT d.dept_name, d.univ_code, u.university_name, c.name, c.id from department AS d 
JOIN college_department As cd ON d.dept_code=cd.udept_code
JOIN college As c ON c.id=cd.college_id
JOIN university As u ON u.univ_code = c.univ_code
WHERE d.dept_name = 'Computer Science' OR d.dept_name = 'Information Technology' 




SELECT d.dept_name, d.univ_code, u.university_name, c.name, c.id , e.name, ed.name from department as d 
JOIN college_department As cd ON d.dept_code=cd.udept_code
JOIN college As c ON c.id=cd.college_id 
JOIN employee as e ON e.college_id = c.id
JOIN designation as ed ON ed.id=e.desg_id
JOIN university As u ON u.univ_code = c.univ_code
WHERE d.dept_name = 'Computer Science' OR d.dept_name= 'Information Technology'  AND e.college_id = c.id
group by e.id


SELECT *FROM college


	 SELECT  `code`,c.`name`,`city`,`state`,`year_opened`,`university_name`,`dept_name`,ed.name,e.`name` 
      FROM  university AS u
            INNER JOIN  college AS c
            ON  u.univ_code = c.univ_code

            INNER JOIN  department AS d
	        ON 	u.univ_code = d.univ_code
            
            INNER JOIN  employee AS e
		    ON  c.id = e.college_id

            INNER JOIN  designation AS ed
		    ON  ed.id = e.desg_id
	HAVING  dept_name = 'Information Technology'
	    OR  dept_name = 'Computer Science'





SELECT * FROM employee where college_id=72




(SELECT c.`name`,c.state, c.id, c.`code`, c.city, c.year_opened
FROM college AS c
WHERE id IN (SELECT college_id
FROM college_department AS cd
WHERE udept_code IN (SELECT dept_code
FROM department AS ud
WHERE dept_name = 'Computer Science' OR dept_name = 'Information Technology')));

SELECT `name`
FROM designation 
WHERE `id` NOT IN (SELECT desg_id
						 FROM employee
						 WHERE college_id=74
						 GROUP BY desg_id );

SELECT `name`
FROM designation
WHERE EXISTS (SELECT `id` FROM employee WHERE `id` != desg_id);

SELECT college_id
FROM Customers
GROUP BY Country
HAVING COUNT(CustomerID) > 5;