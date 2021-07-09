package com.sanju.udemylearning.Sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class database extends SQLiteOpenHelper {

    private long result;
    private static final String DBname = "data.db";

    database(Context context) {
        super(context, DBname, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        init(db);
    }

    boolean insertLevel(String level){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("levelTitle",level);
        result = db.insert("levels",null,cv);
        return result != -1 ;
    }

    private void init(SQLiteDatabase db) {
        db.execSQL("DROP TABLE IF EXISTS levels");
        db.execSQL("create table levels (id INTEGER PRIMARY KEY AUTOINCREMENT, levelTitle TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        init(db);
    }
}
