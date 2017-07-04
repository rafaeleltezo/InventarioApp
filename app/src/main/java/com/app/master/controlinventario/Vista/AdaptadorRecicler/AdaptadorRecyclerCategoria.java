package com.app.master.controlinventario.Vista.AdaptadorRecicler;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.app.master.controlinventario.Modelo.Categoria;
import com.app.master.controlinventario.R;

import java.util.ArrayList;
import java.util.zip.Inflater;

/**
 * Created by Rafael p on 3/7/2017.
 */

public class AdaptadorRecyclerCategoria extends RecyclerView.Adapter<AdaptadorRecyclerCategoria.holderCategoria> {

    ArrayList<Categoria> categorias;
    Context context;

    public AdaptadorRecyclerCategoria(ArrayList<Categoria> categorias,Context context){
        this.categorias=categorias;
        this.context=context;
    }

    @Override
    public holderCategoria onCreateViewHolder(ViewGroup parent, int viewType) {
        View vista= LayoutInflater.from(parent.getContext()).inflate(R.layout.cartacategoria,parent,false);
        vista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Hola has echo click en la carta", Toast.LENGTH_SHORT).show();
            }
        });
        return new holderCategoria(vista);
    }

    @Override
    public void onBindViewHolder(holderCategoria holder, int position) {
        Categoria categoria=categorias.get(position);
        holder.codigo.setText(categoria.getCodigo());
        holder.nombre.setText(categoria.getNombre());

    }

    @Override
    public int getItemCount() {
        return categorias.size();
    }

    public static class holderCategoria extends RecyclerView.ViewHolder{

        private TextView codigo,nombre;

        public holderCategoria(View itemView) {
            super(itemView);
            codigo=(TextView) itemView.findViewById(R.id.codigoCartaCategoria);
            nombre=(TextView) itemView.findViewById(R.id.nombreCartaCategoria);
        }
    }
}
