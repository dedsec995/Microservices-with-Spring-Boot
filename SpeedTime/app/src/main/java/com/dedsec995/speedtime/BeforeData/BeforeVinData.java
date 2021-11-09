package com.dedsec995.speedtime.BeforeData;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.dedsec995.speedtime.Data.DataByVin;
import com.dedsec995.speedtime.R;

public class BeforeVinData extends AppCompatActivity {
    private EditText search_Vin;
    private Button search_vin_button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_before_vin_data);
        search_Vin = (EditText)findViewById(R.id.search_vin);
        search_vin_button = (Button) findViewById(R.id.search_vin_button);
        search_vin_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDataByVinActivity();
            }
        });
    }
    public void openDataByVinActivity() {
        String s_vin= search_Vin.getText().toString();
        if (s_vin.matches("")) {
            Toast.makeText(this, "You did not enter  Vin", Toast.LENGTH_SHORT).show();
            return;
        }
        if(s_vin.length() !=17){
            Toast.makeText(this, "Entered Vin is not of appropriate size", Toast.LENGTH_SHORT).show();
            return;
        }

        Intent intent = new Intent(this, DataByVin.class);
        intent.putExtra("s_vin", s_vin);
        startActivity(intent);
    }
}