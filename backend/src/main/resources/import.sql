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