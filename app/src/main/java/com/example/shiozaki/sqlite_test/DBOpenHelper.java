package com.example.shiozaki.sqlite_test;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by shiozaki on 16/01/07.
 */
public class DBOpenHelper extends SQLiteOpenHelper {

    static final String DB_NAME = "test.db";
    static final int DB_VERSION = 1;
    public static final String TABLE_NAME = "test";
    protected SQLiteDatabase db;

    //コンストラクタ
    public DBOpenHelper(Context context) {
        //super(context, name, factory, version);
        super(context, DB_NAME, null, DB_VERSION);
    }

    //作成
    @Override
    public void onCreate(SQLiteDatabase db) {
        //create
        db.execSQL(
                "CREATE TABLE " + TABLE_NAME + "(" +
                        " _id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
                        " memo TEXT NOT NULL" +
                        " " +
                        ");"
        );
    }

    //更新
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME + ";");
        onCreate(db);
    }
}
