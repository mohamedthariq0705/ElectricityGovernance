package com.example.egbuddy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class login extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "EmailPassword";
    String response;
    private EditText id,password;
    private Button loginbtn;
    private TextView register,skp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        id =findViewById(R.id.user_id);
        password = findViewById(R.id.password);
        loginbtn =findViewById(R.id.login_btn);
        register=findViewById(R.id.register_link);
        skp=findViewById(R.id.skip);
        loginbtn.setOnClickListener(this);
        register.setOnClickListener(this);
        skp.setOnClickListener(this);

    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.login_btn:

                if(id==null && password==null) {
                    //startActivity(new Intent(this,MainActivity.class));
                    Toast.makeText(this,"enter the required fields",Toast.LENGTH_LONG).show();
                }
                else
                {
                    String idd=id.getText().toString();
                    String pass=password.getText().toString();
                    String link = "https://androidproject2914.000webhostapp.com/login.php?user_name="+idd+"&password="+pass;
                    //using this IP for Genymotion emulator
                    new updatedata(this).execute(link);
                }
                /*startActivity(new Intent(this,mainpage.class));*/
                break;
            case R.id.register_link:
                String idd=id.getText().toString();
                String pass=password.getText().toString();
                String link = "https://androidproject2914.000webhostapp.com/login.php?user_name="+idd+"&password="+pass;
                //using this IP for Genymotion emulator
                new updatedata(this).execute(link);
                Toast.makeText(login.this, "Executed", Toast.LENGTH_LONG).show();
                break;
            case R.id.skip:
                startActivity(new Intent(this,MainActivity.class));
                break;


        }
    }
}
