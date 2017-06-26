package com.app.master.controlinventario.Vista.AdaptadorRecicler;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import com.app.master.controlinventario.Modelo.Proveedor;
import com.app.master.controlinventario.R;

import java.util.ArrayList;
import java.util.zip.Inflater;

/**
 * Created by Rafael p on 26/6/2017.
 */

public class AdaptadorRecyclerProveedor extends RecyclerView.Adapter<AdaptadorRecyclerProveedor.holder> {

    private ArrayList<Proveedor> proveedores;
    private Context context;

    public AdaptadorRecyclerProveedor(ArrayList<Proveedor>proveedores,Context context){
        this.proveedores=proveedores;
        this.context=context;
    }
    @Override
    public holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View vista= LayoutInflater.from(parent.getContext()).inflate(R.layout.cartaproveedor,parent,false);

        return new holder(vista);
    }

    @Override
    public void onBindViewHolder(holder holder, int position) {
        Proveedor provedor=proveedores.get(position);
        holder.nit.setText(provedor.getNit());
        holder.nombre.setText(provedor.getNombre());
        holder.telefono.setText(provedor.getNumeroTelefono());
        holder.direccion.setText(provedor.getDireccion());
    }

    @Override
    public int getItemCount() {
        return proveedores.size();
    }

    public static class holder extends RecyclerView.ViewHolder implements View.OnCreateContextMenuListener,
            View.OnClickListener,AdapterView.OnItemClickListener{
        private TextView nit,nombre,direccion,telefono;

        public holder(View itemView) {
            super(itemView);
            nit=(TextView)itemView.findViewById(R.id.nitProvedorCarta);
            nombre=(TextView)itemView.findViewById(R.id.nombreProvedorCarta);
            direccion=(TextView)itemView.findViewById(R.id.direccionProvedorCarta);
            telefono=(TextView)itemView.findViewById(R.id.telefonoProvedorCarta);
            itemView.setOnCreateContextMenuListener(this);
        }

        @Override
        public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
            menu.setHeaderTitle("Select The Action");
            menu.add(0, v.getId(), 0, "Eliminar");//groupId, itemId, order, title
            menu.add(0, v.getId(), 0, "Editar");

        }

        @Override
        public void onClick(View v) {

        }

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        }
    }
}
