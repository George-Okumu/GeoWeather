package com.moringa.geoweather;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class WeatherActivity extends AppCompatActivity {
    @BindView(R.id.locationTextView) TextView mLocationTextView;
    @BindView(R.id.listView) ListView mListView;
    String[] weatherList = new String[]  {"Rains over a few places",
            "Showers and thunderstorms over several places. ",
            "Showers over a few places", "Showers over a few  places", "25-35oC "};
    String[] city = new String[] {"London", "Texas", "Miami", "California", "Washington"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);
        ButterKnife.bind(this);

        WeatherArrayAdapter adapter = new WeatherArrayAdapter(WeatherActivity.this, android.R.layout.simple_list_item_1, weatherList, city);
        mListView.setAdapter(adapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String weatherList = ((TextView)view).getText().toString();
                Toast.makeText(WeatherActivity.this, weatherList, Toast.LENGTH_LONG).show();
            }
        });

        Intent intent = getIntent();
        String location = intent.getStringExtra("location");
        mLocationTextView.setText("This is the today,s weather forecast in: " + location);


    }
}