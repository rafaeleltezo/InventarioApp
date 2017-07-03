package com.app.master.controlinventario.Vista;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.widget.LinearLayout;

import com.app.master.controlinventario.Modelo.Producto;
import com.app.master.controlinventario.Vista.AdaptadorRecicler.AdaptadorRecyclerProducto;
import com.app.master.controlinventario.Vista.AdaptadorRecicler.AdaptadorRecyclerProveedor;

import java.util.ArrayList;

/**
 * Created by Rafael p on 28/6/2017.
 */

public interface iProductoAgregar {

    public LinearLayoutManager getLinear();
    public void setLinear(LinearLayoutManager linear);
    public AdaptadorRecyclerProducto getAdaptador(ArrayList<Producto> pro, Context context,ArrayList<String>cadena);
    public void setAdaptador(AdaptadorRecyclerProducto adaptador);
}
