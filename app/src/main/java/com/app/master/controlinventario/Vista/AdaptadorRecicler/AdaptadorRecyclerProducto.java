package com.app.master.controlinventario.Vista.AdaptadorRecicler;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.view.ActionMode;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.app.master.controlinventario.Modelo.Producto;
import com.app.master.controlinventario.Modelo.ResFull.ConstantesGeneradorCodigoQr;
import com.app.master.controlinventario.R;
import com.app.master.controlinventario.Vista.DetallesProducto;
import com.app.master.controlinventario.Vista.ProductoAgregar;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Rafael p on 23/6/2017.
 */

public class AdaptadorRecyclerProducto extends RecyclerView.Adapter<AdaptadorRecyclerProducto.viewHolder> {

    private ArrayList<Producto> productos;
    private ArrayList<String>cadena;
    private Context context;
    private View view;
    public AdaptadorRecyclerProducto(ArrayList<Producto> productos, Context context){
        this.productos=productos;
        this.context=context;
    }
    public AdaptadorRecyclerProducto(ArrayList<Producto> productos, Context context,ArrayList<String> cadena){
        this.productos=productos;
        this.context=context;
        this.cadena=cadena;
    }

    @Override
    public viewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cartaproducto, parent, false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(final viewHolder holder, int position) {
        final Producto producto=productos.get(position);
        holder.codigo.setText(producto.getCodigo());
        holder.nombre.setText(producto.getNombre());
        holder.precio.setText(String.valueOf(producto.getCostoCompra()));
        Picasso.with(context).load(producto.getImagen()).into(holder.foto);
        Picasso.with(context).load(ConstantesGeneradorCodigoQr.URL+producto.getCodigo()+"%27"+producto.getNombre()+"%27"+producto.getFecha()+"%27"+producto.getFechaVencimiento()
                +"%27"+producto.getCostoCompra()+"%27"+producto.getValorSugerido()+"%27"+producto.getDescuento()+"%27"+producto.getIva()+"%27"+producto.getImagen())
                .into(holder.imagenCodigoQr);
        holder.foto.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                Intent intent=new Intent(context, DetallesProducto.class);
                intent.putStringArrayListExtra("array_posicion",cadena);
                intent.putExtra("codigo",producto.getCodigo());
                intent.putExtra("nombre",producto.getNombre());
                intent.putExtra("fecha",producto.getFecha());
                intent.putExtra("fechaVencimiento",producto.getFechaVencimiento());
                intent.putExtra("costoCompra",producto.getCostoCompra());
                intent.putExtra("valorSugerido",producto.getValorSugerido());
                intent.putExtra("descuento",producto.getDescuento());
                intent.putExtra("iva",producto.getIva());
                intent.putExtra("foto",producto.getImagen());
                context.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return productos.size();
    }

    public static class viewHolder extends RecyclerView.ViewHolder{
        private TextView nombre,codigo,precio;
        private ImageView foto,imagenCodigoQr;

        public viewHolder(View itemView) {
            super(itemView);
            codigo=(TextView)                     itemView.findViewById(R.id.codigoProductoCarta);
            nombre=(TextView)                     itemView.findViewById(R.id.NombreCartaProducto);
            precio=(TextView)                     itemView.findViewById(R.id.PrecioCartaProducto);
            foto=(ImageView)                      itemView.findViewById(R.id.imagenCartaProducto);
            imagenCodigoQr=(ImageView)            itemView.findViewById(R.id.imagenCodigoQrCartaProducto);
        }

    }
}
