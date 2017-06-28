package com.app.master.controlinventario.Presentador;

import android.content.Context;

import com.app.master.controlinventario.Vista.iProductoAgregar;

/**
 * Created by Rafael p on 28/6/2017.
 */

public class PresentadorProducto implements iPresentadorProducto {
    private iProductoAgregar iProductoAgregar;
    private Context context;

    public PresentadorProducto(Context context,iProductoAgregar iProductoAgregar){
        this.context=context;
        this.iProductoAgregar=iProductoAgregar;
    }


    @Override
    public void estabecerLayout() {
        iProductoAgregar.setGridLayout(iProductoAgregar.getGridLayaut());
    }

    @Override
    public void establecerRecycler() {
        iProductoAgregar.setAdaptador(iProductoAgregar.getAdaptador());
    }

}
