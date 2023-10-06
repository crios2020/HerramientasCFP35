package ar.org.centro35.herramientas.entities;

import ar.org.centro35.herramientas.enums.SocioEstado;
import ar.org.centro35.herramientas.enums.TipoDocumento;

public class Socio {
    
    private int id;
    private String nombre;
    private String apellido;
    private TipoDocumento tipo_documento;
    private String numero_documento;
    private String direccion;
    private String celular;
    private String telefono_linea;
    private String email;
    private String comentarios;
    private SocioEstado estado;

    public Socio() {
    }

    public Socio(String nombre, String apellido, TipoDocumento tipo_documento, String numero_documento,
            String direccion, String celular, String telefono_linea, String email, String comentarios) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.tipo_documento = tipo_documento;
        this.numero_documento = numero_documento;
        this.direccion = direccion;
        this.celular = celular;
        this.telefono_linea = telefono_linea;
        this.email = email;
        this.comentarios = comentarios;
        this.estado = SocioEstado.ACTIVO;
    }

    public Socio(String nombre, String apellido, TipoDocumento tipo_documento, String numero_documento,
            String direccion, String celular, String telefono_linea, String email, String comentarios,
            SocioEstado estado) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.tipo_documento = tipo_documento;
        this.numero_documento = numero_documento;
        this.direccion = direccion;
        this.celular = celular;
        this.telefono_linea = telefono_linea;
        this.email = email;
        this.comentarios = comentarios;
        this.estado = estado;
    }

    public Socio(int id, String nombre, String apellido, TipoDocumento tipo_documento, String numero_documento,
            String direccion, String celular, String telefono_linea, String email, String comentarios,
            SocioEstado estado) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.tipo_documento = tipo_documento;
        this.numero_documento = numero_documento;
        this.direccion = direccion;
        this.celular = celular;
        this.telefono_linea = telefono_linea;
        this.email = email;
        this.comentarios = comentarios;
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Socio [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", tipo_documento="
                + tipo_documento + ", numero_documento=" + numero_documento + ", direccion=" + direccion + ", celular="
                + celular + ", telefono_linea=" + telefono_linea + ", email=" + email + ", comentarios=" + comentarios
                + ", estado=" + estado + "]";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public TipoDocumento getTipo_documento() {
        return tipo_documento;
    }

    public void setTipo_documento(TipoDocumento tipo_documento) {
        this.tipo_documento = tipo_documento;
    }

    public String getNumero_documento() {
        return numero_documento;
    }

    public void setNumero_documento(String numero_documento) {
        this.numero_documento = numero_documento;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getTelefono_linea() {
        return telefono_linea;
    }

    public void setTelefono_linea(String telefono_linea) {
        this.telefono_linea = telefono_linea;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    public SocioEstado getEstado() {
        return estado;
    }

    public void setEstado(SocioEstado estado) {
        this.estado = estado;
    }

}
