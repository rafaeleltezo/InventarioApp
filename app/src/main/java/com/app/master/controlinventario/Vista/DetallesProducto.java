package com.app.master.controlinventario.Vista;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.app.master.controlinventario.R;

public class DetallesProducto extends AppCompatActivity implements View.OnClickListener {
    TextView codigo,nombre,fecha,fechaVencimiento,costoCompra,valorSugerido,descuento,iva;
    Button eliminar,guardar;
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

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.editarEliminar:
                Toast.makeText(this, "Eliminado", Toast.LENGTH_SHORT).show();
                break;
            case R.id.editarGuardar:
                Toast.makeText(this, "Editador", Toast.LENGTH_SHORT).show();
        }
    }
}
