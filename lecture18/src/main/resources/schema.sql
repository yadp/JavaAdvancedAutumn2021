CREATE TABLE IF NOT EXISTS person (
    id LONG AUTO_INCREMENT PRIMARY KEY,
    name varchar(255) NOT NULL,
    age INT,
    money DOUBLE
);

CREATE TABLE IF NOT EXISTS USERS (
  id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  username VARCHAR(45) NOT NULL,
  password VARCHAR(45) NOT NULL,
  enabled INT NOT NULL
  );

  CREATE TABLE IF NOT EXISTS authorities (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(45) NULL,
    authority VARCHAR(45) NULL
    );