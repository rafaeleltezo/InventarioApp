package com.app.master.controlinventario.Vista;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.app.master.controlinventario.MainActivity;
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
    private ArrayList<String> cadenas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_producto_agregar);
        recyclerView=(RecyclerView)findViewById(R.id.recyclerProductoAgregar);
        productos=new ArrayList();
        Bundle bundle=getIntent().getExtras();
        //ArrayList<Producto>cadena=(ArrayList<Producto>) bundle.get("cadena");
        cadenas=(ArrayList<String>) bundle.get("cadena");
        for (String cadena:cadenas) {

        String[]valores=cadena.split(":");

        String codigo=valores[1];
        String nombre=valores[2];
        String fecha=valores[3];
        String fechaVencimiento=valores[4];
        String imagen=valores[9];
        double costoCompra=Double.parseDouble(valores[5]);
        double valorSugerido=Double.parseDouble(valores[6]);
        double descuento=Double.parseDouble(valores[7]);
        double iva=Double.parseDouble(valores[8]);
        productos.add(new Producto(codigo,nombre, fecha, fechaVencimiento,costoCompra, valorSugerido, descuento, iva, imagen));
        }

        presentador=new PresentadorProducto(this,this,productos,cadenas);
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
    public AdaptadorRecyclerProducto getAdaptador(ArrayList<Producto>pro, Context context,ArrayList<String>cadenas) {
        AdaptadorRecyclerProducto adaptador=new AdaptadorRecyclerProducto(pro,context,cadenas);
        return adaptador;
    }

    @Override
    public void setAdaptador(AdaptadorRecyclerProducto adaptador) {
        recyclerView.setAdapter(adaptador);
    }

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        Intent intentos=new Intent(this, MainActivity.class);
        startActivity(intentos);
        finish();
        return super.onKeyUp(keyCode, event);
    }
}
