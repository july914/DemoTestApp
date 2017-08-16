package com.example.yuliya.demotestapp.ui.activities;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.yuliya.demotestapp.R;
import com.squareup.picasso.Picasso;


public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private Cat[] mDataset;

    public MyAdapter(Cat[] myDataset) {
        mDataset = myDataset;
    }

    @Override
    public int getItemCount() {
        return mDataset.length;
    }

    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View viewCell = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.my_text_view, parent, false);
        ViewHolder vh = new ViewHolder(viewCell);
        return vh;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public View mTextView;
        public TextView catTextView;
        public TextView catNumber;
        public ImageView catImage;

        public ViewHolder(View viewCell) {
            super(viewCell);

            mTextView = viewCell;

            catTextView = (TextView)mTextView.findViewById(R.id.catTextView);
            catNumber = (TextView)mTextView.findViewById(R.id.catNumber);
            catImage = (ImageView)mTextView.findViewById(R.id.imageView2);
            Picasso.with(viewCell.getContext()).load(R.drawable.androidcat).fit().into(catImage);
        }
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        holder.catTextView.setText(mDataset[position].name);
        holder.catNumber.setText(String.valueOf(position + 1));
        Context context = holder.catImage.getContext();
        Picasso.with(context).load(mDataset[position].photo).fit().error(android.R.drawable.stat_notify_error).into(holder.catImage);
        holder.catImage.setTag(mDataset[position].photo);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Intent intent = new Intent(v.getContext(), UserDetailsActivity.class);
                intent.putExtra("Cat Name", holder.catTextView.getText().toString());
                intent.putExtra("Cat Number", holder.catNumber.getText().toString());
                intent.putExtra("Cat Photo", String.valueOf(holder.catImage.getTag()).toString());
                v.getContext().startActivity(intent);
            }
        });
    }

}