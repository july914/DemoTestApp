package com.example.yuliya.demotestapp.Controllers;

import android.app.Application;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import com.example.yuliya.demotestapp.Interfaces.UmoriliApi;

/**
 * Created by yuliya on 16.08.17.
 */

public class Controller extends Application {

        private static UmoriliApi umoriliApi;
        private Retrofit retrofit;

        @Override
        public void onCreate() {
            super.onCreate();

            retrofit = new Retrofit.Builder()
                    .baseUrl("http://umorili.herokuapp.com/api/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            umoriliApi = retrofit.create(UmoriliApi.class);
        }

        public static UmoriliApi getApi() {
            return umoriliApi;
        }

   /* static final String BASE_URL = "http://www.umori.li/";

    public static UmoriliApi getApi() {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        UmoriliApi umoriliApi = retrofit.create(UmoriliApi.class);
        return umoriliApi;

    }*/
}

