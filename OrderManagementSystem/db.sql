create database ordermanagementdb;

use ordermanagementdb;

create table product (
    productid int primary key auto_increment,
    productname varchar(100) not null,
    description text,
    price double not null,
    quantityinstock int not null,
    type enum('electronics', 'clothing') not null,

    -- electronics-specific
    brand varchar(50),
    warrantyperiod int,

    -- clothing-specific
    size varchar(10),
    color varchar(30)
);




create table if not exists user (
    userid int primary key auto_increment,
    username varchar(50) not null unique,
    password varchar(100) not null,
    role enum('admin', 'user') not null
);

select * from user;

select * from product;