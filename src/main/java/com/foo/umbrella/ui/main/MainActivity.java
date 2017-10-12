package com.foo.umbrella.ui.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.foo.umbrella.R;
import com.foo.umbrella.ui.code.CodeActivity;

public class MainActivity extends AppCompatActivity implements MainLinker {

  boolean state;
  String zipCode ="";
  MainZipCodeAdapter mainZipCodeAdapter;




  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

      mainZipCodeAdapter = new MainZipCodeAdapter();
      mainZipCodeAdapter.show(getFragmentManager(),"myDialog");

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

        goToCodeAcivity();
    }

    public void goToCodeAcivity(){

         String degree ="";

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
