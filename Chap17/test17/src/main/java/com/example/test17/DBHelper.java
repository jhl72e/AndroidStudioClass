package com.example.test17;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION=5;

    public DBHelper(Context context){
        super(context, "datadb", null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String tableSql="create table tb_data ("+
                "_id integer primary key autoincrement," +
                "name not null," +
                "date)";

        db.execSQL(tableSql);

        db.execSQL("insert into tb_data (name,date) values ('노홍림','2019-11-01')");
        db.execSQL("insert into tb_data (name,date) values ('강동훈','2019-11-01')");
        db.execSQL("insert into tb_data (name,date) values ('강준하','2019-11-01')");
        db.execSQL("insert into tb_data (name,date) values ('남주영','2019-10-31')");
        db.execSQL("insert into tb_data (name,date) values ('어연수','2019-10-31')");
        db.execSQL("insert into tb_data (name,date) values ('정유진','2019-10-30')");
        db.execSQL("insert into tb_data (name,date) values ('강경태','2019-10-30')");
        db.execSQL("insert into tb_data (name,date) values ('고윤서','2019-10-29')");
        db.execSQL("insert into tb_data (name,date) values ('고윤슬','2019-10-29')");
        db.execSQL("insert into tb_data (name,date) values ('곽건','2019-10-29')");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if(newVersion == DATABASE_VERSION){
            db.execSQL("drop table tb_data");
            onCreate(db);
        }
    }
}
