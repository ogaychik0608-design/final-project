INSERT INTO categories (id, title)
VALUES (1, 'Электроника'), (2, 'Бытовая техника'), (3, 'Аксессуары')
    ON CONFLICT (id) DO NOTHING;

INSERT INTO product (id, name, stock_quantity, price)
VALUES
    (1, 'Смартфон Samsung', 10, 55000.0),
    (2, 'Ноутбук Asus', 5, 85000.0),
    (3, 'Мышь беспроводная', 50, 1500.0)
    ON CONFLICT (id) DO NOTHING;

INSERT INTO product_categories (product_id, category_id)
VALUES
    (1, 1),
    (2, 2),
    (3, 3)
    ON CONFLICT (product_id, category_id) DO NOTHING;