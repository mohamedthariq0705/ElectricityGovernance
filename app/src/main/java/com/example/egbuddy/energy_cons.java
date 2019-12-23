package com.example.egbuddy;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class energy_cons extends Fragment implements View.OnClickListener {
    RadioGroup radioGroup;
    RadioButton radioButton;
    Button calc;
    EditText lastMR,currentMR;
    TextView ammount;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View energy_cons=inflater.inflate(R.layout.fragment_energy_cons, container, false);
        calc=energy_cons.findViewById(R.id.calc);
        radioGroup=energy_cons.findViewById(R.id.radgroup);
        lastMR=energy_cons.findViewById(R.id.LMR);
        currentMR=energy_cons.findViewById(R.id.CMR);
        ammount=energy_cons.findViewById(R.id.ammountview);
        calc.setOnClickListener(this);
        return energy_cons;
    }

    @Override
    public void onClick(View view) {
        int selectedId = radioGroup.getCheckedRadioButtonId();
        String str;
        // find the radiobutton by returned id
        radioButton = (RadioButton) getActivity().findViewById(selectedId);
        str=radioButton.getText().toString();
        System.out.println(str);
        Toast.makeText(getActivity(),radioButton.getText(), Toast.LENGTH_SHORT).show();
        if(str.equals("Domestic"))
        {
            System.out.println("//////////////oooootttthhhhhaaaaa");
            int lmr=Integer.parseInt(lastMR.getText().toString());
            int cmr=Integer.parseInt(currentMR.getText().toString());
            double unitsconsumed=cmr-lmr;
            double total=Domestic_Calculation(unitsconsumed);
            System.out.println("//////////////"+total);
            String amt=Double.toString(total);
            ammount.setText(amt);
        }
        if(str.equals("Commercial"))
        {
            int lmr=Integer.parseInt(lastMR.getText().toString());
            int cmr=Integer.parseInt(currentMR.getText().toString());
            double unitsconsumed=cmr-lmr;
            Commercial_Calculation(unitsconsumed);
            double total=Commercial_Calculation(unitsconsumed);
            System.out.println(total);
            String amt=Double.toString(total);
            ammount.setText(amt);
        }
    }

    double Domestic_Calculation(double units)
    {
        double billpay=0;
        if(units<=100)
        {
            billpay=(units*1.00);
        }
        else if(units>100 && units<=200)
        {
            billpay=100*1.00+(units-100)*2.50;
        }
        else if(units>200 && units<=500)
        {
            billpay=100*1.00+200*2.50+(units-200)*4.00;
        }
        else if(units>500)
        {
            billpay =100*1.00+200*2.50+500*4.00+(units-500)*6.00;
        }
        return billpay;

    }
    double Commercial_Calculation(double units)
    {
        double billpay = 0;
        if(units<=100)
        {
            billpay=units*2.00;
        }
        else if(units>100 && units<=200)
        {
            billpay=100*2.00+(units-100)*4.50;
        }

        else if(units>200 && units<=500)
        {
            billpay=100*2.00+200*4.50+(units-200)*6.00;
        }
        else if(units>500)
        {
            billpay =100*2.00+200*4.50+500*6.00+(units-500)*7.00;
        }
        return billpay;
    }
}
