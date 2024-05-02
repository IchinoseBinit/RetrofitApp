package com.example.retrofitapp.view.viewholder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.retrofitapp.R;


public class PostViewHolder extends RecyclerView.ViewHolder {

    public TextView txtViewName;
    public TextView txtViewDescription;

    public ImageView imgView;

    public PostViewHolder(@NonNull View itemView) {
        super(itemView);
        txtViewName = itemView.findViewById(R.id.textViewName);
        txtViewDescription = itemView.findViewById(R.id.textViewDescription);
        imgView = itemView.findViewById(R.id.imageView);
    }
}
