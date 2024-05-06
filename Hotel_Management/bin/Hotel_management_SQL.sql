CREATE DATABASE hotelmanagementsystem;
SHOW DATABASES;

USE hotelmanagementsystem;

CREATE TABLE login(username varchar(25), password varchar(25));
INSERT INTO login values('admin','12345');
SELECT * FROM login;

CREATE TABLE employee(name varchar(25) not null, age varchar(10), gender varchar(15), job varchar(30),salary varchar(15), phone varchar(15), email varchar(40));
DESCRIBE employee;
SELECT * FROM employee;

CREATE TABLE room(roomnumber int(10) not null, availability varchar(20), cleaning_status varchar(20), price double(10,2), bed_type varchar(20));
SELECT * FROM room;

CREATE TABLE department(department varchar(50), budget varchar(20));
INSERT INTO department VALUES('Front Office','50000'),
('Housekeeping','40000'),('Kitchen and Food Management','40000'),('Security','100000');

CREATE TABLE driver(name varchar(50), age varchar(5), gender varchar(50), car_company varchar(50),car_model varchar(50), availability varchar(50), location varchar(50));
SELECT * FROM driver;

DROP TABLE room;

DROP TABLE customer;


CREATE TABLE customer(ID varchar(50), phone_number varchar(50), name varchar(50), gender varchar(10), country varchar(50),roomnumber int(10),checkin_time varchar(50),checkout_time varchar(50),deposit double(20,2));
SELECT * FROM customer;