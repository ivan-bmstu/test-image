CREATE DATABASE demo;

CREATE TABLE product (
  id serial,
  title text
);

INSERT INTO product(title) VALUES ('Beer');
INSERT INTO product(title) VALUES ('Candy');
INSERT INTO product(title) VALUES ('Vine');
INSERT INTO product(title) VALUES ('Cheese');
INSERT INTO product(title) VALUES ('Chocolate');
INSERT INTO product(title) VALUES ('Meat');
INSERT INTO product(title) VALUES ('Bread');
INSERT INTO product(title) VALUES ('Apple');

\copy product FROM 'C:\java comeback is real\HeadHunter school 2023\wordstat\docker try\try-make-image\src\main\resources\data_to_copy\data.csv' DELIMITER ',' CSV HEADER;