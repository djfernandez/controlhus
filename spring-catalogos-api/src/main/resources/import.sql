#POBLAR LA TABLA DE CARGOS
INSERT INTO cargos(id_cargo, nombre) VALUES (1, 'GERENTE');
INSERT INTO cargos(id_cargo, nombre) VALUES (2, 'SUB GERENTE');
INSERT INTO cargos(id_cargo, nombre) VALUES (3, 'JEFE');
INSERT INTO cargos(id_cargo, nombre) VALUES (4, 'SUPERVISOR');
INSERT INTO cargos(id_cargo, nombre) VALUES (5, 'SISTEMAS');
#POBLAR LA TABLA DE PERSONAS
INSERT INTO personas(id_persona, id_cargo, nombres, apellidos, documento) VALUES(1, 5, 'ADMINISTRADOR', 'ADMINISTRADOR', 0);
INSERT INTO personas(id_persona, id_cargo, nombres, apellidos, documento) VALUES(2, 5, 'DANNY', 'FERNANDEZ', 0);
#POBLAR LA TABLA DE USUARIOS
INSERT INTO usuarios (id_usuario, usuario, clave) VALUES(1, 'ADMIN', '1234')
INSERT INTO usuarios (id_usuario, usuario, clave) VALUES(2, 'dfernandez', '1234')