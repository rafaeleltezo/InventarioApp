package com.app.master.controlinventario.Modelo.ResFull.Deserializador;

import com.app.master.controlinventario.Modelo.Categoria;
import com.app.master.controlinventario.Modelo.ResFull.RespuestaEndpoindIngresarCategoria;
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
 * Created by Rafael p on 3/7/2017.
 */

public class DeserializadorListarCategorias implements JsonDeserializer<RespuestaEndpoindIngresarCategoria> {
    @Override
    public RespuestaEndpoindIngresarCategoria deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        Gson gson=new Gson();
        RespuestaEndpoindIngresarCategoria respuesta=gson.fromJson(json,RespuestaEndpoindIngresarCategoria.class);
        JsonArray jsonArray=json.getAsJsonObject().getAsJsonArray("Categoria");
        ArrayList<Categoria>categorias=deserializadorArrayCategorias(jsonArray);
        respuesta.setCategorias(categorias);
        return respuesta;
    }

    public ArrayList<Categoria> deserializadorArrayCategorias(JsonArray jsonArray){
        ArrayList<Categoria> categorias=new ArrayList();
        for (int i = 0; i <jsonArray.size() ; i++) {
            JsonObject datos=jsonArray.get(i).getAsJsonObject();
            String codigo=datos.get("codigo").getAsString();
            String nombre=datos.get("nombre").getAsString();
            categorias.add(new Categoria(codigo,nombre));
        }
        return categorias;
    }

}
