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

import com.app.master.controlinventario.R;
import com.app.master.controlinventario.Vista.AdaptadorresViewPager.AdaptadorviewPagerCategoria;

import java.util.ArrayList;

/**
 * Created by Rafael p on 20/8/2017.
 */

public class FragmentPrincipalCategoria extends Fragment {
    private View vista;
    private ViewPager viewPager;
    private TabLayout tabLayout;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        vista=inflater.inflate(R.layout.fracmentprincipalcategoria,container,false);
        viewPager=(ViewPager)vista.findViewById(R.id.categoriaViewPager);
        tabLayout=(TabLayout)vista.findViewById(R.id.categoriaTab);

        ArrayList<Fragment> fragments=new ArrayList<>();
        fragments.add(new FragmentFormularioCategorias());
        fragments.add(new FragmentoRecyclerCategoria());
        viewPager.setAdapter(new AdaptadorviewPagerCategoria(getActivity().getSupportFragmentManager(),fragments));
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(R.drawable.formulario);
        tabLayout.getTabAt(1).setIcon(R.drawable.lista);
        return vista;
    }


}
