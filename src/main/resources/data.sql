DROP TABLE IF EXISTS admin;

CREATE TABLE admin(
id BIGINT AUTO_INCREMENT PRIMARY KEY,
user_ID VARCHAR(250) NOT NULL,
name VARCHAR(250) NOT NULL,
password VARCHAR(250) NOT NULL,
email VARCHAR(250) NOT NULL,
is_logged_in VARCHAR(250) NOT NULL
);

INSERT INTO admin(id, user_ID, name, password, email, is_logged_in) VALUES ('100','JAT16','JATIN','XYZ','jatin@gmail.com','1');