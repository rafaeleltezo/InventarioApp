package com.app.master.controlinventario.Vista;

import android.support.v7.widget.GridLayoutManager;

import com.app.master.controlinventario.Vista.AdaptadorRecicler.AdaptadorRecyclerProducto;
import com.app.master.controlinventario.Vista.AdaptadorRecicler.AdaptadorRecyclerProveedor;

/**
 * Created by Rafael p on 28/6/2017.
 */

public interface iProductoAgregar {

    public GridLayoutManager getGridLayaut();
    public void setGridLayout(GridLayoutManager gridLayout);
    public AdaptadorRecyclerProducto getAdaptador();
    public void setAdaptador(AdaptadorRecyclerProducto adaptador);
}
