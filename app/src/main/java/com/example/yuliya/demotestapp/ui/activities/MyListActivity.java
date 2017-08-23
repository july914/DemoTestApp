package com.example.yuliya.demotestapp.ui.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import com.example.yuliya.demotestapp.Controllers.VKController;
import com.example.yuliya.demotestapp.Models.VKResponse;
import com.example.yuliya.demotestapp.R;
import com.example.yuliya.demotestapp.Models.Cat;

import java.util.List;

public class MyListActivity extends AppCompatActivity {


    final Cat[] catsArray = new Cat[]{
    new Cat("Манюник","http://pngimg.com/uploads/cat/cat_PNG134.png"),
            new Cat("Анфиса","https://avatanplus.com/files/resources/mid/57c4a33e589c2156d81dab9b.png"),
            new Cat("Баксик","http://www.mekong.su/images/mekong_l.png"),
            new Cat("Пуся(Пульхерия)","http://s54.radikal.ru/i143/1007/2c/9f3b406312a5.png"),
            new Cat("Дуся(Дульсинея)","http://s54.radikal.ru/i143/1007/2c/9f3b406312a5.png"),
            new Cat("Гвиневра","http://alfaday.net/uploads/posts/2013-03/1363627354_1048f2a2.jpg"),
            new Cat("Кузя","http://s46.radikal.ru/i113/1105/28/bc6a0a2c09a9.png"),
            new Cat("Березкин","https://kitten.whiskas.ru/images/imgimg8.png"),
            new Cat("Солер","http://izhevsk.ru/forums/icons/forum_pictures/004765/4765619.png"),
            new Cat("Кисуню","http://img-fotki.yandex.ru/get/3509/inmira.1c/0_384de_88576da4_orig.png"),
    };


    RecyclerView recyclerView;
    List<VKResponse> users;

    @Override
        protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mylist);


        users = new ArrayList<>();

        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        MyAdapter adapter = new MyAdapter(users);
        recyclerView.setAdapter(adapter);


        /*try{
            com.example.yuliya.demotestapp.Models.Response response = VKController.getVKApi().getVKData("38593660","photo_100", "91b4df6991b4df6991b4df696e91e9260d991b491b4df69c8299d068e3ece0a09571e0a", "5.68").execute();
        } catch (IOException e){
            e.printStackTrace();
        }*/

            VKController
                    .getVKApi()
                    .getVKData("38593660","photo_100", "91b4df6991b4df6991b4df696e91e9260d991b491b4df69c8299d068e3ece0a09571e0a", "5.68")
                    .enqueue(new  Callback<List<VKResponse>>(){
            @Override
            public void onResponse(Call<List<VKResponse>> call, Response<List<VKResponse>> response){
                users.addAll(response.body());
                recyclerView.getAdapter().notifyDataSetChanged();
            }
            @Override
            public void onFailure(Call<List<VKResponse>> call, Throwable t){
                Toast.makeText(MyListActivity.this, "An error occurred during networking", Toast.LENGTH_SHORT).show();
            }
        });




    }


   /* @Override
    protected void onCreate(Bundle savedInstanceState){
        setContentView(R.layout.activity_mylist);
        Button button = (Button)findViewById(R.id.buttonMenu);
        super.onCreate(savedInstanceState);
        button.setOnClickListener(viewClickListener);


        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        // specify an adapter (see also next example)

        mAdapter = new MyAdapter(catsArray);
        mRecyclerView.setAdapter(mAdapter);
    }*/
    View.OnClickListener viewClickListener = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            showPopupMenu(v);
        }
    };

    private void showPopupMenu(View v){
        PopupMenu popupMenu = new PopupMenu(this, v);
        popupMenu.inflate(R.menu.popupmenu);
        popupMenu
                .setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener(){
            @Override
                    public boolean onMenuItemClick(MenuItem item){
                switch (item.getItemId()){
                    case R.id.menu1:
                        //
                        return true;
                    case R.id.menu2:
                        //
                        return true;
                    case R.id.menu3:
                        return true;
                    default:
                        return false;
                }
            }
        });
        popupMenu.show();

    }


}
