package com.app.master.controlinventario.Vista.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.app.master.controlinventario.Presentador.PresentadorProveedor;
import com.app.master.controlinventario.Presentador.iPresentadorProveedor;
import com.app.master.controlinventario.R;
import com.app.master.controlinventario.Vista.AdaptadorRecicler.AdaptadorRecyclerProducto;
import com.app.master.controlinventario.Vista.AdaptadorRecicler.AdaptadorRecyclerProveedor;

/**
 * Created by Rafael p on 26/6/2017.
 */

public class FragmentFormularioProveedores extends Fragment implements iFragmentFormularioProveedores{

    private TextView nombre,nit,direccion,telefono;
    private Button enviar;
    iPresentadorProveedor presentador;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragmentoformularioproveedor,container,false);
        presentador=new PresentadorProveedor(getContext(),this);
        nombre=     (TextView)    v.findViewById(R.id.nombre_proveedor);
        nit=        (TextView)    v.findViewById(R.id.nit_proveedor);
        direccion=  (TextView)    v.findViewById(R.id.direccion_proveedor);
        telefono=   (TextView)    v.findViewById(R.id.telefono_proveedor);
        enviar=     (Button)      v.findViewById(R.id.enviar);

        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                presentador.IngresarProveedor(nit.getText().toString(),nombre.getText().toString(),
                        direccion.getText().toString(),telefono.getText().toString());

            }
        });
        return v;
    }
}
