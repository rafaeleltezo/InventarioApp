package com.app.master.controlinventario.Vista.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.app.master.controlinventario.Modelo.Proveedor;
import com.app.master.controlinventario.R;
import com.app.master.controlinventario.Vista.AdaptadorRecicler.AdaptadorRecyclerProveedor;

import java.util.ArrayList;

/**
 * Created by Rafael p on 26/6/2017.
 */

public class FragmentRecyclerProveedores extends Fragment implements iFragmentRecyclerProveedores {

    private RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View vista=inflater.inflate(R.layout.fragmentorecyclerproveedor,container,false);
        recyclerView=(RecyclerView)vista.findViewById(R.id.recyclerProveedor);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),2));
        recyclerView.setAdapter(new AdaptadorRecyclerProveedor(proveedores(),getContext()));
        return vista;
    }

    ArrayList<Proveedor>proveedores(){
        ArrayList<Proveedor>proveedor=new ArrayList();
        proveedor.add(new Proveedor("021","pstobon","calle","312"));
        proveedor.add(new Proveedor("022","pesis","calle","312"));
        proveedor.add(new Proveedor("023","on","calle","312"));
        proveedor.add(new Proveedor("024","pson","calle","312"));
        proveedor.add(new Proveedor("025","ton","calle","312"));
        return proveedor;
    }
}
