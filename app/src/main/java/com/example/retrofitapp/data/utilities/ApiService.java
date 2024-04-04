package com.example.retrofitapp.data.utilities;

import com.example.retrofitapp.data.model.Post;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

//https://jsonplaceholder.typicode.com/posts/1

public interface ApiService {
    @GET("posts/{id}")
    Call<Post> getPost(@Path("id") int postId);

    @GET("posts")
    Call<List<Post>> getAllPosts();
}
