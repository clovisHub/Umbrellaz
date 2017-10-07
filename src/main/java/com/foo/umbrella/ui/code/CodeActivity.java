package com.foo.umbrella.ui.code;

import android.content.Intent;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.foo.umbrella.R;
import com.foo.umbrella.data.model.WeatherData;
import com.foo.umbrella.ui.main.MainActivity;


public class CodeActivity extends AppCompatActivity implements CodeContract.View{
    Intent secondIntent;
    String city;

    CodeContract.Presenter presenter;

    TextView secView;
    Button button;
    Toolbar toolbar;

    //String zip = "75243";
    String zip = "";

    public static final String TAG = CodeActivity.class.getName().concat("_TAG");

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_code);
        secView = (TextView) findViewById(R.id.sec_tvId);

        toolbar = (Toolbar) findViewById(R.id.app_barId);
        setSupportActionBar(toolbar);


        zip = getIntent().getStringExtra("zip").trim();

        if(zip.length() == 5){

            secView.setText(zip);
            presenter = new CodePresenter(this);
            presenter.setZipCode(zip);

        }
        else{
            Toast.makeText(this,"Enter five digits", Toast.LENGTH_LONG).show();
        }


    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_code,menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemResId = item.getItemId();

        if(itemResId == R.id.settingsId){

            Intent goToMain = new Intent(this, MainActivity.class);
            goToMain.putExtra("toolbar","create");
            startActivity(goToMain);
        }
        return super.onOptionsItemSelected(item);

    }

    @Override
    public void loadData(WeatherData response) {

        //TODO display data as shown in design and take care of rotation
        // Display result via textView to see how it works

        toolbar.setTitle(response.getCurrentObservation().getDisplayLocation().getFullName().toString());

        toolbar.setSubtitle(Integer.toString((int)(Double.parseDouble(response.getCurrentObservation().getTempFahrenheit())))
                            +"\u00b0"+"F");


        if(Double.parseDouble(response.getCurrentObservation().getTempFahrenheit().toString()) > 60){
            toolbar.setBackgroundColor(getResources().getColor(R.color.weather_warm));
        }
        else{
            toolbar.setBackgroundColor(getResources().getColor(R.color.weather_cool));
        }


        secView.setText(response.getCurrentObservation().getTempCelsius().toString()+ "\u00b0"+"C"
                +"\n and "+response.getCurrentObservation().getTempFahrenheit().toString()+" Fahrenheit"
                +"\n and "+response.getCurrentObservation().getIconName().toString()+" icon name"
                +"\n and "+response.getCurrentObservation().getDisplayLocation().getCountry().toString()+" Country"
                +"\n and "+response.getCurrentObservation().getDisplayLocation().getStateName().toString()+" State"
                +"\n and "+response.getCurrentObservation().getDisplayLocation().getZip().toString()+" Zipcode"
        );
    }
}
