package com.app.master.controlinventario.Presentador;

import android.content.Context;

import com.app.master.controlinventario.Modelo.Producto;
import com.app.master.controlinventario.Vista.iProductoAgregar;

import java.util.ArrayList;

/**
 * Created by Rafael p on 28/6/2017.
 */

public class PresentadorProducto implements iPresentadorProducto {
    private iProductoAgregar iProductoAgregar;
    private Context context;
    private ArrayList<Producto>productos;
    private ArrayList<String> cadenas;

    public PresentadorProducto(Context context,iProductoAgregar iProductoAgregar,ArrayList<Producto>productos,ArrayList<String>cadenas){
        this.context=context;
        this.iProductoAgregar=iProductoAgregar;
        this.productos=productos;
        this.cadenas=cadenas;
    }


    @Override
    public void estabecerLayout() {
        iProductoAgregar.setLinear(iProductoAgregar.getLinear());
    }

    @Override
    public void establecerRecycler() {
        iProductoAgregar.setAdaptador(iProductoAgregar.getAdaptador(productos,context,cadenas));
    }

}
