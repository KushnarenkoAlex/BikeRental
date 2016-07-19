package com.kushnarenko.bikerentalandroid.query;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONObject;

import java.util.HashMap;

import cz.msebera.android.httpclient.client.ResponseHandler;
import cz.msebera.android.httpclient.client.methods.HttpGet;
import cz.msebera.android.httpclient.impl.client.BasicResponseHandler;
import cz.msebera.android.httpclient.impl.client.DefaultHttpClient;

public class GetQuery extends AsyncTask<String, String, String> {

    private Throwable throwable;

    private String result="";

    public String getRes() {
        return result;
    }

    public void setRes(String res) {
        this.result = res;
    }

    @Override
    protected String doInBackground(String... params) {
        try {
            String url = params[0];
            DefaultHttpClient httpClient = new DefaultHttpClient();
            ResponseHandler<String> res = new BasicResponseHandler();
            HttpGet get = new HttpGet(url);
            result = httpClient.execute(get, res);
            Log.d("getQuery",result);
        } catch (Throwable t) {
            Log.d("logs", t.getMessage() + " " + t.toString());
            throwable = t;
        }
        return result;
    }
}
