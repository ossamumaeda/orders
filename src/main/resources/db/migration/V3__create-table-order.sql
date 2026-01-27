CREATE EXTENSION IF NOT EXISTS "pgcrypto";

CREATE TABLE orders(
    id UUID DEFAULT gen_random_uuid() PRIMARY KEY,
    status_order VARCHAR(50) NOT NULL,
    created_at DATE NOT NULL,
    customer_id UUID,
    FOREIGN KEY (customer_id) REFERENCES customer(id) ON DELETE CASCADE
);