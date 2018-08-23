CREATE TABLE university (
	 PRIMARY KEY(`univ_code`),
	 `univ_code`       CHAR(4),
	 `university_name` VARCHAR(100) NOT NULL
);
					
CREATE TABLE college (
	 PRIMARY KEY(`id`),
	 `id` 	   	  INT ,
	 `code`        CHAR(4)      NOT NULL,
	 `name`        VARCHAR(100) NOT NULL,
	 `univ_code`   CHAR(4),
	 `city`        VARCHAR(50)  NOT NULL,
	 `state`       VARCHAR(50)  NOT NULL,
	 `year_opened` YEAR(4)      NOT NULL,
	               KEY k_college_university (`univ_code`),
	               CONSTRAINT fk_college_university
	               FOREIGN KEY (`univ_code`) REFERENCES university (`univ_code`) ON DELETE NO ACTION ON UPDATE NO ACTION
);
					
CREATE TABLE department (
	 PRIMARY KEY(`dept_code`),
	 `dept_code` CHAR(4),
	 `dept_name` VARCHAR(50)   NOT NULL,
	 `univ_code` CHAR(4),
	             KEY k_depatment_university (`univ_code`),
	             CONSTRAINT fk_depatment_university
	             FOREIGN KEY (`univ_code`) REFERENCES university(`univ_code`) ON DELETE NO ACTION ON UPDATE NO ACTION
);
					
CREATE TABLE college_department	(
	 PRIMARY KEY(`cdept_id`),
	 `cdept_id`   INT,
	 `udept_code` CHAR(4),
	 `college_id` INT,
	              KEY k_college_depatment_department (`udept_code`),
	              KEY k_college_department_college (`college_id`),
	              CONSTRAINT fk_college_depatment_department
	              FOREIGN KEY (`udept_code`) REFERENCES department(`dept_code`) ON DELETE NO ACTION ON UPDATE NO ACTION,
	              CONSTRAINT fk_college_department_college 
	              FOREIGN KEY (`college_id`) REFERENCES college(`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
);
					
CREATE TABLE syllabus (
	 PRIMARY KEY(`id`),
	 `id`             INT,
	 `cdept_id`       INT,
	 `syllabus_code`  CHAR(4)      NOT NULL,
	 `syllabus_name`  VARCHAR(100) NOT NULL,
	                  KEY k_syllabus_college_department (`cdept_id`),
	                  CONSTRAINT fk_syllabus_college_department      
	                  FOREIGN KEY (`cdept_id`) REFERENCES college_department(`cdept_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
);
					
CREATE TABLE designation(
	 PRIMARY KEY(`id`),
	 `id`   INT,
	 `name` VARCHAR(30) NOT NULL,
	 `rank` CHAR(1)     NOT NULL
);
					
CREATE TABLE employee	(
	 PRIMARY KEY(`id`),
	 `id`         INT,
	 `name`       VARCHAR(100)  NOT NULL,
	 `dob`        DATE          NOT NULL,
	 `email`      VARCHAR(50)   NOT NULL,
	 `phone`      BIGINT        NOT NULL,
	 `college_id` INT,
	 `cdept_id`    INT,
	 `desg_id`    INT,
	              KEY k_employee_college (`college_id`),
	              KEY k_employee_college_department (`cdept_id`),
	              KEY k_employee_designation (`desg_id`),
	              CONSTRAINT fk_employee_college 
	              FOREIGN KEY (`college_id`) REFERENCES college(`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,    
	              CONSTRAINT fk_employee_college_department
	              FOREIGN KEY (`cdept_id`) REFERENCES college_department(`cdept_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
	              CONSTRAINT fk_employee_designation FOREIGN KEY (`desg_id`) REFERENCES designation(`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
);

			
CREATE TABLE professor_syllabus(
	 `emp_id`      INT,
	 `syllabus_id` INT,
	 `semester`    TINYINT       NOT NULL,
	               KEY k_professor_syllabus_employee (`emp_id`),
	               KEY k_professor_syllabus_syllabus (`syllabus_id`),
	               CONSTRAINT fk_professor_syllabus_employee    
						FOREIGN KEY (`emp_id`) REFERENCES employee(`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
	               CONSTRAINT fk_professor_syllabus_syllabus
	               FOREIGN KEY (`syllabus_id`) REFERENCES syllabus(`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
);


CREATE TABLE student(
	 PRIMARY KEY(`id`),
	 `id`                 INT,
	 `rollnumber`         CHAR(8)       NOT NULL,
	 `name`        	    VARCHAR(100)  NOT NULL,
	 `dob`         	    DATE          NOT NULL,
	 `gender`     	       CHAR(1)       NOT NULL,
	 `email`      	       VARCHAR(50)   NOT NULL,
	 `phone`      	       BIGINT        NOT NULL,
	 `address`            VARCHAR(200)  NOT NULL,
	 `academic_year`      YEAR(4)       NOT NULL,
	 `cdept_id`           INT,
	 `college_id`         INT,
	                      KEY k_student_college_department  (`cdept_id`),
	                      KEY k_student_college_college (`college_id`),
	                      CONSTRAINT fk_student_college_department      
	                      FOREIGN KEY (`cdept_id`) REFERENCES college_department(`cdept_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,    
	                      CONSTRAINT fk_student_college_college
	                      FOREIGN KEY (`college_id`) REFERENCES college(`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
);
					
CREATE TABLE semester_fee(
	 `cdept_id`    INT,
	 `stud_id`     INT,
	 `semester`    TINYINT     NOT NULL,
	 `amount`      DOUBLE(18,2),
	 `paid_year`   YEAR(4),
	 `paid_status` VARCHAR(10) NOT NULL,
	               KEY k_semester_fee_college_department  (`cdept_id`),
	               KEY k_semester_fee_student (`stud_id`),
	               CONSTRAINT fk_semester_fee_college_department  
              	   FOREIGN KEY (`cdept_id`) REFERENCES college_department(`cdept_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
					   CONSTRAINT fk_semester_fee_student   
					   FOREIGN KEY (`stud_id`) REFERENCES student(`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
);
					
CREATE TABLE semester_result(
	 `stud_id`     INT,
	 `syllabus_id` INT,
	 `semester`    TINYINT       NOT NULL,
	 `grade`       VARCHAR(2)    NOT NULL,
	 `credit`      FLOAT         NOT NULL,
	 `result_date` DATE          NOT NULL,
	          		KEY k_semester_result_student (`stud_id`),
	          		KEY k_semester_result_syllabus (`syllabus_id`),
						CONSTRAINT fk_semester_result_student    
					   FOREIGN KEY (`stud_id`) REFERENCES student(`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
						CONSTRAINT fk_semester_result_syllabus
					   FOREIGN KEY (`syllabus_id`) REFERENCES syllabus(`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
);


		
		
					