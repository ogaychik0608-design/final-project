TRUNCATE TABLE product_categories, product, categories RESTART IDENTITY CASCADE;

INSERT INTO categories (title) VALUES
                                   ('Телефоны'),
                                   ('Ноутбуки'),
                                   ('Аксессуары'),
                                   ('Бытовая техника');

INSERT INTO product (name, stock_quantity, price, origin_country, description, specifications) VALUES
                                                                                                   (
                                                                                                       'iPhone 15 Pro', 15, 650000.0, 'США',
                                                                                                       'Флагманский смартфон с титановым корпусом и мощным процессором A17 Pro.',
                                                                                                       'Экран: 6.1" OLED, Память: 256GB, Камера: 48MP'
                                                                                                   ),
                                                                                                   (
                                                                                                       'Samsung Galaxy S24 Ultra', 10, 580000.0, 'Южная Корея',
                                                                                                       'Премиальный смартфон с поддержкой S Pen и искусственным интеллектом Galaxy AI.',
                                                                                                       'Экран: 6.8" Dynamic AMOLED, RAM: 12GB, CPU: SD 8 Gen 3'
                                                                                                   ),
                                                                                                   (
                                                                                                       'MacBook Air M3', 8, 720000.0, 'США',
                                                                                                       'Самый популярный ноутбук в мире стал еще быстрее с чипом M3.',
                                                                                                       'Процессор: Apple M3, RAM: 16GB, SSD: 512GB'
                                                                                                   ),
                                                                                                   (
                                                                                                       'Xiaomi 14 Pro', 20, 420000.0, 'Китай',
                                                                                                       'Мощный смартфон с оптикой Leica и сверхбыстрой зарядкой.',
                                                                                                       'Экран: 6.73" LTPO, Зарядка: 120W, Камера: Leica'
                                                                                                   ),
                                                                                                   (
                                                                                                       'Sony WH-1000XM5', 25, 180000.0, 'Япония',
                                                                                                       'Лучшие в классе беспроводные наушники с активным шумоподавлением.',
                                                                                                       'Тип: Полноразмерные, Время работы: 30ч, Bluetooth 5.2'
                                                                                                   ),
                                                                                                   (
                                                                                                       'Напольный светильник "Qazaq Solar"', 40, 15000.0, 'Казахстан',
                                                                                                       'Стильный светильник в национальном стиле, произведенный в Алматы.',
                                                                                                       'Материал: Металл/Дерево, Высота: 160см, Лампа: E27'
                                                                                                   ),
                                                                                                   (
                                                                                                       'PowerBank Baseus 20000mAh', 100, 12000.0, 'Китай',
                                                                                                       'Компактный внешний аккумулятор с поддержкой быстрой зарядки 22.5W.',
                                                                                                       'Ёмкость: 20000mAh, Порты: 2xUSB, 1xType-C'
                                                                                                   ),
                                                                                                   (
                                                                                                       'Кофемашина DeLonghi Magnifica', 5, 280000.0, 'Германия',
                                                                                                       'Автоматическая кофемашина для идеального эспрессо и капучино.',
                                                                                                       'Давление: 15 бар, Контейнер: 1.8л, Встроенная кофемолка'
                                                                                                   );

INSERT INTO product_categories (product_id, category_id) VALUES
                                                             (1, 1), -- iPhone -> Смартфоны
                                                             (2, 1), -- Samsung -> Смартфоны
                                                             (3, 2), -- MacBook -> Ноутбуки
                                                             (4, 1), -- Xiaomi -> Смартфоны
                                                             (5, 3), -- Sony -> Аксессуары
                                                             (6, 3), -- Светильник -> Аксессуары
                                                             (7, 3), -- PowerBank -> Аксессуары
                                                             (8, 4); -- Кофемашина -> Бытовая техника
INSERT INTO users (username, email, password, role)
VALUES ('admin', 'admin@mystore.kz', 'admin123', 'ADMIN')
    ON CONFLICT (username) DO NOTHING;