    package com.example.chap15;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

    public class MainActivity extends AppCompatActivity implements OnMyChangeListener{
    MyView myView;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myView = findViewById(R.id.myView);
        button = findViewById(R.id.button);

        myView.setOnMyChangeListener(this);
    }

    @Override
    public void onChange(int count) {
        button.setText(String.valueOf(count));
        if(count>10)
        {
            button.setBackgroundColor(Color.GREEN);
        }
    }
}
