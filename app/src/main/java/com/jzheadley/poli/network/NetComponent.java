package com.jzheadley.poli.network;


import com.jzheadley.poli.UI.MainActivity;
import com.jzheadley.poli.UI.PolicyActivity;
import com.jzheadley.poli.UI.SetAccountInfoActivity;
import com.jzheadley.poli.UI.fragment_race_yes;
import com.jzheadley.poli.base.AppModule;
import com.jzheadley.swifey.network.notifications.FirebaseIDService;

import org.jetbrains.annotations.NotNull;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class, NetModule.class})
public interface NetComponent {
    void inject(MainActivity activity);


    void inject(@NotNull SetAccountInfoActivity setAccountInfoActivity);

    void inject(@NotNull FirebaseIDService firebaseIDService);

    void inject(@NotNull PolicyActivity policyActivity);

    void inject(fragment_race_yes fragment_race_yes);
}
