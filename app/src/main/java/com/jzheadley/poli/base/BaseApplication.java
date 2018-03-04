package com.jzheadley.poli.base;

import android.app.Application;
import android.content.Context;

import com.jzheadley.poli.network.DaggerNetComponent;
import com.jzheadley.poli.network.NetComponent;
import com.jzheadley.poli.network.NetModule;

import timber.log.Timber;


public class BaseApplication extends Application {
    private AppComponent appComponent;
    private NetComponent netComponent;

    public static BaseApplication get(Context context) {
        return (BaseApplication) context.getApplicationContext();
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Timber.plant(new Timber.DebugTree());
        initAppComponent();
        initNetComponent();
    }

    private void initNetComponent() {
        netComponent = DaggerNetComponent.builder()
                .appModule(new AppModule(this))
                // .netModule(new NetModule("http://jzheadley.com:5071//api/"))
                .netModule(new NetModule("http://ec2-52-23-204-172.compute-1.amazonaws.com:8080/"))
                .build();
    }

    private void initAppComponent() {
        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }


    public AppComponent getAppComponent() {
        return appComponent;
    }


    public NetComponent getNetComponent() {
        return netComponent;
    }

}
