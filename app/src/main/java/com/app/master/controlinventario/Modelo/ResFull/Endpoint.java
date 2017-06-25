package com.app.master.controlinventario.Modelo.ResFull;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by Rafael p on 22/6/2017.
 */

public interface Endpoint {

    @GET("http://sisra.rsisco.com/practica/archivo.php")
    Call<RespuestaEndpoint> GenerarDatos();

    @POST("http://sisra.rsisco.com/controlinventario/CrearProveedores.php")
    Call<RespuestaEndpointIngresarProveedor> CrearProveedores(
            @Field("nit") String nit, @Field("nombre")String nombre,
            @Field("direccion")String direccion, @Field("telefono") String telefono);
}
