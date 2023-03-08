CREATE SCHEMA IF NOT EXISTS test_hw2;

CREATE TABLE IF NOT EXISTS test_hw2.users
(
    id        bigserial    not null primary key,
    username  varchar(256) not null unique,
    firstname varchar,
    lastname  varchar,
    email     varchar,
    phone     varchar
);