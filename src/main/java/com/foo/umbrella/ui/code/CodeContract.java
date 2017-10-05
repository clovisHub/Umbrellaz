package com.foo.umbrella.ui.code;

import com.foo.umbrella.data.model.WeatherData;

public interface CodeContract {

    interface Presenter{
        void getCity(String city);
    }
    interface View{
        void loadData(WeatherData response);
    }

}
