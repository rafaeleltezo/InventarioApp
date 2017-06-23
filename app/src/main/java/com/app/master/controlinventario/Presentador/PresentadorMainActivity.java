package com.app.master.controlinventario.Presentador;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.app.master.controlinventario.Modelo.ResFull.Datos;
import com.app.master.controlinventario.Modelo.ResFull.Deserializador.DeserializadorDatosJson;
import com.app.master.controlinventario.Modelo.ResFull.Endpoint;
import com.app.master.controlinventario.Modelo.ResFull.RespuestaEndpoint;
import com.app.master.controlinventario.Modelo.ResFull.RestApiAdapter;
import com.app.master.controlinventario.Vista.iProveedores;
import com.google.gson.Gson;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Rafael p on 22/6/2017.
 */

public class PresentadorMainActivity implements iPresentadorMainActivity {

    private Context context;
    private iProveedores iproveedores;
    private ArrayList<Datos>datos;

    public PresentadorMainActivity(Context context,iProveedores proveedores){
        this.context=context;
        this.iproveedores=proveedores;
    }

    public ArrayList<Datos> getDatos() {
        return datos;
    }

    public void setDatos(ArrayList<Datos> datos) {
        this.datos = datos;
    }

    public void generandoRestFull(){
        RestApiAdapter restApiAdapter=new RestApiAdapter();
        Gson gson=restApiAdapter.contruirGsonDeserializador();
        Endpoint endpoint=restApiAdapter.establecerConexion(gson);
        Call<RespuestaEndpoint> respuestaEndpointCall=endpoint.GenerarDatos();

        respuestaEndpointCall.enqueue(new Callback<RespuestaEndpoint>() {
            @Override
            public void onResponse(Call<RespuestaEndpoint> call, Response<RespuestaEndpoint> response) {
                RespuestaEndpoint respuesta= response.body();
                setDatos(respuesta.getDatosEndpoint());
                iproveedores.mostrar(getDatos());
            }

            @Override
            public void onFailure(Call<RespuestaEndpoint> call, Throwable t) {
                Toast.makeText(context, t.getCause().getMessage().toString(), Toast.LENGTH_LONG).show();
            }
        });
    }

    public ArrayList<Datos> DatosResultante(){
        return getDatos();
    }
}
