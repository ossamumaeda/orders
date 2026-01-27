CREATE EXTENSION IF NOT EXISTS "pgcrypto";

CREATE TABLE customer(

    id UUID DEFAULT gen_random_uuid() PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    email VARCHAR(60) NOT NULL
);