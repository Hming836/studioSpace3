package com.bwei.hming20190514.mvp;

import com.bwei.hming20190514.net.CallBackString;

/**
 * @ Auther:Hming
 * @ Date: 2019.05.13
 * @ Description(功能) :
 */
public class HomePresenterImpl implements IHomeContract.IHomePresenter {
    private IHomeContract.IHomeView view;
    private IHomeContract.IHomeModel model;

    @Override
    public void attach(IHomeContract.IHomeView view) {
        this.view = view;
        model = new HomeModelImpl();
    }

    @Override
    public void detach() {
        if (view != null) {
            view = null;
        }
        if (model != null) {
            model = null;
        }
    }

    @Override
    public void requestList(String url) {
        model.requestList(url, new CallBackString() {
            @Override
            public void onSuccess(String result) {
                view.showList(result);
            }

            @Override
            public void onFail(String msg) {

            }
        });
    }
}
