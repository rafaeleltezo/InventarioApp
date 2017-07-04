package com.app.master.controlinventario.Modelo;

/**
 * Created by Rafael p on 3/7/2017.
 */

public class Categoria {

    private String codigo,nombre;

    public Categoria(String codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }

    public Categoria() {
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
