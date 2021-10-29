package com.dedsec995.speedtime.Activity;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


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

public class DataPrint extends AppCompatActivity {
    RecyclerView recyclerView;
//    private TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_print);

        LoadingDialog loadingDialog = new LoadingDialog(DataPrint.this);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        showDAta(loadingDialog);
    }

    private void showDAta(LoadingDialog loadingDialog) {
        loadingDialog.startLoadingDialog();
        //        textViewResult = findViewById(R.id.text_view_result);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.0.203:8878/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiInterface apiInterface = retrofit.create(ApiInterface.class);

        Call<List<Post>> call = apiInterface.getAllUsers();

        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {

                if (!response.isSuccessful()) {
//                    textViewResult.setText("Code: " + response.code());
                    return;
                }
                loadingDialog.dismissDialog();
                List<Post> posts = response.body();
                recyclerView.setAdapter(new PostAdapter(DataPrint.this,posts));

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