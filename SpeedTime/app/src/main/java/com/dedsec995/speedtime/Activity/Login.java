package com.dedsec995.speedtime.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.dedsec995.speedtime.R;

public class Login extends AppCompatActivity {
    private Button login_button;
    private EditText login_id;
    private EditText login_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        login_id = (EditText)findViewById(R.id.login_id);
        login_password   = (EditText)findViewById(R.id.login_password);
        login_button = (Button) findViewById(R.id.login_button);

        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openactivity();
            }
        });
    }
    void openactivity(){
        Intent intent;
        String login_id_string = login_id.getText().toString();
        String login_password_string = login_password.getText().toString();
        if(login_id_string.matches("")){
            Toast.makeText(this, "You did not enter  Userid", Toast.LENGTH_SHORT).show();
            return;
        }
        else if(login_password_string.matches("")){
            Toast.makeText(this, "You did not enter Password", Toast.LENGTH_SHORT).show();
            return;
        }
        else if(login_id_string.equals("admin") && login_password_string.equals("admin")){
            intent = new Intent(this, AdminActivity.class);
            startActivity(intent);
            finish();
        }
        else if(login_id_string.equals("user") && login_password_string.equals("user")){
            intent = new Intent(this, DataQueryPrint.class);
            startActivity(intent);
            finish();
        }
        else{
            Toast.makeText(getApplicationContext(), "Either Userid or Password is wrong", Toast.LENGTH_SHORT).show();
            return;
        }

    }
}