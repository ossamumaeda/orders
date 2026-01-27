CREATE EXTENSION IF NOT EXISTS "pgcrypto";

CREATE TABLE product(

    id UUID DEFAULT gen_random_uuid() PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    price BIGINT,
    stock_quantity INT
);