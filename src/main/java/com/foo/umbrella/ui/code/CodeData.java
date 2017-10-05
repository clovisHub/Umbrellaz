package com.foo.umbrella.ui.code;

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
    ApiServices apiServices;

    private CodeData (){}


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

            }

            @Override
            public void onFailure(Call<WeatherData> call, Throwable t) {

            }
        });


    }
}
