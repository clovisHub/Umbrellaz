package com.foo.umbrella.ui.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.foo.umbrella.R;
import com.foo.umbrella.ui.code.CodeActivity;
import com.foo.umbrella.ui.code.CodePresenter;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText editText;
    TextView textView;
    Button button;
    Toolbar toolbarSet;




  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

      toolbarSet = (Toolbar) findViewById(R.id.app_bar_setId);
      setSupportActionBar(toolbarSet);

      editText = (EditText) findViewById(R.id.ed_id);
      textView = (TextView) findViewById(R.id.tv_id);

      //TODO set color for toolbar and disable any clicks

      button = (Button) findViewById(R.id.btn_id);
      button.setOnClickListener(this);

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

    @Override
    public void onClick(View v) {

        String entry = editText.getText().toString().trim();

      if(!entry.isEmpty()||editText != null ){

       if(entry.length() == 5 && entry.matches("^[0-9]+$")){

             Intent intent = new Intent(this, CodeActivity.class);
             intent.putExtra("zip",entry);
             startActivity(intent);

       }else{
         Toast.makeText(this,"Please enter five digits only! ", Toast.LENGTH_LONG).show();
       }

      }
      else{
       Toast.makeText(this,"Enter zipcode",Toast.LENGTH_LONG).show();
      }

    }
  }
