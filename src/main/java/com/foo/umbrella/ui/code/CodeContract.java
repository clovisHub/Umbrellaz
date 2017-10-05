package com.foo.umbrella.ui.code;

import com.foo.umbrella.data.ApiServices;
import com.foo.umbrella.data.api.WeatherService;
import com.foo.umbrella.data.model.WeatherData;

public interface CodeContract {

    interface Presenter{

        void setZipCode(String city); // called from CodeActivity

        void getResponse(WeatherData data); // called from CodeData

    }

    interface View{

        void loadData(WeatherData response); // called from CodePresenter
    }

    interface Data {

        WeatherService loadResponse(); // called from CodeData,

        void setCity(String code);
    }

}
