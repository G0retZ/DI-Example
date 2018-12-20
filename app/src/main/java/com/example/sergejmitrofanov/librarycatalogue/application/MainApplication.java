package com.example.sergejmitrofanov.librarycatalogue.application;

import android.app.Application;
import androidx.annotation.NonNull;
import com.example.sergejmitrofanov.librarycatalogue.di.AppComponent;
import com.example.sergejmitrofanov.librarycatalogue.di.AppComponentImpl;

public class MainApplication extends Application {

  private static AppComponent appComponent;

  @NonNull
  public static AppComponent getAppComponent() {
    return appComponent;
  }

  @Override
  public void onCreate() {
    super.onCreate();
    appComponent = new AppComponentImpl();
  }
}
