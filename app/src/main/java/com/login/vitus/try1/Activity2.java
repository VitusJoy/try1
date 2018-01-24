package com.login.vitus.try1;

import android.app.AlertDialog;




import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Activity2 extends AppCompatActivity {

    EditText ETusename;
    EditText ETpassword;
    AlertDialog alert;
    AlertDialog.Builder builder;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        ETusename = (EditText)findViewById(R.id.username1);
        ETpassword = (EditText)findViewById(R.id.password1);
        builder = new AlertDialog.Builder(this);
        alert = builder.create();
        alert.setTitle("Error");



    }

    public void OnLogin(View view){
        String username = ETusename.getText().toString();
        String password = ETpassword.getText().toString();
        String type = "login";

        BackgroundWorker bgw = new BackgroundWorker(this);
        bgw.execute(type,username,password);
    }

    public void OnRegister(View view) {
        String username = ETusename.getText().toString();
        String password = ETpassword.getText().toString();
        String type = "register";


        if(username != null && !password.isEmpty()){


            BackgroundWorker bgw = new BackgroundWorker(this);
            bgw.execute(type,username,password);

        }else {
            alert.setMessage(" Null entered");
            alert.show();

        }

    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder2 = new AlertDialog.Builder(this);

        builder2.setTitle("Exit")
                .setMessage("Are you Sure")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Activity2.super.onBackPressed();
                    }
                })
                .setNegativeButton("Cancel",null).setCancelable(false);
        AlertDialog alert2 = builder2.create();
        alert2.show();

    }
}
