package com.foo.umbrella.ui.code;

import android.content.Intent;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;
import com.foo.umbrella.R;
import com.foo.umbrella.data.model.ForecastCondition;
import com.foo.umbrella.data.model.WeatherData;
import com.foo.umbrella.ui.settings.SettingsActivity;
import java.util.ArrayList;
import java.util.List;


public class CodeActivity extends AppCompatActivity implements CodeContract.View{

    CodeContract.Presenter presenter;
    //TextView secView;
    List<List<ForecastCondition>> allList;

    RecyclerView codeRecyclerOut;
    CodeRecOutAdapter recOutAdapter;


    Toolbar toolbar;

    //String zip = "75243";
    String zip = "";
    String degree ="";

    public static final String TAG = CodeActivity.class.getName().concat("_TAG");

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_code);

        toolbar = (Toolbar) findViewById(R.id.app_barId);
        setSupportActionBar(toolbar);
        allList= new ArrayList<>();


        //secView = (TextView) findViewById(R.id.code_txt1);

        //Recyclerview
        codeRecyclerOut = (RecyclerView) findViewById(R.id.code_outer_rcViewId);
        codeRecyclerOut.setLayoutManager(new LinearLayoutManager(CodeActivity.this,LinearLayoutManager.VERTICAL,false));
        codeRecyclerOut.setHasFixedSize(true);



        zip = getIntent().getStringExtra("zip").trim();
        degree = getIntent().getStringExtra("degree").trim();

        if(zip.length() == 5){

            presenter = new CodePresenter(this);
            presenter.setZipCode(zip);

        }
        else{
            Toast.makeText(this,"Enter five digits", Toast.LENGTH_LONG).show();
        }

    }


    @Override
    protected void onRestart() {
        super.onRestart();
        zip = getIntent().getStringExtra("zip").trim();
        degree = getIntent().getStringExtra("degree").trim();
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
        //set Recyclerview

        toolbar.setTitle(response.getCurrentObservation().getDisplayLocation().getFullName().toString());

        if(degree.equalsIgnoreCase("Fahrenheit")){

            toolbar.setSubtitle(Integer.toString((int)(Double.parseDouble(response.getCurrentObservation().getTempFahrenheit())))
                    +"\u00b0"+"F");

            //secView.setText(response.getCurrentObservation().getTempFahrenheit().toString()+"\u00b0"+"F");
        }
        else{
            toolbar.setSubtitle(Integer.toString((int)(Double.parseDouble(response.getCurrentObservation().getTempCelsius())))
                    +"\u00b0"+"C");
            //secView.setText(response.getCurrentObservation().getTempCelsius().toString()+"\u00b0"+"C");
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
            //ListForCastcondition

           List<ForecastCondition> mylist = new ArrayList<>();
           List<ForecastCondition> mylist2 = new ArrayList<>();

           int actualHour = response.getForecast().get(0).getDateTime().getHour();
           int beforeMidnight = 24 -actualHour;

           // Today list start from actual hour to 11 pm
           int limitToshow = 12;
           if(beforeMidnight <= limitToshow){
               limitToshow = beforeMidnight;
           }

           for(int i = 0; i< limitToshow; i++){

               mylist.add(response.getForecast().get(i));
           }

           // tomorrow list starts from midnight and go to end.
           for(int i = beforeMidnight; i< beforeMidnight+12; i++){

               mylist2.add(response.getForecast().get(i));

           }

           allList.add(mylist);
           allList.add(mylist2);


           recOutAdapter = new CodeRecOutAdapter(getApplicationContext(),allList,degree);
           codeRecyclerOut.setAdapter(recOutAdapter);



    }
}
