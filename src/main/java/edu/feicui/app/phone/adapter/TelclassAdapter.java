package edu.feicui.app.phone.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import edu.feicui.app.phone.activity.R;
import edu.feicui.app.phone.entity.TelclassInfo;

/**
 * Created by Administrator on 2016/8/16.
 */
public class TelclassAdapter extends BaseAdapter{
    public TelclassAdapter(Context context) {
        this.context = context;
        inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    Context context;
    LayoutInflater inflater;
    ArrayList<TelclassInfo> list=new ArrayList<TelclassInfo>();
    public void addDataToAdapter(TelclassInfo info){
        if (info!=null){
            list.add(info);
        }
    }
    public void addDataToAdapter(List<TelclassInfo> list1){
        list.addAll(list1);
    }
    public void clearDataToAdapter(){
        list.clear();

    }
    @Override
    public int getCount() {
        return list.size();
    }
    @Override
    public TelclassInfo getItem(int position) {
        return list.get(position);
    }
    @Override
    public long getItemId(int position) {
        return position;
    }
    @Override
    public View getView(int position, View view, ViewGroup parent) {
        if (view==null){
            view=inflater.inflate(R.layout.inflate_telmgr_listitem,null);
        }
        TextView textView= (TextView) view.findViewById(R.id.textView);
        textView.setText(list.get(position).name);
        return view;
    }
}

