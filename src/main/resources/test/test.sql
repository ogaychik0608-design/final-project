DELETE FROM product_categories;
DELETE FROM product;
DELETE FROM categories;

INSERT INTO categories (id, title) VALUES (99, 'Тестовая категория');

INSERT INTO product (id, name, stock_quantity, price)
VALUES (999, 'Тестовый Товар', 100, 10.0);

INSERT INTO product_categories (product_id, category_id) VALUES (999, 99);