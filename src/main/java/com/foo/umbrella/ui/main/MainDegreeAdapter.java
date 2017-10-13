package com.foo.umbrella.ui.main;

import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.Toast;

import com.foo.umbrella.R;

public class MainDegreeAdapter extends DialogFragment {

    private EditText zipCode;
    LayoutInflater inflater;
    String degreeValue = "";
    MainLinker mainLinker = null;



    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        mainLinker = (MainLinker) getActivity();
        return degreeCodeDialog();
    }

    private AlertDialog degreeCodeDialog() {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(R.string.select_unit)
                .setItems(R.array.selected, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        if(which == 0){
                            Toast.makeText(getActivity(),"first",Toast.LENGTH_LONG).show();
                            mainLinker.setOptionTemp(getString(R.string.fahrenheit));
                        }
                        else{
                            Toast.makeText(getActivity(),"second",Toast.LENGTH_LONG).show();
                            mainLinker.setOptionTemp(getString(R.string.celsius));
                        }
                    }
                });

        return builder.create();
    }

}
