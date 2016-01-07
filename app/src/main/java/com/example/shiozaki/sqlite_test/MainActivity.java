package com.example.shiozaki.sqlite_test;

import android.content.Intent;
import android.database.Cursor;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends ActionBarActivity {

    //フィールド
    private TestAdapter test;
    private List<TestItem> list = new ArrayList<TestItem>();
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("activity", "onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        test = new TestAdapter(this);
        Cursor c = test.getAllList();
        //リストの取得
        if(c.moveToFirst()){
            do{
                TestItem item = new TestItem();
                item.set_id(c.getInt(c.getColumnIndex("_id")));
                item.setMemo(c.getString(c.getColumnIndex("memo")));
                list.add(item);
            }while(c.moveToNext());
        }

        //リストビューへ紐付け
        listView = (ListView)findViewById(R.id.listView);

        //ArrayAdapterへ設定
        TestListAdapter rowAdapter = new TestListAdapter(this, 0, list);

        //リストビューへ設定
        listView.setAdapter(rowAdapter);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);

        //メニューボタン追加
        MenuItem item = menu.add("NEW");
        item.setIcon(R.drawable.ic_launcher);

        //メニューイベント定義
        item.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                //intentのインスタンス生成
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                //次画面のアクティビティ起動
                startActivity(intent);
                return false;
            }
        });
        //画面に表示する処理
        MenuItemCompat.setShowAsAction(item, MenuItemCompat.SHOW_AS_ACTION_IF_ROOM);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onRestart(){
        Log.d("activity", "onRestart");

        list.clear();
        Cursor c = test.getAllList();
        if(c.moveToFirst()){
            do{
                TestItem item = new TestItem();
                item.set_id(c.getInt(c.getColumnIndex("_id")));
                item.setMemo(c.getString(c.getColumnIndex("memo")));
                list.add(item);
            }while(c.moveToNext());
        }

        //リストビューへ紐付け
        listView = (ListView)findViewById(R.id.listView);

        //ArrayAdapterへ設定
        TestListAdapter rowAdapter = new TestListAdapter(this, 0, list);

        //リストビューへ設定
        listView.setAdapter(rowAdapter);

        super.onRestart();
    }
}
