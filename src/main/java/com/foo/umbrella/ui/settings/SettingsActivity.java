package com.foo.umbrella.ui.settings;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TableRow;
import android.widget.TextView;
import com.foo.umbrella.R;
import com.foo.umbrella.ui.Linker;
import com.foo.umbrella.ui.ZipCodeAdapter;
import com.foo.umbrella.ui.TempAdapter;

import java.util.Arrays;

public class SettingsActivity extends AppCompatActivity implements View.OnClickListener,Linker {

    TextView setsTv1, setsTv2;
    TableRow tbRow1, tbRow2;
    String zip, temp;
    ZipCodeAdapter zipCodeAdapter;
    TempAdapter mainDegreeAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        setsTv1 = (TextView) findViewById(R.id.set_txtId1);
        setsTv2 = (TextView) findViewById(R.id.set_txtId2);

        tbRow1 = (TableRow) findViewById(R.id.settings_tR1);
        tbRow2 = (TableRow) findViewById(R.id.settings_tR2);

        Intent fromCodeIntent = getIntent();
        zip = fromCodeIntent.getStringExtra("zip");
        temp = fromCodeIntent.getStringExtra("degree");
        setUpView(temp,zip);

        tbRow1.setOnClickListener(this);
        tbRow2.setOnClickListener(this);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("zip",zip);
        outState.putString("degree",temp);
    }

    public void setUpView(String deg, String zip){

        String [] buildZip ={"ZipCode","\n\n",zip};
        setsTv1.setText(Arrays.toString(buildZip).replaceAll("\\[|\\]", "").replaceAll(",",""));

        String [] buildTemp ={"Unit","\n\n",deg};
        setsTv2.setText(Arrays.toString(buildTemp).replaceAll("\\[|\\]", "").replaceAll(",",""));

    }

    private void setUpDeg(String deg){

        String [] buildTemp ={"Unit","\n\n",deg};
        setsTv2.setText(Arrays.toString(buildTemp).replaceAll("\\[|\\]", "").replaceAll(",",""));
    }

    private void setUpZipCode(String zip){

        String [] buildZip ={"ZipCode","\n\n",zip};
        setsTv1.setText(Arrays.toString(buildZip).replaceAll("\\[|\\]", "").replaceAll(",",""));
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

        switch(v.getId()){

            case R.id.settings_tR1:

                zipCodeAdapter = new ZipCodeAdapter();
                zipCodeAdapter.show(getFragmentManager(),"setZipDialog");

                break;
            case R.id.settings_tR2:

                mainDegreeAdapter = new TempAdapter();
                mainDegreeAdapter.show(getFragmentManager(),"degreeDialog");

                break;
            default: // nothing
        }

    }

    @Override
    public void setZipValue(String value) {
        zip = value;
        setUpZipCode(value);
    }

    @Override
    public void setOptionTemp(String tempo) {
       temp = tempo;
       setUpDeg(tempo);
    }
}
