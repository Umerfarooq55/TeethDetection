package com.google.firebase.samples.apps.mlkit;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * Created by tohamy on 3/31/16.
 */
public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
    }
}
