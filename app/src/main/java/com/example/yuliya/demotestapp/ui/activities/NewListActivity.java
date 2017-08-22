package com.example.yuliya.demotestapp.ui.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import com.example.yuliya.demotestapp.R;
import com.example.yuliya.demotestapp.Controllers.Controller;
import com.example.yuliya.demotestapp.Models.AnekdotModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NewListActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    List<AnekdotModel> posts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newlist);

        posts = new ArrayList<>();

        recyclerView = (RecyclerView) findViewById(R.id.posts_recycle_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        PostsAdapter adapter = new PostsAdapter(posts);
        recyclerView.setAdapter(adapter);

        Controller.getApi().getData("bash", 50).enqueue(new Callback<List<AnekdotModel>>() {
            @Override
            public void onResponse(Call<List<AnekdotModel>> call, Response<List<AnekdotModel>> response) {
                posts.addAll(response.body());
                recyclerView.getAdapter().notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<AnekdotModel>> call, Throwable t) {
                Toast.makeText(NewListActivity.this, "An error occurred during networking", Toast.LENGTH_SHORT).show();
            }
        });
    }
}