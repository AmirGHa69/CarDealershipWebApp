DROP TABLE IF EXISTS orders;
DROP TABLE IF EXISTS customers;
DROP TABLE IF EXISTS products;

CREATE TABLE IF NOT EXISTS customers
(
    id
    INTEGER
    NOT
    NULL
    AUTO_INCREMENT
    PRIMARY
    KEY,
    customer_identifier
    VARCHAR
(
    50
) UNIQUE,
    last_name VARCHAR
(
    50
),
    first_name VARCHAR
(
    50
),
    email_address VARCHAR
(
    50
),
    street_address VARCHAR
(
    50
),
    postal_code VARCHAR
(
    50
),
    city VARCHAR
(
    50
),
    province VARCHAR
(
    50
),
    username VARCHAR
(
    50
),
    password VARCHAR
(
    50
),
    phone_number VARCHAR
(
    50
),
    phone_type VARCHAR
(
    50
)
    );
