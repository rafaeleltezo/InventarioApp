package com.app.master.controlinventario.Vista;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.app.master.controlinventario.Modelo.Producto;
import com.app.master.controlinventario.R;

import java.util.ArrayList;

public class DetallesProducto extends AppCompatActivity implements View.OnClickListener {
    private TextView codigo,nombre,fecha,fechaVencimiento,costoCompra,valorSugerido,descuento,iva;
    private Button eliminar,guardar;
    private ArrayList<String>productos;
    private Intent intento;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalles_producto);

        codigo=(TextView)findViewById(R.id.editarCodigoProducto);
        nombre=(TextView)findViewById(R.id.editarNombreProducto);
        fecha=(TextView)findViewById(R.id.editarFeechaProducto);
        fechaVencimiento=(TextView)findViewById(R.id.editarFechaVencimientoProducto);
        costoCompra=(TextView)findViewById(R.id.editarCostoCompraProducto);
        valorSugerido=(TextView)findViewById(R.id.editarValorSugeridoProducto);
        descuento=(TextView)findViewById(R.id.editarDescuentoProducto);
        iva=(TextView)findViewById(R.id.editarIvaProducto);
        eliminar=(Button)findViewById(R.id.editarEliminar);
        guardar=(Button)findViewById(R.id.editarGuardar);
        Bundle bundle=getIntent().getExtras();
        productos=(ArrayList<String>) bundle.get("array_posicion");
        String codigos=bundle.getString("codigo");
        String nombres=bundle.getString("nombre");
        String fechas=bundle.getString("fecha");
        String fechaVencimientos=bundle.getString("fechaVencimiento");
        double costoCompras=bundle.getDouble("costoCompra");
        double valorSugeridos=bundle.getDouble("valorSugerido");
        double descuentos=bundle.getDouble("descuento");
        double ivas=bundle.getDouble("iva");
       // String imagen=bundle.getString("foto");
        codigo.setText(codigos);
        nombre.setText(nombres);
        fecha.setText(fechas);
        fechaVencimiento.setText(fechaVencimientos);
        costoCompra.setText(String.valueOf(costoCompras));
        valorSugerido.setText(String.valueOf(valorSugeridos));
        descuento.setText(String.valueOf(descuentos));
        iva.setText(String.valueOf(iva));
        eliminar.setOnClickListener(this);
        guardar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.editarEliminar:
                if(eliminarRegisto(codigo.getText().toString())) {
                    intento = new Intent(this, ProductoAgregar.class);
                    intento.putExtra("cadena", productos);
                    startActivity(intento);
                }else {
                    Toast.makeText(this, "Error al eliminar", Toast.LENGTH_SHORT).show();
                }

                break;
            case R.id.editarGuardar:
                if(eliminarRegisto(codigo.getText().toString()) && agregarRegistro()) {

                    intento = new Intent(this, ProductoAgregar.class);
                    intento.putExtra("cadena", productos);
                    startActivity(intento);
                    break;
                }else {
                    Toast.makeText(this, "Error al editar", Toast.LENGTH_SHORT).show();
                }
        }
    }

    public boolean eliminarRegisto(String codigo){
        codigo=this.codigo.getText().toString();
        boolean validador=false;

        for (int i = 0; i < productos.size(); i++)  {
            String []decodificado=productos.get(i).split(":");

            if(decodificado[1].equals(codigo)){
                productos.remove(i);
                validador=true;
                break;
            }

        }
        return validador;
    }
    public boolean agregarRegistro(){
        String codigo=this.codigo.getText().toString();
        String nombre=this.nombre.getText().toString();
        String fecha=this.fecha.getText().toString();
        String fechaVencimiento=this.fechaVencimiento.getText().toString();
        String costoCompra=this.costoCompra.getText().toString();
        String valorSugerido=this.valorSugerido.getText().toString();
        String descuento=this.descuento.getText().toString();
        String iva=this.iva.getText().toString();
        return productos.add("p"+codigo+":"+nombre+":"+fecha+":"+fechaVencimiento+":"+costoCompra+":"
                +valorSugerido+":"+descuento+":"+iva);
    }

}
