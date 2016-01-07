package com.example.shiozaki.sqlite_test;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by shiozaki on 16/01/07.
 */
public class MainActivity2 extends ActionBarActivity{
    private TestAdapter test;
    private Button btn_back;
    private Button btn_save;
    private EditText txt1;

    @Override
    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_main2);

        btn_back = (Button)findViewById(R.id.button);
        btn_save = (Button)findViewById(R.id.button2);
        txt1 = (EditText)findViewById(R.id.editText);

        //Backボタンの動作
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //画面を閉じる
                finish();
            }
        });

        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //値を保存する
                test.insert(txt1.getText().toString());

                //画面を閉じる
                finish();
            }
        });

        test = new TestAdapter(this);
    }
}
