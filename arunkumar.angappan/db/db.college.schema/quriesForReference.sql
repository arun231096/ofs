

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
 
 
 




-- rough work
SELECT s.rollnumber, s.`name`, shc.un, shc.c_city  FROM student AS s 
  JOIN(SELECT cd.udept_code AS c_dc,cd.cdept_id AS c_cd , c.id AS c_id, c.city AS c_city, c.univ_code AS c_c, u.university_name AS un FROM college AS c
         JOIN university AS u 
           ON u.univ_code=c.univ_code
         JOIN college_department AS cd
           ON cd.college_id = c.id
        WHERE c.city= 'Coimbatore') AS shc
    ON shc.c_id =s.college_id
  JOIN (SELECT e.`name` AS emp_name, e.college_id AS emp_cid , ed.`name` AS emp_desg FROM employee AS e
          JOIN designation AS ed ON ed.id = e.desig_id AND ed.`name`='HOD' ) AS she
            ON she.emp_cid=shc.c_id
  WHERE 
  
DESC employee

SELECT *FROM employee  AS e, designation AS d WHERE e.desig_id= d.id AND d.name= 'HOD'



-- question 3
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



SELECT * FROM college AS c
 WHERE c.univ_code= 'BHUV'
 



SELECT univ.univ_code AS uc, univ.university_name AS un, ud.dept_name AS udn, clg.id AS cid ,cd.cdept_id AS cdid,clg.`name` AS cname FROM college AS clg, (SELECT univ_code, university_name FROM university
                                WHERE university_name = 'ANNA UNIVERSITY' ) AS univ
                                 JOIN department AS ud
                                 JOIN college_department AS cd
 WHERE clg.univ_code = univ.univ_code AND ud.univ_code=univ.univ_code AND cd.college_id=clg.id AND cd.udept_code = ud.dept_code


SELECT detail.un AS University, detail.cname AS `College Name`, detail.udn AS Department, emp.`name` AS `Faculty Name`, desig.`name` AS `Designation`, desig.rank AS `Rank` FROM employee AS emp, designation AS desig
  JOIN (SELECT univ.univ_code AS uc, univ.university_name AS un, ud.dept_name AS udn, clg.id AS cid ,cd.cdept_id AS cdid,clg.`name` AS cname FROM college AS clg, (SELECT univ_code, university_name FROM university
                                WHERE university_name = 'ANNA UNIVERSITY' ) AS univ
                                 JOIN department AS ud
                                 JOIN college_department AS cd
 WHERE clg.univ_code = univ.univ_code AND ud.univ_code=univ.univ_code AND cd.college_id=clg.id AND cd.udept_code = ud.dept_code) AS detail
 WHERE emp.college_id = detail.cid AND emp.cdept_id=detail.cdid AND emp.desig_id=desig.id
ORDER BY detail.cname ASC,desig.rank ASC



-- 5th question


SELECT *FROM syllabus where cdept_id= 124



SELECT id FROM college WHERE `name`='sns college'

SELECT *FROM semester_result WHERE semester =8

-- 5th question

SELECT  stud.id, stud.`name` , sy.id, sy.syllabus_code, sy.syllabus_name, sr.grade, sr.credit , detail.udname, detail.uname AS University FROM student AS stud
  JOIN (SELECT cd.cdept_id AS cdid, clg.id AS cid, u.university_name AS uname, ud.dept_name AS udname  FROM college AS clg 
          JOIN university AS u ON u.univ_code=clg.univ_code
          JOIN department AS ud
          JOIN college_department AS cd
         WHERE `name`='sns college' AND cd.college_id=clg.id AND ud.dept_code = cd.udept_code) AS detail ON stud.college_id = detail.cid AND stud.cdept_id = cdid
  JOIN semester_result AS sr ON sr.stud_id = stud.id
  JOIN syllabus AS sy ON sy.id = sr.syllabus_id
 WHERE sr.semester = 8





INSERT INTO semester_fee (cdept id ,stud id,semester,amount)
VALUES (121,100,8,40000,'Not Paid'),
       (121,101,8,40000,'Not Paid'),
       (122,102,8,40000,'Not Paid'),
       (121,103,8,40000,'Not Paid'),
       (122,104,8,40000,'Not Paid'),
       (122,105,8,40000,'Not Paid'),
       (121,106,8,40000,'Not Paid'),
       (121,107,8,40000,'Not Paid'),
       (122,108,8,40000,'Not Paid'),
       (123,142,8,40000,'Not Paid'),
       (123,143,8,40000,'Not Paid'),
       (124,144,8,40000,'Not Paid'),
       (124,145,8,40000,'Not Paid'),
       (123,146,8,40000,'Not Paid'),
       (124,147,8,40000,'Not Paid'),
       (123,148,8,40000,'Not Paid'),
       (123,149,8,40000,'Not Paid'),
       (124,150,8,40000,'Not Paid'),
       (124,151,8,40000,'Not Paid'),
       (123,152,8,40000,'Not Paid'),
       (124,153,8,40000,'Not Paid'),
       (221,189,8,40000,'Not Paid'),
       (222,190,8,40000,'Not Paid'),
       (222,191,8,40000,'Not Paid'),
       (221,192,8,40000,'Not Paid'),
       (221,193,8,40000,'Not Paid'),
       (222,194,8,40000,'Not Paid'),
       (221,195,8,40000,'Not Paid'),
       (222,196,8,40000,'Not Paid'),
       (222,197,8,40000,'Not Paid'),
       (221,198,8,40000,'Not Paid'),
       (221,199,8,40000,'Not Paid'),
       (222,200,8,40000,'Not Paid'),
       (223,234,8,40000,'Not Paid'),
       (223,235,8,40000,'Not Paid'),
       (223,236,8,40000,'Not Paid'),
       (224,237,8,40000,'Not Paid'),
       (224,238,8,40000,'Not Paid'),
       (223,239,8,40000,'Not Paid'),
       (224,240,8,40000,'Not Paid'),
       (224,241,8,40000,'Not Paid'),
       (224,242,8,40000,'Not Paid'),
       (223,243,8,40000,'Not Paid'),
       (223,244,8,40000,'Not Paid'),
       (223,245,8,40000,'Not Paid'),
       (121,109,6,30000,'Not Paid'),
       (122,110,6,30000,'Not Paid'),
       (122,111,6,30000,'Not Paid'),
       (121,112,6,30000,'Not Paid'),
       (121,113,6,30000,'Not Paid'),
       (122,114,6,30000,'Not Paid'),
       (121,115,6,30000,'Not Paid'),
       (122,116,6,30000,'Not Paid'),
       (122,117,6,30000,'Not Paid'),
       (121,118,6,30000,'Not Paid'),
       (123,154,6,30000,'Not Paid'),
       (123,155,6,30000,'Not Paid'),
       (124,156,6,30000,'Not Paid'),
       (124,157,6,30000,'Not Paid'),
       (123,158,6,30000,'Not Paid'),
       (124,159,6,30000,'Not Paid'),
       (123,160,6,30000,'Not Paid'),
       (124,161,6,30000,'Not Paid'),
       (124,162,6,30000,'Not Paid'),
       (123,163,6,30000,'Not Paid'),
       (124,164,6,30000,'Not Paid'),
       (123,165,6,30000,'Not Paid'),
       (123,166,6,30000,'Not Paid'),
       (221,201,6,30000,'Not Paid'),
       (222,202,6,30000,'Not Paid'),
       (222,203,6,30000,'Not Paid'),
       (221,204,6,30000,'Not Paid'),
       (221,205,6,30000,'Not Paid'),
       (222,206,6,30000,'Not Paid'),
       (221,207,6,30000,'Not Paid'),
       (222,208,6,30000,'Not Paid'),
       (222,209,6,30000,'Not Paid'),
       (221,210,6,30000,'Not Paid'),
       (221,211,6,30000,'Not Paid'),
       (222,212,6,30000,'Not Paid'),
       (224,246,6,30000,'Not Paid'),
       (224,247,6,30000,'Not Paid'),
       (223,248,6,30000,'Not Paid'),
       (224,249,6,30000,'Not Paid'),
       (224,250,6,30000,'Not Paid'),
       (224,251,6,30000,'Not Paid'),
       (223,252,6,30000,'Not Paid'),
       (223,253,6,30000,'Not Paid'),
       (223,254,6,30000,'Not Paid'),
       (224,255,6,30000,'Not Paid'),
       (224,256,6,30000,'Not Paid');
       





SELECT  SUM(sf.amount) AS collected , detail.clg_name FROM semester_fee AS sf
JOIN (SELECT stud.id AS sid, unv.cname AS clg_name FROM student AS stud
       JOIN (SELECT u.univ_code, c.`name` AS cname, c.id AS cid FROM university AS u 
              INNER JOIN college AS c ON c.univ_code=u.univ_code
         WHERE university_name = 'Anna University') AS unv ON stud.college_id= unv.cid) AS detail ON sf.stud_id=detail.sid 
WHERE sf.paid_status = 'unpaid'

SELECT *FROM semester_fee
SELECT  * FROM student WHERE college_id =71 AND academic_year =2014
SELECT  COUNT(id) FROM student WHERE AND academic_year =2014
SELECT *FROM college WHERE name = 'ppg college'


 SELECT stud_id, amount, paid_year, clg.`name`, univ.university_name FROM semester_fee AS semfee 
  JOIN student AS stud ON stud.id= stud_id
  JOIN college AS clg ON clg.id= stud.college_id  
  JOIN university AS univ ON univ.univ_code=clg.univ_code
  WHERE paid_year = 2018 
 

SELECT SUM(amount) FROM semester_fee  AS sf
  JOIN student AS stu ON stu.id = sf.stud_id
  JOIN college AS clg ON clg.id= stu.college_id AND clg.univ_code = 'ANUV'
WHERE paid_status= 'unpaid'

SELECT SUM(amount) FROM college AS clg
JOIN student AS stud ON stud.college_id = clg.id
JOIN semester_fee AS sf ON sf.stud_id= stud.id AND paid_status ='Unpaid'
WHERE univ_code = (SELECT univ_code FROM university WHERE university_name= 'Anna University')



SELECT (SELECT SUM(amount) FROM semester_fee AS sf, student AS st, college AS c, university AS u
WHERE  sf.stud_id=st.id AND sf.paid_status= 'unpaid' AND st.college_id = c.id AND c.univ_code=u.univ_code AND c.`name`= 'PPG college'  AND u.university_name = 'Anna University') 
) AS Unpaid,


(SELECT (SELECT SUM(amount) FROM semester_fee AS sf, student AS st, college AS c, university AS u
WHERE  sf.stud_id=st.id AND sf.paid_year=2018 AND st.college_id = c.id AND c.univ_code=u.univ_code AND c.`name`= 'PPG college'  AND u.university_name = 'Anna University') AS Collected,

(SELECT (SELECT c.`name` FROM college AS c, university AS u
WHERE c.`name`= 'PPG college'  AND u.university_name = 'Anna University') AS college_name )


SELECT clg.`name`, univ.university_name, SUM(sf.amount) AS Uncollected_Collected 
  FROM student AS stud, college AS clg, university AS univ , semester_fee AS sf
 WHERE sf.stud_id = stud.id
   AND sf.paid_status = 'Unpaid'
   AND stud.college_id = clg.id
   AND clg.univ_code = 'ANUV' 
   AND clg.`name` = 'ppg college'
 UNION ALL
SELECT clg.`name`, univ.university_name, SUM(sf.amount)  
  FROM student AS stud, college AS clg, university AS univ , semester_fee AS sf
 WHERE sf.stud_id = stud.id
  AND stud.college_id = clg.id
  AND sf.paid_year = 2018 
  AND clg.univ_code = 'ANUV' 
  AND clg.`name` = 'ppg college'

SELECT *FROM student

SELECT *FROM semester_fee WHERE paid_status = 'unpaid'

select *from college AS c
join (select )


SELECT cdept_id, d.dept_name AS Vacancies 
  FROM college_department AS cd 
		 JOIN department AS d 
		   ON d.dept_code = cd.udept_code 
				WHERE cd.cdept_id 
				NOT IN (SELECT e.cdept_id 
							 FROM employee AS e
							WHERE e.desig_id = 102) 

UNION

SELECT cdept_id, d.dept_name AS  Prof_Vacancy
  FROM college_department AS cd 
		 JOIN department AS d 
		   ON d.dept_code = cd.udept_code 
				WHERE cd.cdept_id 
				NOT IN (SELECT e.cdept_id
							 FROM employee AS e
							WHERE e.desig_id = 103)
 
 





















 
 
 