USE appsemestre;

INSERT INTO Tipo_identificacion (nombre) VALUES ("Cedula");
INSERT INTO Tipo_identificacion (nombre) VALUES ("Tarjeta de identidad");
INSERT INTO Tipo_identificacion (nombre) VALUES ("Pasaporte");

INSERT INTO Eps (nombre) VALUES ("E.P.S. SANITAS S.A.");
INSERT INTO Eps (nombre) VALUES ("NUEVA EPS S.A.");
INSERT INTO Eps (nombre) VALUES ("SALUDVIDA S.A. E.P.S");

INSERT INTO Rol(nombre) VALUES("Administrador");
INSERT INTO Rol(nombre) VALUES("Alumno");
INSERT INTO Rol(nombre) VALUES("Docente");


INSERT INTO Sexo (nombre) VALUES ("Masculino");
INSERT INTO Sexo (nombre) VALUES ("Femenino");
INSERT INTO Sexo (nombre) VALUES ("Prefiero no decirlo");

INSERT INTO Usuario (id_rol, nombre_completo, id_tipo_identificacion, numero_identificacion, correo_personal, telefono, fecha_nacimiento, id_sexo, id_eps)
VALUES (1, "Cristian Adolfo Estrada Lindarte", 1, "1091968522", "cristianestrada1609@gmail.com", "3204795796", "2005-06-09", 1, 1);

INSERT INTO Administrador (id_usuario, codigo_institucional, correo_institucional, contraseña)
VALUES (1, "02210132001", "02210132001@mail.udes.edu.co", "02210132001@123");

INSERT INTO Usuario (id_rol, nombre_completo, id_tipo_identificacion, numero_identificacion, correo_personal, telefono, fecha_nacimiento, id_sexo, id_eps)
VALUES (2, "Jesus Adolfo Estrada Silva", 1, "88240066", "JesusAdolfo@gmail.com", "3123426851", "1979-10-10", 1, 2);

INSERT INTO Usuario (id_rol, nombre_completo, id_tipo_identificacion, numero_identificacion, correo_personal, telefono, fecha_nacimiento, id_sexo, id_eps)
VALUES (3, "Luis Antonio Lindarte Carrascal", 1, "1091968522", "LuisAntonio@gmail.com", "3212325086", "1985-02-26", 1, 3);

INSERT INTO Usuario (id_rol, nombre_completo, id_tipo_identificacion, numero_identificacion, correo_personal, telefono, fecha_nacimiento, id_sexo, id_eps)
VALUES (1, "Rosmery LIndarte Lopez", 1, "1091968522", "RosmeryLindarte1609@gmail.com", "3204795796", "2005-06-09", 1, 1);


INSERT INTO Programa (codigo,nombre, descripcion) VALUES ("000123","Ingenieria de Sistemas", "Acreditado profesionalmente");


INSERT INTO Administrador (id_usuario, codigo_institucional, correo_institucional, contraseña)
VALUES (4, "3123426851", "3123426851@mail.udes.edu.co", "123456");

INSERT INTO Alumno (id_usuario, id_programa, codigo_institucional, correo_institucional, contraseña)
VALUES (2, 1, "02210132011", "02210132011@mail.udes.edu.co", "02210132011@321");

INSERT INTO Especialidad (nombre) VALUES ("Desarrollo de Software");

INSERT INTO Docente (id_usuario, id_especialidad, id_programa, codigo_institucional, correo_institucional, contraseña)
VALUES (3, 1, 1, "02210132066", "02210132066@mail.udes.edu.co", "02210132066@456");
