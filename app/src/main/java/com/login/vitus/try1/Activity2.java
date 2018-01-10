package com.login.vitus.try1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class Activity2 extends AppCompatActivity {

    EditText ETusename;
    EditText ETpassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        ETusename = (EditText)findViewById(R.id.username1);
        ETpassword = (EditText)findViewById(R.id.password1);

    }
}
