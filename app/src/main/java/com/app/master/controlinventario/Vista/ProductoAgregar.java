package com.app.master.controlinventario.Vista;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;
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
        recyclerView=(RecyclerView)findViewById(R.id.recyclerProductoAgregar);
        productos=new ArrayList();
        Bundle bundle=getIntent().getExtras();
        //ArrayList<Producto>cadena=(ArrayList<Producto>) bundle.get("cadena");
        ArrayList<String> cadenas=(ArrayList<String>) bundle.get("cadena");
        for (String cadena:cadenas) {

        String[]valores=cadena.split(":");

        String codigo=valores[0];
        String nombre=valores[1];
        String fecha=valores[2];
        String fechaVencimiento=valores[3];
        String imagen=valores[8];
        double costoCompra=Double.parseDouble(valores[4]);
        double valorSugerido=Double.parseDouble(valores[5]);
        double descuento=Double.parseDouble(valores[6]);
        double iva=Double.parseDouble(valores[7]);
        productos.add(new Producto(codigo,nombre, fecha, fechaVencimiento,costoCompra, valorSugerido, descuento, iva, imagen));
        }

        presentador=new PresentadorProducto(this,this,productos);
        /*productos=new ArrayList();
        for (Producto c:cadena) {

            productos.add(c);
        }*/
        presentador.estabecerLayout();
        presentador.establecerRecycler();
    }

    @Override
    public LinearLayoutManager getLinear() {
        LinearLayoutManager linear=new LinearLayoutManager(this);
        return linear;
    }

    @Override
    public void setLinear(LinearLayoutManager gridLayout) {
       recyclerView.setLayoutManager(gridLayout);
    }

    @Override
    public AdaptadorRecyclerProducto getAdaptador(ArrayList<Producto>pro, Context context) {
        AdaptadorRecyclerProducto adaptador=new AdaptadorRecyclerProducto(pro,context);
        return adaptador;
    }

    @Override
    public void setAdaptador(AdaptadorRecyclerProducto adaptador) {
        recyclerView.setAdapter(adaptador);
    }

}
