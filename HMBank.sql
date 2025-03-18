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