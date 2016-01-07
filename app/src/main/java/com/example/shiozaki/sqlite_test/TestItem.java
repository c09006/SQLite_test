package com.example.shiozaki.sqlite_test;

/**
 * Created by shiozaki on 16/01/07.
 */

//リスト関係の表示用
public class TestItem {
    private int _id;
    private String memo;

    public void set_id(int _id){
        this._id = _id;
    }

    public int get_id(){
        return this._id;
    }

    public void setMemo(String memo){
        this.memo = memo;
    }

    public String getMemo(){
        return this.memo;
    }
}
