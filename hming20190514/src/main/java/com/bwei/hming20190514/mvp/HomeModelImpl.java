package com.bwei.hming20190514.mvp;

import com.bwei.hming20190514.net.CallBackString;
import com.bwei.hming20190514.net.HttpUtil;

/**
 * @ Auther:Hming
 * @ Date: 2019.05.13
 * @ Description(功能) :
 */
public class HomeModelImpl implements IHomeContract.IHomeModel {

    private HttpUtil util;

    public HomeModelImpl() {
        util = HttpUtil.getUtil();
    }

    @Override
    public void requestList(String url, CallBackString backString) {
        util.doHttpGet(url, backString);
    }
}
