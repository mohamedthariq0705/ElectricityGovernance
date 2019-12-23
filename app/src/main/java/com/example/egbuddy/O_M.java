package com.example.egbuddy;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

public class O_M extends Fragment implements View.OnClickListener {
    ImageButton btn1,btn2,btn3;
    Context context;
    CardView cardview;
    EditText ed1,ed2,ed3;
    LinearLayout.LayoutParams layoutparams;
    TextView textview,predamt,usg,comusg,domusg;
    LinearLayout linearLayout;
    Spinner op1,op2,op3,hr1,hr2,hr3;
    Button predct;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View o_m=inflater.inflate(R.layout.fragment_o__m, container, false);
        btn1= o_m.findViewById(R.id.imgplus1);
        btn2= o_m.findViewById(R.id.imgplus2);
        btn3= o_m.findViewById(R.id.imgplus3);
        ed1=o_m.findViewById(R.id.edt1);
        ed2=o_m.findViewById(R.id.edt2);
        ed3=o_m.findViewById(R.id.edt3);
        op1=o_m.findViewById(R.id.option1);
        op2=o_m.findViewById(R.id.option2);
        op3=o_m.findViewById(R.id.option3);
        hr1=o_m.findViewById(R.id.hrs1);
        hr2=o_m.findViewById(R.id.hrs2);
        hr3=o_m.findViewById(R.id.hrs3);
        predct=o_m.findViewById(R.id.predict);
        predamt=o_m.findViewById(R.id.predictedamt);
        usg=o_m.findViewById(R.id.usage);
        domusg=o_m.findViewById(R.id.domesticusg);
        comusg=o_m.findViewById(R.id.commercialusg);
        //linearLayout =(LinearLayout)o_m.findViewById(R.id.omlayout);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        predct.setOnClickListener(this);

        return o_m;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.imgplus1:
                int a=Integer.parseInt(ed1.getText().toString());
                String str1=Integer.toString(a+1);
                ed1.setText(str1);
                break;
            case R.id.imgplus2:
                int b=Integer.parseInt(ed2.getText().toString());
                String str2=Integer.toString(b+1);
                ed2.setText(str2);
                break;
            case R.id.imgplus3:
                int c=Integer.parseInt(ed3.getText().toString());
                String str3=Integer.toString(c+1);
                ed3.setText(str3);
                break;
            case R.id.predict:
                prediction();
                break;
        }

    }
    int ifelse(String type)
    {
        if(type.equals("Fan"))
        {
            return 75;
        }
        else if (type.equals("AC"))
        {
            return 2650;
        }
        else if (type.equals("Light"))
        {
            return 45;
        }
        else if (type.equals("Refrigerator"))
        {
            return 150;
        }
        return 0;
    }
    void prediction()
    {
        String appliance_type1=String.valueOf(op1.getSelectedItem());
        int wat1=ifelse(appliance_type1);
        String appliance_type2=String.valueOf(op2.getSelectedItem());
        int wat2=ifelse(appliance_type2);
        String appliance_type3=String.valueOf(op3.getSelectedItem());
        int wat3=ifelse(appliance_type3);
        int hours1=Integer.parseInt(String.valueOf(hr1.getSelectedItem()));
        int hours2=Integer.parseInt(String.valueOf(hr2.getSelectedItem()));
        int hours3=Integer.parseInt(String.valueOf(hr3.getSelectedItem()));
        int eq1=Integer.parseInt(ed1.getText().toString());
        int eq2=Integer.parseInt(ed2.getText().toString());
        int eq3=Integer.parseInt(ed3.getText().toString());
        float watage=(float)((eq1*(wat1*hours1*60))+(eq2*(wat2*hours2*60))+(eq3*(wat3*hours3*60)))/1000;
        System.out.println(watage);
        usg.setText(Double.toString(watage));
        Double total=watage*0.12;
        predamt.setText(Double.toString(total));
        domusg.setText(Double.toString(Domestic_Calculation(watage)));
        comusg.setText(Double.toString(Commercial_Calculation(watage)));
    }
    double Domestic_Calculation(float units)
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
    double Commercial_Calculation(float units)
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
    /*public void CreateCardViewProgrammatically(){

        cardview = new CardView(getContext());
        layoutparams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        cardview.setLayoutParams(layoutparams);
        cardview.setRadius(15);
        cardview.setPadding(25, 25, 25, 25);
        cardview.setCardBackgroundColor(Color.MAGENTA);
        cardview.setMaxCardElevation(30);
        cardview.setMaxCardElevation(6);
        textview = new TextView(context);
        textview.setLayoutParams(layoutparams);
        textview.setText("CardView Programmatically");
        textview.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 25);
        textview.setTextColor(Color.WHITE);
        textview.setPadding(25,25,25,25);
        textview.setGravity(Gravity.CENTER);
        cardview.addView(textview);
        linearLayout.addView(cardview);

    }*/

}
