package com.example.egbuddy;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class rights extends Fragment {
    TextView t,tt,t11,t22;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rights =inflater.inflate(R.layout.fragment_rights, container, false);
        tt=rights.findViewById(R.id.textt1);
        tt.setMovementMethod(LinkMovementMethod.getInstance());
        t11=rights.findViewById(R.id.text22);
        t11.setMovementMethod(LinkMovementMethod.getInstance());
        t22=rights.findViewById(R.id.text33);
        t22.setMovementMethod(LinkMovementMethod.getInstance());
        return rights;
    }
}
