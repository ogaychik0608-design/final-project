CREATE TABLE IF NOT EXISTS categories (
    id SERIAL PRIMARY KEY,
    title VARCHAR(255) NOT NULL
    );

CREATE TABLE IF NOT EXISTS product (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    stock_quantity INTEGER,
    price DOUBLE PRECISION
    );

CREATE TABLE IF NOT EXISTS product_categories (
    product_id BIGINT REFERENCES product(id),
    category_id BIGINT REFERENCES categories(id),
    PRIMARY KEY (product_id, category_id)
    );