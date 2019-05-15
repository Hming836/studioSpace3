package com.bwei.hming20190514.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * @ Auther:Hming
 * @ Date: 2019.05.14
 * @ Description(功能) : 抽基类
 */
public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(bindLayout());
        initView();
        initData();
        bindEvent();
    }

    public abstract int bindLayout();

    public abstract void initView();

    public abstract void initData();

    public abstract void bindEvent();

}
