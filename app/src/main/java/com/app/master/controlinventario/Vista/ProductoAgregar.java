package com.app.master.controlinventario.Vista;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.app.master.controlinventario.Modelo.Producto;
import com.app.master.controlinventario.Presentador.PresentadorProducto;
import com.app.master.controlinventario.Presentador.iPresentadorProducto;
import com.app.master.controlinventario.R;
import com.app.master.controlinventario.Vista.AdaptadorRecicler.AdaptadorRecyclerProducto;
import com.app.master.controlinventario.Vista.AdaptadorRecicler.AdaptadorRecyclerProveedor;

import java.util.ArrayList;

public class ProductoAgregar extends AppCompatActivity implements iProductoAgregar{

    private iPresentadorProducto presentador;
    private RecyclerView recyclerView;
    private ArrayList<Producto> productos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_producto_agregar);
        presentador=new PresentadorProducto(this,this);
        recyclerView=(RecyclerView)findViewById(R.id.recyclerProductoAgregar);
        Bundle bundle=getIntent().getExtras();
        ArrayList<String>cadena=(ArrayList<String>) bundle.get("cadena");
        productos=new ArrayList();
        for (String c:cadena) {
            Toast.makeText(this, c, Toast.LENGTH_SHORT).show();
            productos.add(new Producto(c,"","","",0,0,0,0,""));
        }
        presentador.estabecerLayout();
        presentador.establecerRecycler();
    }

    @Override
    public GridLayoutManager getGridLayaut() {
        GridLayoutManager grid=new GridLayoutManager(this,2);
        return grid;
    }

    @Override
    public void setGridLayout(GridLayoutManager gridLayout) {
       recyclerView.setLayoutManager(gridLayout);
    }

    @Override
    public AdaptadorRecyclerProducto getAdaptador() {
        AdaptadorRecyclerProducto adaptador=new AdaptadorRecyclerProducto(productos,this);
        return adaptador;
    }

    @Override
    public void setAdaptador(AdaptadorRecyclerProducto adaptador) {
        recyclerView.setAdapter(adaptador);
    }

}
