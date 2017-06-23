package com.app.master.controlinventario.Modelo.ResFull;

/**
 * Created by Rafael p on 22/6/2017.
 */

public class Datos{
    private String id,fecha,pagina,foto;

    public Datos(String id, String fecha, String pagina, String foto) {
        this.id = id;
        this.fecha = fecha;
        this.pagina = pagina;
        this.foto = foto;
    }

    public Datos() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getPagina() {
        return pagina;
    }

    public void setPagina(String pagina) {
        this.pagina = pagina;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }
}
