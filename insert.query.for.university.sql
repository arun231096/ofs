INSERT INTO university(`univ_code`,`university_name`)
VALUES ('A100','Anna University'),
		 ('P100','Periyar University');
							 
INSERT INTO college(`id`,`code`,`name`,`univ_code`,`city`,`state`,`year_opened`)
VALUES ('223','A675','karpgam college of engineering','A100','Coimbatore','Tamilnadu','1999'),
       ('212','A645','sns college of engineering','A100','Coimbatore','Tamilnadu','1998'),
		 ('434','P987','Paavai college of engineering','P100','Namakkal','Tamilnadu','2001'),
		 ('365','P543','Sairam college of engineering','P100','Chennai','Tamilnadu','2003');
		 
					
INSERT INTO department(`dept_code`,`dept_name`,`univ_code`)
VALUES ('A221','Information Technology','A100'),
		 ('A222','Electrical and Electronics Engineering','A100'),
		 ('A223','Mechanical Engineering','A100'),							
		 ('A224','Computer Science','A100'),
		 ('A225','Electronics and Telecommunication Engineering','A100'),
		 ('A226','Civil Engineering','A100'),
		 ('A227','Electronics and Instrumentation Engineering','A100'),
		 ('P221','Information Technology','P100'),
		 ('P222','Electrical and Electronics Engineering','P100'),
		 ('P223','Mchanical Engineering','P100'),							
		 ('P224','Computer Science','P100'),
		 ('P225','Electronics and Telecommunication Engineering','P100'),
		 ('P226','Civil Engineering','P100'),
		 ('P227','Electronics and Instrumentation Engineering','P100'),
		 ('P230','Mechatronics Engineering','P100');
							
														
														
INSERT INTO college_department(`cdept_id`,`udept_code`,`college_id`)
VALUES ('221','A221','223'),		
		 ('222','A222','223'),																				
		 				   
		 ('321','A221','212'),		
		 ('322','A224','212'),							
																				
		 				
		 ('521','P221','434'),		
		 ('522','P222','434'),
		 					
		 ('621','P221','365'),		
		 ('622','P224','365');
					

INSERT INTO syllabus(`id`,cdept_id,syllabus_code,syllabus_name)
VALUES   ('2100','221','IT01','oops'),
		 ('2101','221','IT02','Java'),
		 ('2200','222','EC01','DSP'),
		 ('2201','222','EC02','Control Networks'),
		 
		 ('3100','321','IT01','oops'),
		 ('3101','321','IT02','Java'),
		 ('3201','322','CS02','Computer Networks'),
		 ('3202','322','CS03','DSP'),
		 
		 ('5100','521','PT01','oops'),
		 ('5101','521','PT02','Java'),
		 ('5201','522','PC02','Control Networks'),
		 ('5202','522','PC03','DSP'),

		 
		 ('6100','621','PT01','oops'),
		 ('6101','621','PT02','Java'),
		 ('6201','622','PE02','Computer Networks'),
		 ('6202','622','PE03','DSP');
				  		  
				  		  
INSERT INTO designation(`id`,`name`,`rank`)
VALUES ('1100','HOD','A'), 
		 ('1102','FACULTY','C');
				  		  		
				  		  		
			 		 	  		  
INSERT INTO employee(`id`,`name`,`dob`,`email`,`phone`,`college_id`,`cdept_id`,`desg_id`)
VALUES ('1000','karthikeyan','1990-12-20','karthikeyan@gmail.com','9347364834','223','221','12'),
  		 ('1001','Arun','1972-01-20','arun@sasurieinfo.tech','8012893941','212','222','11'),
  		 ('1002','guna','1978-02-22','guna@gmail.com','9715993567','23','222','12');

  			truncate table employee  
			  			  
INSERT INTO professor_syllabus(`emp_id`,`syllabus_id`,`semester`)
VALUES ('1000','2100','3'),
		 ('1002','2101','4');
										
										
--	SELECT *FROM employee									
INSERT INTO student(id,rollnumber,`name`,dob,gender,email,phone,address,academic_year,cdept_id,college_id)
VALUES ('801','F801','arunkumar','1996-10-23','M','arunak283933@gmail.com','7014998731','kumaran kudil,thoraipakam','2017','221','223'),
 		 ('802','F802','kaviraj','1996-02-06','M','kavi@gmail.com','7010998723','kumaran kudil,thoraipakam','2017','221','223'),
 		 ('803','F803','vijay','1995-09-13','M','karthi@gmail.com','9715121633','anna nagar main road,guindy','2017','222','223');
 				 		 
INSERT INTO semester_fee(cdept_id,stud_id,semester,amount,paid_year,paid_status)
VALUES ('221','801','3','23000','2017','PAID'),
		 ('222','803','4','34000','2017','PAID');
								
INSERT INTO semester_result(stud_id,syllabus_id,semester,grade,credit,result_date)
VALUES ('801','2100','5','A+','3.5','2018-12-18'),
		 ('802','2101','5','B+','4.5','2018-12-18'),
		 ('803','2102','5','A+','3.0','2018-12-18');							
