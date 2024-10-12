-- Chèn dữ liệu vào bảng Roles
INSERT INTO Roles (RoleName) VALUES 
('Admin'),
('Customer');

-- Chèn dữ liệu vào bảng Users
INSERT INTO Users (UserName, Age, PhoneNumber, Address, Email, Password, RoleID) VALUES 
('John Doe', 25, '1234567890', '123 Main St', 'john@example.com', 'password1', 1),
('Jane Smith', 30, '0987654321', '456 Elm St', 'jane@example.com', 'password2', 2),
('Bob Johnson', 22, '1112233445', '789 Pine St', 'bob@example.com', 'password3', 2),
('Alice Williams', 27, '2223344556', '321 Oak St', 'alice@example.com', 'password4', 2),
('Tom Brown', 35, '3334455667', '654 Maple St', 'tom@example.com', 'password5', 1),
('Emma Davis', 28, '4445566778', '987 Birch St', 'emma@example.com', 'password6', 2),
('James Wilson', 32, '5556677889', '135 Willow St', 'james@example.com', 'password7', 2),
('Sophia Miller', 26, '6667788990', '246 Cedar St', 'sophia@example.com', 'password8', 2),
('Michael Moore', 29, '7778899001', '357 Chestnut St', 'michael@example.com', 'password9', 1),
('Olivia Taylor', 31, '8889900112', '468 Fir St', 'olivia@example.com', 'password10', 2);

-- Chèn dữ liệu vào bảng Suppliers
INSERT INTO Suppliers (SupplierName) VALUES 
('Supplier A'),
('Supplier B'),
('Supplier C'),
('Supplier D'),
('Supplier E'),
('Supplier F'),
('Supplier G'),
('Supplier H'),
('Supplier I'),
('Supplier J');

-- Chèn dữ liệu vào bảng Products
INSERT INTO Products (Pro_Name, Image, Price, SupID, Inventory) VALUES 
('Product 1', 'image1.jpg', 10.99, 1, 50),
('Product 2', 'image2.jpg', 15.99, 2, 30),
('Product 3', 'image3.jpg', 20.99, 3, 20),
('Product 4', 'image4.jpg', 5.99, 4, 15),
('Product 5', 'image5.jpg', 12.49, 5, 25),
('Product 6', 'image6.jpg', 8.99, 6, 35),
('Product 7', 'image7.jpg', 14.99, 7, 10),
('Product 8', 'image8.jpg', 9.99, 8, 40),
('Product 9', 'image9.jpg', 22.99, 9, 5),
('Product 10', 'image10.jpg', 17.49, 10, 60);

-- Chèn dữ liệu vào bảng Categories
INSERT INTO Categories (CategoryName) VALUES 
('Electronics'),
('Clothing'),
('Home & Garden'),
('Sports'),
('Health & Beauty'),
('Toys'),
('Books'),
('Music'),
('Movies'),
('Automotive');

-- Chèn dữ liệu vào bảng ProductCategories
INSERT INTO ProductCategories (ProID, CategoryID) VALUES 
(1, 1),
(2, 2),
(3, 3),
(4, 1),
(5, 2),
(6, 3),
(7, 1),
(8, 2),
(9, 3),
(10, 1);

-- Chèn dữ liệu vào bảng Carts
INSERT INTO Carts (UserID, Total) VALUES 
(1, 0),
(2, 0),
(3, 0),
(4, 0),
(5, 0),
(6, 0),
(7, 0),
(8, 0),
(9, 0),
(10, 0);

-- Chèn dữ liệu vào bảng Cart_Items
INSERT INTO Cart_Items (CartID, ProID, Quantity) VALUES 
(1, 1, 1),
(1, 2, 2),
(2, 3, 1),
(2, 4, 3),
(3, 5, 1),
(4, 6, 5),
(5, 7, 1),
(6, 8, 2),
(7, 9, 1),
(8, 10, 1);

-- Chèn dữ liệu vào bảng Orders
INSERT INTO Orders (UserID, Total, Status) VALUES 
(1, 50.00, 'completed'),
(2, 35.99, 'pending'),
(3, 20.00, 'shipped'),
(4, 15.99, 'pending'),
(5, 12.49, 'completed'),
(6, 30.00, 'pending'),
(7, 14.99, 'completed'),
(8, 22.99, 'shipped'),
(9, 10.00, 'pending'),
(10, 40.00, 'completed');

-- Chèn dữ liệu vào bảng Order_Items
INSERT INTO Order_Items (OrderID, ProID, Quantity) VALUES 
(1, 1, 2),
(1, 2, 1),
(2, 3, 1),
(3, 4, 1),
(4, 5, 1),
(5, 6, 1),
(6, 7, 2),
(7, 8, 1),
(8, 9, 1),
(9, 10, 1);
