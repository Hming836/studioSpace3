package com.bwei.hming20190514;

import android.content.Intent;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.bwei.hming20190514.adapter.MyListAdapter;
import com.bwei.hming20190514.base.BaseActivity;
import com.bwei.hming20190514.bean.JsonBean;
import com.bwei.hming20190514.mvp.HomePresenterImpl;
import com.bwei.hming20190514.mvp.IHomeContract;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * @ Auther:Hming
 * @ Date: 2019.05.14
 * @ Description(功能) : 主页面
 */
public class MainActivity extends BaseActivity implements IHomeContract.IHomeView, View.OnClickListener {

    private IHomeContract.IHomePresenter presenter;
    private RecyclerView lv;
    private ArrayList<JsonBean> list;


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
        String url = "http://172.17.8.100/movieApi/cinema/v1/findRecommendCinemas?page=1&count=10";
        presenter.requestList(url);
    }

    @Override
    public void bindEvent() {

        findViewById(R.id.bt1).setOnClickListener(this);
        findViewById(R.id.bt2).setOnClickListener(this);
        findViewById(R.id.bt3).setOnClickListener(this);
        findViewById(R.id.bt4).setOnClickListener(this);
        findViewById(R.id.bt5).setOnClickListener(this);

    }

    @Override
    public void showList(String result) {
        // Toast.makeText(this, result, Toast.LENGTH_SHORT).show();
        // 解析字符串
        try {
            JSONObject object = new JSONObject(result);
            JSONArray ss = object.getJSONArray("result");

            list = new ArrayList<>();
            for (int i = 0; i < ss.length(); i++) {
                JSONObject oo = (JSONObject) ss.get(i);
                String address = oo.getString("address");
                String commentTotal = oo.getString("commentTotal");
                String distance = oo.getString("distance");
                String followCinema = oo.getString("followCinema");
                String id = oo.getString("id");
                String logo = oo.getString("logo");
                String name = oo.getString("name");
                list.add(new JsonBean(address, commentTotal, distance, followCinema, id, logo, name));
            }
            Toast.makeText(this, list.toString(), Toast.LENGTH_SHORT).show();
            lv.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
            lv.setAdapter(new MyListAdapter(list, MainActivity.this));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detach();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt1:
                lv.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
                break;
            case R.id.bt2:
                lv.setLayoutManager(new GridLayoutManager(this, 3));
                break;
            case R.id.bt3:
                lv.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
                break;
            case R.id.bt4:
                lv.setLayoutManager(new GridLayoutManager(this, 2, GridLayoutManager.HORIZONTAL, false));
                break;
            case R.id.bt5:
                startActivity(new Intent(MainActivity.this, WallterActivity.class));
                break;
        }
    }
}
