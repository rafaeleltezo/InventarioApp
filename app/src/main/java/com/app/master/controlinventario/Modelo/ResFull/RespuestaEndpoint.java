package com.app.master.controlinventario.Modelo.ResFull;

import java.util.ArrayList;

/**
 * Created by Rafael p on 22/6/2017.
 */

public class RespuestaEndpoint {
    ArrayList<Datos>datosEndpoint;

    public ArrayList<Datos> getDatosEndpoint() {
        return datosEndpoint;
    }

    public void setDatosEndpoint(ArrayList<Datos> datosEndpoint) {
        this.datosEndpoint = datosEndpoint;
    }
}
