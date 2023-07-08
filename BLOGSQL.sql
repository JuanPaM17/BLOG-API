DROP DATABASE blog;
CREATE database blog;
USE blog;

CREATE TABLE grupo(
	id_grupo INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	nombre VARCHAR(20)
);

INSERT INTO grupo(nombre) VALUES ('Administrador');
INSERT INTO grupo(nombre) VALUES ('Usuario');

CREATE TABLE permiso(
	id_permiso INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	nombre VARCHAR(20)
);

INSERT INTO permiso(nombre) VALUES ('CREATE_USUARIO');
INSERT INTO permiso(nombre) VALUES ('UPDATE_USUARIO');
INSERT INTO permiso(nombre) VALUES ('DELETE_USUARIO');
INSERT INTO permiso(nombre) VALUES ('GET_USUARIO');
INSERT INTO permiso(nombre) VALUES ('CREATE_COMENTARIO');
INSERT INTO permiso(nombre) VALUES ('UPDATE_COMENTARIO');
INSERT INTO permiso(nombre) VALUES ('DELETE_COMENTARIO');
INSERT INTO permiso(nombre) VALUES ('GET_COMENTARIO');
INSERT INTO permiso(nombre) VALUES ('CREATE_CATEGORIA');
INSERT INTO permiso(nombre) VALUES ('UPDATE_CATEGORIA');
INSERT INTO permiso(nombre) VALUES ('DELETE_CATEGORIA');
INSERT INTO permiso(nombre) VALUES ('GET_CATEGORIA');
INSERT INTO permiso(nombre) VALUES ('CREATE_POST');
INSERT INTO permiso(nombre) VALUES ('UPDATE_POST');
INSERT INTO permiso(nombre) VALUES ('DELETE_POST');
INSERT INTO permiso(nombre) VALUES ('GET_POST');
INSERT INTO permiso(nombre) VALUES ('CREATE_PERMISO');
INSERT INTO permiso(nombre) VALUES ('UPDATE_PERMISO');
INSERT INTO permiso(nombre) VALUES ('DELETE_PERMISO');
INSERT INTO permiso(nombre) VALUES ('GET_PERMISO');
INSERT INTO permiso(nombre) VALUES ('CREATE_GRUPO');
INSERT INTO permiso(nombre) VALUES ('UPDATE_GRUPO');
INSERT INTO permiso(nombre) VALUES ('DELETE_GRUPO');
INSERT INTO permiso(nombre) VALUES ('GET_GRUPO');

CREATE TABLE grupo_permiso(	
	id_grupo_permiso INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	id_permiso INT NOT NULL,
	id_grupo INT NOT NULL,
	FOREIGN KEY (id_grupo) REFERENCES grupo(id_grupo),
	FOREIGN KEY (id_permiso) REFERENCES permiso(id_permiso)
);

INSERT INTO grupo_permiso(id_permiso,id_grupo) VALUES (1,1);
INSERT INTO grupo_permiso(id_permiso,id_grupo) VALUES (2,1);
INSERT INTO grupo_permiso(id_permiso,id_grupo) VALUES (3,1);
INSERT INTO grupo_permiso(id_permiso,id_grupo) VALUES (4,1);
INSERT INTO grupo_permiso(id_permiso,id_grupo) VALUES (5,1);
INSERT INTO grupo_permiso(id_permiso,id_grupo) VALUES (6,1);
INSERT INTO grupo_permiso(id_permiso,id_grupo) VALUES (7,1);
INSERT INTO grupo_permiso(id_permiso,id_grupo) VALUES (8,1);
INSERT INTO grupo_permiso(id_permiso,id_grupo) VALUES (9,1);
INSERT INTO grupo_permiso(id_permiso,id_grupo) VALUES (10,1);
INSERT INTO grupo_permiso(id_permiso,id_grupo) VALUES (11,1);
INSERT INTO grupo_permiso(id_permiso,id_grupo) VALUES (12,1);
INSERT INTO grupo_permiso(id_permiso,id_grupo) VALUES (13,1);
INSERT INTO grupo_permiso(id_permiso,id_grupo) VALUES (14,1);
INSERT INTO grupo_permiso(id_permiso,id_grupo) VALUES (15,1);
INSERT INTO grupo_permiso(id_permiso,id_grupo) VALUES (16,1);
INSERT INTO grupo_permiso(id_permiso,id_grupo) VALUES (17,1);
INSERT INTO grupo_permiso(id_permiso,id_grupo) VALUES (18,1);
INSERT INTO grupo_permiso(id_permiso,id_grupo) VALUES (19,1);
INSERT INTO grupo_permiso(id_permiso,id_grupo) VALUES (20,1);
INSERT INTO grupo_permiso(id_permiso,id_grupo) VALUES (21,1);
INSERT INTO grupo_permiso(id_permiso,id_grupo) VALUES (22,1);
INSERT INTO grupo_permiso(id_permiso,id_grupo) VALUES (23,1);
INSERT INTO grupo_permiso(id_permiso,id_grupo) VALUES (24,1);
INSERT INTO grupo_permiso(id_permiso,id_grupo) VALUES (13,2);
INSERT INTO grupo_permiso(id_permiso,id_grupo) VALUES (14,2);
INSERT INTO grupo_permiso(id_permiso,id_grupo) VALUES (15,2);
INSERT INTO grupo_permiso(id_permiso,id_grupo) VALUES (16,2);

CREATE TABLE usuario(
	id_usuario INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	nombre VARCHAR(50) NOT NULL,
	apellido VARCHAR(50) NOT NULL,
	contrasena VARCHAR(50) NOT NULL,
	correo VARCHAR(50) NOT NULL UNIQUE,
	id_grupo INT NOT NULL,
	FOREIGN KEY (id_grupo) REFERENCES grupo(id_grupo)
);

INSERT usuario (nombre,apellido,contrasena,correo,id_grupo) VALUES ('Juan','Madrigal','juan123','juan@hotmail.com',1);
INSERT usuario (nombre,apellido,contrasena,correo,id_grupo) VALUES ('Daniela','Castañeda','dani123','dani@hotmail.com',2);

CREATE TABLE categoria(
	id_categoria INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	nombre VARCHAR(50) NOT NULL,
	descripcion VARCHAR(100) NOT NULL
);

INSERT categoria(nombre,descripcion) VALUES('Comedia','Diversion al maximo');
INSERT categoria(nombre,descripcion) VALUES('Entretenimiento','Lo mejor de peliculas y series');

CREATE TABLE post(
	id_post INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
   titulo VARCHAR(50) NOT NULL,
   url_img VARCHAR(100) NOT NULL,
   extracto VARCHAR(50) NOT NULL,
   id_usuario INT NOT NULL,
   id_categoria INT NOT NULL,
   img_destacada VARCHAR(100),
   tipo VARCHAR(20) NOT NULL,
   FOREIGN KEY (id_categoria) REFERENCES categoria(id_categoria),
   FOREIGN KEY (id_usuario) REFERENCES usuario(id_usuario)
);

CREATE TABLE contenido(
	id_contenido INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
   tipo VARCHAR(20) NOT NULL,
   contenido VARCHAR(500) NOT NULL,
   id_post INT NOT NULL,
   FOREIGN KEY (id_post) REFERENCES post(id_post)
);

CREATE TABLE post_metadata(
	id_post_metadata INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	clave VARCHAR(50),
	valor VARCHAR(50),
   tipo VARCHAR(20) NOT NULL,
   id_post INT NOT NULL,
   FOREIGN KEY (id_post) REFERENCES post(id_post)
);

CREATE TABLE comentario(
	id_comentario INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	comentario VARCHAR(100) NOT NULL, 
   id_post INT NOT NULL,
   id_usuario INT NOT NULL,
   respuesta INT,
   FOREIGN KEY (id_post) REFERENCES post(id_post),
   FOREIGN KEY (id_usuario) REFERENCES usuario(id_usuario),
   FOREIGN KEY (respuesta) REFERENCES comentario(id_comentario)
);

CREATE TABLE usuario_metadata(
	id_usuario_metadata INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	id_usuario INT NOT NULL, 
	clave VARCHAR(50),
	valor VARCHAR(50),
   tipo VARCHAR(20) NOT NULL,
FOREIGN KEY (id_usuario) REFERENCES usuario(id_usuario)
);
