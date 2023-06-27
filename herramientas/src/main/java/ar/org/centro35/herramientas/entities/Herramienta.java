package ar.org.centro35.herramientas.entities;

import ar.org.centro35.herramientas.enums.HerramientaEstado;
import ar.org.centro35.herramientas.enums.HerramientaTipo;

public class Herramienta {

    private int id;
    private String codigo_barras;
    private String marca;
    private HerramientaTipo tipo;
    private String descripcion;
    private HerramientaEstado estado;
    private String observaciones;

    public Herramienta() {
    }

    public Herramienta(String marca, HerramientaTipo tipo, String descripcion, HerramientaEstado estado,
            String observaciones) {
        this.marca = marca;
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.estado = estado;
        this.observaciones = observaciones;
    }

    public Herramienta(String codigo_barras, String marca, HerramientaTipo tipo, String descripcion,
            HerramientaEstado estado, String observaciones) {
        this.codigo_barras = codigo_barras;
        this.marca = marca;
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.estado = estado;
        this.observaciones = observaciones;
    }

    public Herramienta(int id, String codigo_barras, String marca, HerramientaTipo tipo, String descripcion,
            HerramientaEstado estado, String observaciones) {
        this.id = id;
        this.codigo_barras = codigo_barras;
        this.marca = marca;
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.estado = estado;
        this.observaciones = observaciones;
    }

    @Override
    public String toString() {
        return "Herramienta [id=" + id + ", codigo_barras=" + codigo_barras + ", marca=" + marca + ", tipo=" + tipo
                + ", descripcion=" + descripcion + ", estado=" + estado + ", observaciones=" + observaciones + "]";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodigo_barras() {
        return codigo_barras;
    }

    public void setCodigo_barras(String codigo_barras) {
        this.codigo_barras = codigo_barras;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public HerramientaTipo getTipo() {
        return tipo;
    }

    public void setTipo(HerramientaTipo tipo) {
        this.tipo = tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public HerramientaEstado getEstado() {
        return estado;
    }

    public void setEstado(HerramientaEstado estado) {
        this.estado = estado;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

}
