package com.app.master.controlinventario.Modelo;

/**
 * Created by Rafael p on 21/6/2017.
 */

public class Proveedor {

    private String nit,nombre,direccion,numeroTelefono;

    public Proveedor(String nit, String nombre, String direccion, String numeroTelefono) {
        this.nit = nit;
        this.nombre = nombre;
        this.direccion = direccion;
        this.numeroTelefono = numeroTelefono;
    }

    public Proveedor() {
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNumeroTelefono() {
        return numeroTelefono;
    }

    public void setNumeroTelefono(String numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
    }
}
