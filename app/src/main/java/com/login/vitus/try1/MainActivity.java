package com.login.vitus.try1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    public Button but1;
    public TextView tv;
    public int x;
    public String s;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        but1 = (Button)findViewById(R.id.button);
        tv = (TextView)findViewById(R.id.textView);


        but1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                x =+1;
                s = String.valueOf(x);
                tv.setText(s);

            }
        });

    }
}
