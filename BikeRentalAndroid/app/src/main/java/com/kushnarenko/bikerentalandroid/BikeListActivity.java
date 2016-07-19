package com.kushnarenko.bikerentalandroid;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.kushnarenko.bikerentalandroid.constants.PathConstants;
import com.kushnarenko.bikerentalandroid.entity.Bicycle;
import com.kushnarenko.bikerentalandroid.query.GetQuery;

import org.json.JSONException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class BikeListActivity extends Activity {


    private static final String LOG_TAG = "logs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bike_list);

        final ListView listview = (ListView) findViewById(R.id.listview);

        GetQuery getQuery = new GetQuery();
        List<Bicycle> bicycles = new ArrayList<>();

        try {
            String res = getQuery.execute(PathConstants.BICYCLE_GETALL).get();
            try {
                bicycles = Bicycle.fromJsonList(res);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        String[] strings = new String[bicycles.size()];
        for (int i = 0; i < bicycles.size(); i++) {
            strings[i] = bicycles.get(i).getName();
        }


        listview.setAdapter(new BikeAdapter(this, strings, bicycles));


    }
}

