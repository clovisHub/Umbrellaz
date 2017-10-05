package com.foo.umbrella.applevel;

import android.app.Application;

import com.foo.umbrella.data.ApiServices;
import com.foo.umbrella.data.ApiServicesProvider;
import com.jakewharton.threetenabp.AndroidThreeTen;

public class UmbrellaApp extends Application {

  static ApiServices apiServices;

  @Override public void onCreate() {
    super.onCreate();
    AndroidThreeTen.init(this);
    apiServices = new ApiServicesProvider(this);
    //apiServices.initData(this);
  }

  public static ApiServices getServices(){
    return apiServices;
  }

}
