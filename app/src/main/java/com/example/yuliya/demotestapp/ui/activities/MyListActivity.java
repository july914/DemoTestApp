package com.example.yuliya.demotestapp.ui.activities;

import android.media.Image;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.app.ListActivity;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.yuliya.demotestapp.R;
import com.squareup.picasso.Picasso;

import java.lang.reflect.Array;
import java.util.Arrays;

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


    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
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
    }
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
