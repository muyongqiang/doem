package edu.feicui.app.phone.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;

import java.util.ArrayList;

import edu.feicui.app.phone.adapter.TellistAdapter;
import edu.feicui.app.phone.base.db.DBReader;
import edu.feicui.app.phone.entity.TelnumberInfo;

public class TellistActivity extends AppCompatActivity {
    private ListView listView;
    private TellistAdapter adapter;
    private int idx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tellist);
        //一会儿我们在这里输出我们传过来的值
        //得到Intent对象
        Intent intent=getIntent();
        //把传过来的值显示出来
        idx=intent.getIntExtra("idx",0);
        //Log.v("idx","idx"+idx);
        init(idx);
        listView= (ListView) findViewById(R.id.listView1);
        //适配器
        adapter=new TellistAdapter(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        adapter.clear();
        //给我们的适配器中的集合添加值
        adapter.addDataToAdapter(DBReader.readTeldbTable(idx));
        //设置适配器
        listView.setAdapter(adapter);
    }

    public void init(int idx){
        ArrayList<TelnumberInfo> list= DBReader.readTeldbTable(idx);
        for (TelnumberInfo t : list) {
            Log.v(t.name, t.number);
        }
    }
}
