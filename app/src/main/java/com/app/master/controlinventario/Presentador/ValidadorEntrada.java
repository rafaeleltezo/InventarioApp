package com.app.master.controlinventario.Presentador;

import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Rafael p on 21/6/2017.
 */

public class ValidadorEntrada {

    //terminar
    public Boolean validarCadena(ArrayList<TextView> textViews){
        for (TextView texto:textViews) {
            try {
                Integer.parseInt(texto.getText().toString());
                return false;
            } catch (NumberFormatException nfe){
                return true;
            }

        }
        return false;
    }

    public Boolean textoVacio(ArrayList<TextView> texViews){
        for (TextView texto:texViews) {
            if(texto.getText().toString().equals("")){
                return true;

            }else {
                return false;
            }
        }
       return false;
    }

    public ArrayList<String> quitarEspacios(ArrayList<TextView> texViews){
        ArrayList<String> cadena=new ArrayList();
        for (TextView texto:texViews) {
            cadena.add(texto.getText().toString().trim());
        }
        return cadena;
    }
}
