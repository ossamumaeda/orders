CREATE EXTENSION IF NOT EXISTS "pgcrypto";

CREATE TABLE orders_item(
    id UUID DEFAULT gen_random_uuid() PRIMARY KEY,
    quantity INT,
    price BIGINT,
    order_id UUID,
    FOREIGN KEY (order_id) REFERENCES orders(id) ON DELETE CASCADE,
    product_id UUID,
    FOREIGN KEY (product_id) REFERENCES product(id) ON DELETE CASCADE
);