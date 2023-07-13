-- DML Data Manipulation Language (Lenguaje de manipulación de datos)
-- DML registros (Registros de prueba)
use herramientasCFP35;

INSERT INTO socios (id, nombre, apellido, tipo_documento, numero_documento, direccion, celular, telefono_linea, email, comentarios) VALUES
(1, 'Juan', 'Pérez', 'DNI', '12345678', 'Av. Corrientes 1234', '1155556666', '0114444444', 'jperez@gmail.com', NULL),
(2, 'Ana', 'García', 'LC', '87654321', 'Calle San Martín 432', '1166667777', NULL, 'agarcia@hotmail.com', NULL),
(3, 'Luis', 'Fernández', 'DNI', '23456789', 'Av. Juan B. Justo 5678', '1144443333', '0113333333', 'lfernandez@yahoo.com', NULL),
(4, 'María', 'Rodríguez', 'LE', '34567890', 'Calle Córdoba 123', '1155554444', NULL, 'mrodriguez@outlook.com', NULL),
(5, 'Carlos', 'González', 'PASS', 'AB123456', 'Av. Rivadavia 9876', '1166665555', NULL, 'cgonzalez@gmail.com', NULL),
(6, 'Sofía', 'Acosta', 'DNI', '45678901', 'Calle Florida 432', '1144442222', '0112222222', 'sacosta@hotmail.com', NULL),
(7, 'Juan Pablo', 'Gómez', 'LC', '56789012', 'Av. Santa Fe 3456', '1155551111', NULL, 'jpgomez@yahoo.com.ar', NULL),
(8, 'Ana María', 'Díaz', 'DNI', '67890123', 'Calle Lavalle 567', '1166668888', NULL, 'amdiaz@gmail.com', NULL),
(9, 'Martín', 'Vargas', 'LE', '78901234', 'Av. Cabildo 9012', '1144447777', '0117777777', 'mvargas@hotmail.com', NULL),
(10, 'Valentina', 'Romero', 'DNI', '89012345', 'Calle Corrientes 5678', '1155550000', NULL, 'vromero@outlook.com', NULL),
(11, 'Agustín', 'Álvarez', 'PASS', 'CD987654', 'Av. Callao 1234', '1166663333', NULL, 'aalvarez@yahoo.com', NULL),
(12, 'Lucía', 'Torres', 'DNI', '01234567', 'Calle Sarmiento 432', '1144444444', '0115555555', 'ltorres@gmail.com', NULL),
(13, 'Santiago', 'Castro', 'LC', '23456789', 'Av. Pueyrredón 5678', '1155552222', NULL, 'scastro@hotmail.com', NULL),
(14, 'Florencia', 'Flores', 'DNI', '34567890', 'Calle Belgrano 123', '1166669999', NULL, 'fflores@outlook.com', NULL),
(15, 'José', 'Sánchez', 'LE', '45678901', 'Av. Corrientes 6789', '1144441111', '0118888888', 'jsanchez@yahoo.com.ar', NULL),
(16, 'Camila', 'Benítez', 'DNI', '56789012', 'Calle Florida 876', '1155557777', NULL, 'cbenitez@gmail.com', NULL),
(17, 'Nicolás', 'Acuña', 'LC', '67890123', 'Av. Juan B. Justo 9012', '1166662222', NULL, 'nacuna@hotmail.com', NULL),
(18, 'Victoria', 'Gutiérrez', 'DNI', '78901234', 'Calle Lavalle 901', '1144446666', '0119999999', 'vgutierrez@yahoo.com', NULL),
(19, 'Sebastián', 'Ríos', 'PASS', 'EF123456', 'Av. Santa Fe 6789', '1155553333', NULL, 'srios@outlook.com', NULL),
(20, 'Mariana', 'Mendoza', 'DNI', '90123456', 'Calle Córdoba 567', '1166664444', NULL, 'mmendoza@gmail.com', NULL);

INSERT INTO socios (id, nombre, apellido, tipo_documento, numero_documento, direccion, celular, telefono_linea, email, comentarios) VALUES
(21, 'Mikhail', 'Ivanov', 'PASS', 'AB234567', 'ul. Tverskaya 1, Moscú, Rusia', '79991234567', NULL, 'mivanov@gmail.com', NULL),
(22, 'Katarzyna', 'Nowak', 'DNI', '34567891', 'ul. Nowowiejska 1, Varsovia, Polonia', '48501123456', NULL, 'knowak@yahoo.com', NULL),
(23, 'Alexandru', 'Popescu', 'CI', '1234567', 'Str. Lipscani 1, Bucarest, Rumania', '40721234567', NULL, 'apopescu@hotmail.com', NULL),
(24, 'Olga', 'Kuznetsova', 'PASS', 'CD345678', 'ул. Арбат 1, Moscú, Rusia', '79161234567', NULL, 'okuznetsova@gmail.com', NULL),
(25, 'Dmitri', 'Petrov', 'DNI', '56789123', 'ul. Krymska 1, Kiev, Ucrania', '380501234567', NULL, 'dpetrov@hotmail.com', NULL);

INSERT INTO socios (id, nombre, apellido, tipo_documento, numero_documento, direccion, celular, telefono_linea, email, comentarios) VALUES
(26, 'Giuseppe', 'Russo', 'CI', 'AB123456', 'Via Garibaldi 1, Roma, Italia', '393401234567', NULL, 'grusso@gmail.com', NULL),
(27, 'Sofia', 'Conti', 'PASS', 'CD234567', 'Corso Vittorio Emanuele 1, Milán, Italia', '393401234568', NULL, 'sconti@yahoo.com', NULL),
(28, 'Luigi', 'Lombardi', 'DNI', '3456789', 'Piazza del Popolo 1, Florencia, Italia', '393401234569', NULL, 'llombardi@hotmail.com', NULL),
(29, 'Francesca', 'Romano', 'PASS', 'EF345678', 'Via del Corso 1, Nápoles, Italia', '393401234570', NULL, 'fromano@gmail.com', NULL),
(30, 'Alessandro', 'Moretti', 'CI', '12345678', 'Piazza Navona 1, Venecia, Italia', '393401234571', NULL, 'amoretti@hotmail.com', NULL);

INSERT INTO herramientas (codigo_barras, marca, tipo, descripcion, estado, observaciones) VALUES
('1234567891654', 'Bosch', 'ELECTRICA', 'Taladro percutor de 18V', 'BUENA', 'Ninguna'),
('1654987654321', 'Stanley', 'MANUAL', 'Juego de llaves combinadas de 12 piezas', 'BUENA', 'Ninguna'),
('4567891231654', 'DeWalt', 'ELECTRICA', 'Sierra de calar de 20V', 'REGULAR', 'Le falta la hoja de sierra'),
('7891234561654', 'Makita', 'ELECTRICA', 'Amoladora angular de 4 1/2 pulgadas', 'MALA', 'Cable dañado'),
('3216549871654', 'Husky', 'MANUAL', 'Juego de destornilladores de 6 piezas', 'BUENA', 'Ninguna'),
('7418529631654', 'Milwaukee', 'ELECTRICA', 'Llave de impacto de 1/2 pulgada', 'REGULAR', 'El mandril está flojo'),
('1597534681654', 'Klein Tools', 'MANUAL', 'Pinzas de punta larga de 8 pulgadas', 'BUENA', 'Ninguna'),
('3571592461654', 'Bosch', 'ELECTRICA', 'Sierra circular de 7 1/4 pulgadas', 'FUERA_DE_USO', 'Motor quemado'),
('8521479631654', 'Craftsman', 'MANUAL', 'Juego de llaves de vaso de 20 piezas', 'BUENA', 'Ninguna'),
('3692165458147', 'Ridgid', 'ELECTRICA', 'Taladro de ángulo recto de 12V', 'MALA', 'El gatillo está atascado'),
('2583165469147', 'DeWalt', 'ELECTRICA', 'Sierra de mesa de 10 pulgadas', 'BUENA', 'Ninguna'),
('1478165452369', 'Husky', 'MANUAL', 'Juego de alicates de bloqueo de 3 piezas', 'REGULAR', 'Las mandíbulas están desgastadas'),
('3691478165452', 'Klein Tools', 'MANUAL', 'Destornillador de punta plana de 1/4 pulgada', 'BUENA', 'Ninguna'),
('7418516549863', 'Makita', 'ELECTRICA', 'Sierra de cinta de 18V', 'MALA', 'No funciona'),
('1237816549456', 'Craftsman', 'MANUAL', 'Juego de llaves allen de 10 piezas', 'BUENA', 'Ninguna'),
('9165476543231', 'Milwaukee', 'ELECTRICA', 'Amoladora angular de 7 pulgadas', 'REGULAR', 'El gatillo está suelto'),
('4165561237893', 'Ridgid', 'ELECTRICA', 'Martillo demoledor de 15A', 'BUENA', 'Ninguna'),
('8523691654847', 'Bosch', 'MEDICION', 'Nivel láser de autonivelación de 360 grados', 'BUENA', 'Ninguna'),
('3697418521654', 'DeWalt', 'ELECTRICA', 'Sierra de calar de 12V', 'MALA', 'No corta con precisión'),
('1478523616549', 'Husky', 'MANUAL', 'Juego de llaves de trinquete de 20 piezas', 'BUENA', 'Ninguna');

INSERT INTO herramientas (codigo_barras, marca, tipo, descripcion, estado, observaciones) VALUES
('1234567165489', 'DeWalt', 'ELECTRICA', 'Sierra de inglete compuesta de 12 pulgadas', 'BUENA', 'Ninguna'),
('9816547654321', 'Bosch', 'ELECTRICA', 'Sierra de mesa de 10 pulgadas', 'REGULAR', 'La guía está desajustada'),
('4516546789123', 'Makita', 'ELECTRICA', 'Lijadora orbital de 5 pulgadas', 'MALA', 'El papel de lija se desliza'),
('7816549123456', 'Stanley', 'MANUAL', 'Juego de cinceles de madera de 4 piezas', 'BUENA', 'Ninguna'),
('3216541654987', 'DeWalt', 'ELECTRICA', 'Router de velocidad variable de 2 1/4 HP', 'BUENA', 'Ninguna');

-- Herramienta sin código de barras
INSERT INTO herramientas (marca, tipo, descripcion, estado, observaciones) VALUES
('DeWalt', 'MANUAL', 'Serrucho de mano', 'BUENA', 'Ninguna');

INSERT INTO prestamos (id_herramienta, id_socio, tipo_prestamo_hs, fecha_prestamo, fecha_devolucion, estado_devolucion, observaciones) VALUES
(1, 11, 'h24', '2023-06-10', '2023-06-11', 'TERMINADO', 'Ninguna'),
(2, 12, 'h48', '2023-06-05', '2023-06-07', 'TERMINADO', 'Ninguna'),
(3, 13, 'h72', '2023-06-02', '2023-06-05', 'TERMINADO', 'Ninguna'),
(4, 14, 'h24', '2023-06-08', '2023-06-09', 'TERMINADO', 'Ninguna'),
(5, 15, 'h48', '2023-06-01', '2023-06-03', 'TERMINADO', 'Ninguna'),
(6, 16, 'h72', '2023-06-07', '2023-06-10', 'PENDIENTE', 'Ninguna'),
(7, 17, 'h24', '2023-06-12', NULL, 'PENDIENTE', 'Ninguna'),
(8, 18, 'h48', '2023-06-03', NULL, 'PENDIENTE', 'Ninguna'),
(9, 19, 'h72', '2023-06-06', NULL, 'PENDIENTE', 'Ninguna'),
(10, 11, 'h24', '2023-06-09', NULL, 'PENDIENTE', 'Ninguna'),
(11, 10, 'h48', '2023-06-02', NULL, 'PENDIENTE', 'Ninguna'),
(12, 10, 'h72', '2023-06-04', NULL, 'PENDIENTE', 'Ninguna'),
(13, 10, 'h24', '2023-06-11', NULL, 'PENDIENTE', 'Ninguna'),
(14, 14, 'h48', '2023-06-01', NULL, 'PENDIENTE', 'Ninguna'),
(15, 15, 'h72', '2023-06-03', NULL, 'PENDIENTE', 'Ninguna'),
(16, 16, 'h24', '2023-06-07', NULL, 'PENDIENTE', 'Ninguna'),
(17, 17, 'h48', '2023-06-04', NULL, 'PENDIENTE', 'Ninguna'),
(18, 18, 'h72', '2023-06-10', NULL, 'PENDIENTE', 'Ninguna'),
(19, 19, 'h24', '2023-06-05', NULL, 'PENDIENTE', 'Ninguna'),
(22, 1, 'h24', '2023-06-05', NULL, 'PENDIENTE', 'Ninguna'),
(23, 1, 'h24', '2023-06-05', NULL, 'PENDIENTE', 'Ninguna'),
(25, 1, 'h24', '2023-06-05', NULL, 'PENDIENTE', 'Ninguna'),
(20, 22, 'h48', '2023-06-08', NULL, 'PENDIENTE', 'Ninguna');
