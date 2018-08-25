CREATE TABLE professor_syllabus(
					 PRIMARY KEY(`emp_id`),
					`emp_id`      INT,
					`syllabus_id` INT,
					`semester`    TINYINT       NOT NULL,
									  KEY k_profsyllabus_employee (emp_id),
									  CONSTRAINT fk_profsyllabus_employee
									  FOREIGN KEY (`emp_id`)      REFERENCES employee(`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
									  KEY k_profsyllabus_syllabus (syllabus_id),
									  CONSTRAINT fk_profsyllabus_syllabus
									  FOREIGN KEY (`syllabus_id`) REFERENCES syllabus(`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
					);
					
					SELECT * FROM professor_syllabus
					
							 
INSERT INTO professor_syllabus(emp_id,syllabus_id,semester)
VALUES (904,501,6),
       (921,502,8),
       (905,503,6),
       (922,504,8),
       (909,505,6),
       (923,506,8),
       (910,507,6),
       (924,508,8),
       (914,601,6),
       (925,611,8),
       (915,612,6),
       (926,613,8),
       (919,614,6),
       (927,615,8)