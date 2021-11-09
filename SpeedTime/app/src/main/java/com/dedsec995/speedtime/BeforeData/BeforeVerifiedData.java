package com.dedsec995.speedtime.BeforeData;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.dedsec995.speedtime.Data.DataByVerified;
import com.dedsec995.speedtime.Data.DataByVin;
import com.dedsec995.speedtime.R;

public class BeforeVerifiedData extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private Spinner search_verified_spinner;
    private Button search_verified_button;
    private String search_verified_string;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_before_verified_data);

        search_verified_spinner = (Spinner) findViewById(R.id.search_verified_spinner);
        search_verified_button = (Button) findViewById(R.id.search_verified_button);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.vin_same_select_param, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        search_verified_spinner.setAdapter(adapter);
        search_verified_spinner.setSelection(0);
        search_verified_spinner.setOnItemSelectedListener(this);
        search_verified_string = "no";
        search_verified_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDataByVerifiedActivity();
            }
        });
    }

    public void openDataByVerifiedActivity(){

        Intent intent = new Intent(this, DataByVerified.class);
        intent.putExtra("search_verified_string", search_verified_string);
        startActivity(intent);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        search_verified_string = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(), search_verified_string, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}