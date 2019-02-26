CREATE TABLE sr_address (
    PRIMARY KEY(id),
    id          BIGINT(20)    AUTO_INCREMENT,
    street      VARCHAR(100)  NOT NULL,
    city        VARCHAR(15)   NOT NULL,
    postal_code INT(11)       NOT NULL
);

CREATE TABLE sr_person (
    PRIMARY KEY(id),
    UNIQUE KEY (email),
    id              BIGINT(20)   AUTO_INCREMENT,
    first_name      VARCHAR(50)  NOT NULL,
    last_name       VARCHAR(50)  NOT NULL,
    email           VARCHAR(100) NOT NULL,
    address_id      BIGINT(20)   NOT NULL,
    birth_date      DATE         NOT NULL,
    created_date    DATETIME     NOT NULL,
    KEY k_address (address_id),
    CONSTRAINT fk_sr_person_sr_address
    FOREIGN KEY (address_id) REFERENCES sr_address (id) ON DELETE NO ACTION ON UPDATE NO ACTION
);
