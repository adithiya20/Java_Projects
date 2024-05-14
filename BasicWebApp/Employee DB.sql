USE employees;
CREATE TABLE employee(
id int(3) NOT NULL,
first_name VARCHAR(20) DEFAULT NULL,
last_name VARCHAR(20) DEFAULT NULL,
username VARCHAR(250) DEFAULT NULL,
pass_word VARCHAR(20) DEFAULT NULL,
address VARCHAR(45) DEFAULT NULL,
contact VARCHAR(45) DEFAULT NULL,
PRIMARY KEY (id)
);

#describes the employee table
DESCRIBE employee;

SELECT * FROM employee;
login