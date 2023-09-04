-- DDL Data Definition Language (Lenguaje de Definición de Datos)
-- DDL es la creación de estructuras de datos (Tablas y BD)

drop database if exists herramientasCFP35;
create database herramientasCFP35;
use herramientasCFP35;
drop table if exists prestamos;
drop table if exists herramientas;
drop table if exists socios;

create table socios(
	id int auto_increment primary key,
    nombre varchar(25) not null check (length(nombre) >= 2),
    apellido varchar(25) not null check (length(apellido) >= 2),
    tipo_documento enum('DNI','LC','LE','CI','PASS') not null,
    numero_documento char(8) not null check (length(numero_documento) >= 7),
    direccion varchar(150) not null check (length(direccion) >= 8),
    celular varchar(25) not null  check (length(celular) >= 8),
    telefono_linea varchar(25),
    email varchar(50) not null check (length(email) >= 5),
    comentarios varchar(255),
    unique (tipo_documento, numero_documento)
);

create table herramientas(
	id int auto_increment primary key,
    codigo_barras char(13) check (length(codigo_barras) = 13 or codigo_barras is null),
    marca varchar(30) not null check (length(marca) >= 2),
    tipo enum('MANUAL','ELECTRICA','MEDICION') not null,
    descripcion varchar(255) not null  check (length(descripcion) >= 8),
    estado enum('BUENA','REGULAR','MALA','FUERA_DE_USO'),
    observaciones varchar(255)
);

create table prestamos(
	id int auto_increment primary key,
    id_herramienta int not null,
    id_socio int not null,
    tipo_prestamo_hs enum('h24','h48','h72','h96'),
    fecha_prestamo date not null,
    fecha_devolucion date check (fecha_devolucion >= fecha_prestamo),
    estado_devolucion enum('PENDIENTE','TERMINADO'),
    observaciones varchar(255),
    foreign key (id_herramienta) references herramientas(id),
    foreign key (id_socio) references socios(id),
    unique (id_herramienta, id_socio, fecha_prestamo)
);




