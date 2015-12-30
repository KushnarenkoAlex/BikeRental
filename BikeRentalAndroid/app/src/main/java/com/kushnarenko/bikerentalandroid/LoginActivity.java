package com.kushnarenko.bikerentalandroid;

import android.app.Activity;
import android.content.Intent;

import android.content.SharedPreferences;
import android.os.AsyncTask;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.kushnarenko.bikerentalandroid.constants.PathConstants;

import org.json.JSONObject;

import cz.msebera.android.httpclient.client.ResponseHandler;
import cz.msebera.android.httpclient.client.methods.HttpGet;
import cz.msebera.android.httpclient.impl.client.BasicResponseHandler;
import cz.msebera.android.httpclient.impl.client.DefaultHttpClient;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends Activity{

    private Button sign_in;
    private EditText email, password;

    private static final String LOG_TAG = "logs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (isLoggedIn()) {
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
        } else {
            setContentView(R.layout.activity_login);
        }

        sign_in = (Button) findViewById(R.id.email_sign_in_button);
        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);

        sign_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new QueryTask().execute(PathConstants.GETUSER);
            }
        });

    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_main, menu);
//        return true;
//    }

//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }

    private boolean isLoggedIn() {
        SharedPreferences prefs = getPreferences(MODE_PRIVATE);
        String userLogin = prefs.getString(String.valueOf(R.string.user_email), null);

        if (userLogin != null) {
            return true;
        }
        return false;
    }

    private class QueryTask extends AsyncTask<String, String, String> {

        private Throwable throwable;

        @Override
        @SuppressWarnings("deprecation")
        protected String doInBackground(String... params) {
            try {
                String url = params[0];
                Log.d(LOG_TAG, url);

                DefaultHttpClient httpClient = new DefaultHttpClient();
                ResponseHandler<String> res = new BasicResponseHandler();

                HttpGet get = new HttpGet(url);
                Log.d(LOG_TAG, get.toString());

                String response = httpClient.execute(get, res);
                JSONObject result = new JSONObject(response);
                Log.d(LOG_TAG, response);
                Log.d(LOG_TAG, result.toString());

            } catch (Throwable t) {
                Log.d(LOG_TAG, t.getMessage() + " " + t.toString());
                throwable = t;
            }
            return null;
        }
    }
}

