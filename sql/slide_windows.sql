--orders(id, user_id, amount, created_at)
--🔹 Упражнение 1:
--Для каждого пользователя показать все его заказы и ROW_NUMBER() по дате заказа.
--
--🔹 Упражнение 2:
--Показать заказы, которые являются первыми для каждого пользователя (по дате).
--
--🔹 Упражнение 3:
--Показать топ-3 самых продаваемых товаров (по количеству) с использованием
--RANK() — если есть дубли по количеству, они должны попасть в результат.
--
--Таблицы:
--
--products(id, name)
--
--order_items(id, order_id, product_id, quantity)
--
--🔹 Упражнение 4:
--Для каждого заказа показать разницу между текущей суммой и предыдущей (по пользователю):


select
  id,
  user_id,
  amount,
  created_at,
  ROW_NUMBER() over (PARTITION BY user_id order by created_at) as rn
from orders;

select
  id,
  user_id,
  amount,
  created_at,
  ROW_NUMBER() over (PARTITION BY user_id order by created_at) as rn
from orders
order by user_id ASC;

select top 3
  id,
  user_id,
  amount,
  created_at,
  RANK() over (order by amount) as rank
from orders
order by rank ASC;









