package com.muhm.upokotha;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RacOneAdapter extends RecyclerView.Adapter<RacOneAdapter.MyViewHolder> {


    int[] picture;

    public RacOneAdapter(int[] picture) {
        this.picture = picture;
    }

    @NonNull
    @Override
    public RacOneAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.rac_one_item,parent,false);

        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RacOneAdapter.MyViewHolder holder, int position) {
        holder.topBooks.setImageResource(picture[position]);

    }

    @Override
    public int getItemCount() {
        return picture.length;
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView topBooks;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            topBooks=itemView.findViewById(R.id.img_top_book);
        }
    }
}
