package com.app.master.controlinventario.Modelo.ResFull;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.GET;

/**
 * Created by Rafael p on 22/6/2017.
 */

public interface Endpoint {

    @GET("http://sisra.rsisco.com/practica/archivo.php")
    Call<RespuestaEndpoint> GenerarDatos();
}
