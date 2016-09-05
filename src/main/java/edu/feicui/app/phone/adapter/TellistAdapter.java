package edu.feicui.app.phone.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import edu.feicui.app.phone.activity.R;
import edu.feicui.app.phone.entity.TelnumberInfo;

/**
 * Created by Administrator on 2016/8/17.
 */
public class TellistAdapter extends BaseAdapter {
    //上下文
    Context context;
    //布局对象
    LayoutInflater inflater;
    //集合
    ArrayList<TelnumberInfo> list=new ArrayList<TelnumberInfo>();

    public TellistAdapter(Context context) {
        this.context = context;

        //给我们的对象赋值
        inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public TellistAdapter() {
    }
    //添加方法：1添加一个集合   2.清空集合中的信息
    public void addDataToAdapter(ArrayList<TelnumberInfo> arrays){
        list.addAll(arrays);
    }
    public void clear(){
        list.clear();
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public TelnumberInfo getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        if (view==null){
            view=inflater.inflate(R.layout.inflate_tellist_listitem,null);
        }
        //找到布局中的ID并赋值
        TextView tv_name= (TextView) view.findViewById(R.id.tv_name);
        TextView tv_number= (TextView) view.findViewById(R.id.tv_number);
        //设置值
        tv_name.setText(list.get(position).name);
        tv_number.setText(list.get(position).number);
        return view;
    }
}

