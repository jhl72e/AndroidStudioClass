package com.example.chap17;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button button1, button2, button3;
    OneFragment one;
    TwoFragment two;
    ThreeFragment three;
    FragmentManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);

        one = new OneFragment();
        two = new TwoFragment();
        three = new ThreeFragment();
        manager = getSupportFragmentManager();

        FragmentTransaction ft = manager.beginTransaction();
        ft.add(R.id.container, one);
        ft.commit();

    }


    @Override
    public void onClick(View view) {
        if(view == button1)
        {
            FragmentTransaction ft = manager.beginTransaction();
            ft.addToBackStack(null);
            ft.replace(R.id.container, one);
            ft.commit();
        }
        else if(view == button2)
        {
            FragmentTransaction ft = manager.beginTransaction();
            ft.replace(R.id.container, two);
            ft.commit();
        }
       else  if(view == button3)
        {
            three.show(manager, null);
        }
    }
}
