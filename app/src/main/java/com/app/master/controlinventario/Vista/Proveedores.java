package com.app.master.controlinventario.Vista;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.app.master.controlinventario.MainActivity;
import com.app.master.controlinventario.Modelo.Proveedor;
import com.app.master.controlinventario.Modelo.ResFull.Datos;
import com.app.master.controlinventario.Presentador.PresentadorMainActivity;
import com.app.master.controlinventario.Presentador.iPresentadorMainActivity;
import com.app.master.controlinventario.R;

import java.util.ArrayList;

public class Proveedores extends AppCompatActivity implements iProveedores {

    private TextView nombre,nit,direccion,telefono;
    private Button enviar;
    iPresentadorMainActivity presentador;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proveedores);

        presentador=new PresentadorMainActivity(this,this);



        nombre=(TextView) findViewById(R.id.nombre_proveedor);
        nit=(TextView) findViewById(R.id.nit_proveedor);
        direccion=(TextView) findViewById(R.id.direccion_proveedor);
        telefono=(TextView) findViewById(R.id.telefono_proveedor);
        enviar=(Button) findViewById(R.id.enviar);

        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                presentador.generandoRestFull();

            }
        });

    }

    @Override
    public void mostrar(ArrayList<Datos> datos) {
        for (Datos dato:datos) {
            Toast.makeText(Proveedores.this, dato.getId()+"/n "+dato.getFecha()+"/n "+dato.getPagina()+"/n "+dato.getFoto()+"/n", Toast.LENGTH_SHORT).show();
        }
    }
}
