CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

ALTER TABLE song
    ADD uuid UUID default uuid_generate_v4() NOT NULL UNIQUE;