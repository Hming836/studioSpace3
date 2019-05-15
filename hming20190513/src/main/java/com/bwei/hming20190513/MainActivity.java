package com.bwei.hming20190513;

import android.content.SharedPreferences;
import android.widget.ListView;
import android.widget.Toast;

import com.bwei.hming20190513.base.BaseActivity;
import com.bwei.hming20190513.mvp.HomePresenterImpl;
import com.bwei.hming20190513.mvp.IHomeContract;

import org.json.JSONObject;

/**
 * @ Auther:Hming
 * @ Date: 2019.05.13
 * @ Description(功能) : 主显示页面
 */
public class MainActivity extends BaseActivity implements IHomeContract.IHomeView {

    private ListView lv;
    private IHomeContract.IHomePresenter presenter;
    private SharedPreferences sp;

    @Override
    public int bindLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
        lv = findViewById(R.id.lv);
        presenter = new HomePresenterImpl();
        presenter.attach(this);

    }

    @Override
    public void initData() {
        String requestUrl = "https://code.aliyun.com/598254259/FristProject/raw/master/bw_list.txt";
        presenter.requestList(requestUrl);
    }

    @Override
    public void bindEvent() {

    }

    @Override
    public void showList(String s) {
        sp = getSharedPreferences("login", MODE_PRIVATE);
        sp.edit().putString("key", s).commit();
        // 解析字符串
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
        try {
            JSONObject object = new JSONObject(s);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // 销毁时置空 防止内存泄漏
        presenter.detach();
    }
}

