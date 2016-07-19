package com.kushnarenko.bikerentalandroid;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.kushnarenko.bikerentalandroid.constants.PathConstants;
import com.kushnarenko.bikerentalandroid.entity.Bicycle;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

/**
 * Created by Aexandere on 03-Jan-16.
 */
public class BikeAdapter extends ArrayAdapter<String> {
    private final Context context;
    private final String[] values;
    private final List<Bicycle> bicycleList;

    public BikeAdapter(Context context, String[] values, List<Bicycle> bicycleList) {
        super(context, R.layout.bike_list, values);
        this.context = context;
        this.values = values;
        this.bicycleList = bicycleList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.bike_item, parent, false);
        TextView firstLine = (TextView) rowView.findViewById(R.id.firstLine);
        TextView secondLine = (TextView) rowView.findViewById(R.id.secondLine);
        final ImageView view = (ImageView) rowView.findViewById(R.id.bikeImage);
        firstLine.setText(values[position]);
        Bicycle bicycle = bicycleList.get(position);
        secondLine.setText("Price: "+bicycle.getPrice()+"$");

        URL url = null;
        if (!bicycle.getImage().isEmpty()) {
            new AsyncTask<String, Void, Bitmap>() {
                @Override
                protected Bitmap doInBackground(String... urls) {
                    try {
                        URL url = new URL(urls[0]);
                        Bitmap bmp = BitmapFactory.decodeStream(url.openConnection().getInputStream());
                        return bmp;
                    } catch (Exception e) {
                        return null;
                    }
                }

                @Override
                protected void onPostExecute(Bitmap bitmap) {
                    view.setImageBitmap(bitmap);
                    super.onPostExecute(bitmap);
                }
            }.execute(PathConstants.SERVER2_IMG + bicycle.getImage());

        }

        return rowView;
    }
}

