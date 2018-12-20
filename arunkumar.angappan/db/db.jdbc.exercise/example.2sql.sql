select * from webservice_person join webservice_address on webservice_person.address_id = webservice_address.id

select *from webservice_address join sr_address as a on sr_person.sr_address_id = a.id

 where id = 15 FOR UPDATE

select * from sr_address where postal_code LIKE '%60%' OR street LIKE '%60%' OR city LIKE '%60%';

select * from demo

create table demo (
    id int primary key auto_increment,
    `name` varchar(20)
);
DESC sr_address
DROP table sr_person;
DROP table sr_address;

DELETE FROM sr_person;
DELETE FROM sr_address;
ALTER TABLE sr_person AUTO_INCREMENT = 1;
ALTER TABLE sr_address AUTO_INCREMENT = 1;

truncate sr_address

DELETE FROM sr_address WHERE id = 1

SELECT first_name, email, sr_address_id, birth_date, created_date FROM sr_person WHERE id = 1

SELECT street, city, postal_code FROM sr_address WHERE id = 161


START TRANSACTION;
UPDATE sr_address SET city = 'Chennai' WHERE id = 16;
SELECT id, street, city, postal_code FROM sr_address WHERE id = 16;
COMMIT;




SELECT  
 email,
 `password`,
 isadmin,
  FROM webservice_person
 WHERE email = ?
   AND `password` = ?