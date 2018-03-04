package com.jzheadley.poli.network;


import com.jzheadley.poli.UI.MainActivity;
import com.jzheadley.poli.UI.SetAccountInfoActivity;
import com.jzheadley.poli.base.AppModule;

import org.jetbrains.annotations.NotNull;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class, NetModule.class})
public interface NetComponent {
    void inject(MainActivity activity);


    void inject(@NotNull SetAccountInfoActivity setAccountInfoActivity);
}
