package com.app.master.controlinventario.Presentador;

import android.content.Context;
import android.widget.Toast;

import com.app.master.controlinventario.Modelo.Categoria;
import com.app.master.controlinventario.Modelo.ResFull.Deserializador.DeserializadorIngresarCategoria;
import com.app.master.controlinventario.Modelo.ResFull.Endpoint;
import com.app.master.controlinventario.Modelo.ResFull.RespuestaEndpoindIngresarCategoria;
import com.app.master.controlinventario.Modelo.ResFull.RespuestaEndpointIngresarProveedor;
import com.app.master.controlinventario.Modelo.ResFull.RestApiAdapter;
import com.app.master.controlinventario.Vista.Fragment.iFragmentRecyclerCategoria;
import com.app.master.controlinventario.Vista.Fragment.iFragmentoFormularioCategorias;
import com.google.gson.Gson;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Rafael p on 3/7/2017.
 */

public class PresentadorCategoria implements iPresentadorCategoria{

    private iFragmentoFormularioCategorias iFragmentoFormularioCategorias;
    iFragmentRecyclerCategoria ifragmentrecyclercategoria;
    ArrayList<Categoria>categorias;
    Context context;
    private String codigoEstatusCategoria;

    public PresentadorCategoria (iFragmentoFormularioCategorias ifragment,Context context){
        this.iFragmentoFormularioCategorias=ifragment;
        this.context=context;
    }

    public PresentadorCategoria(iFragmentRecyclerCategoria ifragment,Context context){
        this.ifragmentrecyclercategoria=ifragment;
        this.context=context;
        ListarCategorias();
    }


    @Override
    public void IngresarCategoria(String codigo, String nombre) {
        RestApiAdapter conexion=new RestApiAdapter();
        Gson gson=conexion.construirGsonDeserializadorIngresarCategoria();
        Endpoint endpoint=conexion.establecerConexion(gson);
        Call<RespuestaEndpointIngresarProveedor> respuesta=endpoint.CrearCategoria(codigo,nombre);
        respuesta.enqueue(new Callback<RespuestaEndpointIngresarProveedor>() {
            @Override
            public void onResponse(Call<RespuestaEndpointIngresarProveedor> call, Response<RespuestaEndpointIngresarProveedor> response) {
                RespuestaEndpointIngresarProveedor respuesta=response.body();
                codigoEstatusCategoria=respuesta.getCodigoEstatus();
                estadoDeingresoCategoria();
            }

            @Override
            public void onFailure(Call<RespuestaEndpointIngresarProveedor> call, Throwable t) {
                Toast.makeText(context, "Error, Intente mas tarde", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public void estadoDeingresoCategoria() {
        switch (codigoEstatusCategoria){
            case "0":
                Toast.makeText(context, "Proveedor agregado correctamente", Toast.LENGTH_SHORT).show();
                break;
            case "1":
                Toast.makeText(context, "Nit esta en uso", Toast.LENGTH_SHORT).show();
                break;
            case "2":
                Toast.makeText(context, "Datos faltantes", Toast.LENGTH_SHORT).show();
            default:
                Toast.makeText(context, "Error desconocido", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void ListarCategorias() {
        RestApiAdapter conexion=new RestApiAdapter();
        Gson gson=conexion.construirGsonDeserializadorListarCategoria();
        Endpoint endpoint=conexion.establecerConexion(gson);
        Call<RespuestaEndpoindIngresarCategoria>respuesta=endpoint.obtenerListaCategoria();
        respuesta.enqueue(new Callback<RespuestaEndpoindIngresarCategoria>() {
            @Override
            public void onResponse(Call<RespuestaEndpoindIngresarCategoria> call, Response<RespuestaEndpoindIngresarCategoria> response) {
                RespuestaEndpoindIngresarCategoria respuesta=response.body();
                categorias=respuesta.getCategorias();
                establecerRecycler();
            }

            @Override
            public void onFailure(Call<RespuestaEndpoindIngresarCategoria> call, Throwable t) {
                Toast.makeText(context, "Error, Intentelo mas tarde", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void establecerLayout() {
        ifragmentrecyclercategoria.establecerLayout(ifragmentrecyclercategoria.crearLayaout());
    }

    @Override
    public void establecerRecycler() {
        establecerLayout();
        ifragmentrecyclercategoria.establecerAdaptador(ifragmentrecyclercategoria.crearAdaptador(categorias,context));
    }

}
