create database ecommerce;

use ecommerce;

-- 1. creating customers table

create table customers (
    customer_id int auto_increment primary key,
    first_name varchar(50) not null,
    last_name varchar(50) not null,
    email varchar(50) not null unique,
    address varchar(255) not null,
    password varchar(100) not null,
    check (char_length(password) > 8) -- ensures password is more than 8 characters
);

-- 2. creating products table

create table products (
    product_id int auto_increment primary key,
    name varchar(100) not null,
    price decimal(10,2) not null,
    description varchar(255),
    stockQuantity int not null
);

-- 3. creating cart table

create table cart (
    cart_id int auto_increment primary key,
    customer_id int not null,
    product_id int not null,
    quantity int not null,
    foreign key (customer_id) references customers(customer_id) on delete cascade,
    foreign key (product_id) references products(product_id) on delete cascade
);

-- 4. creating orders table

create table orders (
    order_id int auto_increment primary key,
    customer_id int not null,
    order_date date not null,
    total_price decimal(10,2) not null,
    shipping_address varchar(255),
    foreign key (customer_id) references customers(customer_id) on delete cascade
);

-- 5. creating order_items table

create table order_items (
    order_item_id int auto_increment primary key,
    order_id int not null,
    product_id int not null,
    quantity int not null,
    foreign key (order_id) references orders(order_id) on delete cascade,
    foreign key (product_id) references products(product_id) on delete cascade
);

alter table order_items add column item_amount decimal(10,2);  -- i didnt see the additional iotem_amount in the table

desc order_items;

-- 1. inserting rows into customers table

insert into customers (first_name, last_name, email, address, password) values
('john', 'doe', 'johndoe@example.com', '123 main st, city', 'password123'),
('jane', 'smith', 'janesmith@example.com', '456 elm st, town', 'securepass456'),
('robert', 'johnson', 'robert@example.com', '789 oak st, village', 'pass789xyz'), 
('sarah', 'brown', 'sarah@example.com', '101 pine st, suburb', 'brownsarah2024'),
('david', 'lee', 'david@example.com', '234 cedar st, district', 'davidlee567'),
('laura', 'hall', 'laura@example.com', '567 birch st, county', 'halllaura890'),
('michael', 'davis', 'michael@example.com', '890 maple st, state', 'michaelpass901'),
('emma', 'wilson', 'emma@example.com', '321 redwood st, country', 'emmawilson123'),
('william', 'taylor', 'william@example.com', '432 spruce st, province', 'williamtpassxyz'), 
('olivia', 'adams', 'olivia@example.com', '765 fir st, territory', 'oliviaasecure');

-- 2. inserting rows into products table

insert into products (name, description, price, stockQuantity) values
('Laptop', 'High-performance laptop', 800.00, 10),
('Smartphone', 'Latest smartphone', 600.00, 15),
('Tablet', 'Portable tablet', 300.00, 20),
('Headphones', 'Noise-canceling headphones', 150.00, 30),
('TV', '4K Smart TV', 900.00, 5),
('Coffee Maker', 'Automatic coffee maker', 50.00, 25),
('Refrigerator', 'Energy-efficient refrigerator', 700.00, 10),
('Microwave Oven', 'Countertop microwave oven', 80.00, 15),
('Blender', 'High-speed blender', 70.00, 20),
('Vacuum Cleaner', 'Bagless vacuum cleaner', 120.00, 10);

-- 3. inserting into oredrs table
 
insert into orders (customer_id, order_date, total_price) values
(1, '2023-01-05', 1200.00),
(2, '2023-02-10', 900.00),
(3, '2023-03-15', 300.00),
(4, '2023-04-20', 150.00),
(5, '2023-05-25', 1800.00),
(6, '2023-06-30', 400.00),
(7, '2023-07-05', 700.00),
(8, '2023-08-10', 160.00),
(9, '2023-09-15', 140.00),
(10, '2023-10-20', 1400.00);

-- 4. inserting rows into cart table

insert into cart (customer_id, product_id, quantity) values
(1, 1, 2),
(1, 3, 1),
(2, 2, 3),
(3, 4, 4),
(3, 5, 2),
(4, 6, 1),
(5, 1, 1),
(6, 10, 2),
(6, 9, 3),
(7, 7, 2);

-- 5. inserting rows in order_item_id

insert into order_items (order_id, product_id, quantity, item_amount) values
(1, 1, 2, 1600.00),
(1, 3, 1, 300.00),
(2, 2, 3, 1800.00),
(3, 5, 2, 1800.00),
(4, 4, 4, 600.00),
(4, 6, 1, 50.00),
(5, 1, 1, 800.00),
(5, 2, 2, 1200.00),
(6, 10, 2, 240.00),
(6, 9, 3, 210.00);










-- 1. Update refrigerator product price to 800.

select * from products;

SET SQL_SAFE_UPDATES = 1;
update products set price = 800.00 where name = 'Refrigerator';

-- 2. Remove all cart items for a specific customer. 

select * from cart;

select * from cart where customer_id = 2;

update cart set product_id = null, quantity = null where customer_id = 2;

-- 3. Retrieve Products Priced Below $100. 

select * from products where price < 100.00;

-- 4. Find Products with Stock Quantity Greater Than 5. 

select * from products;

select * from products where stockQuantity > 5;

-- 5. Retrieve Orders with Total Amount Between $500 and $1000. 

select * from orders where total_price between 500.00 and 1000.00;

-- 6. Find Products which name end with letter ‘r’. 

select * from products where name like 'r%';

-- 7. Retrieve Cart Items for Customer 5.

select * from cart where customer_id = 5;

-- 8. Find Customers Who Placed Orders in 2023.

select * from orders;

select c.customer_id, c.first_name, c.last_name, o.order_id, order_date from customers c 
join orders o on c.customer_id = o.customer_id 
where order_date like '2023%'; -- all the orders are on 2023

-- 9. Determine the Minimum Stock Quantity for Each Product Category.

select * from products;

alter table products add column min_stock_quantity int;

update products set min_stock_quantity = 5;

-- 10. Calculate the Total Amount Spent by Each Customer. 












    















