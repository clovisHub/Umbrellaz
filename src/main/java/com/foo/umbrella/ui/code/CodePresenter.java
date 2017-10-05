package com.foo.umbrella.ui.code;

import com.foo.umbrella.data.api.WeatherService;
import com.foo.umbrella.data.model.WeatherData;

public class CodePresenter implements CodeContract.Presenter{

    CodeContract.View caView;
    CodeContract.Data cdData;


    public CodePresenter(CodeContract.View codeView){
        caView = codeView;
        cdData = CodeData.getCodeData();
    }

    @Override
    public void getCity(String city) {
        cdData.setCity(city);
    }

    @Override
    public WeatherData getResponse() {
        return null;
    }
}
