
```sql
SELECT version(); 

CREATE TABLE cars(
	brand VARCHAR(255),
	model VARCHAR(255),
	year INT
);

INSERT INTO cars (brand, model, year)
VALUES ('Ford', 'mustang', 2078)


SELETCT * FROM cars

INSERT INTO cars (brand, model, year)
VALUES 
	('Volvo', 'p1800', 1904),
	('BMW', 'M1', 1570),
	('Toyota', 'Celica', 1975);

		
SELECT brand, year FROM cars

SELECT * FROM cars


-- add a column to the table

ALTER TABLE cars 
ADD color VARCHAR(255);


-- update a value

UPDATE cars
SET color = 'red'
WHERE brand = 'Volvo';

-- If you omit the WHERE clause, ALL records will be updated!

UPDATE cars
SET color= 'white', year = 1901
WHERE brand = 'Toyota';

--  changing to a new data type in a column 

ALTER TABLE cars 
ALTER COLUMN year TYPE VARCHAR(4);



-- Some data types cannot be converted if the column has value. E.g. numbers can always be converted to text, but text cannot always be converted to numbers.

-- changing the max length
ALTER TABLE cars 
ALTER COLUMN color TYPE VARCHAR(30);



-- remove a column 

ALTER TABLE cars 
DROP COLUMN color;

=== deleting 

DELETE FROM cars
WHERE brand = 'Volvo';

-- If you omit the WHERE clause,
all records in the table will be deleted!.


-- delete all records without deleting TBALE

DELETE FROM cars;

-- or

TRUCATE TABLE cars;


-- delete TABLE

DROP TABLE cars ;




/*

++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

*/

-- DEMO

CREATE TABLE categories(
	category_id SERIAL NOT NULL PRIMARY KEY,
	category_name VARCHAR(255),
	description VARCHAR(255)
	
);

INSERT INTO categories ( category_name, description)
VALUES
	('Beverages', 'Soft drinks, coffees, teas, beers, and ales'),
	('Condiments', 'Sweet and savory sauces, relishes, spreads, and seasonings'),
  	('Confections', 'Desserts, candies, and sweet breads'),
  	('Dairy Products', 'Cheeses'),
 	 ('Grains/Cereals', 'Breads, crackers, pasta, and cereal'),
  	('Meat/Poultry', 'Prepared meats'),
 	 ('Produce', 'Dried fruit and bean curd'),
  	('Seafood', 'Seaweed and fish');




CREATE TABLE customers (
  customer_id SERIAL NOT NULL PRIMARY KEY,
  customer_name VARCHAR(255),
  contact_name VARCHAR(255),
  address VARCHAR(255),
  city VARCHAR(255),
  postal_code VARCHAR(255),
  country VARCHAR(255)
);


INSERT INTO customers (customer_name, contact_name, address, city, postal_code, country)
VALUES
  ('Alfreds Futterkiste', 'Maria Anders', 'Obere Str. 57', 'Berlin', '12209', 'Germany'),
  ('Ana Trujillo Emparedados y helados', 'Ana Trujillo', 'Avda. de la Constitucion 2222', 'Mexico D.F.', '05021', 'Mexico'),
  ('Antonio Moreno Taquera', 'Antonio Moreno', 'Mataderos 2312', 'Mexico D.F.', '05023', 'Mexico');



CREATE TABLE products (
  product_id SERIAL NOT NULL PRIMARY KEY,
  product_name VARCHAR(255),
  category_id INT,
  unit VARCHAR(255),
  price DECIMAL(10, 2)
);



INSERT INTO products (product_id, product_name, category_id, unit, price)
VALUES
  (1, 'Chais', 1, '10 boxes x 20 bags', 18),
  (2, 'Chang', 1, '24 - 12 oz bottles', 19),
  (3, 'Aniseed Syrup', 2, '12 - 550 ml bottles', 10),
  (4, 'Chef Antons Cajun Seasoning', 2, '48 - 6 oz jars', 22),
  (5, 'Chef Antons Gumbo Mix', 2, '36 boxes', 21.35);






CREATE TABLE orders (
  order_id SERIAL NOT NULL PRIMARY KEY,
  customer_id INT,
  order_date DATE
);



INSERT INTO orders (order_id, customer_id, order_date)
VALUES
  (10248, 90, '2021-07-04'),
  (10249, 81, '2021-07-05'),
  (10250, 34, '2021-07-08');




CREATE TABLE order_details (
  order_detail_id SERIAL NOT NULL PRIMARY KEY,
  order_id INT,
  product_id INT,
  quantity INT
);


INSERT INTO order_details (order_id, product_id, quantity)
VALUES
  (10248, 11, 12),
  (10248, 42, 10),
  (10248, 72, 5),
  (10470, 64, 8),;



CREATE TABLE testproducts (
  testproduct_id SERIAL NOT NULL PRIMARY KEY,
  product_name VARCHAR(255),
  category_id INT
);


INSERT INTO testproducts (product_name, category_id)
VALUES
  ('Johns Fruit Cake', 3),
  ('Marys Healthy Mix', 9),
  ('Peters Scary Stuff', 10),
  ('Jims Secret Recipe', 11),
  ('Elisabeths Best Apples', 12),
  ('Janes Favorite Cheese', 4),
  ('Billys Home Made Pizza', 13),
  ('Ellas Special Salmon', 8),
  ('Roberts Rich Spaghetti', 5),
  ('Mias Popular Ice', 14);






/*

++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

*/

-- Operators


/*

We can operate with different operators in the WHERE clause:

=	Equal to
<	Less than
>	Greater than
<=	Less than or equal to
>=	Greater than or equal to
<>	Not equal to
!=	Not equal to
LIKE	Check if a value matches a pattern (case sensitive)
ILIKE	Check if a value matches a pattern (case insensitive)
AND	Logical AND
OR	Logical OR
IN	Check if a value is between a range of values
BETWEEN	Check if a value is between a range of values
IS NULL	Check if a value is NULL
NOT	Makes a negative result e.g. NOT LIKE, NOT IN, NOT BETWEEN

*/


SELECT * FROM cars 
WHERE brand = 'Toyota' ; 

SELECT * FROM cars
WHERE model > 2015;


-- LIKE

/*
wildcards
- The percent sign %, represents zero, one, or multiple characters.
- The underscore sign _, represents one single character.
*/

SELECT * FROM cars
WHERE model LIKE 'M%';


-- AND

SELECT * FROM cars
WHERE brand='Volvo' AND year=1530;


-- IN 
SELECT * FROM cars 
WHERE brand IN ('Volvo', 'Toyota')

-- NOT IN 
SELECT * FROM cars 
WHERE brand NOT IN ('Volvo', 'Toyota')

-- BETWEEN 

SELECT * FROM cars
WHERE year BETWEEN 1905 AND 2004

-- IS NULL

SELECT * FROM cars 
WHERE mode IS NULL;


-- NOT

SELECT * FROM cars 
WHERE model NOT LIKE 'm%'


-- specify colunm

SELECT brand, model FROM cars ;

-- Select only distinct values

SELECT DISTINCT country FROM customers ; 

SELECT COUNT(DISTINCT country) FROM customers ; 



-- order by
/*
The ORDER BY keyword sorts the records in ascending order by default
*/

SELECT * FROM cars
ORDER BY price;

SELECT * FROM cars
ORDER BY price DESC;


--LIMIT

SELECT * FROM cars
LIMIT 20;


-- select only 20 byt start start at the 41st record
SELECT * FROM cars
LIMIT 20 OFFSET 40;



-- MIN and MAX

SELECT MIN(price)
FROM cars;


/*

When you use MIN() or MAX(), the returned column will be named min or max by default. To give the column a new name, use the AS keyword

*/

SELECT MIN(price) AS lowest_Price
FROM cars ;


-- note
/*
NULL values are not counted.
*/

-- COUNT
SELECT COUNT(customers_id)
FROM customers
WHERE city='London'

-- SUM

SELECT SUM(qunatity)
FROM order_details;

/*

Note: NULL values are ignored.

*/


-- AVG
 
SELECT AVG(price)
FROM products


/*
We can use the ::NUMERIC operator to round the average price to a number with 2 decimals:
*/

SELECT AVG(price)::NUMERIC(10,2)
FROM products;



-- JOIN

products table:

 product_id |  product_name  | category_id
------------+----------------+-------------
         33 | Geitost        |           4
         34 | Sasquatch Ale  |           1
         35 | Steeleye Stout |           1
         36 | Inlagd Sill    |           8



categories table:

 category_id | category_name
-------------+----------------
           1 | Beverages
           2 | Condiments
           3 | Confections
           4 | Dairy Products










```










