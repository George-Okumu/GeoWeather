package com.moringa.geoweather;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements  View.OnClickListener{
    public static final String TAG = MainActivity.class.getSimpleName();
    @BindView(R.id.searchWeatherButton) Button mSearchWeatherButton;
    @BindView(R.id.locationEditText) EditText mLocationEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        mSearchWeatherButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if(v == mSearchWeatherButton){

            String location = mLocationEditText.getText().toString();
            Log.d(TAG, "onClick: "+ location);
            Intent intent = new Intent(MainActivity.this, WeatherActivity.class);
            intent.putExtra("location", location);
            startActivity(intent);
            Toast.makeText(MainActivity.this, "Welcome to Weather App", Toast.LENGTH_LONG).show();
        }
    }
}