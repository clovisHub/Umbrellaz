package com.foo.umbrella.applevel;

import android.app.Application;

import com.foo.umbrella.data.ApiServices;
import com.jakewharton.threetenabp.AndroidThreeTen;

public class UmbrellaApp extends Application {

  ApiServices apiServices;

  @Override public void onCreate() {
    super.onCreate();
    AndroidThreeTen.init(this);
    //apiServices.getData(this);

  }

}
