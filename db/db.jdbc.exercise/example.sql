select * from person join address on person.address_id = address.id

select *from address join address as a on person.address_id = a.id

 where id = 15 FOR UPDATE

select * from demo

create table demo (
    id int primary key auto_increment,
    `name` varchar(20)
);
DESC address

truncate address

DELETE FROM address WHERE id = 64

SELECT name, email, address_id, birth_date, created_date FROM person WHERE id = 1

SELECT street, city, postal_code FROM address WHERE id = 161


START TRANSACTION;
UPDATE address SET city = 'Chennai' WHERE id = 16;
SELECT id, street, city, postal_code FROM address WHERE id = 16;
COMMIT;



