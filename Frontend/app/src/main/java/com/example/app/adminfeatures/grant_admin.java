package com.example.app.adminfeatures;

import com.example.app.R;

import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import android.os.Bundle;

public class grant_admin extends AppCompatActivity {

    private Spinner privileges;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grant_admin);

        privileges = (Spinner) findViewById(R.id.privileges);
    }
}