package com.app.master.controlinventario.Modelo.ResFull.Deserializador;

import com.app.master.controlinventario.Modelo.ResFull.RespuestaEndpointIngresarProveedor;
import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

/**
 * Created by Rafael p on 3/7/2017.
 */

public class DeserializadorIngresarCategoria implements JsonDeserializer<RespuestaEndpointIngresarProveedor> {
    @Override
    public RespuestaEndpointIngresarProveedor deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        Gson gson=new Gson();
        RespuestaEndpointIngresarProveedor respuesta=gson.fromJson(json,RespuestaEndpointIngresarProveedor.class);
        JsonObject jsonObject=json.getAsJsonObject().getAsJsonObject("Categoria");
        String codigo=jsonObject.get("Respuesta").getAsString();
        respuesta.setCodigoEstatus(codigo);
        return respuesta;
    }
}
