package com.foo.umbrella.ui.main;

import android.content.Intent;
import android.os.Bundle;
<<<<<<< HEAD
=======
import android.os.PersistableBundle;
>>>>>>> e822345953bb695dac74acc413704fe75a855e41
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.foo.umbrella.R;
import com.foo.umbrella.ui.code.CodeActivity;
import com.foo.umbrella.ui.code.CodePresenter;

public class MainActivity extends AppCompatActivity implements MainLinker {

  boolean state;
  String zipCode ="";
  MainZipCodeAdapter mainZipCodeAdapter;


<<<<<<< HEAD
=======
    //EditText editText, editText2;
   // TextView textView;
   // Button button;
    Toolbar toolbarSet;
    String checkerFromCode;

    public static final String TAG = MainActivity.class.getName().concat("_TAG");

    //DialogStarted
    TextView dialStartTv;
    EditText dialStartEdt;
    RadioButton dialFarBtn, dialCelsBtn;
    Button dialClickBtn;
    AlertDialog.Builder dialogStartedBuilder;
    View dialogStarView;

>>>>>>> e822345953bb695dac74acc413704fe75a855e41


  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

<<<<<<< HEAD
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
=======
      toolbarSet = (Toolbar) findViewById(R.id.app_bar_setId);

      if(getIntent().getStringExtra("toolbar")!= null && getIntent().getStringExtra("zip").equals("")){

          checkerFromCode = getIntent().getStringExtra("toolbar").trim();
          setSupportActionBar(toolbarSet);
      }else{
          toolbarSet.setBackgroundColor(getResources().getColor(R.color.content_background));
          showDialog();
      }

      //editText = (EditText) findViewById(R.id.ed_id);
      //editText2 = (EditText) findViewById(R.id.ed_id2);
     // textView = (TextView) findViewById(R.id.tv_id);

     // button = (Button) findViewById(R.id.btn_id);
     // button.setOnClickListener(this);

  }

    public void showDialog(){


        dialogStartedBuilder = new AlertDialog.Builder(MainActivity.this);
        dialogStarView = getLayoutInflater().inflate(R.layout.dialog_started,null);

        dialStartTv = (TextView) dialogStarView.findViewById(R.id.dialSt_tv);
        dialStartEdt = (EditText) dialogStarView.findViewById(R.id.dialSt_edtId);

        dialCelsBtn = (RadioButton) dialogStarView.findViewById(R.id.dialSt_celsiusId);
        dialFarBtn = (RadioButton) dialogStarView.findViewById(R.id.dialSt_FarId);

        dialClickBtn = (Button) dialogStarView.findViewById(R.id.dialSt_BtnId);
        dialClickBtn.setOnClickListener(this);
        dialogStartedBuilder.setView(dialogStarView);
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause: Paused");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onPause: Stopped");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart: Restarted");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: Resumed");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onResume: Destroyed");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_setting,menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemResId = item.getItemId();

        if(itemResId == R.id.arrow_SubmitId){
            // set a new layout,
        }
        return super.onOptionsItemSelected(item);
    }
    public void switchActivity(String entry, String entry2){

        Intent intent = new Intent(this, CodeActivity.class);
        intent.putExtra("zip",entry);
        intent.putExtra("degree",entry2);
        startActivity(intent);
    }

    @Override
    public void onClick(View v) {

        String entry = dialStartEdt.getText().toString().trim();
        String entry2= "";


      if(!entry.isEmpty()||dialStartEdt != null ){

       if(entry.length() == 5 && entry.matches("^[0-9]+$")){

           if(dialFarBtn.isChecked()){

               entry2 = "faren";
               switchActivity(entry,entry2);

           }
           else if(dialCelsBtn.isChecked()){
               entry2 = "celsius";
               switchActivity(entry,entry2);
           }
           else{
               showDialog();
           }

       }else{
         Toast.makeText(this,"Please enter five digits only! ", Toast.LENGTH_LONG).show();
           showDialog();
       }

      }
      else{
       Toast.makeText(this,"Enter zipcode",Toast.LENGTH_LONG).show();
          showDialog();
      }

    }
  }
>>>>>>> e822345953bb695dac74acc413704fe75a855e41
