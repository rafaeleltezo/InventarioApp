package com.app.master.controlinventario.Modelo.ResFull.Deserializador;

import android.util.Log;

import com.app.master.controlinventario.Modelo.ResFull.Datos;
import com.app.master.controlinventario.Modelo.ResFull.RespuestaEndpoint;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 * Created by Rafael p on 22/6/2017.
 */

public class DeserializadorDatosJson implements JsonDeserializer<RespuestaEndpoint>{

    @Override
    public RespuestaEndpoint deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        Gson gson=new Gson();
        RespuestaEndpoint respuesta=gson.fromJson(json,RespuestaEndpoint.class);
        JsonArray jsons =json.getAsJsonObject().getAsJsonArray("Datos");
        respuesta.setDatosEndpoint(resApi(jsons));
        return respuesta;
    }

    public ArrayList<Datos> resApi(JsonArray jsons){
        ArrayList<Datos> datos=new ArrayList<>();

        for (int i = 0; i <jsons.size() ; i++) {
            JsonObject jsonObject= jsons.get(i).getAsJsonObject();
            String id=jsonObject.get("id").getAsString();
            String fecha=jsonObject.get("fecha").getAsString();
            String pagina=jsonObject.get("pagina").getAsString();
            String imagen=jsonObject.get("imagen").getAsString();
            Datos d=new Datos();
            d.setId(id);
            d.setFecha(fecha);
            d.setFoto(imagen);
            d.setPagina(pagina);
            datos.add(d);
        }
        return datos;
    }
}
