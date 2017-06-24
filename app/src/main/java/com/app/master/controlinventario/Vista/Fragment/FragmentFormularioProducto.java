package com.app.master.controlinventario.Vista.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.app.master.controlinventario.R;

/**
 * Created by Rafael p on 23/6/2017.
 */

public class FragmentFormularioProducto extends Fragment {

    private TextView  codigo,  nombre,  fecha,  fechaVencimiento,  costoCompra,
            valorSugerido,  descuento,  iva, imagen;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragmentformularioproducto,container,false);

        return view;
    }
}
