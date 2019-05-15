package com.bwei.hming20190514.holder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.bwei.hming20190514.R;

/**
 * @ Auther:Hming
 * @ Date: 2019.05.13
 * @ Description(功能) :
 */
public class SimpleHolder extends RecyclerView.ViewHolder {
    public TextView tv;

    public SimpleHolder(@NonNull View itemView) {
        super(itemView);
        tv = itemView.findViewById(R.id.tv_list);
    }
}
