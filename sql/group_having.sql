--🔹 Упражнение 1:
--Показать имена пользователей и общее количество заказов. Отсортировать по убыванию количества заказов.
--
--🔹 Упражнение 2:
--Показать имена пользователей, которые сделали более 3 заказов.
--
--🔹 Упражнение 3:
--Показать название товара и общее количество проданных единиц (через order_items.quantity).
--Только товары, которых продано более 50 штук.
--
--🔹 Упражнение 4:
--Показать 3 самых популярных товара по количеству проданных штук.

--users(id, name)
--orders(id, user_id, amount)
--products(id, name)
--order_items(id, order_id, product_id, quantity)


select u.name, COUNT (o.id) AS orders_count
from users u
inner join orders o on u.id = o.user_id
group by u.name
order by orders_count DESC;

select u.name, COUNT (o.id) AS orders_count
from users u
inner join orders o on u.id = o.user_id
group by u.name
having COUNT(o.id) > 3;

select p.name, sum(o_i.quantity)
from order_items o_i
inner join products p on o_i.product_id = p.id
group by p.name
having sum(o_i.quantity) > 50;

select TOP 3 p.name, sum(o_i.quantity) as order_sum
from order_items o_i
inner join products p on o_i.product_id = p.id
group by p.name
order by order_sum DESC


