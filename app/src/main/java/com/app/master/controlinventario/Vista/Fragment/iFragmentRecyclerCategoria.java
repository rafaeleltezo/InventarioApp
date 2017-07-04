package com.app.master.controlinventario.Vista.Fragment;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;

import com.app.master.controlinventario.Modelo.Categoria;
import com.app.master.controlinventario.Vista.AdaptadorRecicler.AdaptadorRecyclerCategoria;

import java.util.ArrayList;

/**
 * Created by Rafael p on 3/7/2017.
 */

public interface iFragmentRecyclerCategoria {

    public GridLayoutManager crearLayaout();
    public void establecerLayout(GridLayoutManager gridLayoutManager);
    public AdaptadorRecyclerCategoria crearAdaptador(ArrayList<Categoria> proveedores, Context context);
    public void establecerAdaptador(AdaptadorRecyclerCategoria adaptadorRecyclerProveedor);
}
