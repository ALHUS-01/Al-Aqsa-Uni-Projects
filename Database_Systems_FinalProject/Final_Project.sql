-- Final_Project						 الاسم: حسام أكرم حمد  بريكة						الرقم الجامعي: 1320237093
-- =================================================================================

/*
Submit the following files: 
1. Screenshots used for system analysis.
2. EER Diagram. 
3. Database creation script (DDL). 
4. Data insertion script (INSERT). 
5. SQL Queries script.
*/

-- =================================================================================
-- 3. Database creation script (DDL):

-- create the database
create database fooddeliverydb;
use fooddeliverydb;

-- 1. customers table
create table customers (
    customerid int auto_increment primary key,
    firstname varchar(50) not null,
    lastname varchar(50) not null,
    phone varchar(20) unique,
    city varchar(50),
    status varchar(20) default 'active'
);

-- 2. restaurants table
create table restaurants (
    restaurantid int auto_increment primary key,
    name varchar(100) not null,
    cuisinetype varchar(50),
    rating decimal(3, 2) check (rating >= 0 and rating <= 5),
    deliveryfee decimal(5, 2)
);

-- 3. menuitems table
create table menuitems (
    itemid int auto_increment primary key,
    restaurantid int,
    itemname varchar(100) not null,
    price decimal(8, 2) not null,
    foreign key (restaurantid) references restaurants(restaurantid) on delete cascade
);

-- 4. drivers table
create table drivers (
    driverid int auto_increment primary key,
    firstname varchar(50) not null,
    lastname varchar(50) not null,
    phone varchar(20) unique,
    vehicletype varchar(50),
    status varchar(20) default 'available'
);

-- 5. orders table
create table orders (
    orderid int auto_increment primary key,
    customerid int,
    restaurantid int,
    driverid int,
    orderdate datetime default current_timestamp,
    totalamount decimal(10, 2),
    orderstatus varchar(20) default 'pending',
    foreign key (customerid) references customers(customerid),
    foreign key (restaurantid) references restaurants(restaurantid),
    foreign key (driverid) references drivers(driverid) on delete set null
);

-- 6. orderdetails table
create table orderdetails (
    orderdetailid int auto_increment primary key,
    orderid int,
    itemid int,
    quantity int not null check (quantity > 0),
    foreign key (orderid) references orders(orderid) on delete cascade,
    foreign key (itemid) references menuitems(itemid)
);


-- =================================================================================
-- 4. Data insertion script (INSERT):

-- insert into customers
insert into customers (firstname, lastname, phone, city, status) values
('ahmed', 'ali', '0599111111', 'gaza', 'active'),
('mona', 'salem', '0599222222', 'deir al balah', 'active'),
('khaled', 'yousef', '0599333333', 'rafah', 'inactive'),
('sara', 'hassan', '0599444444', 'khan yunis', 'active'),
('omar', 'tariq', '0599555555', 'gaza', 'active'),
('laila', 'nasser', '0599666666', 'jabalia', 'active'),
('mahmoud', 'sami', '0599777777', 'gaza', 'active'),
('nour', 'kamal', '0599888888', 'deir al balah', 'inactive'),
('huda', 'rami', '0599999999', 'rafah', 'active'),
('ziad', 'fadel', '0599000000', 'gaza', 'active');

-- insert into restaurants
insert into restaurants (name, cuisinetype, rating, deliveryfee) values
('burger king', 'fast food', 4.2, 5.00),
('pizza hut', 'italian', 4.5, 7.00),
('albaik', 'broasted', 4.8, 4.00),
('kfc', 'fast food', 4.0, 5.00),
('shawarma mazaj', 'arabic', 4.7, 3.00),
('sushi k', 'japanese', 4.9, 10.00),
('taco bell', 'mexican', 3.8, 6.00),
('taj mahal', 'indian', 4.6, 8.00),
('mado', 'turkish', 4.4, 9.00),
('al aseel', 'traditional', 4.3, 5.00);

-- insert into menuitems
insert into menuitems (restaurantid, itemname, price) values
(1, 'whopper', 15.00),
(1, 'fries', 5.00),
(2, 'margherita pizza', 30.00),
(2, 'garlic bread', 10.00),
(3, 'chicken meal', 25.00),
(4, 'zinger burger', 18.00),
(5, 'chicken shawarma', 12.00),
(6, 'salmon roll', 40.00),
(8, 'chicken tikka', 35.00),
(10, 'mansaf', 50.00);

-- insert into drivers
insert into drivers (firstname, lastname, phone, vehicletype, status) values
('yousef', 'ahmed', '0598111111', 'motorcycle', 'available'),
('kareem', 'said', '0598222222', 'car', 'busy'),
('majed', 'ali', '0598333333', 'bicycle', 'available'),
('tamer', 'hussein', '0598444444', 'motorcycle', 'offline'),
('basem', 'saad', '0598555555', 'car', 'available'),
('fadi', 'nabil', '0598666666', 'motorcycle', 'busy'),
('ramzy', 'khalil', '0598777777', 'car', 'available'),
('waleed', 'jaber', '0598888888', 'bicycle', 'available'),
('ayman', 'salah', '0598999999', 'motorcycle', 'busy'),
('shady', 'mahmoud', '0598000000', 'car', 'offline');

-- insert into orders
insert into orders (customerid, restaurantid, driverid, totalamount, orderstatus) values
(1, 1, 1, 20.00, 'delivered'),
(2, 2, 2, 40.00, 'delivered'),
(3, 5, 3, 24.00, 'cancelled'),
(4, 3, 4, 25.00, 'pending'),
(5, 8, 5, 35.00, 'delivered'),
(6, 10, 6, 100.00, 'delivered'),
(7, 4, 7, 36.00, 'preparing'),
(8, 1, 8, 15.00, 'cancelled'),
(9, 6, 9, 80.00, 'delivered'),
(10, 5, 10, 12.00, 'delivered');

-- insert into orderdetails
insert into orderdetails (orderid, itemid, quantity) values
(1, 1, 1),
(1, 2, 1),
(2, 3, 1),
(2, 4, 1),
(3, 7, 2),
(4, 5, 1),
(5, 9, 1),
(6, 10, 2),
(7, 6, 2),
(8, 1, 1),
(9, 8, 2),
(10, 7, 1);

-- =================================================================================
-- 5. SQL Queries script:

-- 1. display all records from a table
select * from drivers;

-- 2. search for specific data using where
select * from drivers where status = 'available';

-- 3. sort data using order by
select * from restaurants order by rating desc;

-- 4. use aggregate function (count)
select count(*) as totalorders from orders;

-- 5. use aggregate function (sum)
select sum(totalamount) as totalrevenue from orders where orderstatus = 'delivered';

-- 6. use aggregate function (avg)
select avg(price) as averageitemprice from menuitems;

-- 7. use aggregate functions (min, max)
select min(deliveryfee) as lowestfee, max(deliveryfee) as highestfee from restaurants;

-- 8. use group by
select vehicletype, count(*) as drivercount from drivers group by vehicletype;

-- 9. use having
select cuisinetype, count(*) as numberofrestaurants 
from restaurants 
group by cuisinetype 
having count(*) > 1;

-- 10. use inner join
select orders.orderid, customers.firstname as customername, drivers.firstname as drivername, orders.totalamount 
from orders 
inner join customers on orders.customerid = customers.customerid
inner join drivers on orders.driverid = drivers.driverid;

-- 11. use left join
select customers.firstname, orders.orderid 
from customers 
left join orders on customers.customerid = orders.customerid;

-- 12. use union
select name as entityname from restaurants 
union 
select firstname from drivers;

-- 13. use string functions (concat)
select concat(firstname, ' ', lastname) as fullname from drivers;

-- 14. use string functions (upper)
select upper(name) as uppercaserestaurantname from restaurants;

-- 15. complex query combining join and where
select orders.orderid, menuitems.itemname, orderdetails.quantity, orders.orderstatus
from orderdetails
inner join orders on orderdetails.orderid = orders.orderid
inner join menuitems on orderdetails.itemid = menuitems.itemid
where orders.orderstatus = 'delivered';

-- 16. use logical operators (or, and) with parentheses
select firstname, lastname, city, status 
from customers 
where (city = 'gaza' or city = 'rafah') and status = 'active';

-- 17. use between operator
select orderid, totalamount, orderstatus 
from orders 
where totalamount between 20.00 and 50.00;

-- 18. use like operator for pattern matching
select name, cuisinetype 
from restaurants 
where name like 's%';

-- 19. group by with inner join
select customers.firstname, sum(orders.totalamount) as totalspent
from customers
inner join orders on customers.customerid = orders.customerid
group by customers.customerid, customers.firstname;

-- 20. subquery with aggregate function (max)
select orderid, customerid, totalamount 
from orders 
where totalamount = (select max(totalamount) from orders);

-- =================================================================================
-- Finish ^_^
