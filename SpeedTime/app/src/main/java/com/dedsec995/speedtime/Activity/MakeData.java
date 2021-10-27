package com.dedsec995.speedtime.Activity;

import android.support.v7.app.AppCompatActivity;
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
import com.dedsec995.speedtime.Model.Post1;
import com.dedsec995.speedtime.R;



import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MakeData extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private ApiInterface apiInterface;
    private Button CreateData;
    private EditText no_of_vin;
    private EditText frequency;
    private Spinner vin_same_select;
    private String vin_same_select_string;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_data);


        vin_same_select = findViewById(R.id.same_vin_param);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.vin_same_select_param, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        vin_same_select.setAdapter(adapter);
        vin_same_select.setOnItemSelectedListener(this);
        vin_same_select_string = "no";

        LoadingDialog loadingDialog = new LoadingDialog(MakeData.this);
        no_of_vin   = (EditText)findViewById(R.id.no_of_vin);
        frequency   = (EditText)findViewById(R.id.frequency);
        CreateData = (Button) findViewById(R.id.submit_vin_data);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.0.203:8880/")
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
        String vinny= no_of_vin.getText().toString();
        String freq= frequency.getText().toString();
        if (vinny.matches("")) {
            Toast.makeText(this, "You did not enter  No. of Vin", Toast.LENGTH_SHORT).show();
            return;
        }
        if (freq.matches("")) {
            Toast.makeText(this, "You did not enter frequency", Toast.LENGTH_SHORT).show();
            return;
        }
        loadingDialog.startLoadingDialog();

        int fvinny=Integer.parseInt(vinny);

        int ffreq=Integer.parseInt(freq);
        Call<Post1> call = apiInterface.createPost(fvinny,ffreq,vin_same_select_string  );
//        Intent intent = new Intent(MakeData.this, BackgroundService.class);
//        startService(intent);
//        try {
//            Response<Post1> response = call.execute();
//            textViewResult.setText("Done");
//        } catch (IOException e) {
//            textViewResult.setText(e.getLocalizedMessage());
//        }
//        mkLoader.setVisibility(View.VISIBLE);
        call.enqueue(new Callback<Post1>() {
            @Override
            public void onResponse(Call<Post1> call, Response<Post1> response) {

                if (!response.isSuccessful()) {
                    Toast.makeText(getApplicationContext(), response.code(), Toast.LENGTH_SHORT).show();
                    return;
                }
                Post1 postresponse = response.body();

                String content = "";
                content += "Code: " + response.code() + "\n";
                content += "ID: " + postresponse.getVin() + "\n";
                content += "User ID: " + postresponse.getFrequency() + "\n";
                content += "Title: " + postresponse.getSame_vin() + "\n\n";
//                textViewResult.setText(content)
                loadingDialog.dismissDialog();
                Toast.makeText(getApplicationContext(), "Done", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<Post1> call, Throwable t) {
                loadingDialog.dismissDialog();
                Toast.makeText(getApplicationContext(), t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        vin_same_select_string = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(), vin_same_select_string, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}