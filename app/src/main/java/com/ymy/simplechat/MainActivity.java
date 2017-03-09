package com.ymy.simplechat;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
   private List<Msg> msgs = new ArrayList<>();
    private RecyclerView mRC;
    private Button mButton;
    private EditText mEditText;
    MyAdapter myAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRC = (RecyclerView) findViewById(R.id.mRC);
        mButton = (Button) findViewById(R.id.mButton);
        mEditText = (EditText) findViewById(R.id.mEditText);
        mRC.setLayoutManager(new LinearLayoutManager(this));
        initData();
        initAdapter();
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!TextUtils.isEmpty(mEditText.getText())){
                    Msg msg = new Msg(mEditText.getText().toString(),Msg.send);
                    msgs.add(msg);
                    myAdapter.notifyDataSetChanged();
                    mEditText.setText("");

                }else {
                    mEditText.setError("内容不能为空");
                }
            }
        });
    }

    private void initAdapter() {
        myAdapter= new MyAdapter(msgs);
        mRC.setAdapter(myAdapter);
    }

    private void initData() {
        Msg msg1 = new Msg("你今天在干什么？",Msg.send);
        Msg msg2 = new Msg("我一样的一些新手，少走些弯路了。",Msg.recive);
        Msg msg3 = new Msg("好的？",Msg.send);
        msgs.add(msg1);
        msgs.add(msg2);
        msgs.add(msg3);
    }


}
