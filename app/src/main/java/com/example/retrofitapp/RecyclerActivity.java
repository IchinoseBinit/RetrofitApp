package com.example.retrofitapp;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.retrofitapp.data.model.Post;
import com.example.retrofitapp.data.utilities.ApiClient;
import com.example.retrofitapp.view.adapter.PostAdapter;

import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class RecyclerActivity extends AppCompatActivity {


    ArrayList<Post> users= new ArrayList<Post>();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler_activity);

        ProgressBar progressBar = findViewById(R.id.loadingIndicator);
        progressBar.setVisibility(View.VISIBLE);


        ArrayList<Post> posts = new ArrayList<>();
        LinearLayoutManager manager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);

        RecyclerView recyclerView = findViewById(R.id.rvPosts);
        recyclerView.setLayoutManager(manager);
        PostAdapter adapter = new PostAdapter(posts);
        recyclerView.setAdapter(adapter);

        ApiClient client = new ApiClient();

        posts = client.getAllData(adapter, recyclerView, progressBar);
        Log.d("Array list", "size: " + posts.size());


    }

}
