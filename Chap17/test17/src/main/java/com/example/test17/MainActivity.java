package com.example.test17;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<Item> datas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler);
        datas = new ArrayList<>();

        DBHelper helper = new DBHelper(this);
        SQLiteDatabase db = helper.getReadableDatabase();
        String sql = "select * from tb_data where date='2019-11-01'";
        String ysql = "select * from tb_data where date ='2019-10-31'";
        String psql = "select * from tb_data where date!='2019-10-31' and date != '2019-11-01'";

        Cursor cursor = db.rawQuery(sql, null);
        Cursor yCursor = db.rawQuery(ysql, null);
        Cursor pCursor = db.rawQuery(psql, null);

        if(cursor.getCount()>0)
        {
            datas.add(new Headeritem("오늘"));
            while(cursor.moveToNext())
            {
                DataItem item = new DataItem(cursor.getString(1), cursor.getString(2));
                datas.add(item);
            }
        }
        if(yCursor.getCount()>0)
        {
            datas.add(new Headeritem("어제"));
            while(yCursor.moveToNext())
            {
                DataItem item = new DataItem(yCursor.getString(1), yCursor.getString(2));
                datas.add(item);
            }
        }
        if(pCursor.getCount()>0)
        {
            datas.add(new Headeritem("이전"));
            while(pCursor.moveToNext())
            {
                DataItem item = new DataItem(pCursor.getString(1), pCursor.getString(2));
                datas.add(item);
            }
        }




        ItemAdapter adapter = new ItemAdapter(datas);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        MyDecoration myDecoration = new MyDecoration();
        recyclerView.addItemDecoration(myDecoration);

    }


    class MyDecoration extends RecyclerView.ItemDecoration{
        @Override
        public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
            super.getItemOffsets(outRect, view, parent, state);
            int position = parent.getChildAdapterPosition(view);
            Item item = datas.get(position);

            if(item.getType()==item.TYPE_DATA)
            {
                recyclerView.setBackgroundColor(0xFFFFFFFF);
                ViewCompat.setElevation(view, 10.0f);
            }
            outRect.set(20,10,20,10);
        }
        }
    }





}
