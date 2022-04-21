--Ao colocar o nome do arquivo como data.sql o compilador não encontras as entidades

INSERT INTO user (email, password, first_name, last_name, active) VALUES ('maria@siganatural.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG', 'maria', 'dos santos', 1);
INSERT INTO user (email, password, first_name, last_name, active) VALUES ('joao@siganatural.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG', 'joão', 'nascimento', 1);
INSERT INTO user (email, password, first_name, last_name, active) VALUES ('creuza@siganatural.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG', 'creuza', 'silva', 1);

INSERT INTO role (authority) VALUES ('ROLE_MAIN');
INSERT INTO role (authority) VALUES ('ROLE_SALESMAN');
INSERT INTO role (authority) VALUES ('ROLE_ADMIN');

INSERT INTO user_role (user_id, role_id) VALUES (1, 1);
INSERT INTO user_role (user_id, role_id) VALUES (2, 2);
INSERT INTO user_role (user_id, role_id) VALUES (3, 1);
INSERT INTO user_role (user_id, role_id) VALUES (3, 3);

INSERT INTO salesman (goal, user_id) VALUES (40000.0, 2);

INSERT INTO pharmacy (name, cnpj, phone, cellphone, email, active) VALUES ('drogvida', '123.154.00/0001-15', '8137264444','81995245698', 'drogvida@email.com', 1);
INSERT INTO pharmacy (name, cnpj, phone, cellphone, email, active) VALUES ('farmácia dos trabalhadores', '999.536.00/0001-34', '8137265555', '81995245698', 'fdt@email.com', 1);

INSERT INTO address (city, district, street, number, pharmacy_id) VALUES ('recife', 'pedro manuel', 'josé cardoso', 13, 1);
INSERT INTO address (city, district, street, number, pharmacy_id) VALUES ('recife', 'pedro manuel', 'antonio de sá', 156, 2);

INSERT INTO product (name, description, price, image, active) VALUES ('amargo beringela', 'excelente para o bem estar', 21.22, null, 1);
INSERT INTO product (name, description, price, image, active) VALUES ('amargo hortelã', 'o sabor refrescante da pura erva do campo', 24.14, null, 1);
INSERT INTO product (name, description, price, image, active) VALUES ('arrelique', 'a mais nova formula da tecnologia dos estudos das ervas naturais', 27.64, null, 1);
INSERT INTO product (name, description, price, image, active) VALUES ('pomada arrelique', 'alívio nas dores de forma imediata', 19.54, null, 1);
INSERT INTO product (name, description, price, image, active) VALUES ('ergo 30', 'sua juventude garantida ao decorrer do tempo', 29.44, null, 1);

INSERT INTO sale (pharmacy_id, salesman_id, amount, date, form_pay) VALUES (1, 1, 7432.25, TIMESTAMP WITH TIME ZONE '2022-04-14T15:00:00Z', 'parcelado');
INSERT INTO sale (pharmacy_id, salesman_id, amount, date, form_pay) VALUES (2, 1, 3412.17, TIMESTAMP WITH TIME ZONE '2022-04-14T15:45:00Z', 'á vista');

INSERT INTO sale_product (sale_id, product_id, quantity_product) VALUES (1, 2, 55);
INSERT INTO sale_product (sale_id, product_id, quantity_product) VALUES (1, 4, 80);
INSERT INTO sale_product (sale_id, product_id, quantity_product) VALUES (1, 5, 10);

INSERT INTO sale_product (sale_id, product_id, quantity_product) VALUES (2, 5, 10);
INSERT INTO sale_product (sale_id, product_id, quantity_product) VALUES (2, 1, 30);

INSERT INTO ticket (sale_id, amount, due_date, image, paid) VALUES (1, 3716.12, TIMESTAMP WITH TIME ZONE '2022-05-14T15:45:00Z', null, 0);
INSERT INTO ticket (sale_id, amount, due_date, image, paid) VALUES (1, 3716.12, TIMESTAMP WITH TIME ZONE '2022-06-14T15:45:00Z', null, 0);

INSERT INTO nf (sale_id, image) VALUES (1, null);
INSERT INTO nf (sale_id, image) VALUES (2, null);

