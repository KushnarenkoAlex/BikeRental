package com.kushnarenko.bikerentalandroid;

import android.app.Activity;
import android.content.Intent;

import android.content.SharedPreferences;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.kushnarenko.bikerentalandroid.constants.PathConstants;
import com.kushnarenko.bikerentalandroid.entity.User;
import com.kushnarenko.bikerentalandroid.query.GetQuery;

import org.json.JSONException;

import java.util.concurrent.ExecutionException;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends Activity {

    private Button sign_in;
    private Button register;
    private EditText email, password;

    private static final String LOG_TAG = "logs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        if (isLogged()) {
            Intent intent = new Intent(LoginActivity.this, BikeListActivity.class);
            startActivity(intent);
        }
        sign_in = (Button) findViewById(R.id.email_sign_in_button);
        register = (Button) findViewById(R.id.register_button);
        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);

        sign_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GetQuery getQuery = new GetQuery();
                String res = null;
                try {
                    res = getQuery.execute(String.format(PathConstants.GETUSER, email.getText())).get();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
                try {
                    User user = User.fromJson(res);
                    if (user.getPassword().equals(password.getText().toString())) {
                        Intent intent = new Intent(LoginActivity.this, BikeListActivity.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(LoginActivity.this, "Incorrect password",
                                Toast.LENGTH_LONG).show();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
    }

    private void updatePrefs(String userEmail) {
        SharedPreferences prefs = getPreferences(MODE_PRIVATE);
        prefs.edit().putString(String.valueOf(R.string.user_email), userEmail);
    }

    private boolean isLogged() {
        SharedPreferences prefs = getPreferences(MODE_PRIVATE);
        String userEmail = prefs.getString(String.valueOf(R.string.user_email), null);

        return userEmail != null;
    }

}

