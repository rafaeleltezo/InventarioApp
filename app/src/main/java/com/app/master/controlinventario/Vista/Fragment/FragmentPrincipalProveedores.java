package com.app.master.controlinventario.Vista.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.app.master.controlinventario.Modelo.ResFull.Datos;
import com.app.master.controlinventario.R;
import com.app.master.controlinventario.Vista.AdaptadorresViewPager.AdaptadorviewPagerProveedores;
import com.app.master.controlinventario.Vista.Proveedores;
import com.app.master.controlinventario.Vista.iProveedores;

import java.util.ArrayList;

/**
 * Created by Rafael p on 20/8/2017.
 */

public class FragmentPrincipalProveedores extends Fragment implements iProveedores {

    private View vista;
    private ViewPager viewPager;
    private TabLayout tabLayout;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        vista=inflater.inflate(R.layout.fracmentprincipalproveedor,container,false);
        viewPager=(ViewPager)vista.findViewById(R.id.viewPagerProveedor);
        tabLayout=(TabLayout) vista.findViewById(R.id.tablayoutProveedor);
        viewPager.setAdapter(new AdaptadorviewPagerProveedores(getActivity().getSupportFragmentManager(),fragment()));
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(R.drawable.formulario);
        tabLayout.getTabAt(1).setIcon(R.drawable.lista);


        return vista;
    }

    public ArrayList<Fragment> fragment(){
        ArrayList<Fragment> fragments=new ArrayList();
        fragments.add(new FragmentFormularioProveedores());
        fragments.add(new FragmentRecyclerProveedores());
        return  fragments;
    }

    @Override
    public void mostrar(ArrayList<Datos> datos) {
        for (Datos dato:datos) {
            Toast.makeText(getContext(), dato.getId()+"/n "+dato.getFecha()+"/n "+dato.getPagina()+"/n "+dato.getFoto()+"/n", Toast.LENGTH_SHORT).show();
        }

    }

}
