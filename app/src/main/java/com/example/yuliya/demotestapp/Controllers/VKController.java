package com.example.yuliya.demotestapp.Controllers;

import android.app.Application;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import com.example.yuliya.demotestapp.Interfaces.VkontakteApi;

/**
 * Created by yuliya on 21.08.17.
 */

public class VKController extends Application{

    private static VkontakteApi vkontakteApi;
    private Retrofit retrofit;

    @Override
    public  void onCreate() {
        super.onCreate();

        retrofit = new Retrofit.Builder()
                .baseUrl("https://api.vk.com/method/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(new OkHttpClient.Builder().build())
                .build();

        vkontakteApi = retrofit.create(VkontakteApi.class);
    }
    public static VkontakteApi getVKApi(){
        return vkontakteApi;
    }
}
