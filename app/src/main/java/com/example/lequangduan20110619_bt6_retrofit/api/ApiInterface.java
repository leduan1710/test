package com.example.lequangduan20110619_bt6_retrofit.api;


import com.example.lequangduan20110619_bt6_retrofit.model.UserModel;
import com.example.lequangduan20110619_bt6_retrofit.model.Category;

import java.util.List;


import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiInterface
{
    @POST("/registrationapi.php?apicall=signup")
    Call<UserModel> registerUser(@Body UserModel user);

    // Login User
    @POST("/registrationapi.php?apicall=login")
    Call<UserModel> loginUser(@Body UserModel user);

    @GET("categories.php")
    Call<List<Category>> getCategotyAll();
}
