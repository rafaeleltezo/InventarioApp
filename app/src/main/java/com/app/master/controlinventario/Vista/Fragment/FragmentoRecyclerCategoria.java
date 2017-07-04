package com.app.master.controlinventario.Vista.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.app.master.controlinventario.Modelo.Categoria;
import com.app.master.controlinventario.Presentador.PresentadorCategoria;
import com.app.master.controlinventario.Presentador.iPresentadorCategoria;
import com.app.master.controlinventario.R;
import com.app.master.controlinventario.Vista.AdaptadorRecicler.AdaptadorRecyclerCategoria;

import java.util.ArrayList;

/**
 * Created by Rafael p on 3/7/2017.
 */

public class FragmentoRecyclerCategoria extends Fragment implements iFragmentRecyclerCategoria{

    private RecyclerView recyclerView;
    private iPresentadorCategoria presentador;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View vista=inflater.inflate(R.layout.fragmentorecyclerformulariocategoria,container,false);
        recyclerView=(RecyclerView)vista.findViewById(R.id.recyclerCategoria);
        presentador=new PresentadorCategoria(this,getContext());
        presentador.ListarCategorias();
        return vista;
    }


    @Override
    public GridLayoutManager crearLayaout() {
        return new GridLayoutManager(getContext(),2);
    }

    @Override
    public void establecerLayout(GridLayoutManager gridLayoutManager) {
        recyclerView.setLayoutManager(gridLayoutManager);
    }

    @Override
    public AdaptadorRecyclerCategoria crearAdaptador(ArrayList<Categoria> proveedores, Context context) {
        return new AdaptadorRecyclerCategoria(proveedores,context);
    }

    @Override
    public void establecerAdaptador(AdaptadorRecyclerCategoria adaptadorRecyclerProveedor) {
        recyclerView.setAdapter(adaptadorRecyclerProveedor);
    }
}
