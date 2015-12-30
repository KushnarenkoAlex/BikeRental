package ua.nure.kushnarenko.rest.myapi.query;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class JsonQuery implements ServerQuery {

    @Override
    public String sendGetQuery(String query) {
        String ans = "";
        try {
            DefaultHttpClient httpClient = new DefaultHttpClient();
            ResponseHandler<String> res = new BasicResponseHandler();
            HttpGet get = new HttpGet(query);
            String response = null;
            response = httpClient.execute(get, res);
            ans = response.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ans;
    }

    @Override
    public String sendPostQuery(String query, HashMap<String, Object> params) {
        String ans = "";
        try {
            DefaultHttpClient httpClient = new DefaultHttpClient();
            ResponseHandler<String> res = new BasicResponseHandler();
            HttpPost post = new HttpPost(query);
            List<NameValuePair> param = new ArrayList<NameValuePair>(params.size());

            params.entrySet().forEach(set -> param.add(new BasicNameValuePair(set.getKey(), set.getValue().toString())));

            post.setEntity(new UrlEncodedFormEntity(param, "UTF-8"));
            HttpResponse response = httpClient.execute(post);
            ans = response.toString();
            System.out.println(ans);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ans;

    }

}
