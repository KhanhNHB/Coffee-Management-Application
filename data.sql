create DATABASE QuanLyQuanCafe
GO

USE QuanLyQuanCafe
GO 


-- Food
-- Table
-- FoodCategory
-- Account
-- Bill
-- BillInfo

CREATE TABLE Tables
(
	id INT IDENTITY PRIMARY KEY,
	name NVARCHAR(100),
	status BIT, -- Trống || Có người 
)
GO

CREATE TABLE Accounts
(
	id INT IDENTITY PRIMARY KEY,
	fullname NVARCHAR(100) NOT NULL,
	username NVARCHAR(100) NOT NULL,
	password NVARCHAR(1000) NOT NULL,
	type INT NOT NULL
)