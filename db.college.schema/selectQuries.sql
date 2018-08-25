

-- Select College details which are having IT / CSC departments across all the universities.

SELECT d.dept_code,d.univ_code, cd.college_id,d.dept_name, c.`name`, e.`name`, ed.`name`,u.university_name  
  FROM department AS d
		 JOIN college_department AS cd 
		   ON cd.udept_code = d.dept_code
		 JOIN college AS c 
		   ON c.id = cd.college_id
		 JOIN university AS u 
		   ON u.univ_code = c.univ_code
		 JOIN employee AS e 
		   ON e.cdept_id = cd.cdept_id
		 JOIN designation AS ed 
		   ON ed.id = e.desig_id
		      WHERE dept_name = 'Computer Science' 
				    OR dept_name = 'Information Technology' HAVING (ed.`name`)='HOD'
				    
-- Select final year students
		    
 SELECT s.name,s.rollnumber,s.gender,s.email,s.phone,s.address,c.name,d.dept_name,c.city,u.university_name
  FROM student AS s
		 JOIN college AS c 
		   ON c.id = s.college_id
		 JOIN college_department AS cd 
		   ON cd.cdept_id = s.cdept_id
		 JOIN department AS d 
		   ON d.dept_code = cd.udept_code
		 JOIN university AS u 
		   ON d.univ_code = u.univ_code
				WHERE `academic_year` = '2014' 
				  AND `university_name` = 'Anna university' 
				  AND c.city = 'Madurai'
              
 -- Select students details who are studying under a particular university and selected cities alone
 
SELECT stud.rollnumber, stud.`name`, stud.gender, stud.dob, stud.email, stud.phone, stud.address, detail.clg_name AS `college`, detail.udept AS `department`, detail.d_head AS HOD  
  FROM student AS stud,(SELECT cd.cdept_id AS dept, ud.dept_name AS udept, e.`name` AS d_head ,uc.c_name AS clg_name, uc.c_id AS cid  
                          FROM employee AS e, (SELECT c.`name` AS c_name, c.id AS c_id, c.city AS c_city, c.univ_code AS c_c, u.university_name AS un 
                                                 FROM college AS c
                                                 JOIN university AS u 
                                                   ON u.univ_code=c.univ_code
                                                WHERE c.city= 'Coimbatore' AND u.university_name= 'Anna University') AS uc
                          JOIN designation AS d
                          JOIN college_department AS cd
                          JOIN department AS ud
                         WHERE e.college_id = uc.c_id AND d.id=e.desig_id AND d.`name`='HOD' AND cd.cdept_id=e.cdept_id AND ud.dept_code=cd.udept_code) AS detail
 WHERE detail.cid = stud.college_id AND detail.dept=stud.cdept_id
 LIMIT 0,20
 
 
 -- List Employees details from a particular university
 
 SELECT detail.un AS University, detail.cname AS `College Name`, detail.udn AS Department, emp.`name` AS `Faculty Name`, desig.`name` AS `Designation`, desig.rank AS `Rank` FROM employee AS emp, designation AS desig
  JOIN (SELECT univ.univ_code AS uc, univ.university_name AS un, ud.dept_name AS udn, clg.id AS cid ,cd.cdept_id AS cdid,clg.`name` AS cname FROM college AS clg, (SELECT univ_code, university_name FROM university
                                WHERE university_name = 'ANNA UNIVERSITY' ) AS univ
                                 JOIN department AS ud
                                 JOIN college_department AS cd
 WHERE clg.univ_code = univ.univ_code AND ud.univ_code=univ.univ_code AND cd.college_id=clg.id AND cd.udept_code = ud.dept_code) AS detail
 WHERE emp.college_id = detail.cid AND emp.cdept_id=detail.cdid AND emp.desig_id=desig.id
ORDER BY detail.cname ASC,desig.rank ASC

 
 --List Students details along with their GRADE,CREDIT and GPA details
from all universities
 SELECT  stud.id, stud.`name` , sy.id, sy.syllabus_code, sy.syllabus_name, sr.grade, sr.credit , detail.udname, detail.uname AS University FROM student AS stud
  JOIN (SELECT cd.cdept_id AS cdid, clg.id AS cid, u.university_name AS uname, ud.dept_name AS udname  FROM college AS clg 
          JOIN university AS u ON u.univ_code=clg.univ_code
          JOIN department AS ud
          JOIN college_department AS cd
         WHERE `name`='sns college' AND cd.college_id=clg.id AND ud.dept_code = cd.udept_code) AS detail ON stud.college_id = detail.cid AND stud.cdept_id = cdid
  JOIN semester_result AS sr ON sr.stud_id = stud.id
  JOIN syllabus AS sy ON sy.id = sr.syllabus_id
 WHERE sr.semester = 8
 
 
 


 
 
 
 
 