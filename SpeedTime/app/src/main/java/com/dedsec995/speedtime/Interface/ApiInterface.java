package com.dedsec995.speedtime.Interface;

import com.dedsec995.speedtime.Model.MaunalPost;
import com.dedsec995.speedtime.Model.Post;
import com.dedsec995.speedtime.Model.Post1;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.OPTIONS;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("my/getAllUsers/")
    Call<List<Post>> getAllUsers();

    @POST("my/pro/")
    Call<Post1> createPost(@Query("vin") int vin,@Query("freq") int frequency,@Query("same") String same);

    @POST("my/manual/")
    Call<MaunalPost> createManualPost(@Query("vin") String manual_vin, @Query("speed") int speed);

}