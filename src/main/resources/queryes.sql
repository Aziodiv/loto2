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



CREATE TABLE bet(
    id INTEGER PRIMARY KEY,
    number1 INTEGER NOT NULL,
    number2 INTEGER NOT NULL,
    number3 INTEGER NOT NULL,
    number4 INTEGER NOT NULL,
    number5 INTEGER NOT NULL,
    number6 INTEGER NOT NULL,
	user_account_id INTEGER NOT NULL,
	active BOOLEAN NOT NULL,
	datetime TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT NOW(),
	FOREIGN KEY (user_account_id) REFERENCES user_account (id)
);

CREATE SEQUENCE user_account_seq;


CREATE TABLE play_result(
    id INTEGER PRIMARY KEY,
    number1 INTEGER NOT NULL,
    number2 INTEGER NOT NULL,
    number3 INTEGER NOT NULL,
    number4 INTEGER NOT NULL,
    number5 INTEGER NOT NULL,
    number6 INTEGER NOT NULL,
	datetime TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT NOW());


CREATE SEQUENCE play_result_seq;