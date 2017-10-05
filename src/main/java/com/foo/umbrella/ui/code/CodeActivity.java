package com.foo.umbrella.ui.code;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.foo.umbrella.R;
import com.foo.umbrella.data.model.WeatherData;


public class CodeActivity extends AppCompatActivity implements CodeContract.View{
    Intent secondIntent;
    String city;

    TextView secView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_code);
        city = secondIntent.getExtras().get("zip").toString();

        secView = (TextView) findViewById(R.id.sec_tvId);
        secView.setText(city);

    }

    @Override
    public void loadData(WeatherData response) {

    }
}
