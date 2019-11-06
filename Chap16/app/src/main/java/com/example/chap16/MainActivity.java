package com.example.chap16;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button button;
    Boolean isHide =false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);

        final ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("액션바 실습");
        actionBar.setSubtitle("레디 액션");
        actionBar.setDisplayShowHomeEnabled(true); // 아이콘
        actionBar.setIcon(R.drawable.icon);
        actionBar.setDisplayHomeAsUpEnabled(true);// asup버튼

       button.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               if(isHide)
               {
                   actionBar.show();
                   isHide = false;
               }
               else {
                   actionBar.hide();
                   isHide = true;
               }
           }
       });

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == android.R.id.home)
        {
            Toast.makeText(this, "홈애스업버튼클릭", Toast.LENGTH_SHORT).show();
        }

        return true;
    }
}
