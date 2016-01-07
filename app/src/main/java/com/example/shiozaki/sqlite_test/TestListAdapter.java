package com.example.shiozaki.sqlite_test;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by shiozaki on 16/01/07.
 */
public class TestListAdapter extends ArrayAdapter<TestItem> {
    private LayoutInflater layoutInflater;

    //コンストラクタ
    public TestListAdapter(Context context, int textViewResourceID, List<TestItem> objects) {
        super(context, textViewResourceID, objects);
        layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        //指定行のデータを取得
        TestItem detail = (TestItem)getItem(position);

        //nullの場合のみ再作成
        if(null == convertView){
            convertView = layoutInflater.inflate(R.layout.row, null);
        }

        //行のデータを項目へ設定
        TextView text1 = (TextView)convertView.findViewById(R.id.textView);
        text1.setText(String.valueOf(detail.get_id()));

        TextView text2 = (TextView)convertView.findViewById(R.id.textView2);
        text2.setText(String.valueOf(detail.getMemo()));

        return convertView;
    }
}
