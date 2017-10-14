package com.foo.umbrella.ui.code;

import android.content.Intent;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.foo.umbrella.R;
import com.foo.umbrella.data.model.WeatherData;
import com.foo.umbrella.ui.settings.SettingsActivity;


public class CodeActivity extends AppCompatActivity implements CodeContract.View{

    CodeContract.Presenter presenter;

    TextView secView;
    Toolbar toolbar;

    //String zip = "75243";
    String zip = "";
    String degree ="";

    public static final String TAG = CodeActivity.class.getName().concat("_TAG");

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_code);
        secView = (TextView) findViewById(R.id.sec_tvId);

        toolbar = (Toolbar) findViewById(R.id.app_barId);
        setSupportActionBar(toolbar);


        zip = getIntent().getStringExtra("zip").trim();
        degree = getIntent().getStringExtra("degree").trim();

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

            Intent goToSettings = new Intent(this, SettingsActivity.class);
            goToSettings.putExtra("toolbar","create");
            goToSettings.putExtra("degree",degree);
            goToSettings.putExtra("zip",zip);
            startActivity(goToSettings);
        }
        return super.onOptionsItemSelected(item);

    }

    @Override
    public void loadData(WeatherData response) {

        //TODO display data as shown in design and take care of rotation
        // Display result view textView to see how it works
        // Display result via textView to see how it works

        toolbar.setTitle(response.getCurrentObservation().getDisplayLocation().getFullName().toString());

        if(degree.equalsIgnoreCase("Fahrenheit")){

            toolbar.setSubtitle(Integer.toString((int)(Double.parseDouble(response.getCurrentObservation().getTempFahrenheit())))
                    +"\u00b0"+"F");

            secView.setText(response.getCurrentObservation().getTempFahrenheit().toString()+"\u00b0"+"F");
        }
        else{
            toolbar.setSubtitle(Integer.toString((int)(Double.parseDouble(response.getCurrentObservation().getTempCelsius())))
                    +"\u00b0"+"C");
            secView.setText(response.getCurrentObservation().getTempCelsius().toString()+"\u00b0"+"C");
        }


        if(Double.parseDouble(response.getCurrentObservation().getTempFahrenheit().toString()) > 60){
            toolbar.setBackgroundColor(getResources().getColor(R.color.weather_warm));
        }
        else if(Double.parseDouble(response.getCurrentObservation().getTempCelsius().toString()) > 16){
            // 60 * F = 15.5 * C
            toolbar.setBackgroundColor(getResources().getColor(R.color.weather_warm));
        }
        else{
            toolbar.setBackgroundColor(getResources().getColor(R.color.weather_cool));
        }

    }
}
