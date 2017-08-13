package com.example.yuliya.demotestapp.ui.activities;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.yuliya.demotestapp.R;


public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private String[] mDataset;

    public MyAdapter(String[] myDataset) {
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

        public ViewHolder(View viewCell) {
            super(viewCell);

            mTextView = viewCell;

            catTextView = (TextView)mTextView.findViewById(R.id.catTextView);
            catNumber = (TextView)mTextView.findViewById(R.id.catNumber);
        }
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.catTextView.setText(mDataset[position]);
        holder.catNumber.setText(String.valueOf(position + 1));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "You have chosen " + String.valueOf(position + 1),
                        Toast.LENGTH_SHORT).show();
            }
        });
    }

}