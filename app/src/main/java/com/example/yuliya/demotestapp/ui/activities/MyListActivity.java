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

class Cat{
    public String name;
    public String photo;

    public Cat(String name, String photo) {
        this.name = name;
        this.photo = photo;
    }

}

public class MyListActivity extends AppCompatActivity {


    final Cat[] catsArray = new Cat[]{
    new Cat("Манюник","http://pngimg.com/uploads/cat/cat_PNG134.png"),
            new Cat("Анфиса","http://pngimg.com/uploads/cat/cat_PNG134.png"),
            new Cat("Баксик","http://pngimg.com/uploads/cat/cat_PNG134.png"),
            new Cat("Пуся","http://pngimg.com/uploads/cat/cat_PNG134.png"),
            new Cat("Дуся","http://pngimg.com/uploads/cat/cat_PNG134.png"),
            new Cat("Гвиневра","http://pngimg.com/uploads/cat/cat_PNG134.png"),
            new Cat("Кузя","http://pngimg.com/uploads/cat/cat_PNG134.png"),
            new Cat("Березкин","http://pngimg.com/uploads/cat/cat_PNG134.png"),
            new Cat("Солер","http://pngimg.com/uploads/cat/cat_PNG134.png"),
            new Cat("Кисуню","http://pngimg.com/uploads/cat/cat_PNG134.png"),
    };

//    final String[] catNamesArray = new String[]{
//            "Манюник", "Анфиса", "Баксик", "Симона", "Бешамель", "Томасина", "Бобик", "Кристина", "Пуся",
//            "Дуся", "Гвиневра", "Кузя", "Березкин", "Симба", "Солер", "Кисуню"
//    };


//    private ArrayAdapter<String> mAdapter;

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        setContentView(R.layout.activity_mylist);
        Button button = (Button)findViewById(R.id.buttonMenu);
        super.onCreate(savedInstanceState);
        button.setOnClickListener(viewClickListener);

//        mAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, catNamesArray);
//        setListAdapter(mAdapter);

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

//    @Override
//    protected void onListItemClick(ListView l, View v, int position, long id){
//        super.onListItemClick(l, v, position, id);
//        Toast.makeText(getApplicationContext(), "You have chosen "+ l.getItemAtPosition(position).toString(), Toast.LENGTH_SHORT).show();
//    }


}
