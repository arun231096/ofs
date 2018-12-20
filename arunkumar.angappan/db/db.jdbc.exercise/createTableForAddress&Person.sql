CREATE TABLE address (
    PRIMARY KEY(id),
    id          BIGINT(20)    AUTO_INCREMENT,
    street      VARCHAR(100),
    city        VARCHAR(15)   NOT NULL,
    postal_code INT(11)       NOT NULL
);

CREATE TABLE person (
    PRIMARY KEY(id),
    UNIQUE KEY (email),
    id           BIGINT(20)   AUTO_INCREMENT,
    `name`       VARCHAR(50)  NOT NULL,
    email        VARCHAR(100) NOT NULL,
    address_id   BIGINT(20)   NOT NULL,
    birth_date   DATE         NOT NULL,
    created_date DATETIME     NOT NULL,
    KEY k_address (address_id),
    CONSTRAINT fk_person_address
    FOREIGN KEY (address_id) REFERENCES address (id) ON DELETE NO ACTION ON UPDATE NO ACTION
);

ALTER TABLE address MODIFY COLUMN postal_code INT(11) NOT NULL;

ALTER TABLE person MODIFY COLUMN email VARCHAR(100) UNIQUE KEY;