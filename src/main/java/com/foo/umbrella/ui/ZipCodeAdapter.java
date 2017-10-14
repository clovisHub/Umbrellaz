package com.foo.umbrella.ui;

import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import com.foo.umbrella.R;

public class ZipCodeAdapter extends DialogFragment{

    private EditText zipCode;
    LayoutInflater inflater;
    String zipCodeValue = "";
    Linker activityLinker = null;
    TempAdapter mainDegreeAdapter;


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        activityLinker = (Linker) getActivity();

        return zipCodeDialog();
    }


    private AlertDialog zipCodeDialog(){

        inflater = getActivity().getLayoutInflater();
        View zipView = inflater.inflate(R.layout.zip_text,null);

        AlertDialog.Builder alertDialZip = new AlertDialog.Builder(getActivity());

        alertDialZip.setTitle(R.string.zip_code)
                .setView(zipView)
                .setPositiveButton("click", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        zipCode = (EditText) zipView.findViewById(R.id.edit_zipId);

                        zipCodeValue = zipCode.getText().toString();

                        activityLinker.setZipValue(zipCodeValue);
                    }
                });

        return alertDialZip.create();
    }

    public String getZipCodeValue(){
        return zipCodeValue;
    }

}
