package com.example.masakazu.myapplication;

import java.util.HashMap;
import rx.Observable;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 * Created by Masakazu on 15/12/18.
 */
public interface KawaseApi {

    @GET("/get.php")
    public Observable<HashMap<String, String>> getCurrency(@Query("format") String format, @Query("code") Code code, @Query("to") Code to);
}
