package com.dedsec995.speedtime.BeforeData;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Toast;

import com.dedsec995.speedtime.Data.DataByTimest;
import com.dedsec995.speedtime.R;

import java.util.Calendar;

public class BeforeTimestData extends AppCompatActivity {

    private DatePickerDialog datePickerDialog;
    private Button datePickerButton;
    private Button search_timest_button;
    private String selected_timest;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_before_timest_data);

        initDatePicker();
        datePickerButton = findViewById(R.id.datePickerButton);
        datePickerButton.setText(getTodaysDate());
        search_timest_button = (Button) findViewById(R.id.search_timest_button);
        search_timest_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDataByTimest();
            }
        });
    }

    private String getTodaysDate()
    {
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        month = month + 1;
        int day = cal.get(Calendar.DAY_OF_MONTH);
        return makeDateString(day, month, year);
    }
    private void initDatePicker()
    {
        DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener()
        {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day)
            {
                month = month + 1;
                String date = makeDateString(day, month, year);
                selected_timest = year + "-" + month + "-" + day;
                datePickerButton.setText(date);
                Toast.makeText(getApplicationContext(), selected_timest, Toast.LENGTH_SHORT).show();
            }
        };

        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);

        int style = AlertDialog.THEME_HOLO_LIGHT;
        datePickerDialog = new DatePickerDialog(this, style, dateSetListener, year, month, day);
        datePickerDialog.getDatePicker().setMaxDate(System.currentTimeMillis());

    }

    private String makeDateString(int day, int month, int year)
    {
        return day + " " + getMonthFormat(month) + " " + year;
    }

    private String getMonthFormat(int month)
    {
        if(month == 1)
            return "JAN";
        if(month == 2)
            return "FEB";
        if(month == 3)
            return "MAR";
        if(month == 4)
            return "APR";
        if(month == 5)
            return "MAY";
        if(month == 6)
            return "JUN";
        if(month == 7)
            return "JUL";
        if(month == 8)
            return "AUG";
        if(month == 9)
            return "SEP";
        if(month == 10)
            return "OCT";
        if(month == 11)
            return "NOV";
        if(month == 12)
            return "DEC";

        //default should never happen
        return "JAN";
    }

    public void openDatePicker(View view)
    {
        datePickerDialog.show();
    }
    public void openDataByTimest(){
        if(selected_timest == null ||selected_timest.isEmpty()){
            Toast.makeText(getApplicationContext(), "Please select Date", Toast.LENGTH_SHORT).show();
            return;
        }
        Intent intent = new Intent(this, DataByTimest.class);
        intent.putExtra("selected_timest",selected_timest);
        startActivity(intent);
    }
}