package com.example.dreamkatchtestapp.api;

import com.example.dreamkatchtestapp.model.VideoResponse;

import io.reactivex.Single;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;

public interface ApiInterface {

    // Sign up
    @GET("api/v1/activity/?page=1")
    Single<VideoResponse> getVideosList();

}
