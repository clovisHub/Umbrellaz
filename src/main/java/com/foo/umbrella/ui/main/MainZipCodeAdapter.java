package com.foo.umbrella.ui.main;

import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.foo.umbrella.R;
import com.foo.umbrella.ui.TempAdapter;
import com.foo.umbrella.ui.Linker;

public class MainZipCodeAdapter extends  DialogFragment{

    private EditText zipCode;
    String zipCodeValue = "";
    Linker activityLinker = null;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

          activityLinker = (Linker) getActivity();

          return zipCodeDialog();
    }


    private Dialog zipCodeDialog(){

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View  zipView = inflater.inflate(R.layout.zip_text,null);

        AlertDialog.Builder alertDialZip = new AlertDialog.Builder(getActivity());

        alertDialZip.setTitle(R.string.zip_code)
                .setView(zipView)
                .setPositiveButton("click", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {



                    }
                });

        AlertDialog dialog = alertDialZip.create();
        dialog.show();
        dialog.getButton(AlertDialog.BUTTON_POSITIVE).setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                zipCode = (EditText) zipView.findViewById(R.id.edit_zipId);

                zipCodeValue = zipCode.getText().toString();

                if((!(zipCodeValue.equals("")|| zipCodeValue == null))&& zipCodeValue.length()== 5){

                    activityLinker.setZipValue(zipCodeValue);
                    dialog.dismiss();

                    TempAdapter mainDegreeAdapter = new TempAdapter();
                    mainDegreeAdapter.show(getFragmentManager(),"degreeDialog");
                }
                else {
                    //do nothing
                    Toast.makeText(zipView.getContext(),"Enter a valid zipcode",Toast.LENGTH_LONG).show();
                }

            }
        });

        return dialog;
    }

    public String getZipCodeValue(){
        return zipCodeValue;
    }





}


