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
 * Created by macbookpro on 27/06/17.
 */

public class FragmentFormularioCategoria extends Fragment {

    private TextView codigoCategoria,  nombreCategoria;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragmentformulariocategoria,container,false);

        return view;
    }
}