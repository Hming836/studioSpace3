package com.bwei.hming20190514.mvp;

import com.bwei.hming20190514.net.CallBackString;

/**
 * @ Auther:Hming
 * @ Date: 2019.05.13
 * @ Description(功能) :契约管理接口
 */
public interface IHomeContract {
    public interface IHomeView {
        void showList(String result);
    }

    public interface IHomeModel {
        void requestList(String url, CallBackString backString);
    }

    public interface IHomePresenter {
        void attach(IHomeView view);

        void detach();

        void requestList(String url);
    }
}
