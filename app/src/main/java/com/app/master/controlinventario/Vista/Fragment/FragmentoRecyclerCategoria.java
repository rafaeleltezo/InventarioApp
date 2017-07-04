package com.app.master.controlinventario.Vista.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.app.master.controlinventario.Modelo.Categoria;
import com.app.master.controlinventario.R;
import com.app.master.controlinventario.Vista.AdaptadorRecicler.AdaptadorRecyclerCategoria;

import java.util.ArrayList;

/**
 * Created by Rafael p on 3/7/2017.
 */

public class FragmentoRecyclerCategoria extends Fragment{

    private RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View vista=inflater.inflate(R.layout.fragmentorecyclerformulariocategoria,container,false);
        recyclerView=(RecyclerView)vista.findViewById(R.id.recyclerCategoria);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),2));
        recyclerView.setAdapter(new AdaptadorRecyclerCategoria(categorias(),getContext()));
        return vista;
    }

    public ArrayList<Categoria> categorias(){
        ArrayList<Categoria> categorias=new ArrayList();
        categorias.add(new Categoria("1232","adsasda"));
        categorias.add(new Categoria("2","adsasda"));
        categorias.add(new Categoria("122","adsasda"));
        categorias.add(new Categoria("123","adsasda"));
        categorias.add(new Categoria("32","adsasda"));
        return categorias;

    }
}
