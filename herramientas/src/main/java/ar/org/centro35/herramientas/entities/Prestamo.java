package ar.org.centro35.herramientas.entities;

import ar.org.centro35.herramientas.enums.PrestamoEstado;
import ar.org.centro35.herramientas.enums.PrestamoTipo;

public class Prestamo {

    private int id;
    private int id_herramienta;
    private int id_socio;
    private PrestamoTipo tipo_prestamo_hs;
    private String fecha_prestamo;
    private String fecha_devolucion;
    private PrestamoEstado estado_devolucion;
    private String observaciones;
    
    public Prestamo() {
    }

    public Prestamo(int id_herramienta, int id_socio, PrestamoTipo tipo_prestamo_hs, String fecha_prestamo,
            String fecha_devolucion, PrestamoEstado estado_devolucion, String observaciones) {
        this.id_herramienta = id_herramienta;
        this.id_socio = id_socio;
        this.tipo_prestamo_hs = tipo_prestamo_hs;
        this.fecha_prestamo = fecha_prestamo;
        this.fecha_devolucion = fecha_devolucion;
        this.estado_devolucion = estado_devolucion;
        this.observaciones = observaciones;
    }

    public Prestamo(int id, int id_herramienta, int id_socio, PrestamoTipo tipo_prestamo_hs, String fecha_prestamo,
            String fecha_devolucion, PrestamoEstado estado_devolucion, String observaciones) {
        this.id = id;
        this.id_herramienta = id_herramienta;
        this.id_socio = id_socio;
        this.tipo_prestamo_hs = tipo_prestamo_hs;
        this.fecha_prestamo = fecha_prestamo;
        this.fecha_devolucion = fecha_devolucion;
        this.estado_devolucion = estado_devolucion;
        this.observaciones = observaciones;
    }

    @Override
    public String toString() {
        return "Prestamo [id=" + id + ", id_herramienta=" + id_herramienta + ", id_socio=" + id_socio
                + ", tipo_prestamo_hs=" + tipo_prestamo_hs + ", fecha_prestamo=" + fecha_prestamo + ", fecha_devolucion="
                + fecha_devolucion + ", estado_devolucion=" + estado_devolucion + ", observaciones=" + observaciones
                + "]";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_herramienta() {
        return id_herramienta;
    }

    public void setId_herramienta(int id_herramienta) {
        this.id_herramienta = id_herramienta;
    }

    public int getId_socio() {
        return id_socio;
    }

    public void setId_socio(int id_socio) {
        this.id_socio = id_socio;
    }

    public PrestamoTipo getTipo_prestamo_hs() {
        return tipo_prestamo_hs;
    }

    public void setTipo_prestamo_hs(PrestamoTipo tipo_prestamo_hs) {
        this.tipo_prestamo_hs = tipo_prestamo_hs;
    }

    public String getFecha_prestamo() {
        return fecha_prestamo;
    }

    public void setFecha_prestamo(String fecha_prestamo) {
        this.fecha_prestamo = fecha_prestamo;
    }

    public String getFecha_devolucion() {
        return fecha_devolucion;
    }

    public void setFecha_devolucion(String fecha_devolucion) {
        this.fecha_devolucion = fecha_devolucion;
    }

    public PrestamoEstado getEstado_devolucion() {
        return estado_devolucion;
    }

    public void setEstado_devolucion(PrestamoEstado estado_devolucion) {
        this.estado_devolucion = estado_devolucion;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

}
