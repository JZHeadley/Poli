package com.jzheadley.poli.network;


import com.jzheadley.poli.models.User;

import retrofit2.http.Body;
import retrofit2.http.POST;

import io.reactivex.Observable;

public interface PoliApi {
    @POST("users")
    Observable<User> submitUserDemographics(@Body User user);
}
