package com.foo.umbrella.data;

import android.app.Application;

import com.foo.umbrella.data.api.WeatherService;

public interface ApiServices {

   void initData(Application app);
   WeatherService getdata();
}
