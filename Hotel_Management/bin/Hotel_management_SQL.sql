CREATE DATABASE hotelmanagementsystem;
SHOW DATABASES;

USE hotelmanagementsystem;

CREATE TABLE login(username varchar(25), password varchar(25));
INSERT INTO login values('admin','12345');
SELECT * FROM login;

CREATE TABLE employee(ID varchar(10) NOT NULL PRIMARY KEY,
					E_name varchar(25) ,
					Age varchar(10), 
                    Gender varchar(15),
                    job varchar(30),
                    Salary varchar(15), 
                    Phone varchar(15), 
                    Email varchar(40)
                    );

CREATE TABLE room(Roomnumber varchar(10) not null PRIMARY KEY, 
				Availability varchar(20), 
                Cleaning_status varchar(20),
                Price VARCHAR(25), 
                Bed_type varchar(20));
                
                
CREATE TABLE driver(ID varchar(10) NOT NULL PRIMARY KEY,
					D_name varchar(50),
					Age varchar(5), 
					Gender varchar(50),
                    Car_company varchar(50),
                    Car_model varchar(50),
                    Availability varchar(50));
                    
CREATE TABLE customer(ID varchar(50) NOT NULL PRIMARY KEY,
					Document varchar(50),
					C_name varchar(50), 
					Phone varchar(50), 
                    Gender varchar(10), 
                    Country varchar(50),
                    Roomnumber int(10),
                    Checkin_time varchar(50),
                    Checkout_time varchar(50),
                    Deposit varchar(50));


SELECT * FROM customer;