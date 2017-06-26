package com.app.master.controlinventario.Vista.Fragment;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;

import com.app.master.controlinventario.Modelo.Proveedor;
import com.app.master.controlinventario.Vista.AdaptadorRecicler.AdaptadorRecyclerProveedor;

import java.util.ArrayList;

/**
 * Created by Rafael p on 26/6/2017.
 */

public interface iFragmentRecyclerProveedores {

    public GridLayoutManager crearLayaout();
    public void establecerLayout(GridLayoutManager gridLayoutManager);
    public AdaptadorRecyclerProveedor crearAdaptador(ArrayList<Proveedor> proveedores, Context context);
    public void establecerAdaptador(AdaptadorRecyclerProveedor adaptadorRecyclerProveedor);
}
