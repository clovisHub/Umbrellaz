package com.foo.umbrella.ui.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.foo.umbrella.R;
import com.foo.umbrella.ui.code.CodeActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

  EditText editText;
  TextView textView;
  Button button;
  Toolbar toolbar;


  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    toolbar = (Toolbar) findViewById(R.id.app_barId);
    setSupportActionBar(toolbar);

    editText = (EditText) findViewById(R.id.ed_id);
    textView = (TextView) findViewById(R.id.tv_id);

    button = (Button) findViewById(R.id.btn_id);
    button.setOnClickListener(this);

  }

  @Override
  public void onClick(View v) {

     if(!editText.getText().toString().isEmpty()||editText != null ){

       Intent intent = new Intent(this, CodeActivity.class);
       intent.putExtra("zip",editText.getText().toString());
       startActivity(intent);
     }
     else{
       Toast.makeText(this,"Enter zipcode",Toast.LENGTH_LONG).show();
     }

  }
}
