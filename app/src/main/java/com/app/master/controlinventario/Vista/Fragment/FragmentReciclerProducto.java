package com.app.master.controlinventario.Vista.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.app.master.controlinventario.Modelo.Producto;
import com.app.master.controlinventario.R;
import com.app.master.controlinventario.Vista.AdaptadorRecicler.AdaptadorRecyclerProducto;

import java.util.ArrayList;

/**
 * Created by Rafael p on 23/6/2017.
 */

public class FragmentReciclerProducto extends Fragment {
    private RecyclerView recyclerView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View view=inflater.inflate(R.layout.fragmentrecyclerproducto,container,false);
        recyclerView=(RecyclerView)view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(new AdaptadorRecyclerProducto(productos(),getContext()));
        return view;
    }

    private ArrayList<Producto> productos(){
        ArrayList<Producto>productos=new ArrayList();
        productos.add(new Producto("011","soflan","","",2,2,2,2,"https://images-na.ssl-images-amazon.com/images/I/5156FefjlqL._SY355_.jpg"));
        productos.add(new Producto("012","soflan","","",2,2,2,2,"https://static.iris.net.co/semana/upload/images/2016/7/11/481531_1.jpg"));
        productos.add(new Producto("013","soflan","","",2,2,2,2,"http://static.hsbnoticias.com/sites/default/files/styles/original/public/gallery/2015/12/chocorramo.png?itok=VUxLzUTF"));
        productos.add(new Producto("014","soflan","","",2,2,2,2,"https://images-na.ssl-images-amazon.com/images/I/5156FefjlqL._SY355_.jpg"));
        productos.add(new Producto("015","soflan","","",2,2,2,2,"http://static.hsbnoticias.com/sites/default/files/styles/original/public/gallery/2015/12/chocorramo.png?itok=VUxLzUTF"));
        return productos;
    }

}
