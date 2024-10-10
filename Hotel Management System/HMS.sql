show databases;
create database hotelmanagementsystem;
use hotelmanagementsystem;
create table login(userName varchar(25), password varchar(25));
insert into login values('admin', '12345');
select * from login;