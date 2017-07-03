package com.app.master.controlinventario.Modelo.ResFull;

/**
 * Created by Rafael p on 3/7/2017.
 */

public class ConstantesGeneradorCodigoQr {
    public static final String BASEURL="https://api.qrserver.com";
    public static final String VERSION="/v1";
    public static final String COMANDO="/create-qr-code";
    public static final String TAMAÑO="/?size=350x350";
    public static final String DATOS="&data=";
    public static final String INDICADOR_PRODUCTO="p%27";
    public static final String URL=BASEURL+VERSION+COMANDO+TAMAÑO+DATOS+INDICADOR_PRODUCTO;
}
