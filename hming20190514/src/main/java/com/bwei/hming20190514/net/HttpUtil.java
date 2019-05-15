package com.bwei.hming20190514.net;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import java.util.Map;

/**
 * @ Auther:Hming
 * @ Date: 2019.05.13
 * @ Description(功能) : 工具类（请求网络）
 */
public class HttpUtil {
    // 单例模式(懒汉式)

    private HttpUtil() {
    }

    private static HttpUtil util;

    public static synchronized HttpUtil getUtil() {
        if (util == null) {
            util = new HttpUtil();
        }
        return util;
    }

    public void doHttpGet(String strURL, final CallBackString backString) {
        /*new AsyncTask<String, Integer, String>() {
            @Override
            protected String doInBackground(String... strings) {
                try {
                    URL url = new URL(strings[0]);
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                    connection.setRequestMethod("GET");
                    connection.setConnectTimeout(5000);
                    connection.setReadTimeout(5000);
                    if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                        return CharStreams.toString(new InputStreamReader(connection.getInputStream()));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    backString.onFail(e.getMessage());
                }
                return null;
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                backString.onSuccess(s);
            }
        }.execute(strURL);*/
        StringRequest request = new StringRequest(Request.Method.GET, strURL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                backString.onSuccess(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                backString.onFail(error.getMessage());
            }
        });
        request.setTag("get");
        MyApplication.getQueue().add(request);
    }

    public void doHttpPost(String strURL, CallBackString backString) {
        StringRequest request = new StringRequest(Request.Method.POST, strURL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                return super.getParams();
            }
        };
    }
    // 关闭 TAG
    public void cancle(String tag) {
        MyApplication.getQueue().cancelAll(tag);
    }
}
