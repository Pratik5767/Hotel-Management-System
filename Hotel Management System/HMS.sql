show databases;
-- creating database
create database hotelmanagementsystem;
-- use database
use hotelmanagementsystem; 
-- creating login table 
create table login(userName varchar(25), password varchar(25));
-- inserting values inside login table 
insert into login values('admin', '12345');
select * from login;

-- creating employee table
create table employee(name varchar(25), age varchar(10), gender varchar(15), job varchar(30), salary varchar(15), phone varchar(15), email varchar(40), aadhaar varchar(20));
select * from employee;

-- creating rooms table
create table rooms(roomNo varchar(10), availableRoom varchar(20), roomStatus varchar(20), roomPrice varchar(20), bedType varchar(20));
select * from rooms;

-- creating customer table
create table customer(document varchar(20), number varchar(30), name varchar(30), gender varchar(15), country varchar(20), room varchar(10), checkintime varchar(80), deposit varchar(20));
select * from customer;

-- creating department table
create table department(department varchar(30), bugget varchar(30));
-- adding the values inside department table
insert into department values('Front office', '500000');
insert into department values('House keeping', '40000');
insert into department values('Food and Beverage', '23000');
insert into department values('Kitchen or food Production', '540000');
insert into department values('Security', '320000');
select * from department;