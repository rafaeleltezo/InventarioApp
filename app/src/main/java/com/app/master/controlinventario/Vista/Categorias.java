package com.app.master.controlinventario.Vista;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.app.master.controlinventario.R;
import com.app.master.controlinventario.Vista.AdaptadorresViewPager.AdaptadorviewPagerCategoria;
import com.app.master.controlinventario.Vista.Fragment.FragmentFormularioCategorias;
import com.app.master.controlinventario.Vista.Fragment.FragmentoRecyclerCategoria;

import java.util.ArrayList;

public class Categorias extends AppCompatActivity {

    private ViewPager viewPager;
    private TabLayout tabLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categorias);

        viewPager=(ViewPager)findViewById(R.id.categoriaViewPager);
        tabLayout=(TabLayout)findViewById(R.id.categoriaTab);

        ArrayList<Fragment>fragments=new ArrayList<>();
        fragments.add(new FragmentFormularioCategorias());
        fragments.add(new FragmentoRecyclerCategoria());
        viewPager.setAdapter(new AdaptadorviewPagerCategoria(getSupportFragmentManager(),fragments));
        tabLayout.setupWithViewPager(viewPager);

    }
}
