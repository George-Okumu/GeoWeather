package com.moringa.geoweather;

import android.content.Context;
import android.widget.ArrayAdapter;

public class WeatherArrayAdapter extends ArrayAdapter {
    private Context mContext;
    private String[] mCity;
    private String[] mWeather;

    WeatherArrayAdapter(Context mContext, int resource, String[] mCity, String[] mWeather){
        super(mContext, resource);
        this.mCity = mCity;
        this.mWeather = mWeather;
    }

    @Override
    public Object getItem(int position) {
        String weatherList = mWeather[position];
        String city = mCity[position];
        return String.format("%s \nThis city has : %s", weatherList, city);
    }

    @Override
    public int getCount() {
        return mWeather.length;
    }

}
