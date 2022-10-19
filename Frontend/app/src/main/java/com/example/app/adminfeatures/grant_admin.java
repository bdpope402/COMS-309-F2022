package com.example.app.adminfeatures;

import com.example.app.R;
import com.example.app.activity_menu;
import com.example.app.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import android.os.Bundle;

public class grant_admin extends AppCompatActivity {

    private Spinner privileges;
    private Button grant_privileges;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grant_admin);

        privileges = (Spinner) findViewById(R.id.privileges);

        ArrayAdapter<CharSequence>adapter=ArrayAdapter.createFromResource(this, R.array.privileges, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);

        privileges.setAdapter(adapter);

        grant_privileges = (Button) findViewById(R.id.grant_privileges);

        grant_privileges.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String perms = privileges.getSelectedItem().toString();
            }
        });

    }
}