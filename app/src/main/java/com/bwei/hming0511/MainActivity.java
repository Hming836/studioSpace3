package com.bwei.hming0511;

import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.bwei.hming0511.base.BaseActivity;
import com.bwei.hming0511.mvp.user.IUserContract;
import com.bwei.hming0511.mvp.user.UserPresenterImpl;

// 在Activity中千万别忘了实现契约类中的View层接口
public class MainActivity extends BaseActivity implements IUserContract.IUserView {

    private EditText etUsername;
    private EditText etPassword;
    private CheckBox cbRemeberMe;
    private Button btReigst;
    private Button btLogin;

    private IUserContract.IUserPresenter presenter;

    @Override
    public int bindLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {

        etUsername = findViewById(R.id.et_username);
        etPassword = findViewById(R.id.et_password);
        cbRemeberMe = findViewById(R.id.cb_remember_me);
        btReigst = findViewById(R.id.bt_regist);
        btLogin = findViewById(R.id.bt_login);



    }

    @Override
    public void initData() {
        presenter = new UserPresenterImpl();
        presenter.attach(this);
    }

    @Override
    public void bindEvent() {
        btReigst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 注册
                presenter.register(etUsername.getText().toString(), etPassword.getText().toString());
            }
        });
        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 登录
                presenter.login(etUsername.getText().toString(), etPassword.getText().toString());
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detach();
    }

    @Override
    public void onRegisterSuccess(String result) {
        Toast.makeText(MainActivity.this, "123" + result, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onLoginSuccess(String result) {
        Toast.makeText(MainActivity.this, result + "456", Toast.LENGTH_SHORT).show();
    }
}
