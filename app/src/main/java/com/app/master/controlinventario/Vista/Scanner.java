package com.app.master.controlinventario.Vista;

import android.app.Activity;
import android.content.Intent;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.Toast;

import com.app.master.controlinventario.MainActivity;
import com.app.master.controlinventario.Modelo.Producto;

import java.util.ArrayList;

import me.dm7.barcodescanner.zbar.Result;
import me.dm7.barcodescanner.zbar.ZBarScannerView;

import static android.content.ContentValues.TAG;

/**
 * Created by Rafael p on 27/6/2017.
 */

public class Scanner extends Activity implements ZBarScannerView.ResultHandler {
    private ZBarScannerView mScannerView;
    private Intent intento;
    FloatingActionButton boton;
    ArrayList<String> cadena;

    @Override
    public void onCreate(Bundle state) {
        super.onCreate(state);
        mScannerView = new ZBarScannerView(this);    // Programmatically initialize the scanner view
        setContentView(mScannerView);                // Set the scanner view as the content view
        intento=new Intent(this, ProductoAgregar.class);
        cadena=new ArrayList();
        boton=new FloatingActionButton(this);
        boton.setLayoutParams(new AbsListView.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));

    }

    @Override
    public void onResume() {
        super.onResume();
        mScannerView.setResultHandler(this); // Register ourselves as a handler for scan results.
        mScannerView.startCamera();          // Start camera on resume
    }

    @Override
    public void onPause() {
        super.onPause();
        mScannerView.stopCamera();           // Stop camera on pause
    }

    @Override
    public void handleResult(Result rawResult) {
        // Do something with the result here

       // Log.v(TAG, rawResult.getContents()); // Prints scan results
       // Log.v(TAG, rawResult.getBarcodeFormat().getName()); // Prints the scan format (qrcode, pdf417 etc.)
        //Toast.makeText(this, rawResult.getContents(), Toast.LENGTH_SHORT).show();
        Uri notificacion=RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        Ringtone rintn=RingtoneManager.getRingtone(this,notificacion);
        rintn.play();

        // If you would like to resume scanning, call this method below:
        try {
            Thread.sleep(2000);
            mScannerView.resumeCameraPreview(this);
            desencriptarImagen(rawResult.getContents());

        } catch (InterruptedException e) {
            e.printStackTrace();
            Toast.makeText(this, "Error al escanear", Toast.LENGTH_SHORT).show();
        }

    }
    public void desencriptarImagen(String cadena){
        this.cadena.add(cadena);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        intento.putExtra("cadena",cadena);
        startActivity(intento);

    }
}
