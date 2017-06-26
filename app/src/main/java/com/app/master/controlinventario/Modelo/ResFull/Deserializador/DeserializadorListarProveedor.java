package com.app.master.controlinventario.Modelo.ResFull.Deserializador;

import com.app.master.controlinventario.Modelo.Proveedor;
import com.app.master.controlinventario.Modelo.ResFull.RespuestaProveedores;
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
 * Created by Rafael p on 26/6/2017.
 */

public class DeserializadorListarProveedor implements JsonDeserializer<RespuestaProveedores> {

    @Override
    public RespuestaProveedores deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        Gson gson=new Gson();
        RespuestaProveedores respuesta=gson.fromJson(json,RespuestaProveedores.class);
        JsonArray jsonArray=json.getAsJsonObject().getAsJsonArray("Proveedores");
        respuesta.setProveedores(deserializarArray(jsonArray));
        return respuesta;
    }

    private ArrayList<Proveedor> deserializarArray(JsonArray jsonArray){
        ArrayList<Proveedor> proveedores=new ArrayList();
        for (int i = 0; i <jsonArray.size() ; i++) {
            JsonObject objetoDato=jsonArray.get(i).getAsJsonObject();
            String nit=objetoDato.get("nit").getAsString();
            String nombre=objetoDato.get("nombre").getAsString();
            String direccion=objetoDato.get("direccion").getAsString();
            String telefono=objetoDato.get("telefono").getAsString();
            proveedores.add(new Proveedor(nit,nombre,direccion,telefono));
        }
        return proveedores;
    }
}
