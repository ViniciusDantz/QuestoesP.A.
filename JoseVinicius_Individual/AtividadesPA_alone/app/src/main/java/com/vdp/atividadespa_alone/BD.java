package com.vdp.atividadespa_alone;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class BD extends SQLiteOpenHelper {
    private static final String name = "atvdPAdb.db";
    private static final int version = 1;
    public BD(Context context) {
        super(context, name, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create table usuario(id integer primary key autoincrement," +
                "nome varchar (20), senha varchar (45), email varchar (45))");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
