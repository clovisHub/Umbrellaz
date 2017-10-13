package com.foo.umbrella.ui.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;
import com.foo.umbrella.R;
import com.foo.umbrella.ui.code.CodeActivity;
import com.foo.umbrella.ui.settings.SettingsActivity;


public class MainActivity extends AppCompatActivity implements MainLinker {

  boolean state;
  String zipCode ="";
  MainZipCodeAdapter mainZipCodeAdapter;


    public static final String TAG = MainActivity.class.getName().concat("_TAG");

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

      mainZipCodeAdapter = new MainZipCodeAdapter();
      mainZipCodeAdapter.show(getFragmentManager(),"myDialog");

  }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("zipcode",zipCode);
    }

    @Override
    protected void onResume() {
        super.onResume();

        if(!zipCode.equals("")){
            Intent intent = new Intent(this, SettingsActivity.class);
            startActivity(intent);
        }

    }

    @Override
    public void setZipValue(String value) {
       zipCode = value;

    }

    @Override
    public String getTheValue() {
        return null;
    }

    @Override
    public void setOptionTemp(String temp) {

             state = false;
             if(temp.equalsIgnoreCase(getString(R.string.fahrenheit))) {
                 state = true;
             }

        goToCodeAcivity(state);
    }

    public void goToCodeAcivity(boolean stat){

        String degree ="";

         if(stat==true){
             degree = "fahrenheit";
         }else{
             degree = "celsius";
         }

        if(!zipCode.isEmpty()||zipCode != null ){

             Intent intent = new Intent(this, CodeActivity.class);
             intent.putExtra("zip",zipCode);
             intent.putExtra("degree",degree);
             startActivity(intent);
        }
        else{
            Toast.makeText(this, R.string.enter_zipcode,Toast.LENGTH_LONG).show();
        }
    }


}

