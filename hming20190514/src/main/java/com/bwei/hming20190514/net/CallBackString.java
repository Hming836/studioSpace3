package com.bwei.hming20190514.net;

/**
 * @ Auther:Hming
 * @ Date: 2019.05.13
 * @ Description(功能) :接口（存储数据）
 */
public interface CallBackString {
    // 成功时的方法
    void onSuccess(String result);

    // 失败时的方法
    void onFail(String msg);
}
