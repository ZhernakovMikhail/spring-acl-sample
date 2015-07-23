INSERT INTO users (username, password, enabled) VALUES ('admin', 'q', 1);
INSERT INTO users (username, password, enabled) VALUES ('user', 'q', 1);

INSERT INTO authorities (username, authority) VALUES ('admin', 'ADMIN');
INSERT INTO authorities (username, authority) VALUES ('user', 'USER');