CREATE TABLE webservice_address (
    PRIMARY KEY(id),
    id          BIGINT(20)    AUTO_INCREMENT,
    street      VARCHAR(100)  NOT NULL,
    city        VARCHAR(15)   NOT NULL,
    postal_code INT(11)       NOT NULL
);

CREATE TABLE webservice_person (
    PRIMARY KEY(id),
    UNIQUE KEY (email),
    id              BIGINT(20)   AUTO_INCREMENT,
    first_name      VARCHAR(50)  NOT NULL,
    last_name       VARCHAR(50)  NOT NULL,
    email           VARCHAR(100) NOT NULL,
    `password`      VARCHAR(60)  NOT NULL,
    isadmin         BOOLEAN,
    address_id      BIGINT(20)   NOT NULL,
    birth_date      DATE         NOT NULL,
    created_date    DATETIME     NOT NULL,
    KEY k_address (address_id),
    CONSTRAINT fk_webservice_person_webservice_address
    FOREIGN KEY (address_id) REFERENCES webservice_address (id) ON DELETE NO ACTION ON UPDATE NO ACTION
);
