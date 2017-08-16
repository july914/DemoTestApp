package com.example.yuliya.demotestapp.ui.activities;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.yuliya.demotestapp.R;
import com.squareup.picasso.Picasso;

public class UserDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_details);

        String catname=getIntent().getStringExtra("Cat Name");
        String catnumber=getIntent().getStringExtra("Cat Number");

        TextView catnameTextView = (TextView)findViewById(R.id.CatNametextView);
        catnameTextView.setText(catname);

        TextView catnumberTextView = (TextView)findViewById(R.id.CatNumbertextView);
        catnumberTextView.setText(catnumber);

        ImageView catImageView = (ImageView)findViewById(R.id.imageView);
        Picasso.with(this).load("http://pngimg.com/uploads/cat/cat_PNG134.png").fit().into(catImageView);

    }

}
