INSERT INTO categories (title)
VALUES ('Электроника'), ('Бытовая техника'), ('Аксессуары');

INSERT INTO product (name, stock_quantity, price)
VALUES ('Смартфон Samsung', 10, 55000.0);
INSERT INTO product (name, stock_quantity, price)
VALUES ('Ноутбук Asus', 5, 85000.0);
INSERT INTO product (name, stock_quantity, price)
VALUES ('Мышь беспроводная', 50, 1500.0);

INSERT INTO product_categories (product_id, category_id)
VALUES (1, 1), (2, 1), (3, 3)
ON CONFLICT (product_id, category_id) DO NOTHING;