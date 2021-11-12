package com.dedsec995.speedtime.BeforeData;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.dedsec995.speedtime.Data.DataBySpeed;
import com.dedsec995.speedtime.Data.DataByVin;
import com.dedsec995.speedtime.R;

public class BeforeSpeedData extends AppCompatActivity {
    private Button search_speed_button;
    private EditText search_speed_range_1;
    private EditText search_speed_range_2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_before_speed_data);
        search_speed_range_1 = (EditText)findViewById(R.id.search_speed_range_1);
        search_speed_range_2 = (EditText)findViewById(R.id.search_speed_range_2);
        search_speed_button = (Button) findViewById(R.id.search_speed_button);
        search_speed_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDataBySpeedActivity();
            }
        });
    }
    public void openDataBySpeedActivity(){
        String speed_range_1 = search_speed_range_1.getText().toString();
        String speed_range_2 = search_speed_range_2.getText().toString();
        if(speed_range_1.matches("")){
            Toast.makeText(this, "You did not enter Min Speed", Toast.LENGTH_SHORT).show();
            return;
        }
        else if(speed_range_2.matches("")){
            Toast.makeText(this, "You did not enter Max Speed", Toast.LENGTH_SHORT).show();
            return;
        }
        else if(speed_range_1.length() != 3 && speed_range_2.length() !=3 ){
            Toast.makeText(this, "Data of not appropriate size", Toast.LENGTH_SHORT).show();
            return;
        }
        Intent intent = new Intent(this, DataBySpeed.class);
        intent.putExtra("search_speed_range_1", speed_range_1);
        intent.putExtra("search_speed_range_2", speed_range_2);
        startActivity(intent);
    }
}