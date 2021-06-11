#POBLAR LA TABLA DE CARGOS
INSERT INTO `cargos`(id_cargo, nombre) VALUES (1, 'GERENTE');
INSERT INTO `cargos`(id_cargo, nombre) VALUES (2, 'SUB GERENTE');
INSERT INTO `cargos`(id_cargo, nombre) VALUES (3, 'JEFE');
INSERT INTO `cargos`(id_cargo, nombre) VALUES (4, 'SUPERVISOR');
INSERT INTO `cargos`(id_cargo, nombre) VALUES (5, 'SISTEMAS');
#POBLAR LA TABLA DE PERSONAS
INSERT INTO `personas`(id_persona, id_cargo, nombres, apellidos, documento) VALUES(1, 5, 'ADMINISTRADOR', 'ADMINISTRADOR', 0);
INSERT INTO `personas`(id_persona, id_cargo, nombres, apellidos, documento) VALUES(2, 5, 'DANNY', 'FERNANDEZ', 0);
#POBLAR LA TABLA DE USUARIOS
INSERT INTO `usuarios` (id_usuario, usuario, clave) VALUES(1, 'dfernandez', '$2a$10$O9wxmH/AeyZZzIS09Wp8YOEMvFnbRVJ8B4dmAMVSGloR62lj.yqXG')
INSERT INTO `usuarios` (id_usuario, usuario, clave) VALUES(2, 'admin', '$2a$10$O9wxmH/AeyZZzIS09Wp8YOEMvFnbRVJ8B4dmAMVSGloR62lj.yqXG')
#POBLAR LA TABLA DE AUTORIZACIONES
INSERT INTO `authorities` (user_id, authority) VALUES (1,'ROLE_USER');
INSERT INTO `authorities` (user_id, authority) VALUES (2,'ROLE_ADMIN');
INSERT INTO `authorities` (user_id, authority) VALUES (2,'ROLE_USER');