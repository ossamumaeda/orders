CREATE EXTENSION IF NOT EXISTS "pgcrypto";

CREATE TABLE payment(

    id UUID DEFAULT gen_random_uuid() PRIMARY KEY,
    status VARCHAR(50) NOT NULL,
    amount BIGINT NOT NULL,
    order_id UUID,
    FOREIGN KEY (order_id) REFERENCES orders(id) ON DELETE CASCADE

);