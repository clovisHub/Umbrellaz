package com.foo.umbrella.ui.code;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.foo.umbrella.R;
import com.foo.umbrella.data.model.WeatherData;


public class CodeActivity extends AppCompatActivity implements CodeContract.View{
    Intent secondIntent;
    String city;

    CodeContract.Presenter presenter;

    TextView secView;
    Button button;

    //String zip = "75243";
    String zip = "";
    String degree ="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_code);
        secView = (TextView) findViewById(R.id.sec_tvId);

        zip = getIntent().getStringExtra("zip").trim();
        degree = getIntent().getStringExtra("degree").trim();

        if(zip.length() == 5){

            //if(zip.matches("^[0-9]")){

                secView.setText(zip);
                presenter = new CodePresenter(this);
                presenter.setZipCode(zip);
           // }

        }
        else{
            Toast.makeText(this,"Enter five digits", Toast.LENGTH_LONG).show();
        }


    }

    @Override
    public void loadData(WeatherData response) {

        //TODO display data as shown in design and take care of rotation
        // Display result view textView to see how it works
        if(degree.equalsIgnoreCase("Fahrenheit")){
            secView.setText(response.getCurrentObservation().getTempCelsius().toString()+" Fahrenheit");
        }
        else{
            secView.setText(response.getCurrentObservation().getTempCelsius().toString()+" Celsuis");
        }

    }
}
