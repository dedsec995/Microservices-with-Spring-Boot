package com.dedsec995.speedtime.Data;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.dedsec995.speedtime.Background.LoadingDialog;
import com.dedsec995.speedtime.Background.PostAdapter;
import com.dedsec995.speedtime.Interface.ApiInterface;
import com.dedsec995.speedtime.Model.Post;
import com.dedsec995.speedtime.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DataByVin extends AppCompatActivity {
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_all_data);
        Intent intent = getIntent();
        String s_vin = intent.getStringExtra("s_vin");

        LoadingDialog loadingDialog = new LoadingDialog(DataByVin.this);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerview_ShowAllData);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        showDAta(loadingDialog,s_vin);
    }
    private void showDAta(LoadingDialog loadingDialog,String s_vin) {
        loadingDialog.startLoadingDialog();
        //        textViewResult = findViewById(R.id.text_view_result);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.0.204:8883/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiInterface apiInterface = retrofit.create(ApiInterface.class);

        Call<List<Post>> call = apiInterface.getUsersbyVin(s_vin);

        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {

                if (!response.isSuccessful() || response.body().isEmpty()) {
                    loadingDialog.dismissDialog();
                    Toast.makeText(getApplicationContext(), "Data Not Present", Toast.LENGTH_SHORT).show();
                    DataByVin.super.onBackPressed();
//                    textViewResult.setText("Code: " + response.code());
                    return;
                }
                loadingDialog.dismissDialog();
                List<Post> posts = response.body();
                recyclerView.setAdapter(new PostAdapter(DataByVin.this,posts));

//                List<Post> posts = response.body();
//
//                for (Post post : posts) {
//                    String content = "";
//                    content += "Vin: " + post.getVin() + "\n";
//                    content += "Verified: " + post.getVerified() + "\n";
//                    content += "Speed: " + post.getSpeed() + "\n";
//                    content += "Alert: " + post.getAlert() + "\n";
//                    content += "TimeStamp: " + post.getTimest() + "\n\n";

//                    textViewResult.append(content);
//                }
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                loadingDialog.dismissDialog();
                Toast.makeText(getApplicationContext(), t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
//                textViewResult.setText(t.getMessage());
            }
        });
    }
}