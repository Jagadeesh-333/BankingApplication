-- schema.sql

CREATE TABLE account (
    id BIGINT AUTO_INCREMENT,
    account_holder_name VARCHAR(255),
    balance DOUBLE,
    PRIMARY KEY (id)
);
