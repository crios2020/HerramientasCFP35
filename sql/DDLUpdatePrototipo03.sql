use herramientasCFP35;
alter table herramientas modify tipo enum('MANUAL','ELECTRICA','MEDICION','HIDRAULICA','NEUMATICA') not null;
alter table socios add estado enum('ACTIVO','NO_ACTIVO') not null;
alter table prestamos modify estado_devolucion enum('PENDIENTE','TERMINADO','CANCELADO') not null;

