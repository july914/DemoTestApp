package com.example.yuliya.demotestapp.ui.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.yuliya.demotestapp.Models.UserModel;
import com.example.yuliya.demotestapp.R;
import com.example.yuliya.demotestapp.Models.Cat;
import com.squareup.picasso.Picasso;

import java.util.List;


public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private List<UserModel> posts;


    public MyAdapter(List<UserModel> posts) {
        this.posts = posts;
    }

    @Override
    public int getItemCount() {
        if (posts == null)
            return 0;
        return posts.size();
    }

    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.my_text_view, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public View mTextView;
        public TextView FirstName;
        public TextView LastName;
        public ImageView catImage;

        public ViewHolder(View viewCell) {
            super(viewCell);

            mTextView = viewCell;

            FirstName = (TextView) mTextView.findViewById(R.id.catTextView);
            LastName = (TextView) mTextView.findViewById(R.id.catNumber);
            catImage = (ImageView) mTextView.findViewById(R.id.imageView2);
            Picasso.with(viewCell.getContext()).load(R.drawable.androidcat).fit().into(catImage);
        }
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        UserModel post = posts.get(position);
        Context context = holder.catImage.getContext();
        holder.FirstName.setText(post.getFirstName());
        holder.LastName.setText(post.getLastName());
        Picasso.with(context).load(post.getPhoto100()).fit().error(android.R.drawable.stat_notify_error).into(holder.catImage);
        holder.catImage.setTag(post.getPhoto100());
        holder.itemView.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick (View v){
                final Intent intent = new Intent(v.getContext(), UserDetailsActivity.class);
                intent.putExtra("Cat Name", holder.FirstName.getText().toString());
                intent.putExtra("Cat Number", holder.LastName.getText().toString());
                intent.putExtra("Cat Photo", String.valueOf(holder.catImage.getTag()).toString());
                v.getContext().startActivity(intent);
            }
        });
    }

       /* holder.catTextView.setText(mDataset[position].name);
        holder.catNumber.setText(String.valueOf(position + 1));
        Context context = holder.catImage.getContext();
        Picasso.with(context).load(mDataset[position].photo).fit().error(android.R.drawable.stat_notify_error).into(holder.catImage);
        holder.catImage.setTag(mDataset[position].photo);*/


}