DROP TABLE IF EXISTS carts CASCADE;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS products CASCADE;

CREATE TABLE IF NOT EXISTS products (id bigserial, title VARCHAR(255), coast integer, PRIMARY KEY (id));
CREATE TABLE IF NOT EXISTS users (id bigserial, login VARCHAR(255), password integer, role VARCHAR(255), PRIMARY KEY (id));
CREATE TABLE IF NOT EXISTS carts ( user_id integer, product_id integer,FOREIGN KEY (user_id) REFERENCES users(id), FOREIGN KEY (product_id) REFERENCES products(id));

INSERT INTO products (title, coast) VALUES ('First', 2), ('Second', 4), ('Third', 6),('Fourth',8),('Fifth',10);
INSERT INTO users(login, password, role) VALUES ('user1',111578566,'user'),('user2',111578567,'user'),('user3',111578568,'user');

