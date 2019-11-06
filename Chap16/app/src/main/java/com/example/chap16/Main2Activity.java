package com.example.chap16;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.lang.reflect.Method;

public class Main2Activity extends AppCompatActivity {

    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        imageView = findViewById(R.id.img);
        registerForContextMenu(imageView);

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.add(0,0,0,"서버 전송");
        menu.add(0,1,0,"보관함에 보관");
        menu.add(0,2,0,"삭제");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if(item.getItemId()==0)
        {
            show("서버 전송");
        }
        else if(item.getItemId()==1)
        {
            show("보관함에 보관");
        }
        else if(item.getItemId()==1)
        {
            show("삭제");
        }
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
//        MenuItem item1 = menu.add(0,0,0,"메뉴1");
//        MenuItem item2 = menu.add(0,1,0,"메뉴2");
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu,menu);

        try{
            Method method = menu.getClass().getDeclaredMethod("setOptionalIconsVisible", boolean.class);
            method.setAccessible(true);
            method.invoke(menu, true);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

       MenuItem menuItem = menu.findItem(R.id.search);
        SearchView searchView = (SearchView)menuItem.getActionView();
        searchView.setQueryHint("검색어를 입력하세요 ");
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                show("검색어: "+ query);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                return false;
            }
        });

        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==R.id.menu1)
        {
            show("메뉴 1번이 선택되었습니다");
        }
        if(item.getItemId()==R.id.menu2)
        {
            show("메뉴 2번이 선택되었습니다");
        }else if(item.getItemId() ==R.id.sub1)
        {
            show("sub1 이 선택되었습니다");
        }
        else if(item.getItemId()==R.id.sub2)
        {
            show("sub2 가 선택되었습니다");
        }
        return true;
    }




    public void show(String msg)
    {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

}
