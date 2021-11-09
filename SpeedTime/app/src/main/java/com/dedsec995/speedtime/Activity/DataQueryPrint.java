package com.dedsec995.speedtime.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.dedsec995.speedtime.Data.DataByAlert;
import com.dedsec995.speedtime.Data.DataBySpeed;
import com.dedsec995.speedtime.Data.DataByTimest;
import com.dedsec995.speedtime.Data.DataByVerified;
import com.dedsec995.speedtime.Data.DataByVin;
import com.dedsec995.speedtime.Data.ShowAllData;
import com.dedsec995.speedtime.R;

public class DataQueryPrint extends AppCompatActivity {
    private Button ShowAllData;
    private Button GetDataByVin;
    private Button GetDataBySpeed;
    private Button GetDataByVerified;
    private Button GetDataByAlert;
    private Button GetDataByTimest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_query_print);
        ShowAllData = (Button) findViewById(R.id.showAllData);
        GetDataByVin = (Button) findViewById(R.id.GetDataByVin);
        GetDataBySpeed = (Button) findViewById(R.id.GetDataBySpeed);
        GetDataByVerified = (Button) findViewById(R.id.GetDataByVerified);
        GetDataByAlert = (Button) findViewById(R.id.GetDataByAlert);
        GetDataByTimest = (Button) findViewById(R.id.GetDataByTimest);



        ShowAllData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openshowAllData();
            }
        });

        GetDataByVin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opengetDataByVin();
            }
        });
        GetDataBySpeed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opengetDataBySpeed();
            }
        });

        GetDataByVerified.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opengetDataByVerified();
            }
        });

        GetDataByAlert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opengetDataByAlert();
            }
        });
        GetDataByTimest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opengetDataByTimest();
            }
        });

    }
    public void openshowAllData() {
        Intent intent = new Intent(this, ShowAllData.class);
        startActivity(intent);
    }
    public void opengetDataByVin() {
        Intent intent = new Intent(this, DataByVin.class);
        startActivity(intent);
    }
    public void opengetDataBySpeed() {
        Intent intent = new Intent(this, DataBySpeed.class);
        startActivity(intent);
    }
    public void opengetDataByVerified() {
        Intent intent = new Intent(this, DataByVerified.class);
        startActivity(intent);
    }
    public void opengetDataByAlert() {
        Intent intent = new Intent(this, DataByAlert.class);
        startActivity(intent);
    }
    public void opengetDataByTimest() {
        Intent intent = new Intent(this, DataByTimest.class);
        startActivity(intent);
    }
}