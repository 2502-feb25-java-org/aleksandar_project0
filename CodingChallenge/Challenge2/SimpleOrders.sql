--Creating Tables using DDL

DROP TABLE PRODUCTS;
DROP TABLE CUSTOMERS;
DROP TABLE ORDERS;


CREATE TABLE PRODUCTS(
ID int IDENTITY(1,1) PRIMARY KEY,
Name varchar(25),
Price money 
);


CREATE TABLE CUSTOMERS(
ID int IDENTITY(1,1) PRIMARY KEY,
Firstname varchar(25),
Lastname varchar(25),
CardNumber bigint
);

CREATE TABLE ORDERS(
ID int IDENTITY(1,1),
ProductID int,
CustomersID int,
FOREIGN KEY(ProductID) REFERENCES PRODUCTS(ID),
FOREIGN KEY(ProductID) REFERENCES CUSTOMERS(ID),
);

--Confirming Creation
select * FROM ORDERS;
SELECT * FROM CUSTOMERS;
SELECT * FROM PRODUCTS;


--Insert 3 rows into each table
INSERT INTO PRODUCTS (Name, Price)
VALUES('Tablet', 233.33),
('Banana', 1.50),
('Espresso Machine', 500.00);

INSERT INTO CUSTOMERS(FirstName, LastName, CardNumber)
VALUES('Aleksandar', 'Antonov', 1234567812345678),
('Pushpinder', 'Kaur', 1234567812345679),
('Alexa', 'McSiri', 1234567812345677);

INSERT INTO ORDERS(ProductID, CustomersID)
VALUES(2,1),
(3,1),
(2,2);

--Add Product iPhone priced at $200 (Maybe 15 years ago...)
INSERT INTO PRODUCTS(Name, Price)
VALUES('iPhone', 200.00)

--Create order for 'Tina Smith bought an iPhone'
--Create Tina Smith Customer
--Create Order Entry
INSERT INTO CUSTOMERS(FirstName, LastName, CardNumber)
VALUES('Tina', 'Smith', 1234567812345111);
INSERT INTO ORDERS(ProductID, CustomersID) --iPhone(4), TinaSmith(4)
VALUES(4,4);

--Report all orders by 'Tina Smith'
SELECT o.CustomersID as 'TinaSmithID', p.ID, p.Name
FROM PRODUCTS p
LEFT JOIN ORDERS o ON p.ID = o.ProductID
WHERE o.CustomersID = 4

--Report all revenue generated by sales of Iphone
--Creating an additional iPhone order to demonstrate
INSERT INTO ORDERS(ProductID, CustomersID) --iPhone(4), AlexMcSiri(3)
VALUES(4,4);

select * FROM ORDERS;

SELECT ProductID, p.Name, p.Price
FROM PRODUCTS p
INNER JOIN ORDERS o on o.ProductID = p.ID
WHERE p.ID = 4

SELECT sum(p.Price) as 'iPhone Revenue'
FROM PRODUCTS p
INNER JOIN ORDERS o on o.ProductID = p.ID
WHERE p.ID = 4


--Increase the price of iPhone to $250
UPDATE PRODUCTS 
SET Price = '250.00'
WHERE Name = 'iPhone'

