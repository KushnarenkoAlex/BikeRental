package com.kushnarenko.bikerentalandroid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.kushnarenko.bikerentalandroid.constants.PathConstants;
import com.kushnarenko.bikerentalandroid.query.GetQuery;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class RegisterActivity extends Activity {


    private static final String LOG_TAG = "logs";

    private Button register;
    private EditText name, email, password1, password2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        register = (Button) findViewById(R.id.register_button);
        name = (EditText) findViewById(R.id.name);
        email = (EditText) findViewById(R.id.email);
        password1 = (EditText) findViewById(R.id.password1);
        password2 = (EditText) findViewById(R.id.password2);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(LOG_TAG, password1.getText() + " " + password2.getText());
                if (!password1.getText().toString().equals(password2.getText().toString())) {
                    Toast.makeText(RegisterActivity.this, "Password aren`t equal",
                            Toast.LENGTH_LONG).show();
                } else {
                    GetQuery getQuery = new GetQuery();
                    try {
                        String res = getQuery.execute(String.format(PathConstants.ADD_USER, name.getText(), email.getText(), password1.getText())).get();
                        if (res != null && !res.isEmpty()) {
                            Intent intent = new Intent(RegisterActivity.this, BikeListActivity.class);
                            startActivity(intent);
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (ExecutionException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }
}

