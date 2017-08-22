package com.example.yuliya.demotestapp.Interfaces;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import com.example.yuliya.demotestapp.Models.UserModel;
/**
 * Created by yuliya on 21.08.17.
 */

public interface VkontakteApi {

    @GET("/method/friends.get")
    Call<List<UserModel>> getData(@Query("user_id") String resourceID, @Query("fields") String photo);

}
