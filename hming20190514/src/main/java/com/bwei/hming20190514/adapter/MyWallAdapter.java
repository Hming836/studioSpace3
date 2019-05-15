package com.bwei.hming20190514.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.bwei.hming20190514.R;
import com.bwei.hming20190514.holder.SimpleHolder;

import java.util.ArrayList;


/**
 * @ Auther:Hming
 * @ Date: 2019.05.13
 * @ Description(功能) :适配器
 */
public class MyWallAdapter extends RecyclerView.Adapter<SimpleHolder> {

    private ArrayList<String> list;
    private Context context;
    private ArrayList<Integer> itemHight;

    public MyWallAdapter(ArrayList<String> list, Context context) {
        this.list = list;
        this.context = context;
        itemHight = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            itemHight.add((int) (Math.random() * 100 + 200));
        }
    }

    @NonNull
    @Override
    public SimpleHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(context);
        return new SimpleHolder(inflater.inflate(R.layout.item_list, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull SimpleHolder simpleHolder, int i) {

        // ViewGroup.LayoutParams layoutParams = simpleHolder.tv.getLayoutParams();
        // layoutParams.height = itemHight.get(i);
        simpleHolder.tv.setBackgroundColor(Color.rgb((int) (Math.random() * 100 + 155), (int) (Math.random() * 100 + 155), (int) (Math.random() * 100 + 155)));
        simpleHolder.tv.setText(list.get(i));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
