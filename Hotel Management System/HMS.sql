show databases;
create database hotelmanagementsystem;
use hotelmanagementsystem;
create table login(userName varchar(25), password varchar(25));
insert into login values('admin', '12345');
select * from login;
create table employee(name varchar(25), age varchar(10), gender varchar(15), job varchar(30), salary varchar(15), phone varchar(15), email varchar(40), aadhaar varchar(20));
select * from employee;