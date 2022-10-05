package com.example.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class register extends AppCompatActivity implements View.OnClickListener{

    private Button register;
    private TextView msgResponse;
    private EditText username;
    private EditText password;
    private EditText email;
    private EditText phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        email = (EditText) findViewById(R.id.email);
        phone = (EditText) findViewById(R.id.phone);
        register = (Button) findViewById(R.id.register);
        msgResponse = (TextView) findViewById(R.id.msgResponse);

        register.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int error = 0;

        if (username.getText().toString().trim().length() <= 0) {
            error += 1;
        }
        else if (password.getText().toString().trim().length() <= 0) {
            error += 1;
        }
        else if (email.getText().toString().trim().length() <= 0) {
            error += 1;
        }
        else if (phone.getText().toString().trim().length() <= 0) {
            error += 1;
        }

        if (error != 0) {
            msgResponse.setText("Error: Haven't filled out all necessary fields");
            error = 0;
        }
        else {
            msgResponse.setText("You have successfully created a new user!");
            postReq();
            final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    startActivity(new Intent(register.this, MainActivity.class));
                }
            }, 5000);
        }
    }

    private void postReq() {

    }
}