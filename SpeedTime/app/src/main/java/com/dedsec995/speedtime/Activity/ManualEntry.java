package com.dedsec995.speedtime.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.dedsec995.speedtime.Background.LoadingDialog;
import com.dedsec995.speedtime.Interface.ApiInterface;
import com.dedsec995.speedtime.Model.MaunalPost;
import com.dedsec995.speedtime.Model.Post1;
import com.dedsec995.speedtime.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ManualEntry extends AppCompatActivity {
    private ApiInterface apiInterface;
    private Button CreateData;
    private EditText manual_vin;
    private EditText manual_speed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manual_entry);

        LoadingDialog loadingDialog = new LoadingDialog(ManualEntry.this);
        manual_vin = (EditText)findViewById(R.id.manual_vin);
        manual_speed   = (EditText)findViewById(R.id.manual_speed);
        CreateData = (Button) findViewById(R.id.submit_vin_data);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.0.203:8881/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        apiInterface = retrofit.create(ApiInterface.class);

        CreateData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createPost(loadingDialog);
            }
        });
    }
    private void createPost(LoadingDialog loadingDialog) {
        String m_vin= manual_vin    .getText().toString();
        String manual_speed_int= manual_speed.getText().toString();
        if (m_vin.matches("")) {
            Toast.makeText(this, "You did not enter  No. of Vin", Toast.LENGTH_SHORT).show();
            return;
        }
        if (manual_speed_int.matches("")) {
            Toast.makeText(this, "You did not enter frequency", Toast.LENGTH_SHORT).show();
            return;
        }
        loadingDialog.startLoadingDialog();

//        int fmanual_vin_int=Integer.parseInt(manual_vin_int);

        int fmanual_speed_int=Integer.parseInt(manual_speed_int);
        Call<MaunalPost> call = apiInterface.createManualPost(m_vin,fmanual_speed_int);
//        Intent intent = new Intent(MakeData.this, BackgroundService.class);
//        startService(intent);
//        try {
//            Response<Post1> response = call.execute();
//            textViewResult.setText("Done");
//        } catch (IOException e) {
//            textViewResult.setText(e.getLocalizedMessage());
//        }
//        mkLoader.setVisibility(View.VISIBLE);
        call.enqueue(new Callback<MaunalPost>() {
            @Override
            public void onResponse(Call<MaunalPost> call, Response<MaunalPost> response) {

                if (!response.isSuccessful()) {
                    Toast.makeText(getApplicationContext(), response.code(), Toast.LENGTH_SHORT).show();
                    return;
                }
                MaunalPost postresponse = response.body();

                String content = "";
                content += "Code: " + response.code() + "\n";
                content += "ID: " + postresponse.getVin_number() + "\n";
                content += "User ID: " + postresponse.getSpeed() + "\n\n";

//                textViewResult.setText(content)
                loadingDialog.dismissDialog();
                Toast.makeText(getApplicationContext(), "Done", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<MaunalPost> call, Throwable t) {
                loadingDialog.dismissDialog();
                Toast.makeText(getApplicationContext(), t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}