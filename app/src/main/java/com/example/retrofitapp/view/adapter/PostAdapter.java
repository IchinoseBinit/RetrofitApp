package com.example.retrofitapp.view.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.retrofitapp.R;
import com.example.retrofitapp.data.model.Post;
import com.example.retrofitapp.view.viewholder.PostViewHolder;
import com.squareup.picasso.Picasso;


import java.util.ArrayList;

public class PostAdapter extends RecyclerView.Adapter<PostViewHolder> {

    ArrayList<Post> posts;

    public PostAdapter(ArrayList posts) {
        this.posts = posts;
    }

    public void setPosts(ArrayList posts) {
        this.posts = posts;
    }


    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_holder, parent, false);
        return new PostViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {
        Post post = posts.get(position);

        holder.txtViewName.setText(post.getTitle());
        holder.txtViewDescription.setText(post.getBody() );

        // Placeholder for loading state
        int placeholderResource = R.drawable.ic_launcher_background;
        // Placeholder for error state
        int errorResource = R.drawable.ic_launcher_foreground;

        // Load image from a URL into the ImageView using Picasso
        Picasso.get().
                load(post.getImage()).
//                Add Placeholder image (that loads when the image is not retrieved yet)
                placeholder(placeholderResource).
//                Add error image (that loads when the image fails to load)
                error(errorResource).
                into(holder.imgView);
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }
}
