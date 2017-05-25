-- create database OMS;

USE OMS;


DROP TABLE SALES;
DROP TABLE ORDER_CLIENT;
DROP TABLE DVD;
DROP TABLE Book;
DROP TABLE Product;


CREATE TABLE Product
(
codp		INTEGER(50) auto_increment,
title		varchar(50),
cost		Double(5,2),
stock		Integer(5),
category	varchar(50),
constraint codp_pk primary key (codp)
);

INSERT INTO Product (title,cost,stock,category) VALUES ('Java de la 0 la Expert',78.00,10,'Education'); -- Book
INSERT INTO Product (title,cost,stock,category) VALUES ('Top 100',20.00,15,'Top 100'); -- DVD
INSERT INTO Product (title,cost,stock,category) VALUES ('Head first Java',200.00,5,'Education'); -- Book
INSERT INTO Product (title,cost,stock,category) VALUES ('Californication',80.00,10,'Rock'); -- DVD

SELECT * FROM Product;

CREATE TABLE Book
(
codp		INTEGER(50),
authors		varchar(50),
pages		Integer(5),
constraint codp_fk foreign key (codp) references Product (codp)
);

INSERT INTO Book VALUES (1,'Cineva',1000);
INSERT INTO Book VALUES (3,'Altu',400);

SELECT * FROM Book;

CREATE TABLE DVD
(
codp		INTEGER(50),
director	varchar(50),
length 		Integer(6),
constraint codp_fk foreign key (codp) references Product (codp)
);

INSERT INTO DVD VALUES (2,'ala e',5000);
INSERT INTO DVD VALUES (4,'alalalt e',8000);

SELECT * FROM DVD;

CREATE TABLE ORDER_CLIENT
(
codo		INTEGER(50) auto_increment,
userId		Integer(5),
constraint codo_pk	primary key (codo)
);

INSERT INTO ORDER_CLIENT (userId) VALUES (100);
INSERT INTO ORDER_CLIENT (userId) VALUES (102);

SELECT * FROM ORDER_CLIENT;


CREATE TABLE SALES
(
codp		INTEGER(50),
codo		INTEGER(50),
constraint codp_fk foreign key (codp) references Product (codp),
constraint codo_fk foreign key (codo) references ORDER_CLIENT (codo)
);

INSERT INTO SALES VALUES (1,100);
INSERT INTO SALES VALUES (2,102);

SELECT* FROM SALES;