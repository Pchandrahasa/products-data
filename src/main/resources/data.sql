-- Insert data into Product table
INSERT INTO Product (productName, price) VALUES
('Smartphone', 599.99),
('Laptop', 1299.99),
('Gaming Console', 399.99);

-- Insert data into Review table
INSERT INTO Review (reviewContent, rating, productId) VALUES
('Great battery life!', 5, 1),
('Lags sometimes.', 3, 1),
('Perfect for my daily tasks!', 4, 2),
('Bit pricey, but worth it.', 4, 2),
('Awesome gaming experience!', 5, 3),
('Needs more exclusive games.', 4, 3);
