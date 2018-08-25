INSERT INTO college_department(cdept_id,udept_code,college_id)
VALUES ('121','ANIT','071'),
		 ('122','ANEC','071'),
		 ('123','ANCS','072'),
		 ('124','ANIT','072'),
		 ('221','BHEC','073'),
		 ('222','BHCS','073'),
		 ('223','BHAE','074'),
		 ('224','BHME','074')
		 

INSERT INTO syllabus(`id`,cdept_id,syllabus_code,syllabus_name)
VALUES ('501','121','S501','FOCP'),
		 ('502','121','S502','DBMS'),
		 ('503','122','S511','S&S'),
		 ('504','122','S512','AWP'),
		 ('505','123','S521','OS'),
		 ('506','123','S522','OOPS'),
		 ('507','124','S531','FOCP'),
		 ('508','124','S532','DBMS'),
		 ('601','221','S601','MPMC'),
		 ('611','221','S602','EDC'),
		 ('612','222','S611','N&C'),
		 ('613','222','S612','FOCP'),
		 ('614','223','S621','AvE'),
		 ('615','223','S622','ToA'),
		 ('616','224','S631','FM'),
		 ('617','224','S632','BME')
		 
INSERT INTO professor_syllabus(emp_id,syllabus_id,semester)
VALUES (901,501,1),
		 (901,502,2)

TRUNCATE TABLE professor_syllabus
SELECT * FROM professor_syllabus
		 
INSERT INTO department(dept_code,dept_name,univ_code)
VALUES ('ANIT','Information Technology','ANUV'),
		 ('ANCS','Computer Science','ANUV'),
		 ('ANEC','Electronics and Communication Engineering','ANUV'),
		 ('ANME','Mechanical','ANUV'),
		 ('ANAE','Aeronautical engineering','ANUV'),
		 ('BHIT','Information Technology','BHUV'),
		 ('BHCS','Computer Science','BHUV'),
		 ('BHEC','Electronics and Communication Engineering','BHUV'),
		 ('BHME','Mechanical','BHUV'),
		 ('BHAE','Aeronautical engineering','BHUV')


INSERT INTO college(`id`,`code`,`name`,`univ_code`,`city`,`state`,`year_opened`)
VALUES('071','4501','PPG college','ANUV','Coimbatore','Tamilnadu','2008'),
		('072','4502','SNS college','ANUV','Madurai','Tamilnadu','2004'),
		('073','5501','RK college','BHUV','Madurai','Tamilnadu','2000'),
		('074','5502','Sasurie college','BHUV','Coimbatore','Tamilnadu','1996')

INSERT INTO university(`univ_code`,`university_name`)
VALUES ('ANUV','Anna University'),
   	 ('BHUV','Bharathiar University')

		 
INSERT INTO designation(`id`,`name`,`rank`)
VALUES(101,'Principal','A'),
		(102,'HOD','B'),
      (103,'Professor','C')
     
		 
		 
		 
		 	