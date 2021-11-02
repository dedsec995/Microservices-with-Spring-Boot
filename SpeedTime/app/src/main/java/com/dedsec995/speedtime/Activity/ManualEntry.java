package com.dedsec995.speedtime.Activity;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
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
    private Button submit_button;
    private EditText manual_vin;
    private EditText manual_speed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manual_entry);

        LoadingDialog loadingDialog = new LoadingDialog(ManualEntry.this);
        manual_vin = (EditText)findViewById(R.id.manual_vin);
        manual_speed   = (EditText)findViewById(R.id.manual_speed);
        submit_button = (Button) findViewById(R.id.submit_manual_data);


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.0.204:8881/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        apiInterface = retrofit.create(ApiInterface.class);

        submit_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendManualData(loadingDialog);
            }
        });

    }

    private void sendManualData(LoadingDialog loadingDialog) {
        String m_vin= manual_vin.getText().toString();
        String manual_speed_int= manual_speed.getText().toString();
        if (m_vin.matches("")) {
            Toast.makeText(this, "You did not enter  Vin", Toast.LENGTH_SHORT).show();
            return;
        }
        if (manual_speed_int.matches("")) {
            Toast.makeText(this, "You did not enter speed", Toast.LENGTH_SHORT).show();
            return;
        }
        loadingDialog.startLoadingDialog();

        int fmanual_speed_int=Integer.parseInt(manual_speed_int);
        Call<MaunalPost> call = apiInterface.createManualPost(m_vin,fmanual_speed_int);

        call.enqueue(new Callback<MaunalPost>() {
            @Override
            public void onResponse(Call<MaunalPost> call, Response<MaunalPost> response) {

                if (!response.isSuccessful()) {
                    Toast.makeText(getApplicationContext(), response.code(), Toast.LENGTH_SHORT).show();
                    return;
                }
                MaunalPost postresponse = response.body();

//                String content = "";
//                content += "Code: " + response.code() + "\n";
//                content += "ID: " + postresponse.getVin_number() + "\n";
//                content += "User ID: " + postresponse.getSpeed() + "\n\n";

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