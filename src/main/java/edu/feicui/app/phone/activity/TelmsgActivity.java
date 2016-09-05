package edu.feicui.app.phone.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import edu.feicui.app.phone.adapter.TelclassAdapter;
import edu.feicui.app.phone.base.db.AssetsDBManager;
import edu.feicui.app.phone.base.db.DBReader;
import edu.feicui.app.phone.entity.TelclassInfo;

public class TelmsgActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    ListView listView;
    TelclassAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_telmsg);
        listView= (ListView) findViewById(R.id.listView);
        adapter=new TelclassAdapter(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        init();
        adapter.clearDataToAdapter();
        TelclassInfo info=new TelclassInfo("本地电话",0);
        adapter.addDataToAdapter(info);
        adapter.addDataToAdapter(DBReader.readTeldClasslist());
        listView.setOnItemClickListener(this);
        listView.setAdapter(adapter);
    }

    //定义一个方法用于初始化的
    public void init() {
        try {
            //1.判断数据库是否存在
            //2.写
            if (!DBReader.isExistsTeldbFile()) {
                //写吧
                AssetsDBManager.copyAssetsFileToFile(getApplicationContext(), "db/commonnum.db", DBReader.toFile);
            }
        } catch (Exception e) {
            Toast.makeText(this, "copy数据库失败", Toast.LENGTH_SHORT).show();
        }
        Toast.makeText(this, "copy数据库成功", Toast.LENGTH_SHORT).show();
    }
    public void test() {
        ArrayList<TelclassInfo> list = DBReader.readTeldClasslist();
        for (TelclassInfo t : list) {
            Log.v("name:" + t.name, "idx:" + t.idx);
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        TelclassInfo info= adapter.getItem(position);
        Log.v("ssssssss","sssssssssssssssssssss");
        Intent intent=new Intent(TelmsgActivity.this,TellistActivity.class);
        intent.putExtra("idx",info.idx);
        startActivity(intent);
    }
}



