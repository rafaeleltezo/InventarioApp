package com.app.master.controlinventario.Vista;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.app.master.controlinventario.R;
import com.app.master.controlinventario.Vista.AdaptadorresViewPager.AdaptadorViewPager;
import com.app.master.controlinventario.Vista.Fragment.FragmentFormularioProducto;
import com.app.master.controlinventario.Vista.Fragment.FragmentReciclerProducto;

import java.util.ArrayList;

public class Productos extends AppCompatActivity implements iProductos {

    private ViewPager viewPager;
    private RecyclerView recyclerView;
    TabLayout tabLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_productos);
        viewPager=(ViewPager)findViewById(R.id.viewPagerProducto);
        tabLayout=(TabLayout)findViewById(R.id.tabLayout);
        viewPager.setAdapter(new AdaptadorViewPager(getSupportFragmentManager(),fragments()));
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(R.drawable.formulario);
        tabLayout.getTabAt(1).setIcon(R.drawable.lista);

    }

    public ArrayList<Fragment> fragments(){
        ArrayList<Fragment>fragments=new ArrayList();
        fragments.add(new FragmentFormularioProducto());
        fragments.add(new FragmentReciclerProducto());

        return fragments;
    }


}
