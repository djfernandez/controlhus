#POBLAR LA TABLA DE CARGOS
INSERT INTO cargos(id_cargo, nombre, estado, registro) VALUES (1, 'GERENTE', 1, '2021-01-01');
INSERT INTO cargos(id_cargo, nombre, estado, registro) VALUES (2, 'SUB GERENTE', 1, '2021-01-01');
INSERT INTO cargos(id_cargo, nombre, estado, registro) VALUES (3, 'JEFE', 1, '2021-01-01');
INSERT INTO cargos(id_cargo, nombre, estado, registro) VALUES (4, 'SUPERVISOR', 1, '2021-01-01');
INSERT INTO cargos(id_cargo, nombre, estado, registro) VALUES (5, 'SISTEMAS', 1, '2021-01-01');
#POBLAR LA TABLA DE PERSONAS
INSERT INTO personas(id_persona, id_cargo, nombres, apellidos, documento, estado, registro) VALUES(1, 5, 'ADMINISTRADOR', 'ADMINISTRADOR', 0, 1, '2021-01-01');
INSERT INTO personas(id_persona, id_cargo, nombres, apellidos, documento, estado, registro) VALUES(2, 5, 'DANNY', 'FERNANDEZ', 0, 1, '2021-01-01');
#POBLAR LA TABLA DE USUARIOS
INSERT INTO usuarios (id_usuario, usuario, clave, estado, registro) VALUES(1, 'ADMIN', '1234', 1, '2021-01-01')
INSERT INTO usuarios (id_usuario, usuario, clave, estado, registro) VALUES(2, 'dfernandez', '1234', 1, '2021-01-01')