package com.example.myfragment;

import android.content.res.Configuration;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    DetailFragment detail;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    detail = (DetailFragment)getSupportFragmentManager().findFragmentById(R.id.detail);
    }

    public void detailView(int index)
    {
        Configuration configuration = getResources().getConfiguration();
        if(Configuration.ORIENTATION_PORTRAIT == configuration.orientation)
        {
            detail = new DetailFragment(index);
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.container, detail).commit();
            ft.addToBackStack(null);

        } else {
            detail.setImage(index);
        }

    }



}
