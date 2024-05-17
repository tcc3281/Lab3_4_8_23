package com.example.lab3_4_8_23;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class Adapter extends BaseAdapter {
    private List<ThiSinh> data;
    private Activity context;
    private LayoutInflater inflater;
    public Adapter(){
        super();
    }
    public Adapter(List<ThiSinh> data, Activity context) {
        super();
        this.data = data;
        this.context = context;
        inflater= context.getLayoutInflater();
    }
    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v=inflater.inflate(R.layout.thisinh_item,null);
        TextView sbd=v.findViewById(R.id.sbd);
        TextView hoten=v.findViewById(R.id.hoten);
        TextView diem=v.findViewById(R.id.tongdiem);

        sbd.setText(data.get(position).getSBD());
        hoten.setText(data.get(position).getHoten());
        diem.setText(String.valueOf(data.get(position).TD()));

        return v;
    }
}
