--List Students details along with their GRADE,CREDIT and GPA details

 SELECT  stud.id, stud.`name` , sy.id, sy.syllabus_code, sy.syllabus_name, sr.grade, sr.credit , detail.udname, detail.uname AS University FROM student AS stud
  JOIN (SELECT cd.cdept_id AS cdid, clg.id AS cid, u.university_name AS uname, ud.dept_name AS udname  FROM college AS clg 
          JOIN university AS u ON u.univ_code=clg.univ_code
          JOIN department AS ud
          JOIN college_department AS cd
         WHERE `name`='sns college' AND cd.college_id=clg.id AND ud.dept_code = cd.udept_code) AS detail ON stud.college_id = detail.cid AND stud.cdept_id = cdid
  JOIN semester_result AS sr ON sr.stud_id = stud.id
  JOIN syllabus AS sy ON sy.id = sr.syllabus_id
 WHERE sr.semester = 8
 LIMIT 20