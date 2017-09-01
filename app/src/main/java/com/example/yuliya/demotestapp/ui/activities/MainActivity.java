package com.example.yuliya.demotestapp.ui.activities;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.util.DiffUtil;
import android.view.View;
import android.widget.EditText;

import com.example.yuliya.demotestapp.BuildConfig;
import com.example.yuliya.demotestapp.R;

import java.util.List;
import java.util.concurrent.TimeUnit;


public class MainActivity extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onSearchButtonClick(View view) {
        EditText userEditText = (EditText) findViewById(R.id.editTextUserId);
        EditText depthEditText = (EditText) findViewById(R.id.editTextDepth);

        Intent intent = new Intent(MainActivity.this, MyListActivity.class);
        intent.putExtra("User ID", userEditText.getText().toString());
        intent.putExtra("Depth", depthEditText.getText().toString());
        startActivity(intent);
    }

}
