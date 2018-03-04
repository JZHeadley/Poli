package com.jzheadley.poli.network;


import com.jzheadley.poli.models.User;
import com.jzheadley.poli.models.Vote;
import com.jzheadley.polipoll.server.models.MessagingId;

import retrofit2.http.Body;
import retrofit2.http.POST;

import io.reactivex.Observable;

public interface PoliApi {
    @POST("users")
    Observable<User> submitUserDemographics(@Body User user);

    @POST("messagingIds")
    Observable<Void> sendUserMessagingId(@Body MessagingId token);

    @POST("votes")
    Observable<Void> submitVote(@Body Vote vote);
}
