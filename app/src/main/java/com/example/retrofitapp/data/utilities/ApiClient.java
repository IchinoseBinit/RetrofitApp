package com.example.retrofitapp.data.utilities;

import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import androidx.recyclerview.widget.RecyclerView;

import com.example.retrofitapp.data.model.Post;
import com.example.retrofitapp.view.adapter.PostAdapter;


import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    public Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    public ApiService apiService = retrofit.create(ApiService.class);

    ArrayList<Post> posts = new ArrayList<>();


    public void getData(){
        Call<Post> call = apiService.getPost(1);
        Log.d("api call", "in data ");
        call.enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                Log.d("api called", "in response");
                if (response.isSuccessful()) {
                    try {
                        Post post = (Post) response.body();
                        System.out.println("Data is " + post.getBody());
                    } catch (Exception ex) {
                        System.out.println("-----Error");
                        System.out.println(ex.toString());
                    }
                }
            }
            @Override
            public void onFailure(Call<Post> call, Throwable t) {
                Log.d("on failure", t.toString());

                System.out.println(t.toString());
                System.out.println(t.getMessage());
            }

        });
    }

//    3 params:
//    Adapter to update the list of data in recycler view and update the ui using notify method
//    Recycler view instance to update its visibility
//    Progress bar instance to update its visibility to hidden
    public ArrayList<Post> getAllData(PostAdapter adapter, RecyclerView recyclerView, ProgressBar progressBar){
        Call<List<Post>> call = apiService.getAllPosts();
        Log.d("api call", "in data ");
        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                Log.d("api called", "in response");
                if (response.isSuccessful()) {
                    try {
                        posts = (ArrayList<Post>) response.body();
//                        Casting the response to array list of post
                        adapter.setPosts(posts);
//                        Calling the setter to update the posts
                        adapter.notifyDataSetChanged();
//                        Calling the notify method to rebuild recycler view
//                        As it had earlier 0 data, now it needs to rebuild for showing data from api
                    } catch (Exception ex) {
                        System.out.println("-----Error");
                        System.out.println(ex.toString());
                    }
                }
//                Show visibility of recyclerView
                recyclerView.setVisibility(View.VISIBLE);
//                Hide the visibility of progress bar
                progressBar.setVisibility(View.GONE);

            }
            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                Log.d("on failure", t.toString());

                System.out.println(t.toString());
                System.out.println(t.getMessage());
                recyclerView.setVisibility(View.VISIBLE);
                progressBar.setVisibility(View.GONE);
            }


        });
        return posts;
    }
}
