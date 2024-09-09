INSERT INTO users (username, password, roles) VALUES
('admin', '$2a$10$OaQqSxKLP5phA3RtxFT6Q.3HtZC0dey2hL.4JX2p7zQZ1zYQAMKoq', 'ROLE_ADMIN'),
('user', '$2a$10$Kk3U6gD5Ot2C6C91o6ph/u6Vp8pQo4zZzP7Y7./FwK7fK2fKzP.tq', 'ROLE_USER');

INSERT INTO products (name, category, price, stock) VALUES
('Laptop', 'Electronics', 80000.00, 50),
('Smartphone', 'Electronics', 8000.00, 100),
('Table', 'Furniture', 4500.00, 20),
('Double-cart', 'Furniture', 30000.00, 20),
('Dining-Table', 'Furniture', 20000.00, 10),
('SmartWatch', 'Electronics', 3000.00, 80),
('Sofa', 'Furniture', 25000.00, 10),
('Office-Chair', 'Furniture', 10000.00, 15);
