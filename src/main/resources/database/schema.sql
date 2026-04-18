DROP TABLE IF EXISTS product_categories CASCADE;
DROP TABLE IF EXISTS product CASCADE;
DROP TABLE IF EXISTS categories CASCADE;
DROP TABLE IF EXISTS t_users_permissions CASCADE;
DROP TABLE IF EXISTS t_users CASCADE;
DROP TABLE IF EXISTS t_permissions CASCADE;

CREATE TABLE categories (
                            id SERIAL PRIMARY KEY,
                            title VARCHAR(255) NOT NULL UNIQUE
);

CREATE TABLE product (
                         id SERIAL PRIMARY KEY,
                         name VARCHAR(255) NOT NULL,
                         stock_quantity INTEGER DEFAULT 0,
                         price DOUBLE PRECISION DEFAULT 0.0,
                         origin_country VARCHAR(100) DEFAULT 'Казахстан',
                         description TEXT,
                         specifications TEXT
);

CREATE TABLE product_categories (
                                    product_id BIGINT NOT NULL,
                                    category_id BIGINT NOT NULL,
                                    PRIMARY KEY (product_id, category_id),
                                    FOREIGN KEY (product_id) REFERENCES product(id) ON DELETE CASCADE,
                                    FOREIGN KEY (category_id) REFERENCES categories(id) ON DELETE CASCADE
);