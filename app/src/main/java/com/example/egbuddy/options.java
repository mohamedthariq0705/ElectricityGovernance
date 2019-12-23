package com.example.egbuddy;

import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class options extends Fragment implements View.OnClickListener {
    CardView consumer_rights,consumption,o_m,smart_grid;
    Fragment fragment;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View iconview= inflater.inflate(R.layout.fragment_options, container, false);
        consumer_rights=iconview.findViewById(R.id.consumerrights);
        consumption=iconview.findViewById(R.id.energy_consumption);
        o_m=iconview.findViewById(R.id.O_M);
        smart_grid=iconview.findViewById(R.id.Smart_grid);
        consumer_rights.setOnClickListener(this);
        consumption.setOnClickListener(this);
        o_m.setOnClickListener(this);
        smart_grid.setOnClickListener(this);
        return iconview;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.energy_consumption:
                fragment=new energy_cons();
                fragmentcall();
                break;
            case R.id.consumerrights:
                break;
            case R.id.Smart_grid:
                fragment=new smartgrid();
                fragmentcall();
                break;
            case R.id.O_M:
                fragment=new O_M();
                fragmentcall();
                break;
        }

    }
    public void fragmentcall()
    {
        FragmentManager fm=getFragmentManager();
        FragmentTransaction ft=fm.beginTransaction();
        ft.replace(R.id.frame,fragment);
        ft.commit();

    }
}
