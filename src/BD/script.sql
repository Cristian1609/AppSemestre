DROP DATABASE IF EXISTS appsemestre;
CREATE DATABASE appsemestre;
USE appsemestre;


CREATE TABLE Tipo_identificacion (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(30)
);

CREATE TABLE Eps (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(40)
);

CREATE TABLE Sexo (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(30)
);

CREATE TABLE Rol (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(15)
);

CREATE TABLE Usuario (
    id INT AUTO_INCREMENT PRIMARY KEY,
    id_rol INT NOT NULL,
    nombre_completo VARCHAR(40) NOT NULL,
    id_tipo_identificacion INT NOT NULL,
    numero_identificacion INT NOT NULL,
    correo_personal VARCHAR(30) NOT NULL,
    telefono VARCHAR(15),
    estado VARCHAR(15),
    fecha_nacimiento DATE,
    id_sexo INT NOT NULL,
    id_eps INT NOT NULL,
    FOREIGN KEY (id_tipo_identificacion) REFERENCES Tipo_identificacion(id),
    FOREIGN KEY (id_sexo) REFERENCES Sexo(id),
    FOREIGN KEY (id_eps) REFERENCES Eps(id),
    FOREIGN KEY (id_rol) REFERENCES Rol(id),
    UNIQUE (correo_personal)
);

CREATE TABLE Programa (
    id INT AUTO_INCREMENT PRIMARY KEY,
    codigo VARCHAR(15),
    nombre VARCHAR(50),
    descripcion VARCHAR(50)
);

CREATE TABLE Semestre (
    id INT AUTO_INCREMENT PRIMARY KEY,
    semestre VARCHAR(20)
);

CREATE TABLE Pensum (
    id INT AUTO_INCREMENT PRIMARY KEY,
    codigo VARCHAR(15),
    id_programa INT NOT NULL,
    FOREIGN KEY (id_programa) REFERENCES Programa(id)
);

CREATE TABLE Asignatura (
    id INT AUTO_INCREMENT PRIMARY KEY,
    codigo VARCHAR(15),
    nombre VARCHAR(50),
    numero_creditos INT,
    id_semestre int not null,
    id_pensum int not null,
    FOREIGN KEY (id_semestre) REFERENCES Semestre(id),
    FOREIGN KEY (id_pensum) REFERENCES Pensum(id)
);

CREATE TABLE Curso (
    id INT AUTO_INCREMENT PRIMARY KEY,
    codigo VARCHAR(15),
    nombre VARCHAR(50),
    id_asignatura INT NOT NULL,
    FOREIGN KEY (id_asignatura) REFERENCES Asignatura(id)
);

CREATE TABLE Administrador (
    id INT AUTO_INCREMENT PRIMARY KEY,
    id_usuario INT NOT NULL,
    codigo_institucional VARCHAR(15),
    correo_institucional VARCHAR(30),
    contraseña VARCHAR(30),
    FOREIGN KEY (id_usuario) REFERENCES Usuario(id),
    UNIQUE (correo_institucional)
);

CREATE TABLE Alumno (
    id INT AUTO_INCREMENT PRIMARY KEY,
    id_usuario INT NOT NULL,
    id_programa INT NOT NULL,
    codigo_institucional VARCHAR(15),
    correo_institucional VARCHAR(30),
    contraseña VARCHAR(30),
    FOREIGN KEY (id_usuario) REFERENCES Usuario(id),
    FOREIGN KEY (id_programa) REFERENCES Programa(id),
    UNIQUE (correo_institucional)
);

CREATE TABLE Especialidad (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50)
);

CREATE TABLE Docente (
    id INT AUTO_INCREMENT PRIMARY KEY,
    id_usuario INT NOT NULL,
    id_especialidad INT NOT NULL,
    id_programa INT NOT NULL,
    codigo_institucional VARCHAR(15),
    correo_institucional VARCHAR(30),
    contraseña VARCHAR(30),
    FOREIGN KEY (id_usuario) REFERENCES Usuario(id),
    FOREIGN KEY (id_programa) REFERENCES Programa(id),
    FOREIGN KEY (id_especialidad) REFERENCES Especialidad(id),
    UNIQUE (correo_institucional)
);


DELIMITER //
CREATE TRIGGER Insertar_Estado
BEFORE INSERT ON Usuario
FOR EACH ROW
BEGIN
    SET NEW.estado = 'activo';
END;
//
DELIMITER ;


