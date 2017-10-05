package com.foo.umbrella.ui.code;

import com.foo.umbrella.data.ApiServices;
import com.foo.umbrella.data.api.WeatherService;
import com.foo.umbrella.data.model.WeatherData;

public interface CodeContract {

    interface Presenter{
        void getCity(String city); // called in CodeActivity

        WeatherData getResponse();

    }
    interface View{
        void loadData(WeatherData response); // called in CodePresenter
    }

    interface Data {

        WeatherService loadResponse();

        void setCity(String code);
    }

}
