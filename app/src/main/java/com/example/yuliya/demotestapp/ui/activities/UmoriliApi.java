package com.example.yuliya.demotestapp.ui.activities;


import java.util.List;

import com.example.yuliya.demotestapp.ui.activities.AnekdotModel;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface UmoriliApi {

    @GET("/api/get")
    Call<List<AnekdotModel>> getData(@Query("name") String resourceName, @Query("num") int count);


}
