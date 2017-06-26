package com.app.master.controlinventario.Vista;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.app.master.controlinventario.MainActivity;
import com.app.master.controlinventario.Modelo.Proveedor;
import com.app.master.controlinventario.Modelo.ResFull.Datos;
import com.app.master.controlinventario.Presentador.PresentadorMainActivity;
import com.app.master.controlinventario.Presentador.PresentadorProveedor;
import com.app.master.controlinventario.Presentador.iPresentadorMainActivity;
import com.app.master.controlinventario.Presentador.iPresentadorProveedor;
import com.app.master.controlinventario.R;
import com.app.master.controlinventario.Vista.AdaptadorresViewPager.AdaptadorviewPagerProveedores;
import com.app.master.controlinventario.Vista.Fragment.FragmentFormularioProducto;
import com.app.master.controlinventario.Vista.Fragment.FragmentFormularioProveedores;
import com.app.master.controlinventario.Vista.Fragment.FragmentRecyclerProveedores;

import java.util.ArrayList;

public class Proveedores extends AppCompatActivity implements iProveedores {
    private ViewPager viewPager;
    private TabLayout tabLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proveedores);
        viewPager=(ViewPager)findViewById(R.id.viewPagerProveedor);
        tabLayout=(TabLayout) findViewById(R.id.tablayoutProveedor);
        viewPager.setAdapter(new AdaptadorviewPagerProveedores(getSupportFragmentManager(),fragment()));
        tabLayout.setupWithViewPager(viewPager);


    }

    public ArrayList<Fragment>fragment(){
        ArrayList<Fragment> fragments=new ArrayList();
        fragments.add(new FragmentFormularioProveedores());
        fragments.add(new FragmentRecyclerProveedores());
        return  fragments;
    }

    @Override
    public void mostrar(ArrayList<Datos> datos) {
        for (Datos dato:datos) {
            Toast.makeText(Proveedores.this, dato.getId()+"/n "+dato.getFecha()+"/n "+dato.getPagina()+"/n "+dato.getFoto()+"/n", Toast.LENGTH_SHORT).show();
        }
    }


}
