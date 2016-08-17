CREATE DATABASE test_db;
USE test_db;
CREATE TABLE IF NOT EXISTS greetings (
  primary_id INT NOT NULL AUTO_INCREMENT,
  greeting VARCHAR(45) NOT NULL,
  PRIMARY KEY (primary_id)
) ENGINE=InnoDB

