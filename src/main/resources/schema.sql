create table if not exists products
(
product_id int primary key,
title varchar(200),
description varchar(200),
price varchar(20),
discount varchar(2),
discounted_price varchar(10)
);