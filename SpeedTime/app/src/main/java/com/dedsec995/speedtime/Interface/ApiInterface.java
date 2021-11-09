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
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("my/getAllUsers/")
    Call<List<Post>> getAllUsers();

    @GET("my/getUsersbyVin/{vin}")
    Call<List<Post>> getUsersbyVin(@Path("vin") String userVin);

    @GET("my/getbySpeedbetween/{speed}/{speed2}")
    Call<List<Post>> getUsersbySpeed(@Path("speed") String userSpeed,@Path("speed2") String userSpeed2);

    @GET("my/getUsersbyAlert/{alert}")
    Call<List<Post>> getUsersbyAlert(@Path("alert") String userAlert);

    @GET("my/getUsersbyVerified/{verify}")
    Call<List<Post>> getUsersbyVerify(@Path("verify") String userVerify);

    @GET("my/getUsersbyTime/{timest}")
    Call<List<Post>> getUsersbyTime(@Path("timest") String userTimest);

    @POST("my/pro/")
    Call<Post1> createPost(@Query("vin") int vin,@Query("freq") int frequency,@Query("same") String same);

    @POST("my/manual/")
    Call<MaunalPost> createManualPost(@Query("vin") String manual_vin, @Query("speed") int speed);

}