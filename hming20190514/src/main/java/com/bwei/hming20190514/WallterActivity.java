package com.bwei.hming20190514;

import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.bwei.hming20190514.adapter.MyWallAdapter;
import com.bwei.hming20190514.base.BaseActivity;

import java.util.ArrayList;

public class WallterActivity extends BaseActivity {


    private RecyclerView recycler;
    private ArrayList<String> list = new ArrayList<>();

    @Override
    public int bindLayout() {
        return R.layout.activity_wallter;
    }

    @Override
    public void initView() {
        recycler = findViewById(R.id.wallterRecycler);
        recycler.setLayoutManager(new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL));
        recycler.setItemAnimator(new DefaultItemAnimator());
        recycler.setAdapter(new MyWallAdapter(list, WallterActivity.this));
    }

    @Override
    public void initData() {
        for (int i = 0; i < 100; i++) {
            list.add("满纸荒唐言" + i);
        }
    }

    @Override
    public void bindEvent() {

    }
}
