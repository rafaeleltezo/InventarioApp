package com.app.master.controlinventario.Vista;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.app.master.controlinventario.R;

public class Proveedores extends AppCompatActivity {

    private TextView nombre,nit,direccion,telefono;
    private Button enviar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proveedores);
        nombre=(TextView) findViewById(R.id.nombre_proveedor);
        nit=(TextView) findViewById(R.id.nit_proveedor);
        direccion=(TextView) findViewById(R.id.direccion_proveedor);
        telefono=(TextView) findViewById(R.id.telefono_proveedor);
        nombre=(Button) findViewById(R.id.enviar);
    }
}
