--Problem 9 (a)
SELECT sf.amount, sf.paid_status, sf.semester FROM semester_fee as sf
JOIN student AS s ON s.id = sf.stud_id
WHERE sf.semester= 8 AND s.id IN (SELECT s.id FROM student AS s 
JOIN college AS c ON c.id = s.college_id
WHERE college_id = 71)

--Problem 9 (b)
SELECT sf.paid_status, sf.amount, u.university_name FROM university as u
JOIN college AS c ON c.univ_code = u.univ_code
JOIN student AS s ON s.college_id = c.id
JOIN semester_fee AS sf ON sf.stud_id = s.id
WHERE u.univ_code = 'ANUV' AND paid_status = 'paid'







SELECT sf.amount FROM semester_fee as sf
WHERE paid_status='Paid'

JOIN college AS c ON c.id = sf.stud_id

SELECT * FROM semester_fee as sf
JOIN student AS s ON sf.stud_id = s.id

SELECT paid_status, amount FROM semester_fee
WHERE paid_status = 'paid'

SELECT sf.paid_status, sf.amount, u.university_name FROM university as u
JOIN college AS c ON c.univ_code = u.univ_code
JOIN student AS s ON s.college_id = c.id
JOIN semester_fee AS sf ON sf.stud_id = s.id
WHERE u.univ_code = 'ANUV' AND paid_status = 'paid'












SELECT s.id FROM student AS s 
JOIN college AS c ON c.id = s.college_id
WHERE college_id = 71