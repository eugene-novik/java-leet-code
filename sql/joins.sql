--Представим следующие таблицы:
--
--users(id, name)
--orders(id, user_id, amount)
--products(id, name)
--order_items(id, order_id, product_id, quantity)
--Попробуй выполнить:

--🔹 Упражнение 1:
--Выбери имена всех пользователей, которые сделали хотя бы один заказ.
--
--🔹 Упражнение 2:
--Выбери имена всех пользователей, которые не сделали ни одного заказа.
--🔹 Упражнение 3:
--Выбери пользователей и сумму всех их заказов (в amount), если у них есть хотя бы один заказ.
--
--🔹 Упражнение 4:
--Выбери пользователей, которые заказывали товар с названием "Laptop".

--first
select u.name
from users u
inner join orders o on u.id = o.user_id;

--second
select u.name
from users u
left join orders o on u.id = o.user_id
where
o.id is null;

--second
select u.name
from users u
where not exists (select o.id from orders o where o.user_id = u.id);


--third
select u.name, sum(o.amount)
from users u
inner join orders o on u.id = o.user_id
group by u.name

--four
select u.name
from users u
inner join orders o on u.id = o.user_id
inner join order_items oi on o.id = oi.order_id
inner join products p on  oi.product_id = p.id
where p.name = 'Laptop';