package com.app.master.controlinventario.Vista.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.app.master.controlinventario.Presentador.PresentadorCategoria;
import com.app.master.controlinventario.Presentador.iPresentadorCategoria;
import com.app.master.controlinventario.R;

/**
 * Created by Rafael p on 3/7/2017.
 */

public class FragmentFormularioCategorias extends Fragment implements iFragmentoFormularioCategorias, View.OnClickListener {

    private EditText codigo,nombre;
    private Button enviar;
    private iPresentadorCategoria presentador;
    @Nullable
    @Override

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View vista=inflater.inflate(R.layout.fragmentformulariocategoria,container,false);
        codigo=(EditText)vista.findViewById(R.id.codigoCateriaformulario);
        nombre=(EditText)vista.findViewById(R.id.nombreCateriaformulario);
        enviar=(Button)vista.findViewById(R.id.enviarCategoriaformulario);
        presentador=new PresentadorCategoria(this,getContext());
        enviar.setOnClickListener(this);
        return vista;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.enviarCategoriaformulario:
                presentador.IngresarCategoria(codigo.getText().toString(),nombre.getText().toString());

        }
    }
}
