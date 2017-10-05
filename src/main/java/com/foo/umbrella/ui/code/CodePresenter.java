package com.foo.umbrella.ui.code;

import com.foo.umbrella.data.model.WeatherData;

public class CodePresenter implements CodeContract.Presenter{

    CodeContract.View caView;
    CodeContract.Data cdData;
    private static CodePresenter  presObj = null;

    private CodePresenter(){}


    public CodePresenter(CodeContract.View codeView){ //Method called from CodeActivity

        if(codeView != null){

            caView = codeView;
            cdData = CodeData.getCodeData();
            presObj = this;
        }

    }

    public static CodeContract.Presenter getPresenter(){
        return presObj;
    }

  /*  public CodeContract.View getView(){
        return caView;
    }

    public CodeContract.Data getCOntractData(){
        return cdData;
    }*/

    @Override
    public void setZipCode(String zipCode) { //Method called from CodeActivity
        cdData.setCity(zipCode);
    }

    @Override
    public void getResponse(WeatherData data) { //Method called from CodeData
        caView.loadData(data);
    }
}
