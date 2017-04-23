package com.example.olamide.javadevelopers.api;

import com.example.olamide.javadevelopers.models.ItemResponse;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by olamide on 4/21/2017.
 */

public interface Service {
    @GET("/search/users?q=language:java+location:lagos")
    Call<ItemResponse> getItems();
}
