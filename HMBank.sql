-- TASK 1


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









-- TASK 2 

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

alter table Customers drop column account_type;

-- by using joins
-- i first tried by adding the new column in customers and then join the acc type in account table to customers 
select c.first_name, c.last_name, a.account_type, c.email
from Customers c
join Accounts a on c.customer_id = a.customer_id;

-- 2. Write a SQL query to list all transaction corresponding customer. 

select 
    c.first_name, 
    c.last_name, 
    t.transaction_id, 
    t.amount, 
    t.transaction_type, 
    t.transaction_date
from Customers c
join Accounts a on c.customer_id = a.customer_id
join Transactions t on a.account_id = t.account_id;

-- 3. Writing a SQL query to increase the balance of a specific account by a certain amount.

update Accounts set balance = balance + 500 where account_id = 1;

select * from Accounts;

-- 4. Writing a SQL query to Combine first and last names of customers as a full_name. 

select concat(first_name,' ', last_name) as full_name from Customers;

-- 5. Write a SQL query to remove accounts with a balance of zero where the account type is savings. 

select * from Accounts;

update Accounts set balance = 0.00 where account_id = 1;
SET SQL_SAFE_UPDATES = 0;
delete from Accounts where balance = 0 and account_type = 'savings';
SET SQL_SAFE_UPDATES = 1;

-- NOTE i'm inserting the same row just to avoid confusion 
insert into Accounts (customer_id, account_type, balance) values (1, 'savings', 5500.00); -- i mistakenly added the row without including the account_id so it got added in the last row
delete from Accounts where account_id = 11;

insert into Accounts (account_id, customer_id, account_type, balance) values (1, 1, 'savings', 5500.00); 

-- 6. Write a SQL query to Find customers living in a specific city. 

select * from Customers where address like '%Miami%';

-- 7. Write a SQL query to Get the account balance for a specific account.

select account_id, balance from Accounts where balance = 0.00;

-- 8. Write a SQL query to List all current accounts with a balance greater than $1,000. 

select * from Accounts where account_type = 'current' and balance > 1000;

-- 9. Write a SQL query to Retrieve all transactions for a specific account. 
-- i have not added a multiple transaction for single account so i'm adding it here.
insert into Transactions (transaction_id, account_id, transaction_type, amount) values (1, 1, 'deposit', 1000.00);

select * from Transactions where account_id = 1;

-- 10. Write a SQL query to Calculate the interest accrued on savings accounts based on a given interest rate. 
-- here im taking 2% interest 

select account_id, account_type, balance, (balance * 0.02) as interest_accured from Accounts where account_type = 'savings';

-- 11. Write a SQL query to Identify accounts where the balance is less than a specified overdraft limit.
-- lets say the over_draft limit is 500

select * from Accounts where balance < 500;

-- 12. Write a SQL query to Find customers not living in a specific city. 

select * from Customers where address not like '%Miami%';







-- TASK 3

-- 1. Write a SQL query to Find the average account balance for all customers.  

select avg(balance) as avg_bal_of_all from Accounts;

-- 2. Write a SQL query to Retrieve the top 10 highest account balances.  

select * from Accounts order by balance desc; 

-- 3. Write a SQL query to Calculate Total Deposits for All Customers in specific date.

select sum(amount) as total_deposits from Transactions where transaction_type = 'deposit' and transaction_date like '%2025-03-18%';

select sum(amount) as total_deposits from Transactions where transaction_type = 'deposit' and DATE(transaction_date) = '2025-03-18';

-- 4. Write a SQL query to Find the Oldest and Newest Customers. 

-- oldest customer
select * from Customers order by DOB asc limit 1;

-- newest customer
select * from Customers order by DOB desc limit 1;

-- i also tried to retreive them both with the same query using UNION



-- 5. Write a SQL query to Retrieve transaction details along with the account type. 
select * from Transactions;
select * from Accounts;

select t.*, a.account_type from Transactions t 
join Accounts a on t.account_id = a.account_id;

-- 6. Write a SQL query to Get a list of customers along with their account details. 

select c.first_name, c.last_name, a.*  from Accounts a 
join Customers c on a.customer_id = c.customer_id;

-- 7. Write a SQL query to Retrieve transaction details along with customer information for a specific account. 

select t.*, c.* from Customers c
join Accounts a on c.customer_id = a.customer_id
join Transactions t on a.account_id = t.transaction_id
where t.amount = 1000.00;

-- 8. Write a SQL query to Identify customers who have more than one account. 

select * from Customers;
select * from Accounts;

use hmbank;

select customer_id, count(account_id) as num_accounts
from Accounts
group by customer_id
having count(account_id) > 1;



















































































































































































































































