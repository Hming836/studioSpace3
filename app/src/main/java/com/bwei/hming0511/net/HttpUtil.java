package com.bwei.hming0511.net;

import android.os.AsyncTask;

import com.google.common.io.CharStreams;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

/**
 * @ Auther:Hming
 * @ Date: 2019.05.13
 * @ Description(功能) :工具类
 */
public class HttpUtil {
    // 单列模式（懒汉式）
    private HttpUtil() {
    }

    private static HttpUtil util;

    public static HttpUtil getUtil() {
        if (util == null) {
            util = new HttpUtil();
        }
        return util;
    }

    // GET请求
    public void doHttpGET(String strURL, final CallBackString backString) {
        new AsyncTask<String, Integer, String>() {
            @Override
            protected String doInBackground(String... strings) {
                try {
                    URL url = new URL(strings[0]);
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                    connection.setRequestMethod("GET");
                    connection.setConnectTimeout(5000);
                    connection.setReadTimeout(5000);
                    if (connection.getResponseCode() == 200) {
                        return CharStreams.toString(new InputStreamReader(connection.getInputStream()));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return null;
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                backString.success(s);
            }
        }.execute(strURL);
    }

    // POST 请求
    public void doHttpPost(String strURL, final String phone, final String pwd, final CallBackString backString) {
        new AsyncTask<String, Integer, String>() {
            @Override
            protected String doInBackground(String... strings) {
                try {
                    URL url = new URL(strings[0]);
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                    connection.setRequestMethod("POST");
                    connection.setConnectTimeout(5000);
                    connection.setReadTimeout(5000);

                    String body = "phone=" + URLEncoder.encode(phone) + "&pwd=" + URLEncoder.encode(pwd);
                    connection.setDoOutput(true);
                    connection.getOutputStream().write(body.getBytes());
                    if (connection.getResponseCode() == 200) {
                        return CharStreams.toString(new InputStreamReader(connection.getInputStream()));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return null;
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                backString.success(s);
            }
        }.execute(strURL);
    }
}

