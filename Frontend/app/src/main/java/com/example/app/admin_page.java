package com.example.app;

import androidx.appcompat.app.AppCompatActivity;
import com.example.app.adminfeatures.grant_admin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class admin_page extends AppCompatActivity {

    Button grant_admin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_page);

        grant_admin = (Button) findViewById(R.id.grant_admin);

        grant_admin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(admin_page.this, grant_admin.class);
                startActivity(intent);
            }
        });
    }
}