package com.codemargonda.sagitariuschat;

import android.app.Application;

import com.qiscus.sdk.Qiscus;

/**
 * Created by Jefri Yushendri on 23/9/2016.
 */

public class Chat extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Qiscus.init(this, "sagitarius");
    }
}