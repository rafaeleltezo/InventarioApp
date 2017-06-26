package com.app.master.controlinventario.Vista.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

import com.app.master.controlinventario.Modelo.Proveedor;
import com.app.master.controlinventario.Presentador.PresentadorProveedor;
import com.app.master.controlinventario.Presentador.iPresentadorProveedor;
import com.app.master.controlinventario.R;
import com.app.master.controlinventario.Vista.AdaptadorRecicler.AdaptadorRecyclerProveedor;

import java.util.ArrayList;

/**
 * Created by Rafael p on 26/6/2017.
 */

public class FragmentRecyclerProveedores extends Fragment implements iFragmentRecyclerProveedores {

    private RecyclerView recyclerView;
    private iPresentadorProveedor presentador;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View vista=inflater.inflate(R.layout.fragmentorecyclerproveedor,container,false);
        recyclerView=(RecyclerView)vista.findViewById(R.id.recyclerProveedor);
        presentador=new PresentadorProveedor(getContext(),this);
        registerForContextMenu(vista.findViewById(R.id.recyclerProveedor));
        return vista;
    }


    @Override
    public GridLayoutManager crearLayaout() {
        GridLayoutManager grid=new GridLayoutManager(getContext(),2);
        return grid;
    }

    @Override
    public void establecerLayout(GridLayoutManager gridLayoutManager) {
        recyclerView.setLayoutManager(gridLayoutManager);
    }

    @Override
    public AdaptadorRecyclerProveedor crearAdaptador(ArrayList<Proveedor> proveedores, Context context) {
        return  new AdaptadorRecyclerProveedor(proveedores,context);
    }

    @Override
    public void establecerAdaptador(AdaptadorRecyclerProveedor adaptadorRecyclerProveedor) {
        recyclerView.setAdapter(adaptadorRecyclerProveedor);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {

    }
}
