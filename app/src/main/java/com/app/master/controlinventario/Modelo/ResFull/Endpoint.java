package com.app.master.controlinventario.Modelo.ResFull;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Rafael p on 22/6/2017.
 */

public interface Endpoint {

    @GET("http://sisra.rsisco.com/practica/archivo.php")
    Call<RespuestaEndpoint> GenerarDatos();

    @GET("http://sisra.rsisco.com/controlinventario/CrearProveedores.php")
    Call<RespuestaEndpointIngresarProveedor> CrearProveedores(
            @Query("nit") String nit, @Query("nombre")String nombre,
            @Query("direccion")String direccion, @Query("telefono") String telefono);

    @GET("http://sisra.rsisco.com/controlinventario/ListarProveedores.php")
    Call<RespuestaProveedores>obtenerListaprovedores();
}
