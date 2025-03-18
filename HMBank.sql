create database HMBank;

use HMBank;

-- create customers table

create table Customers (
    customer_id int auto_increment primary key,
    first_name varchar(50) not null,
    last_name varchar(50) not null,
    DOB DATE not null,
    email varchar(100) unique not null,
    phone_number varchar(15) UNIQUE not null,
    address text not null
);

-- create accounts table

create table Accounts (
    account_id int auto_increment primary key,
    customer_id int not null,
    account_type enum('savings', 'current', 'zero_balance') not null,
    balance decimal(15,2) not null default 0.00, -- upto 15 digits, with 2 decimal
    foreign key (customer_id) references Customers(customer_id) on delete cascade -- foreign key constraint
);

-- create transactions table

create table Transactions (
    transaction_id int auto_increment primary key,
    account_id int not null,
    transaction_type enum('deposit', 'withdrawal', 'transfer') not null,
    amount decimal(15,2) not null,
    transaction_date timestamp default current_timestamp,
    foreign key (account_id) references Accounts(account_id) on delete cascade
);

-- insertion of sample data into the customer table

insert into Customers (first_name, last_name, DOB, email, phone_number, address) values -- i didnt mention the customer_id as it is auto_inc and if i mentioned it i have to put null for each record
('John', 'Doe', '1990-05-15', 'john.doe@email.com', '9876543210', '123 Main St, New York'),
('Jane', 'Smith', '1985-08-20', 'jane.smith@email.com', '9876543211', '456 Elm St, Los Angeles'),
('Alice', 'Johnson', '1992-03-10', 'alice.j@email.com', '9876543212', '789 Oak St, Chicago'),
('Bob', 'Brown', '1988-07-25', 'bob.b@email.com', '9876543213', '101 Pine St, Houston'),
('Charlie', 'Davis', '1995-12-30', 'charlie.d@email.com', '9876543214', '202 Maple St, Miami'),
('Emma', 'Wilson', '1991-09-05', 'emma.w@email.com', '9876543215', '303 Birch St, New York'),
('Liam', 'Taylor', '1987-06-15', 'liam.t@email.com', '9876543216', '404 Cedar St, Los Angeles'),
('Olivia', 'Martinez', '1993-11-22', 'olivia.m@email.com', '9876543217', '505 Redwood St, Chicago'),
('Noah', 'Anderson', '1989-04-18', 'noah.a@email.com', '9876543218', '606 Palm St, Houston'),
('Sophia', 'Thomas', '1994-02-28', 'sophia.t@email.com', '9876543219', '707 Spruce St, Miami');

select * from Customers;

-- insertion of sample data into the accounts table

insert into Accounts (customer_id, account_type, balance) values
(1, 'savings', 5000.00),
(2, 'current', 1200.00),
(3, 'savings', 800.00),
(4, 'current', 3000.00),
(5, 'zero_balance', 0.00),
(6, 'savings', 2000.00),
(7, 'current', 4500.00),
(8, 'savings', 50.00),
(9, 'current', 900.00),
(10, 'savings', 12000.00); -- customer id should be manually added since its a foreign key and its to link the customerid from customer table

select * from Accounts;

-- insertion of sample data into the transactions table

insert into Transactions (account_id, transaction_type, amount) values
(1, 'deposit', 500.00),
(2, 'withdrawal', 200.00),
(3, 'deposit', 100.00),
(4, 'withdrawal', 300.00),
(5, 'deposit', 50.00),
(6, 'deposit', 150.00),
(7, 'withdrawal', 250.00),
(8, 'deposit', 350.00),
(9, 'withdrawal', 400.00),
(10, 'deposit', 500.00);

select * from Transactions;

-- SQL queries
-- 1. Writing a SQL query to retrieve the name, account type and email of all customers.  

alter table Customers add column account_type varchar(20);

SET SQL_SAFE_UPDATES = 0;

UPDATE Customers c
JOIN Accounts a ON c.customer_id = a.customer_id
SET c.account_type = a.account_type;

SET SQL_SAFE_UPDATES = 1; -- Turn safe mode back on

select first_name, last_name, account_type, email from Customers;

-- by using joins

select c.first_name, c.last_name, a.account_type, c.email
from Customers c
join Accounts a on c.customer_id = a.customer_id;


