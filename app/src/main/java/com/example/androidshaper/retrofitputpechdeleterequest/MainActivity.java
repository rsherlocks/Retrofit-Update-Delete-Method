package com.example.androidshaper.retrofitputpechdeleterequest;

import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ObjectClass objectClass=new ObjectClass("Me on Rakib","",3);

        OurRetrofitClient ourRetrofitClient=retrofit.create(OurRetrofitClient.class);
        Call<ObjectClass> call=ourRetrofitClient.updateUser(1,objectClass);
        call.enqueue(new Callback<ObjectClass>() {
            @Override
            public void onResponse(Call<ObjectClass> call, Response<ObjectClass> response) {
                if (response.isSuccessful())
                {
                    Log.d("Response", "onResponse: "+response.body().getUserId()+" "+response.body().getBody()+" "+response.body().getTitle());
                }

            }

            @Override
            public void onFailure(Call<ObjectClass> call, Throwable t) {
                Log.d("Error", "onFailure: ");

            }
        });
        Call<Void> cllDelete=ourRetrofitClient.deleteUser(1);
        cllDelete.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if (response.code()==200)
                {
                    Log.d("Response", "onResponse: Delete Successful");
                }

            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Log.d("Error", "onFailure: message");

            }
        });
    }
}