SELECT id FROM student WHERE rollnumber = 'PPIT4001'


SELECT * FROM semester_fee;
SELECT * FROM student ;

--Single update 
UPDATE semester_fee 
SET paid_status = 'Paid',
	 paid_year = '2018'
WHERE stud_id = (SELECT id FROM student WHERE rollnumber = 'PPIT4009')

--Multiple update 
UPDATE semester_fee 
SET paid_status = 'Paid',
	 paid_year = '2018'
WHERE stud_id IN (SELECT id FROM student WHERE rollnumber = 'PPIT4002' OR rollnumber = 'PPIT4003' OR rollnumber = 'PPIT4005')