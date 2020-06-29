CREATE TABLE user_account(
id INTEGER PRIMARY KEY,
username VARCHAR(50) UNIQUE NOT NULL,
password VARCHAR(50) NOT NULL,
email VARCHAR(100) UNIQUE NOT NULL,
tax_number INTEGER UNIQUE NOT NULL,
first_name VARCHAR(100),
last_name VARCHAR(100)
);

CREATE SEQUENCE user_account_seq;

select * from user_account