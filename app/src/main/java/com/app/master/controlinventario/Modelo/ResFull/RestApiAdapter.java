package com.app.master.controlinventario.Modelo.ResFull;

import com.app.master.controlinventario.Modelo.ResFull.Deserializador.DeserializadorDatosJson;
import com.app.master.controlinventario.Modelo.ResFull.Deserializador.DeserializadorIngresarProveedor;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Rafael p on 22/6/2017.
 */

public class RestApiAdapter {

    public Endpoint establecerConexion(Gson gson){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://sisra.rsisco.com")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        return retrofit.create(Endpoint.class);
    }

    public Gson contruirGsonDeserializador(){
        GsonBuilder gsonBuilder=new GsonBuilder();
        gsonBuilder.registerTypeAdapter(RespuestaEndpoint.class,new DeserializadorDatosJson());
        return gsonBuilder.create();
    }

    //Enpoint Provvedores

    public Endpoint establecerConexionIngresarProveedor(Gson gson){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://sisra.rsisco.com")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        return retrofit.create(Endpoint.class);
    }

    public Gson constriurGsonDeserializadorProveedores(){
        GsonBuilder gsonBuilder=new GsonBuilder();
        gsonBuilder.registerTypeAdapter(RespuestaEndpointIngresarProveedor.class,new DeserializadorIngresarProveedor());
        return gsonBuilder.create();
    }

}
