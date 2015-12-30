package com.kushnarenko.bikerentalandroid;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

/**
 * A login screen that offers login via email/password.
 */
public class MainActivity extends Activity{


    private static final String LOG_TAG = "logs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        if (isLoggedIn()) {
//            Intent intent = new Intent(MainActivity.this, LoginActivity.class);
//            startActivity(intent);
//        } else {
            setContentView(R.layout.main_page_layout);
       // }

    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_main, menu);
//        return true;
//    }
//
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

//    private boolean isLoggedIn() {
//        SharedPreferences prefs = getPreferences(MODE_PRIVATE);
//        String userLogin = prefs.getString(String.valueOf(R.string.user_login), null);
//
//        if (userLogin != null) {
//            return true;
//        }
//        return false;
//    }

//    private class QueryTask extends AsyncTask<String, String, String> {
//
//        private Throwable throwable;
//
//        @Override
//        @SuppressWarnings("deprecation")
//        protected String doInBackground(String... params) {
//            try {
//                String url = params[0];
//                Log.d(LOG_TAG, url);
//
//                DefaultHttpClient httpClient = new DefaultHttpClient();
//                ResponseHandler<String> res = new BasicResponseHandler();
//
//                HttpGet get = new HttpGet(url);
//                Log.d(LOG_TAG, get.toString());
//
//                String response = httpClient.execute(get, res);
//                JSONObject result = new JSONObject(response);
//                Log.d(LOG_TAG, response);
//
//            } catch (Throwable t) {
//                Log.d(LOG_TAG, t.getMessage() + " " + t.toString());
//                throwable = t;
//            }
//            return null;
//        }
//    }
}

