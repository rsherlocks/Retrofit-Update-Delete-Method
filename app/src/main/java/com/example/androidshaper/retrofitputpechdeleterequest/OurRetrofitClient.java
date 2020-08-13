package com.example.androidshaper.retrofitputpechdeleterequest;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.PATCH;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface OurRetrofitClient {
    @PATCH("posts/{id}")
    Call<ObjectClass> updateUser(@Path("id") int id, @Body ObjectClass objectClass);

//    @PUT("posts/{id}")
////    Call<ObjectClass> updateUser(@Path("id") int id, @Body ObjectClass objectClass);

    @DELETE("posts/{id}")
    Call<Void> deleteUser(@Path("id") int id);
}
