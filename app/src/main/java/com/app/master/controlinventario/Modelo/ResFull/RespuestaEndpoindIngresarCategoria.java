package com.app.master.controlinventario.Modelo.ResFull;

import com.app.master.controlinventario.Modelo.Categoria;

import java.util.ArrayList;

/**
 * Created by Rafael p on 3/7/2017.
 */

public class RespuestaEndpoindIngresarCategoria {
    ArrayList<Categoria>categorias;

    public ArrayList<Categoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(ArrayList<Categoria> categorias) {
        this.categorias = categorias;
    }
}
