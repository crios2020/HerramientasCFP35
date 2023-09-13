-- Colocar aquí un conjunto de consultas que permitan testear 
--      el funcionamiento de la BD

use herramientasCFP35;

select * from socios;
select * from herramientas;
select * from prestamos;


-- nombrar los prestamos de herramientas realizados al socio 'Juan Perez'
select * from socios s join prestamos p on s.id=p.id_socio
			join herramientas h on p.id_herramienta=h.id
            where s.nombre='Juan' and s.apellido='Perez';
            
-- Nombrar los socios (nombre, apellido y celular) que tienen entregas de herramientas pendientes
select distinct s.nombre, s.apellido, s.celular from socios s join prestamos p on s.id=p.id_socio
			join herramientas h on p.id_herramienta=h.id
            where p.estado_devolucion='PENDIENTE';
            
-- Lista las herramientas con entrega pendiente y el nombre del socio (nombre, apellido, telefono) 
-- que tiene la herramienta prestada.
select h.id, h.marca, h.tipo, h.descripcion, s.nombre, s.apellido, s.celular from socios s join prestamos p on s.id=p.id_socio
			join herramientas h on p.id_herramienta=h.id
            where p.estado_devolucion='PENDIENTE';


-- Consultas de prueba realizadas por ChatGPT

-- 1 Consultar todos los socios cuyo apellido comienza con la letra "S":
SELECT * FROM socios WHERE apellido LIKE 'S%';

-- 2 Consultar todas las herramientas que están fuera de uso:
SELECT * FROM herramientas WHERE estado = 'FUERA_DE_USO';

-- 3 Consultar todos los préstamos que están pendientes de devolución:
SELECT * FROM prestamos WHERE estado_devolucion = 'PENDIENTE';

-- 4 Consultar el número de préstamos que ha realizado cada socio:
SELECT s.nombre, s.apellido, s.numero_documento, COUNT(*) AS num_prestamos
	FROM socios s
	JOIN prestamos p ON s.id = p.id_socio
	GROUP BY s.id;
    
-- 5 Consultar el número de herramientas prestadas por cada socio:
SELECT s.nombre, s.apellido, s.numero_documento, COUNT(*) AS num_herramientas_prestadas
	FROM socios s
	JOIN prestamos p ON s.id = p.id_socio
	JOIN herramientas h ON p.id_herramienta = h.id
	GROUP BY s.id;
    
-- 6 Consultar prestamos pendientes y devoluciones de hoy
select * from prestamos where estado_devolucion='PENDIENTE' or fecha_devolucion=curdate();

-- 7 Consultar prestamos pendientes y devoluciones de hoy y descripcion like '%patron%' y apellido like '%patron%'
select p.id, p.id_herramienta, p.id_socio, p.tipo_prestamo_hs, p.fecha_prestamo, p.fecha_devolucion, p.estado_devolucion, p.observaciones
 from socios s join prestamos p on s.id=p.id_socio
			join herramientas h on p.id_herramienta=h.id
            where (s.apellido like '%%' or h.descripcion like '%%') 
            and (p.estado_devolucion='PENDIENTE' or p.fecha_devolucion=curdate())
            order by p.id;