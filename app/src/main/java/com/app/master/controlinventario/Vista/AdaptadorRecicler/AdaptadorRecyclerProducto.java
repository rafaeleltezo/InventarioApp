package com.app.master.controlinventario.Vista.AdaptadorRecicler;

import android.content.Context;
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
import com.app.master.controlinventario.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Rafael p on 23/6/2017.
 */

public class AdaptadorRecyclerProducto extends RecyclerView.Adapter<AdaptadorRecyclerProducto.viewHolder> {

    private ArrayList<Producto> productos;

    private Context context;

    public AdaptadorRecyclerProducto(ArrayList<Producto> productos, Context context){
        this.productos=productos;
        this.context=context;
    }

    @Override
    public viewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.cartaproducto,parent,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(viewHolder holder, int position) {
        Producto producto=productos.get(position);

        holder.codigo.setText(producto.getCodigo());
        holder.nombre.setText(producto.getNombre());
        holder.precio.setText(String.valueOf(producto.getCostoCompra()));
        //Picasso.with(context).load(producto.getImagen()).into(holder.foto);

    }

    @Override
    public int getItemCount() {
        return productos.size();
    }

    public static class viewHolder extends RecyclerView.ViewHolder{
        private TextView nombre,codigo,precio;
        private ImageView foto;

        public viewHolder(View itemView) {
            super(itemView);
            codigo=(TextView)                     itemView.findViewById(R.id.codigoProductoCarta);
            nombre=(TextView)                     itemView.findViewById(R.id.NombreCartaProducto);
            precio=(TextView)                     itemView.findViewById(R.id.PrecioCartaProducto);
            foto=(ImageView)                      itemView.findViewById(R.id.imagenCartaProducto);

        }

    }
}
