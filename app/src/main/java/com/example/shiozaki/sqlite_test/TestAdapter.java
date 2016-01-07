package com.example.shiozaki.sqlite_test;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by shiozaki on 16/01/07.
 */
public class TestAdapter {
    private SQLiteDatabase db;
    static private DBOpenHelper helper;

    //コンストラクタ
    public  TestAdapter(Context context){
        helper = new DBOpenHelper(context);
        db = helper.getWritableDatabase();
    }

    //リストを取得
    public Cursor getAllList(){
        return db.query(DBOpenHelper.TABLE_NAME, null, null, null, null, null, null, null);
    }

    //追加
    public void insert(String memo){
        ContentValues values = new ContentValues();
        values.put("memo", memo);
        db.insertOrThrow(DBOpenHelper.TABLE_NAME, null, values);
    }
}
