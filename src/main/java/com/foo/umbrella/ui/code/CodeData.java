package com.foo.umbrella.ui.code;

import android.util.Log;

import com.foo.umbrella.applevel.UmbrellaApp;
import com.foo.umbrella.data.ApiServices;
import com.foo.umbrella.data.api.WeatherService;
import com.foo.umbrella.data.model.WeatherData;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by user on 10/5/2017.
 */

public class CodeData implements CodeContract.Data{

    CodeContract.Presenter cdPresenter;
    WeatherService weatherService;
    static  ApiServices apiServices;

    public static final String TAG ="CodeData";

    private static  CodeData codeData = null;

    private CodeData (){}

    public static CodeData getCodeData(){
        if(codeData == null){
            codeData = new CodeData();
            apiServices = UmbrellaApp.getServices();
        }
        return codeData;
    }


    @Override
    public WeatherService loadResponse() {
        return apiServices.getdata();
    }

    @Override
    public void setCity(String code) {

        weatherService = loadResponse();

        weatherService.forecastForZipCallable(code).enqueue(new Callback<WeatherData>() {
            @Override
            public void onResponse(Call<WeatherData> call, Response<WeatherData> response) {

                if(response.isSuccessful()) {

                    Log.d(TAG, "posts loaded from API");
                }else {
                    int statusCode  = response.code();
                    // handle request errors depending on status code
                }

            }

            @Override
            public void onFailure(Call<WeatherData> call, Throwable t) {

            }
        });


    }
}
