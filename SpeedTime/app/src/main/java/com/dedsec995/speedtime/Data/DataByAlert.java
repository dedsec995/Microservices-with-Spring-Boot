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

public class DataByAlert extends AppCompatActivity {
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_all_data);

        Intent intent = getIntent();
        String search_alert_string = intent.getStringExtra("search_alert_string");

        LoadingDialog loadingDialog = new LoadingDialog(DataByAlert.this);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerview_ShowAllData);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        showDAta(loadingDialog,search_alert_string);
    }
    private void showDAta(LoadingDialog loadingDialog,String search_alert_string) {
        loadingDialog.startLoadingDialog();
        //        textViewResult = findViewById(R.id.text_view_result);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.0.204:8883/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiInterface apiInterface = retrofit.create(ApiInterface.class);
        String search_alt_string = "n";
        if(search_alert_string.equals("Yes")){
            search_alt_string = "y";
        }
        else if (search_alert_string.equals("No")){
            search_alt_string = "n";
        }
        else{
            Toast.makeText(getApplicationContext(), "Something Went Wrong", Toast.LENGTH_SHORT).show();
            super.onBackPressed();
        }

        Call<List<Post>> call = apiInterface.getUsersbyAlert(search_alt_string);

        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {

                if (!response.isSuccessful()) {
//                    textViewResult.setText("Code: " + response.code());
                    loadingDialog.dismissDialog();
                    Toast.makeText(getApplicationContext(), "Failed", Toast.LENGTH_SHORT).show();
                    DataByAlert.super.onBackPressed();
                    return;
                }
                loadingDialog.dismissDialog();
                List<Post> posts = response.body();
                recyclerView.setAdapter(new PostAdapter(DataByAlert.this,posts));

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