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



INSERT INTO Programa (codigo,nombre, descripcion) VALUES ("000123","Ingenieria de Sistemas", "Acreditado profesionalmente");




INSERT INTO Especialidad (nombre) VALUES ("Desarrollo de Software");
