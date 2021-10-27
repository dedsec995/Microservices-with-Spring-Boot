package com.dedsec995.speedtime.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.dedsec995.speedtime.R;

public class MainActivity extends AppCompatActivity {
    private Button DataBase;
    private Button MakeData;
    private Button ManualEntry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DataBase = (Button) findViewById(R.id.Database);
        MakeData = (Button) findViewById(R.id.CreateData);
        ManualEntry = (Button) findViewById(R.id.ManualEntry);

        DataBase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDatabaseActivity();
            }
        });

        MakeData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMakeDataActivity();
            }
        });
        ManualEntry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openManualEntryActivity();
            }
        });


    }
    public void openDatabaseActivity() {
        Intent intent = new Intent(this, DataPrint.class);
        startActivity(intent);
    }
    public void openMakeDataActivity() {
        Intent intent = new Intent(this, MakeData.class);
        startActivity(intent);
    }
    public void openManualEntryActivity() {
        Intent intent = new Intent(this, ManualEntry.class);
        startActivity(intent);
    }
}