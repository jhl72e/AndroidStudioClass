package com.example.test16;

import android.graphics.Color;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Method;

public class MainActivity extends AppCompatActivity {

    LinearLayout layout;
    TextView changetext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("액션바 실습");
        actionBar.setSubtitle("레디 액션");
        actionBar.setDisplayShowHomeEnabled(true); // 아이콘
        actionBar.setIcon(R.drawable.ic_launcher_foreground);
        actionBar.setDisplayHomeAsUpEnabled(true);// asup버튼

        layout = findViewById(R.id.layout);

        changetext = findViewById(R.id.changetext);
        registerForContextMenu(layout);

    }


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.add(0,0,0,"RED");
        menu.add(0,1,0,"WHITE");
        menu.add(0,2,0,"BLACK");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if(item.getItemId()==0)
        {
            changetext.setTextColor(Color.RED);
            show("RED");
        }
        else if(item.getItemId()==1)
        {
            changetext.setTextColor(Color.WHITE);
            show("WHITE");
        }
        else if(item.getItemId()==1)
        {
            changetext.setTextColor(Color.BLACK);
            show("BLACK");
        }
        return true;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu,menu);

        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==R.id.RED)
        {
            layout.setBackgroundColor(Color.RED);
            show("빨간색이 선택되었습니다");
        }
        if(item.getItemId()==R.id.BLUE)
        {
            layout.setBackgroundColor(Color.BLUE);
            show("파란색이 선택되었습니다");
        }else if(item.getItemId() ==R.id.YELLOW)
        {
            layout.setBackgroundColor(Color.YELLOW);
            show("노란색이 선택되었습니다");
        }
        else if(item.getItemId()==R.id.CYAN)
        {
            layout.setBackgroundColor(Color.CYAN);
            show("청록색이 선택되었습니다");
        }
        else if(item.getItemId()==R.id.WHITE)
        {
            layout.setBackgroundColor(Color.WHITE);
            show("하얀색이 선택되었습니다");
        }
        return true;
    }





    public void show(String msg)
    {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }




}
