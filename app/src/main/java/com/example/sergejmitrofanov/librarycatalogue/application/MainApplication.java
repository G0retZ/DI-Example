package com.example.sergejmitrofanov.librarycatalogue.application;

import android.app.Application;
import com.example.sergejmitrofanov.librarycatalogue.di.AppComponent;
import com.example.sergejmitrofanov.librarycatalogue.di.AppComponentImpl;

public class MainApplication extends Application {

  public static AppComponent appComponent;

  @Override
  public void onCreate() {
    super.onCreate();
    appComponent = new AppComponentImpl();
  }
}
