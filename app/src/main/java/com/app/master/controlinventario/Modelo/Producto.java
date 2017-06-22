package com.app.master.controlinventario.Modelo;

/**
 * Created by Rafael p on 21/6/2017.a
 */

public class Producto {
    String codigo,nombre,fecha,fechaVencimiento;
    double costoCompra,valorSugerido,descuento,iva;

    public Producto(String codigo, String nombre, String fecha, String fechaVencimiento, double costoCompra, double valorSugerido, double descuento, double iva) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.fecha = fecha;
        this.fechaVencimiento = fechaVencimiento;
        this.costoCompra = costoCompra;
        this.valorSugerido = valorSugerido;
        this.descuento = descuento;
        this.iva = iva;
    }

    public Producto() {
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

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(String fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public double getCostoCompra() {
        return costoCompra;
    }

    public void setCostoCompra(double costoCompra) {
        this.costoCompra = costoCompra;
    }

    public double getValorSugerido() {
        return valorSugerido;
    }

    public void setValorSugerido(double valorSugerido) {
        this.valorSugerido = valorSugerido;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public double getIva() {
        return iva;
    }

    public void setIva(double iva) {
        this.iva = iva;
    }
}
