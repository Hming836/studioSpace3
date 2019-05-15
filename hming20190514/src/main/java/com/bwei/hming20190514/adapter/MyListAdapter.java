package com.bwei.hming20190514.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.bwei.hming20190514.R;
import com.bwei.hming20190514.bean.JsonBean;
import com.bwei.hming20190514.holder.SimpleHolder;

import java.util.ArrayList;

/**
 * @ Auther:Hming
 * @ Date: 2019.05.13
 * @ Description(功能) : 适配器
 */
public class MyListAdapter extends RecyclerView.Adapter<SimpleHolder> {

    private ArrayList<JsonBean> list;
    private Context context;

    public MyListAdapter(ArrayList<JsonBean> list, Context context) {
        this.list = list;
        this.context = context;
    }


    @Override
    public SimpleHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        // 找到 inflater
        LayoutInflater inflater = LayoutInflater.from(context);
        return new SimpleHolder(inflater.inflate(R.layout.item_list, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(SimpleHolder simpleHolder, int i) {
        simpleHolder.tv.setText(list.get(i).getName());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
